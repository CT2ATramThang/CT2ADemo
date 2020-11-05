
package controller;

import entity.FlightEntity;
import entity.TicketClassEntity;
import entity.TicketEntity;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import repository.AirPortStationRepository;
import repository.FlightRepository;
import repository.FlightRouteRepository;
import repository.TicketClassRepository;
import repository.TicketRepository;

@Controller
public class FlightScheduleController {
    @Autowired
    AirPortStationRepository airPortStationRepo;
    @Autowired
    FlightRouteRepository flightRouteRepo;
    @Autowired
    FlightRepository flightRepo;
    @Autowired
    TicketRepository ticketRepo;
     @Autowired
    TicketClassRepository ticketClassRepo;
    
    

    @RequestMapping(value = "/findSchedule", method = RequestMethod.POST)
    public String findFlight(@RequestParam(name= "airPortStationFrom")int airPortStationFrom,
                                @RequestParam(name= "airPortStationTo")int airPortStationTo,
                                @RequestParam(name= "depart")Date departDate,  
                                Model model){
        LocalDate depart = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(departDate));
         
        List<FlightEntity> flightList = (List<FlightEntity>)flightRepo.getFlightNativeQuery(airPortStationFrom, airPortStationTo,depart);
        List<FlightEntity> avaiableFlight= new ArrayList<>();
        for(FlightEntity f: flightList){
            String status = "have tickets";            
            List<TicketEntity> ticketList = (List<TicketEntity>)ticketRepo.getTicketByFlightId(status, f.getFlightId());
            int adult = 0, child = 0;
            int sum = adult + child;
            if(ticketList.size() >= sum){
                avaiableFlight.add(f);
            }   
        }
        String bussiness = "business";
        TicketClassEntity ticketClass = ticketClassRepo.findByTypeClass(bussiness);  
        model.addAttribute("flightList", avaiableFlight); 
        model.addAttribute("ticketClass", ticketClass);
        
        return "flightSchedule/flightSchedule";
    }
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    } 
}
