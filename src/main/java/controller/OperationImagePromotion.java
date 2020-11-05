package controller;

import entity.PromotionEntity;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
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
import org.springframework.web.multipart.MultipartFile;
import repository.PromotionRepository;

@Controller
public class OperationImagePromotion {

    @Autowired
    PromotionRepository promotionRepo;

    //List Image Promotion
    @RequestMapping(value = "/listImagePromotion", method = RequestMethod.GET)
    public String showImagePromotion(HttpServletRequest request, Model model, ModelMap modelMap) {
        List<PromotionEntity> imagePromotionList = (List<PromotionEntity>) promotionRepo.findAll();

        PagedListHolder pagedListHolder = new PagedListHolder(imagePromotionList);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        modelMap.put("pagedListHolder", pagedListHolder);

        //model.addAttribute("imagePromotionList", imagePromotionList);
        return "operation/listImagePromotion";
    }

    //Add Image Promotion
    @RequestMapping(value = "/addImagePromotion", method = RequestMethod.GET)
    public String addImagePromotion(Model model) {
        model.addAttribute("imagePromotion", new PromotionEntity());

        return "operation/addImagePromotion";
    }

    @RequestMapping(value = "/addImagePromotion", method = RequestMethod.POST)
    public String uploadFilePromotion(@RequestParam("imagePromotion") MultipartFile imagePromotion,
            HttpServletRequest request, Model model, ModelMap modelMap) {
        try {
            byte[] bytes = imagePromotion.getBytes();
            // Creating the directory to store file
            // Assume uploaded file location on web server is D:\file-upload
            String pathName = "D:\\Information_Technology\\Java\\JavaSpringProject\\project\\FlightBookingMVC\\src\\main\\webapp\\template\\images\\promotion";
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
            String fileName = imagePromotion.getOriginalFilename();
            model.addAttribute("message", message);
            model.addAttribute("filename", fileName);
        } catch (Exception e) {
            System.out.println(e);
            model.addAttribute("message", "Error when uploading file" + e);
        }

        List<PromotionEntity> imagePromotionList = (List<PromotionEntity>) promotionRepo.findAll();
        PagedListHolder pagedListHolder = new PagedListHolder(imagePromotionList);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        modelMap.put("pagedListHolder", pagedListHolder);

        return "operation/listImagePromotion";
    }

    //Edit Image Promotion
    @RequestMapping(value = "/editImagePromotion/{promotionId}", method = RequestMethod.GET)
    public String showUpdateImagePromotion(@PathVariable(value = "promotionId") int promotionId, Model model) {
        PromotionEntity imagePromotion = promotionRepo.findById(promotionId);

        model.addAttribute("imagePromotion", imagePromotion);

        return "operation/updateImagePromotion";
    }

    //update Image Promotion
    @RequestMapping(value = "/updateImagePromotion", method = RequestMethod.POST)
    public String updateImagePromotion(PromotionEntity imagePromotion,
            HttpServletRequest request, Model model, ModelMap modelMap) {
        promotionRepo.save(imagePromotion);
        List<PromotionEntity> imagePromotionList = (List<PromotionEntity>) promotionRepo.findAll();
        PagedListHolder pagedListHolder = new PagedListHolder(imagePromotionList);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        modelMap.put("pagedListHolder", pagedListHolder);

        return "operation/listImagePromotion";
    }

    //Delete Image Promotion
    @RequestMapping(value = "/deleteImagePromotion/{promotionId}", method = RequestMethod.GET)
    public String deleteImagePromotion(@PathVariable(value = "promotionId") int promotionId,
            HttpServletRequest request, Model model, ModelMap modelMap) {

        try {
            promotionRepo.deleteById(promotionId);
        } catch (Exception e) {
            System.out.println(e);
        }

        List<PromotionEntity> imagePromotionList = (List<PromotionEntity>) promotionRepo.findAll();
        PagedListHolder pagedListHolder = new PagedListHolder(imagePromotionList);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        modelMap.put("pagedListHolder", pagedListHolder);

        return "operation/listImagePromotion";
    }
    
    //Search Promotion
    @RequestMapping(value = "/searchImagePromotion", method = RequestMethod.GET)
    public String searchPromotion(@RequestParam(name = "searchImagePromotion") String searchImagePromotion,
            HttpServletRequest request, Model model, ModelMap modelMap) {

        String promotionName = "%" + searchImagePromotion + "%";
        double valueOfPromotion = 0.0;
        try{
            valueOfPromotion = Double.parseDouble(searchImagePromotion);
        }catch(Exception e){
            valueOfPromotion = 0.0;
        }

        List<PromotionEntity> imagePromotionList = (List<PromotionEntity>) promotionRepo.findByPromotionNameLikeOrValueOfPromotion(promotionName, valueOfPromotion);
        PagedListHolder pagedListHolder = new PagedListHolder(imagePromotionList);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        modelMap.put("pagedListHolder", pagedListHolder);

        return "operation/listImagePromotion";
    }
}
