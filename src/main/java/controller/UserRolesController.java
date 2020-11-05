
package controller;

import entity.RolesEntity;
import entity.UserRolesEntity;
import entity.UsersEntity;
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
import repository.RolesRepository;
import repository.UserRolesRepository;
import repository.UsersRepository;

@Controller
public class UserRolesController {
    @Autowired
    UserRolesRepository userRolesRepo;
    @Autowired
    UsersRepository usersRepo;
    @Autowired
    RolesRepository rolesRepo;
    
    //List 
    @RequestMapping(value = "/listUserRoles", method = RequestMethod.GET)
    public String listAdminPage(Model model, HttpServletRequest request, ModelMap modelMap) {
        List<UserRolesEntity> userRolesList = (List<UserRolesEntity>)userRolesRepo.findAll();
        
        PagedListHolder pagedListHolder = new PagedListHolder(userRolesList);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        modelMap.put("pagedListHolder", pagedListHolder);
        
        return "admin/listUserRoles";
    }
    
    //add User Roles
    @RequestMapping(value = "/addUserRoles", method = RequestMethod.GET)
    public String setupAircraft(Model model) {
        model.addAttribute("userRoles", new UserRolesEntity());
        setDropdownUsersNameList(model);
        setDropdownUserstList(model);
        setDropdownRolesList(model);
        return "admin/addUserRoles";
    }
    
    private void setDropdownUsersNameList(Model model) {
        List<UsersEntity> userList = (List<UsersEntity>) usersRepo.findAll();
        if (!userList.isEmpty()) {
            Map<String, String> usersMap = new LinkedHashMap<>();

            for (UsersEntity users : userList) {
                usersMap.put(users.getUserName(), users.getUserName());
            }
            model.addAttribute("userNameList", usersMap);
        }
    }
    
    private void setDropdownUserstList(Model model) {
        List<UsersEntity> userList = (List<UsersEntity>) usersRepo.findAll();
        if (!userList.isEmpty()) {
            Map<Integer, String> usersMap = new LinkedHashMap<>();

            for (UsersEntity users : userList) {
                usersMap.put(users.getUserId(), users.getUserName());
            }
            model.addAttribute("userList", usersMap);
        }
    }
    
    private void setDropdownRolesList(Model model) {
        List<RolesEntity> rolesList = (List<RolesEntity>) rolesRepo.findAll();
        if (!rolesList.isEmpty()) {
            Map<Integer, String> rolesMap = new LinkedHashMap<>();

            for (RolesEntity roles : rolesList) {
                rolesMap.put(roles.getRolesId(), roles.getRole());
            }
            model.addAttribute("rolesList", rolesMap);
        }
    }
    
    //save User Roles
    @RequestMapping(value = "/addUserRoles", method = RequestMethod.POST)
    public String saveSetupAirCraft(UserRolesEntity userRoles, HttpServletRequest request, Model model, ModelMap modelMap) {
        userRolesRepo.save(userRoles);
        List<UserRolesEntity> userRolesList = (List<UserRolesEntity>)userRolesRepo.findAll();
        
        PagedListHolder pagedListHolder = new PagedListHolder(userRolesList);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        modelMap.put("pagedListHolder", pagedListHolder);

        return "admin/listUserRoles";
    }
    
    /*//Edit User Roles
    @RequestMapping(value = "/editUserRoles/{userRolesId}", method = RequestMethod.GET)
    public String showUpdateAircraft(@PathVariable(value = "userRolesId") int userRolesId, Model model) {
        UserRolesEntity userRoles = userRolesRepo.findByUserRolesId(userRolesId);

        model.addAttribute("userRoles", userRoles);

        return "admin/updateUserRoles";
    }

    //update User Roles
    @RequestMapping(value = "/updateUserRoles", method = RequestMethod.POST)
    public String updateAirCraft(UserRolesEntity userRoles, HttpServletRequest request, Model model, ModelMap modelMap) {
        userRolesRepo.save(userRoles);
        List<UserRolesEntity> userRolesList = (List<UserRolesEntity>)userRolesRepo.findAll();
        
        PagedListHolder pagedListHolder = new PagedListHolder(userRolesList);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        modelMap.put("pagedListHolder", pagedListHolder);

        return "admin/listUserRoles";
    }*/
    
    //Delete Users
    @RequestMapping(value = "/deleteUserRoles/{userRolesId}", method = RequestMethod.GET)
    public String deleteFlight(@PathVariable(value = "userRolesId") int userRolesId, HttpServletRequest request, Model model, ModelMap modelMap) {

        try {
            userRolesRepo.deleteById(userRolesId);
        } catch (Exception e) {
            System.out.println(e);
        }
        List<UserRolesEntity> userRoles = (List<UserRolesEntity>)userRolesRepo.findAll();
        
        PagedListHolder pagedListHolder = new PagedListHolder(userRoles);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        modelMap.put("pagedListHolder", pagedListHolder);
        return "admin/listUserRoles";
    }
}
