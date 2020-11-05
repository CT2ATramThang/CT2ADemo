package controller;

import entity.AircraftEntity;
import java.util.List;
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
import repository.AircraftRepository;

@Controller
public class OperationAircraftController {

    @Autowired
    AircraftRepository aircraftRepo;

    //List setup Aircraft
    @RequestMapping(value = "/listAircraft", method = RequestMethod.GET)
    public String getListAircraft(HttpServletRequest request, Model model, ModelMap modelMap) {
        List<AircraftEntity> aircraftList = (List<AircraftEntity>) aircraftRepo.findAll();

        PagedListHolder pagedListHolder = new PagedListHolder(aircraftList);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        modelMap.put("pagedListHolder", pagedListHolder);

        //model.addAttribute("aircraftList", aircraftList);
        return "operation/listAircraft";
    }

    //add Aircraft
    @RequestMapping(value = "/setupAircraft", method = RequestMethod.GET)
    public String setupAircraft(Model model) {
        model.addAttribute("aircraft", new AircraftEntity());

        return "operation/addAircraft";
    }

    //save setupAircraft
    @RequestMapping(value = "/setupAircraft", method = RequestMethod.POST)
    public String saveSetupAirCraft(AircraftEntity aircraft, HttpServletRequest request, Model model, ModelMap modelMap) {
        aircraftRepo.save(aircraft);
        List<AircraftEntity> aircraftList = (List<AircraftEntity>) aircraftRepo.findAll();
        PagedListHolder pagedListHolder = new PagedListHolder(aircraftList);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        modelMap.put("pagedListHolder", pagedListHolder);

        return "operation/listAircraft";
    }

    //Edit Aircraft
    @RequestMapping(value = "/editAircraft/{aircraftId}", method = RequestMethod.GET)
    public String showUpdateAircraft(@PathVariable(value = "aircraftId") int aircraftId, Model model) {
        AircraftEntity aircraft = aircraftRepo.findById(aircraftId);

        model.addAttribute("aircraft", aircraft);

        return "operation/updateAircraft";
    }

    //update Aircraft
    @RequestMapping(value = "/updateAircraft", method = RequestMethod.POST)
    public String updateAirCraft(AircraftEntity aircraft, HttpServletRequest request, Model model, ModelMap modelMap) {
        aircraftRepo.save(aircraft);
        List<AircraftEntity> aircraftList = (List<AircraftEntity>) aircraftRepo.findAll();
        PagedListHolder pagedListHolder = new PagedListHolder(aircraftList);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        modelMap.put("pagedListHolder", pagedListHolder);

        return "operation/listAircraft";
    }

    //Delete Aircraft
    @RequestMapping(value = "/deleteAircraft/{aircraftId}", method = RequestMethod.GET)
    public String deleteAircraft(@PathVariable(value = "aircraftId") int aircraftId, HttpServletRequest request, Model model, ModelMap modelMap) {

        try {
            aircraftRepo.deleteById(aircraftId);
            List<AircraftEntity> aircraftList = (List<AircraftEntity>) aircraftRepo.findAll();
            PagedListHolder pagedListHolder = new PagedListHolder(aircraftList);
            int page = ServletRequestUtils.getIntParameter(request, "p", 0);
            pagedListHolder.setPage(page);
            pagedListHolder.setPageSize(5);
            modelMap.put("pagedListHolder", pagedListHolder);
        } catch (Exception e) {
            System.out.println(e);
        }

        return "operation/listAircraft";
    }

    //Search Aircraft
    @RequestMapping(value = "/searchAircraft", method = RequestMethod.GET)
    public String searchAircraft(@RequestParam(name = "searchAircraft") String searchAircraft, 
            HttpServletRequest request, Model model, ModelMap modelMap) {

        String searchText = "%" + searchAircraft + "%";
        int numberOfCommercialSeats = 0;
        int numberOfVIP = 0;
        
        try{
            numberOfCommercialSeats = Integer.parseInt(searchAircraft);
            numberOfVIP = Integer.parseInt(searchAircraft);
        }catch(Exception e){
            numberOfCommercialSeats = 0;
            numberOfVIP = 0;
        }
        List<AircraftEntity> aircraftList = (List<AircraftEntity>) 
                aircraftRepo.findByAirNumberLikeOrNumberOfCommercialSeatsOrNumberOfVIP(searchText, numberOfCommercialSeats, numberOfVIP);
        
        PagedListHolder pagedListHolder = new PagedListHolder(aircraftList);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        modelMap.put("pagedListHolder", pagedListHolder);
        model.addAttribute("searchAircraft", searchAircraft);

        return "operation/listAircraft";
    }
}
