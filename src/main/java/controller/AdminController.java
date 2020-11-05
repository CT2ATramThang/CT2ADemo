
package controller;

import entity.UserRolesEntity;
import entity.UsersEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import repository.UserRolesRepository;
import repository.UsersRepository;

@Controller
public class AdminController {
    @Autowired
    UserRolesRepository userRolesRepo;
    @Autowired
    UsersRepository usersRepo;
    
    @RequestMapping(value = "/admin/showAdminPage", method = RequestMethod.GET)
    public String showAdminPage(Model model) {
        List<UsersEntity> users = (List<UsersEntity>)usersRepo.findAll();
        List<UserRolesEntity> userRoles = (List<UserRolesEntity>)userRolesRepo.findAll();
        
        int count = 0;
        for (int i = 0; i < users.size(); i++) {
            count++;
            
        }
        int count1 = 0;
        for (int i = 0; i < userRoles.size(); i++) {
            count1++;
            
        }
        model.addAttribute("count", count);
        model.addAttribute("count1", count1);
        
        return "admin/adminHome";
    }
    
    
}
