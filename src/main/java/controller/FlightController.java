package controller;

import entity.AirPortStationEntity;
import entity.FlightEntity;
import entity.FlightRouteEntity;
import entity.ImageBannerEntity;
import entity.PopularDestinationEntity;
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
import repository.ImageBannerRepository;
import repository.PopularDestinationRepository;
import repository.TicketClassRepository;
import repository.TicketRepository;

@Controller

public class FlightController {

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
    @Autowired
    ImageBannerRepository imageBannerRepo;
    @Autowired
    PopularDestinationRepository popularDestinationRepo;
    
    

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showAirPortStationForm(Model model) {
        List<AirPortStationEntity> airPortList = (List<AirPortStationEntity>) airPortStationRepo.findAll();
        List<ImageBannerEntity> imageList = (List<ImageBannerEntity>) imageBannerRepo.findAll();
        List<PopularDestinationEntity> popularDestinationList = (List<PopularDestinationEntity>) popularDestinationRepo.findAll();

        model.addAttribute("airPortList", airPortList);
        model.addAttribute("imageList", imageList);
        model.addAttribute("popularDestinationList", popularDestinationList);

        return "homePage";
    }
    @RequestMapping(value = "/findDes",method = RequestMethod.GET)
        public String getDestination(@RequestParam("source")int from, Model model){

             List<FlightRouteEntity> flightRouteList= (List<FlightRouteEntity>) flightRouteRepo.findAll();

             List<AirPortStationEntity> destinations= new ArrayList<>();
             for(FlightRouteEntity fr:flightRouteList){
                 if(fr.getAirPortStationFrom().getAirPortStationId() == from){
                     destinations.add(fr.getAirPortStationTo());
                 }
             }

             model.addAttribute("destinations", destinations);

            return "destination";
        }
    @RequestMapping(value="/homepage", method = RequestMethod.GET)
        public String homepage( Model model){
        List<ImageBannerEntity> imageList = (List<ImageBannerEntity>) imageBannerRepo.findAll();
        List<PopularDestinationEntity> popularDestinationList = (List<PopularDestinationEntity>) popularDestinationRepo.findAll();

        model.addAttribute("imageList", imageList);
        model.addAttribute("popularDestinationList", popularDestinationList);
            return "homePage";
    }
    @RequestMapping(value = "/findFlight", method = RequestMethod.POST)
    public String findFlight(@RequestParam(name = "airPortStationFrom") int airPortStationFrom,
            @RequestParam(name = "airPortStationTo") int airPortStationTo,
            @RequestParam(name = "depart") Date departDate,
            @RequestParam(name = "adult") int adult,
            @RequestParam(name = "child") int child,
            Model model) {
        LocalDate depart = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(departDate));

        List<FlightEntity> flightList = (List<FlightEntity>) flightRepo.getFlightNativeQuery(airPortStationFrom, airPortStationTo, depart);
        List<FlightEntity> avaiableFlight = new ArrayList<>();
        int sum = adult + child;
        for (FlightEntity f : flightList) {
            String status = "have tickets";
            List<TicketEntity> ticketList = (List<TicketEntity>) ticketRepo.getTicketByFlightId(status, f.getFlightId());
            if (ticketList.size() >= sum) {
                avaiableFlight.add(f);
            }
        }
        String bussiness = "business";
        TicketClassEntity ticketClass = ticketClassRepo.findByTypeClass(bussiness);
        model.addAttribute("flightList", avaiableFlight);
        model.addAttribute("ticketClass", ticketClass);
        model.addAttribute("adult", adult);
        model.addAttribute("child", child);

        return "flight/flight";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

}
