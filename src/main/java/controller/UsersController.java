
package controller;

import entity.UsersEntity;
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
import repository.UsersRepository;

@Controller
public class UsersController {
    @Autowired
    UsersRepository usersRepo;
    
    @RequestMapping(value = "/listUsers", method = RequestMethod.GET)
    public String listAdminPage(Model model, HttpServletRequest request, ModelMap modelMap) {
        List<UsersEntity> usersList = (List<UsersEntity>)usersRepo.findAll();
        
        PagedListHolder pagedListHolder = new PagedListHolder(usersList);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        modelMap.put("pagedListHolder", pagedListHolder);
        
        return "admin/listUsers";
    }
    
    //add Users
    @RequestMapping(value = "/addUsers", method = RequestMethod.GET)
    public String setupAircraft(Model model) {
        model.addAttribute("users", new UsersEntity());

        return "admin/addUsers";
    }

    //save User
    @RequestMapping(value = "/addUsers", method = RequestMethod.POST)
    public String saveSetupAirCraft(UsersEntity users, HttpServletRequest request, Model model, ModelMap modelMap) {
        usersRepo.save(users);
        List<UsersEntity> usersList = (List<UsersEntity>)usersRepo.findAll();
        
        PagedListHolder pagedListHolder = new PagedListHolder(usersList);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        modelMap.put("pagedListHolder", pagedListHolder);

        return "admin/listUsers";
    }
    
    //Edit User
    @RequestMapping(value = "/editUsers/{userId}", method = RequestMethod.GET)
    public String showUpdateAircraft(@PathVariable(value = "userId") int userId, Model model) {
        UsersEntity users = usersRepo.findByUserId(userId);

        model.addAttribute("users", users);

        return "admin/updateUsers";
    }

    //update User 
    @RequestMapping(value = "/updateUsers", method = RequestMethod.POST)
    public String updateAirCraft(UsersEntity users, HttpServletRequest request, Model model, ModelMap modelMap) {
        usersRepo.save(users);
        List<UsersEntity> usersList = (List<UsersEntity>)usersRepo.findAll();
        
        PagedListHolder pagedListHolder = new PagedListHolder(usersList);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        modelMap.put("pagedListHolder", pagedListHolder);

        return "admin/listUsers";
    }
    
    //Delete Users
    @RequestMapping(value = "/deleteUsers/{userId}", method = RequestMethod.GET)
    public String deleteFlight(@PathVariable(value = "userId") int userId, HttpServletRequest request, Model model, ModelMap modelMap) {

        try {
            usersRepo.deleteById(userId);
        } catch (Exception e) {
            System.out.println(e);
        }
        List<UsersEntity> usersList = (List<UsersEntity>)usersRepo.findAll();
        
        PagedListHolder pagedListHolder = new PagedListHolder(usersList);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        modelMap.put("pagedListHolder", pagedListHolder);
        return "admin/listUsers";
    }
}
