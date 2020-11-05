
package controller;

import entity.AircraftEntity;
import entity.FlightEntity;
import entity.PromotionEntity;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import repository.AirPortStationRepository;
import repository.AircraftRepository;
import repository.FlightRepository;
import repository.PromotionRepository;

@Controller
public class OperationFlightController {
    @Autowired
    AircraftRepository aircraftRepo;
    
    @Autowired
    FlightRepository flightRepo;

    @Autowired
    AirPortStationRepository airPortStationRepo;
    
    @Autowired
    PromotionRepository promotionRepo;
    
    
    //List Flight
    @RequestMapping(value = "/listFlight", method = RequestMethod.GET)
    public String getListFlight(HttpServletRequest request, Model model, ModelMap modelMap) {
        List<FlightEntity> flightList = (List<FlightEntity>) flightRepo.findAll();
        
        PagedListHolder pagedListHolder = new PagedListHolder(flightList);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        modelMap.put("pagedListHolder", pagedListHolder);
        
        //model.addAttribute("flightList", flightList);

        return "operation/listFlight";
    }

    //add setupFlight
    @RequestMapping(value = "/setupFlight", method = RequestMethod.GET)
    public String setupFlight(Model model) {
        model.addAttribute("flight", new FlightEntity());
        setDropdownAircraftList(model);
        setDropdownPromotionList(model);

        return "operation/addFlight";
    }

    private void setDropdownAircraftList(Model model) {
        List<AircraftEntity> aircraftList = (List<AircraftEntity>) aircraftRepo.findAll();
        if (!aircraftList.isEmpty()) {
            Map<Integer, String> aircraftMap = new LinkedHashMap<>();

            for (AircraftEntity aircraft : aircraftList) {
                aircraftMap.put(aircraft.getAircraftId(), aircraft.getAirNumber());
            }
            model.addAttribute("aircraftList", aircraftMap);
        }
    }

    private void setDropdownPromotionList(Model model) {
        List<PromotionEntity> promotionList = (List<PromotionEntity>) promotionRepo.findAll();
        if (!promotionList.isEmpty()) {
            Map<Integer, String> promotionMap = new LinkedHashMap<>();

            for (PromotionEntity promotion : promotionList) {
                promotionMap.put(promotion.getPromotionId(), promotion.getPromotionName());
            }
            model.addAttribute("promotionList", promotionMap);
        }
    }

    //save setupFlight
    @RequestMapping(value = "/setupFlight", method = RequestMethod.POST)
    public String saveSetupFlight(FlightEntity flight,HttpServletRequest request, Model model, ModelMap modelMap) {

        flightRepo.save(flight);
        List<FlightEntity> flightList = (List<FlightEntity>) flightRepo.findAll();
        PagedListHolder pagedListHolder = new PagedListHolder(flightList);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        modelMap.put("pagedListHolder", pagedListHolder);

        return "operation/listFlight";
    }

    //Edit Flight
    @RequestMapping(value = "/editFlight/{flightId}", method = RequestMethod.GET)
    public String showUpdateFlight(@PathVariable(value = "flightId") int flightId, Model model) {
        FlightEntity flight = flightRepo.findByFlightId(flightId);

        model.addAttribute("flight", flight);
        setDropdownAircraftList(model);
        setDropdownPromotionList(model);
        return "operation/updateFlight";
    }

    //update Flight
    @RequestMapping(value = "/updateFlight", method = RequestMethod.POST)
    public String updateFlight(FlightEntity flight, HttpServletRequest request, Model model, ModelMap modelMap) {
        flightRepo.save(flight);
        List<FlightEntity> flightList = (List<FlightEntity>) flightRepo.findAll();
        PagedListHolder pagedListHolder = new PagedListHolder(flightList);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        modelMap.put("pagedListHolder", pagedListHolder);

        return "operation/listFlight";
    }

    //Delete Flight
    @RequestMapping(value = "/deleteFlight/{flightId}", method = RequestMethod.GET)
    public String deleteFlight(@PathVariable(value = "flightId") int flightId, HttpServletRequest request, Model model, ModelMap modelMap) {

        try {
            flightRepo.deleteById(flightId);
        } catch (Exception e) {
            System.out.println(e);
        }
        List<FlightEntity> flightList = (List<FlightEntity>) flightRepo.findAll();
        PagedListHolder pagedListHolder = new PagedListHolder(flightList);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        modelMap.put("pagedListHolder", pagedListHolder);
        return "operation/listFlight";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    } 
    
    //Search Flight
    @RequestMapping(value = "/searchFlight", method = RequestMethod.GET)
    public String searchFlight(@RequestParam(name= "searchFlight")Date searchFlight,HttpServletRequest request, Model model, ModelMap modelMap){
        
        LocalDate date = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(searchFlight));
        
        List<FlightEntity> flightList = (List<FlightEntity>) flightRepo.findByFlightDate(date);
        
        PagedListHolder pagedListHolder = new PagedListHolder(flightList);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        modelMap.put("pagedListHolder", pagedListHolder);
        model.addAttribute("searchFlight", searchFlight);
         
        return "operation/listFlight";
    }
}
