package controller;

import entity.AirPortStationEntity;
import entity.FlightRouteEntity;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import repository.AirPortStationRepository;
import repository.FlightRouteRepository;

@Controller
public class OperationFlightRouteController {

    @Autowired
    FlightRouteRepository flightRouteRepo;

    @Autowired
    AirPortStationRepository airPortStationRepo;

    //List FlightRoute
    @RequestMapping(value = "/listFlightRoute", method = RequestMethod.GET)
    public String getListFlightRoute(HttpServletRequest request, Model model, ModelMap modelMap) {
        List<FlightRouteEntity> flightRouteList = (List<FlightRouteEntity>) flightRouteRepo.findAll();

        PagedListHolder pagedListHolder = new PagedListHolder(flightRouteList);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        modelMap.put("pagedListHolder", pagedListHolder);

        //model.addAttribute("flightRouteList", flightRouteList);
        return "operation/listFlightRoute";
    }

    //Add setupFlightRoute
    @RequestMapping(value = "/setupFlightRoute", method = RequestMethod.GET)
    public String setupFlightRoute(Model model) {
        model.addAttribute("flightRoute", new FlightRouteEntity());
        setAirPortDropdownToList(model);
        return "operation/addFlightRoute";
    }

    private void setAirPortDropdownToList(Model model) {
        List<AirPortStationEntity> airPortStationList = (List<AirPortStationEntity>) airPortStationRepo.findAll();
        if (!airPortStationList.isEmpty()) {
            Map<Integer, String> airPortMap = new LinkedHashMap<>();

            for (AirPortStationEntity airPortStation : airPortStationList) {
                airPortMap.put(airPortStation.getAirPortStationId(), airPortStation.getAirportName());
            }
            model.addAttribute("airPortStationList", airPortMap);
        }
    }

    //save setupFlightRoute
    @RequestMapping(value = "/setupFlightRoute", method = RequestMethod.POST)
    public String saveSetupFlightRoute(FlightRouteEntity flightRoute, HttpServletRequest request, Model model, ModelMap modelMap) {
        flightRouteRepo.save(flightRoute);
        List<FlightRouteEntity> flightRouteList = (List<FlightRouteEntity>) flightRouteRepo.findAll();
        PagedListHolder pagedListHolder = new PagedListHolder(flightRouteList);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        modelMap.put("pagedListHolder", pagedListHolder);

        return "operation/listFlightRoute";
    }

    //Edit FlightRoute
    @RequestMapping(value = "/editFlightRoute/{flightRouteId}", method = RequestMethod.GET)
    public String showUpdateFlightRoute(@PathVariable(value = "flightRouteId") int flightRouteId, Model model) {
        FlightRouteEntity flightRoute = flightRouteRepo.findById(flightRouteId);
        setAirPortDropdownToList(model);
        model.addAttribute("flightRoute", flightRoute);

        return "operation/updateFlightRoute";
    }

    //update FlightRoute
    @RequestMapping(value = "/updateFlightRoute", method = RequestMethod.POST)
    public String updateFlightRoute(FlightRouteEntity flightRoute, HttpServletRequest request, Model model, ModelMap modelMap) {
        flightRouteRepo.save(flightRoute);
        List<FlightRouteEntity> flightRouteList = (List<FlightRouteEntity>) flightRouteRepo.findAll();
        PagedListHolder pagedListHolder = new PagedListHolder(flightRouteList);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        modelMap.put("pagedListHolder", pagedListHolder);

        return "operation/listFlightRoute";
    }

    //Delete FlightRoute
    @RequestMapping(value = "/deleteFlightRoute/{flightRouteId}", method = RequestMethod.GET)
    public String deleteFlightRoute(@PathVariable(value = "flightRouteId") int flightRouteId, HttpServletRequest request, Model model, ModelMap modelMap) {

        try {
            flightRouteRepo.deleteById(flightRouteId);
            List<FlightRouteEntity> flightRouteList = (List<FlightRouteEntity>) flightRouteRepo.findAll();
            PagedListHolder pagedListHolder = new PagedListHolder(flightRouteList);
            int page = ServletRequestUtils.getIntParameter(request, "p", 0);
            pagedListHolder.setPage(page);
            pagedListHolder.setPageSize(5);
            modelMap.put("pagedListHolder", pagedListHolder);
        } catch (Exception e) {
            System.out.println(e);
        }

        return "operation/listFlightRoute";
    }

    //Search FlightRoute
    @RequestMapping(value = "/searchFlightRoute", method = RequestMethod.GET)
    public String searchFlightRoute(@RequestParam(name = "searchFlightRoute") double searchFlightRoute, HttpServletRequest request, Model model, ModelMap modelMap) {

        //String searchText = "%" + searchFlightRoute + "%";
        int duration = (int)searchFlightRoute;
        
        List<FlightRouteEntity> flightRouteList = (List<FlightRouteEntity>) flightRouteRepo.findByStandPriceOrDistanceOrDuration(searchFlightRoute, searchFlightRoute, duration);
        PagedListHolder pagedListHolder = new PagedListHolder(flightRouteList);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        modelMap.put("pagedListHolder", pagedListHolder);
        model.addAttribute("searchFlightRoute", searchFlightRoute);

        return "operation/listFlightRoute";
    }
}
