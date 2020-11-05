package controller;

import entity.AircraftEntity;
import entity.PopularDestinationEntity;
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
import repository.PopularDestinationRepository;

@Controller
public class OperationImagePopularDestinationController {

    @Autowired
    PopularDestinationRepository popularDestinationRepo;

    //List Popular Destination
    @RequestMapping(value = "/listImagePopularDestination", method = RequestMethod.GET)
    public String showImagePopularDestination(HttpServletRequest request, Model model, ModelMap modelMap) {
        List<PopularDestinationEntity> imagePopularDestinationList = (List<PopularDestinationEntity>) popularDestinationRepo.findAll();

        PagedListHolder pagedListHolder = new PagedListHolder(imagePopularDestinationList);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        modelMap.put("pagedListHolder", pagedListHolder);

        //model.addAttribute("imagePopularDestinationList", imagePopularDestinationList);
        return "operation/listImagePopularDestination";
    }

    //Add Image Popular Destination
    @RequestMapping(value = "/addImagePopularDestination", method = RequestMethod.GET)
    public String addImagePopularDestination(Model model) {
        model.addAttribute("imagePopularDestination", new PopularDestinationEntity());

        return "operation/addImagePopularDestination";
    }

    @RequestMapping(value = "/addImagePopularDestination", method = RequestMethod.POST)
    public String uploadFilePopularDestination(@RequestParam("imgPopularDestination") MultipartFile imgPopularDestination, HttpServletRequest request, Model model, ModelMap modelMap) {
        try {
            byte[] bytes = imgPopularDestination.getBytes();
            // Creating the directory to store file
            // Assume uploaded file location on web server is D:\file-upload
            String pathName = "D:\\Information_Technology\\Java\\JavaSpringProject\\project\\FlightBookingMVC\\src\\main\\webapp\\template\\images\\popular";
            File dir = new File(pathName);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            // Create the file on server
            String fileSource = dir.getAbsolutePath() + File.separator
                    + imgPopularDestination.getOriginalFilename();
            File serverFile = new File(fileSource);
            BufferedOutputStream stream
                    = new BufferedOutputStream(new FileOutputStream(serverFile));
            stream.write(bytes);
            stream.close();
            String message = "You uploaded successfully a file, at : " + fileSource;
            String fileName = imgPopularDestination.getOriginalFilename();
            model.addAttribute("message", message);
            model.addAttribute("filename", fileName);
        } catch (Exception e) {
            System.out.println(e);
            model.addAttribute("message", "Error when uploading file" + e);
        }

        List<PopularDestinationEntity> imagePopularDestinationList = (List<PopularDestinationEntity>) popularDestinationRepo.findAll();

        PagedListHolder pagedListHolder = new PagedListHolder(imagePopularDestinationList);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        modelMap.put("pagedListHolder", pagedListHolder);

        return "operation/listImagePopularDestination";
    }

    //Edit Image Popular Destination
    @RequestMapping(value = "/editImagePopularDestination/{popularDestinationId}", method = RequestMethod.GET)
    public String showUpdateImagePopularDestination(@PathVariable(value = "popularDestinationId") int popularDestinationId, Model model) {
        PopularDestinationEntity imagePopularDestination = popularDestinationRepo.findByPopularDestinationId(popularDestinationId);

        model.addAttribute("imagePopularDestination", imagePopularDestination);

        return "operation/updateImagePopularDestination";
    }

    //update Image Popular Destination
    @RequestMapping(value = "/updateImagePopularDestination", method = RequestMethod.POST)
    public String updateImagePopularDestination(PopularDestinationEntity imagePopularDestination, HttpServletRequest request, Model model, ModelMap modelMap) {
        popularDestinationRepo.save(imagePopularDestination);
        List<PopularDestinationEntity> imagePopularDestinationList = (List<PopularDestinationEntity>) popularDestinationRepo.findAll();
        PagedListHolder pagedListHolder = new PagedListHolder(imagePopularDestinationList);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        modelMap.put("pagedListHolder", pagedListHolder);

        return "operation/listImagePopularDestination";
    }

    //Delete Image Popular Destination
    @RequestMapping(value = "/deleteImagePopularDestination/{popularDestinationId}", method = RequestMethod.GET)
    public String deleteImagePopularDestination(@PathVariable(value = "popularDestinationId") int popularDestinationId, HttpServletRequest request, Model model, ModelMap modelMap) {

        try {
            popularDestinationRepo.deleteById(popularDestinationId);
            List<PopularDestinationEntity> imagePopularDestinationList = (List<PopularDestinationEntity>) popularDestinationRepo.findAll();
            PagedListHolder pagedListHolder = new PagedListHolder(imagePopularDestinationList);
            int page = ServletRequestUtils.getIntParameter(request, "p", 0);
            pagedListHolder.setPage(page);
            pagedListHolder.setPageSize(5);
            modelMap.put("pagedListHolder", pagedListHolder);
        } catch (Exception e) {
            System.out.println(e);
        }

        List<PopularDestinationEntity> imagePopularDestinationList = (List<PopularDestinationEntity>) popularDestinationRepo.findAll();
        model.addAttribute("imagePopularDestinationList", imagePopularDestinationList);

        return "operation/listImagePopularDestination";
    }

    //Search Aircraft
    @RequestMapping(value = "/searchImagePopularDestination", method = RequestMethod.GET)
    public String searchImagePopularDestination(@RequestParam(name = "searchImagePopularDestination") String searchImagePopularDestination, HttpServletRequest request, Model model, ModelMap modelMap) {

        String searchText = "%" + searchImagePopularDestination + "%";
        List<PopularDestinationEntity> imagePopularDestinationList = (List<PopularDestinationEntity>) popularDestinationRepo.findByTourNameLike(searchText);
        PagedListHolder pagedListHolder = new PagedListHolder(imagePopularDestinationList);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        modelMap.put("pagedListHolder", pagedListHolder);
        model.addAttribute("searchImagePopularDestination", searchImagePopularDestination);

        return "operation/listImagePopularDestination";
    }
}
