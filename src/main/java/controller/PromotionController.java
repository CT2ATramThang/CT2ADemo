
package controller;

import entity.PromotionEntity;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import repository.PromotionRepository;

@Controller
public class PromotionController {
    @Autowired
    PromotionRepository promotionRepo;
    
    @RequestMapping(value="/promotion", method = RequestMethod.GET)
    public String showAirPortStationForm(HttpServletRequest request, Model model, ModelMap modelMap){
        List<PromotionEntity> promotionList = (List<PromotionEntity>) promotionRepo.findAll();
        
        PagedListHolder pagedListHolder = new PagedListHolder(promotionList);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        modelMap.put("pagedListHolder", pagedListHolder);
        
        return "promotion/promotion";
    }
}
