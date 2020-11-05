
package controller;

import entity.TicketTypeEntity;
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
import repository.TicketTypeRepository;

@Controller
public class OperationTicketTypeController {
    @Autowired
    TicketTypeRepository ticketTypeRepo;
    
    //List Ticket Type
    @RequestMapping(value = "/listTicketType", method = RequestMethod.GET)
    public String getListTicketType(HttpServletRequest request, Model model, ModelMap modelMap) {
        List<TicketTypeEntity> ticketTypeList = (List<TicketTypeEntity>) ticketTypeRepo.findAll();
        
        PagedListHolder pagedListHolder = new PagedListHolder(ticketTypeList);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        modelMap.put("pagedListHolder", pagedListHolder);
        
        //model.addAttribute("ticketTypeList", ticketTypeList);

        return "operation/listTicketType";
    }

    //add setupTicketType
    @RequestMapping(value = "/setupTicketType", method = RequestMethod.GET)
    public String setupTicketType(Model model) {
        model.addAttribute("ticketType", new TicketTypeEntity());

        return "operation/addTicketType";
    }

    //save ticketType
    @RequestMapping(value = "/setupTicketType", method = RequestMethod.POST)
    public String saveSetupTicketType(TicketTypeEntity ticketType, 
            HttpServletRequest request, Model model, ModelMap modelMap) {
        //double exchanges = exchange/100;

        ticketTypeRepo.save(ticketType);
        List<TicketTypeEntity> ticketTypeList = (List<TicketTypeEntity>) ticketTypeRepo.findAll();
        PagedListHolder pagedListHolder = new PagedListHolder(ticketTypeList);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        modelMap.put("pagedListHolder", pagedListHolder);
        
        return "operation/listTicketType";
    }

    //Edit ticketType
    @RequestMapping(value = "/editTicketType/{ticketTypeId}", method = RequestMethod.GET)
    public String showUpdateTicketType(@PathVariable(value = "ticketTypeId") int ticketTypeId, Model model) {
        TicketTypeEntity ticketType = ticketTypeRepo.findById(ticketTypeId);

        model.addAttribute("ticketType", ticketType);

        return "operation/updateTicketType";
    }

    //update ticketType
    @RequestMapping(value = "/updateTicketType", method = RequestMethod.POST)
    public String updateTicketType(TicketTypeEntity ticketType, 
            HttpServletRequest request, Model model, ModelMap modelMap) {
        ticketTypeRepo.save(ticketType);
        List<TicketTypeEntity> ticketTypeList = (List<TicketTypeEntity>) ticketTypeRepo.findAll();
        PagedListHolder pagedListHolder = new PagedListHolder(ticketTypeList);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        modelMap.put("pagedListHolder", pagedListHolder);

        return "operation/listTicketType";
    }

    //Delete TicketType
    @RequestMapping(value = "/deleteTicketType/{ticketTypeId}", method = RequestMethod.GET)
    public String deleteTicketType(@PathVariable(value = "ticketTypeId") int ticketTypeId, 
            HttpServletRequest request, Model model, ModelMap modelMap) {

        try {
            ticketTypeRepo.deleteById(ticketTypeId);
        } catch (Exception e) {
            System.out.println(e);
        }
        List<TicketTypeEntity> ticketTypeList = (List<TicketTypeEntity>) ticketTypeRepo.findAll();
        PagedListHolder pagedListHolder = new PagedListHolder(ticketTypeList);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        modelMap.put("pagedListHolder", pagedListHolder);

        return "operation/listTicketType";
    }
}
