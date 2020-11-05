package controller;

import entity.BookingEntity;
import entity.CustomerEntity;
import entity.TicketEntity;
import java.time.LocalDate;
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
import repository.BookingRepository;
import repository.CustomerRepository;
import repository.TicketRepository;

@Controller
@RequestMapping(value = "/")
public class OperationController {

    @Autowired
    BookingRepository bookingRepo;
    @Autowired
    CustomerRepository customerRepo;
    @Autowired
    TicketRepository ticketRepo;

    //login
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    //setup
    /*@RequestMapping(value = "/operationFlight", method = RequestMethod.GET)
    public String showUserPage() {
        return "operation/operationFlight";
    }*/
    @RequestMapping(value = "/operation/showOperationPage", method = RequestMethod.GET)
    public String showOperationPage(Model model, HttpServletRequest request, ModelMap modelMap) {
        List<BookingEntity> bookingList = (List<BookingEntity>) bookingRepo.findAll();
        List<CustomerEntity> customerList = (List<CustomerEntity>) customerRepo.findAll();
        List<TicketEntity> ticketList = (List<TicketEntity>) ticketRepo.findAll();
        
        LocalDate min = LocalDate.now().minusMonths(1);
        LocalDate max = LocalDate.now();
        List<BookingEntity> bookingDate = (List<BookingEntity>) bookingRepo.findByDateBookingBetween(min, max);
        
        PagedListHolder pagedListHolder = new PagedListHolder(bookingDate);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        modelMap.put("pagedListHolder", pagedListHolder);
        
        int count2 = 0;
        int count1 = 0;
        int count = 0;
        double sum = 0.0;

        for (BookingEntity book : bookingList) {
            sum += book.getTotal();
            
        }
        
        for (int i = 0; i < ticketList.size(); i++) {
            count2++;
            
        }
        
        for (int i = 0; i < bookingList.size(); i++) {
            count1++;
            
        }
        
        for (int i = 0; i < customerList.size(); i++) {
            count++;
            
        }
        
        
        model.addAttribute("bookingDate", bookingDate);
        model.addAttribute("sum", sum);
        model.addAttribute("count", count);
        model.addAttribute("count1", count1);
        model.addAttribute("count2", count2);
        
        return "operation/operationFlight";
    }

}
