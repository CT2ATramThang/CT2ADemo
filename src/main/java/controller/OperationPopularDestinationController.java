
package controller;

import entity.PopularDestinationEntity;
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
import repository.PopularDestinationRepository;

@Controller
public class OperationPopularDestinationController {
    @Autowired
    PopularDestinationRepository popularDestinationRepo;
    
    
    
    //List Popular Destination
    @RequestMapping(value="/listPopularDestination", method = RequestMethod.GET)
    public String showPopularDestination(HttpServletRequest request, Model model, ModelMap modelMap){
        List<PopularDestinationEntity> popularDestinationList = (List<PopularDestinationEntity>) popularDestinationRepo.findAll();
        
        PagedListHolder pagedListHolder = new PagedListHolder(popularDestinationList);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        modelMap.put("pagedListHolder", pagedListHolder);
        
        //model.addAttribute("popularDestinationList", popularDestinationList);
        
        return "operation/listPopularDestination";
    }
    
    //Add Popular Destination
    @RequestMapping(value = "/addPopularDestination", method = RequestMethod.GET)
    public String addPopularDestination(Model model) {
        model.addAttribute("popularDestination", new PopularDestinationEntity());

        return "operation/addPopularDestination";
    }
    
    // save add Popular Destination
    @RequestMapping(value = "/addPopularDestination", method = RequestMethod.POST)
    public String saveAddPopularDestination(PopularDestinationEntity popularDestination, 
            HttpServletRequest request, Model model, ModelMap modelMap) {
        popularDestinationRepo.save(popularDestination);
        List<PopularDestinationEntity> popularDestinationList = (List<PopularDestinationEntity>) popularDestinationRepo.findAll();
        PagedListHolder pagedListHolder = new PagedListHolder(popularDestinationList);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        modelMap.put("pagedListHolder", pagedListHolder);
        
        return "operation/listPopularDestination";
    }
    
    //Edit Popular Destination
    @RequestMapping(value = "/editPopularDestination/{popularDestinationId}", method = RequestMethod.GET)
    public String showUpdatePopularDestination(@PathVariable(value = "popularDestinationId") int popularDestinationId, Model model) {
        PopularDestinationEntity popularDestination = popularDestinationRepo.findByPopularDestinationId(popularDestinationId);

        model.addAttribute("popularDestination", popularDestination);
        
        return "operation/updatePopularDestination";
    }

    //update Popular Destination
    @RequestMapping(value = "/updatePopularDestination", method = RequestMethod.POST)
    public String updatePopularDestination(PopularDestinationEntity popularDestination, 
            HttpServletRequest request, Model model, ModelMap modelMap) {
        popularDestinationRepo.save(popularDestination);
        List<PopularDestinationEntity> popularDestinationList = (List<PopularDestinationEntity>) popularDestinationRepo.findAll();
        PagedListHolder pagedListHolder = new PagedListHolder(popularDestinationList);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        modelMap.put("pagedListHolder", pagedListHolder);

        return "operation/listPopularDestination";
    }
    
    //Delete Popular Destination
    @RequestMapping(value = "/deletePopularDestination/{popularDestinationId}", method = RequestMethod.GET)
    public String deletePopularDestination(@PathVariable(value = "popularDestinationId") int popularDestinationId, 
            HttpServletRequest request, Model model, ModelMap modelMap) {

        try {
            popularDestinationRepo.deleteById(popularDestinationId);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        List<PopularDestinationEntity> popularDestinationList = (List<PopularDestinationEntity>) popularDestinationRepo.findAll();
        PagedListHolder pagedListHolder = new PagedListHolder(popularDestinationList);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        modelMap.put("pagedListHolder", pagedListHolder);
        
        return "operation/listPopularDestination";
    }
    
    //Search Popular Destination
    @RequestMapping(value = "/searchPopularDestination", method = RequestMethod.GET)
    public String searchPopularDestination(@RequestParam(name= "searchPopularDestination")String searchPopularDestination,
            HttpServletRequest request, Model model, ModelMap modelMap){
        
        String tourName = "%" + searchPopularDestination + "%";
        String place = "%" + searchPopularDestination + "%";
        double price = 0.0;
        try{
            price = Double.parseDouble(searchPopularDestination);
        }catch(Exception e){
            price = 0.0;
        }
        
        List<PopularDestinationEntity> popularDestinationList = (List<PopularDestinationEntity>) popularDestinationRepo.findByTourNameLikeOrPlaceLikeOrPrice(tourName, place, price);
        PagedListHolder pagedListHolder = new PagedListHolder(popularDestinationList);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        modelMap.put("pagedListHolder", pagedListHolder);
        model.addAttribute("searchPopularDestination", searchPopularDestination);
         
        return "operation/listPopularDestination";
    }
}
