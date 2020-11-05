
package controller;

import entity.ImageBannerEntity;
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
import repository.ImageBannerRepository;

@Controller
public class OperationImageBannerController {
    @Autowired
    ImageBannerRepository imageBannerRepo;
    
    
    
    //List image banner
    @RequestMapping(value="/listImageBanner", method = RequestMethod.GET)
    public String showImageBanner(HttpServletRequest request, Model model, ModelMap modelMap){
        List<ImageBannerEntity> imageBannerList = (List<ImageBannerEntity>)imageBannerRepo.findAll();
        
        PagedListHolder pagedListHolder = new PagedListHolder(imageBannerList);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        modelMap.put("pagedListHolder", pagedListHolder);
        
        //model.addAttribute("imageBannerList", imageBannerList);
        
        return "operation/listImageBanner";
    }
    
    //add image banner
    @RequestMapping(value = "/addImageBanner", method = RequestMethod.GET)
    public String addImageBanner(Model model) {
        model.addAttribute("imageBanner", new ImageBannerEntity());

        return "operation/addImageBanner";
    }
    
    @RequestMapping(value = "/addImageBanner", method = RequestMethod.POST)
    public String uploadFile(@RequestParam("imgName") MultipartFile imgName, HttpServletRequest request, Model model, ModelMap modelMap){
        try {
            byte[] bytes = imgName.getBytes();
            // Creating the directory to store file
            // Assume uploaded file location on web server is D:\file-upload
            String pathName = "D:\\Information_Technology\\Java\\JavaSpringProject\\project\\FlightBookingMVC\\src\\main\\webapp\\template\\images\\banner";
            File dir = new File(pathName);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            // Create the file on server
            String fileSource = dir.getAbsolutePath() + File.separator 
                    + imgName.getOriginalFilename();
            File serverFile = new File(fileSource);
            BufferedOutputStream stream = 
                    new BufferedOutputStream(new FileOutputStream(serverFile));
            stream.write(bytes);
            stream.close();
            String message="You uploaded successfully a file, at : " + fileSource;
            String fileName = imgName.getOriginalFilename();
            model.addAttribute("message", message);
            model.addAttribute("filename", fileName);
            
            
        } catch (Exception e) {
            System.out.println(e);
            model.addAttribute("message", "Error when uploading file"+ e);          
        }
        
        List<ImageBannerEntity> imageBannerList = (List<ImageBannerEntity>)imageBannerRepo.findAll();
        
        PagedListHolder pagedListHolder = new PagedListHolder(imageBannerList);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        modelMap.put("pagedListHolder", pagedListHolder);
        
        return "operation/listImageBanner";
    }
    
    //Edit Image Banner
    @RequestMapping(value = "/editImageBanner/{imgId}", method = RequestMethod.GET)
    public String showUpdateImageBanner(@PathVariable(value = "imgId") int imgId, Model model) {
        ImageBannerEntity imageBanner = imageBannerRepo.findByImgId(imgId);
        
        model.addAttribute("imageBanner", imageBanner);
        
        return "operation/updateImageBanner";
    }

    //update Image Banner
    @RequestMapping(value = "/updateImageBanner", method = RequestMethod.POST)
    public String updateImageBanner(ImageBannerEntity imageBanner, HttpServletRequest request, Model model, ModelMap modelMap) {
        imageBannerRepo.save(imageBanner);
        List<ImageBannerEntity> imageBannerList = (List<ImageBannerEntity>)imageBannerRepo.findAll();
        PagedListHolder pagedListHolder = new PagedListHolder(imageBannerList);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        modelMap.put("pagedListHolder", pagedListHolder);

        return "operation/listImageBanner";
    }
}
