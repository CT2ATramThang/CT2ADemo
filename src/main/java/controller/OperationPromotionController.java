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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import repository.PromotionRepository;

@Controller
public class OperationPromotionController {

    @Autowired
    PromotionRepository promotionRepo;

    //List Promotion
    @RequestMapping(value = "/listPromotion", method = RequestMethod.GET)
    public String getListPromotion(HttpServletRequest request, Model model, ModelMap modelMap) {
        List<PromotionEntity> promotionList = (List<PromotionEntity>) promotionRepo.findAll();

        PagedListHolder pagedListHolder = new PagedListHolder(promotionList);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        modelMap.put("pagedListHolder", pagedListHolder);

        //model.addAttribute("promotionList", promotionList);
        return "operation/listPromotion";
    }

    //add setup Promotion
    @RequestMapping(value = "/setupPromotion", method = RequestMethod.GET)
    public String setupPromotion(Model model) {
        model.addAttribute("promotion", new PromotionEntity());

        return "operation/addPromotion";
    }

    // save add setup Promotion
    @RequestMapping(value = "/setupPromotion", method = RequestMethod.POST)
    public String saveSetupPromotion(PromotionEntity promotion, HttpServletRequest request, Model model, ModelMap modelMap) {

        /*try {
            byte[] bytes = imagePromotion.getBytes();
            // Creating the directory to store file
            // Assume uploaded file location on web server is D:\file-upload
            String pathName = "D:\\Information_Technology\\Java\\JavaSpringProject\\project\\FlightBookingMVC_Thang\\src\\main\\webapp\\template\\images\\promotion";
            File dir = new File(pathName);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            // Create the file on server
            String fileSource = dir.getAbsolutePath() + File.separator
                    + imagePromotion.getOriginalFilename();
            File serverFile = new File(fileSource);
            BufferedOutputStream stream
                    = new BufferedOutputStream(new FileOutputStream(serverFile));
            stream.write(bytes);
            stream.close();
            String message = "You uploaded successfully a file, at : " + fileSource;
            promotion.setImagePromotion(imagePromotion.getOriginalFilename());
            
            model.addAttribute("message", message);
            //model.addAttribute("filename", promotion);

        } catch (Exception e) {
            System.out.println(e);
            model.addAttribute("message", "Error when uploading file" + e);
        }*/
        
        promotionRepo.save(promotion);
        
        List<PromotionEntity> promotionList = (List<PromotionEntity>) promotionRepo.findAll();
        PagedListHolder pagedListHolder = new PagedListHolder(promotionList);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        modelMap.put("pagedListHolder", pagedListHolder);

        return "operation/listPromotion";
    }

    //Edit Promotion
    @RequestMapping(value = "/editPromotion/{promotionId}", method = RequestMethod.GET)
    public String showUpdatePromotion(@PathVariable(value = "promotionId") int promotionId, Model model) {
        PromotionEntity promotion = promotionRepo.findById(promotionId);

        model.addAttribute("promotion", promotion);

        return "operation/updatePromotion";
    }

    //update Promotion
    @RequestMapping(value = "/updatePromotion", method = RequestMethod.POST)
    public String updatePromotion(PromotionEntity promotion, HttpServletRequest request, Model model, ModelMap modelMap) {
        promotionRepo.save(promotion);
        List<PromotionEntity> promotionList = (List<PromotionEntity>) promotionRepo.findAll();
        PagedListHolder pagedListHolder = new PagedListHolder(promotionList);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        modelMap.put("pagedListHolder", pagedListHolder);

        return "operation/listPromotion";
    }

    //Delete Promotion
    @RequestMapping(value = "/deletePromotion/{promotionId}", method = RequestMethod.GET)
    public String deletePromotion(@PathVariable(value = "promotionId") int promotionId,
            HttpServletRequest request, Model model, ModelMap modelMap) {

        try {
            promotionRepo.deleteById(promotionId);

        } catch (Exception e) {
            System.out.println(e);
        }

        List<PromotionEntity> promotionList = (List<PromotionEntity>) promotionRepo.findAll();
        PagedListHolder pagedListHolder = new PagedListHolder(promotionList);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        modelMap.put("pagedListHolder", pagedListHolder);

        return "operation/listPromotion";
    }

    //Search Promotion
    @RequestMapping(value = "/searchPromotion", method = RequestMethod.GET)
    public String searchPromotion(@RequestParam(name = "searchPromotion") String searchPromotion,
            HttpServletRequest request, Model model, ModelMap modelMap) {

        String promotionName = "%" + searchPromotion + "%";
        double valueOfPromotion = 0.0;
        try{
            valueOfPromotion = Double.parseDouble(searchPromotion);
        }catch(Exception e){
            valueOfPromotion = 0.0;
        }

        List<PromotionEntity> promotionList = (List<PromotionEntity>) promotionRepo.findByPromotionNameLikeOrValueOfPromotion(promotionName, valueOfPromotion);
        PagedListHolder pagedListHolder = new PagedListHolder(promotionList);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        modelMap.put("pagedListHolder", pagedListHolder);
        model.addAttribute("searchPromotion", searchPromotion);

        return "operation/listPromotion";
    }
}
