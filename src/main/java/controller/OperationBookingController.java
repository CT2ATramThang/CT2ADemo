package controller;

import component.BookingComponent;
import entity.AircraftEntity;
import entity.BookingEntity;
import entity.ImageBannerEntity;
import entity.TicketEntity;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import repository.BookingRepository;
import repository.CustomerRepository;
import repository.TicketRepository;

@Controller
@Scope(value = "session")
@SessionAttributes("bookingList")
public class OperationBookingController {

    @Autowired
    BookingRepository bookingRepo;
    @Autowired
    CustomerRepository customerRepo;
    @Autowired
    TicketRepository ticketRepo;
    @Autowired
    BookingComponent book;

    
    //List Booking
    @RequestMapping(value = "/listBooking", method = RequestMethod.GET)
    public String getAllListBooking(HttpServletRequest request, Model model, ModelMap modelMap) {

        List<BookingEntity> bookingList = (List<BookingEntity>) bookingRepo.findAll();

        PagedListHolder pagedListHolder = new PagedListHolder(bookingList);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        modelMap.put("pagedListHolder", pagedListHolder);

        model.addAttribute("bookingList", bookingList);
        double sum = 0;

        for (BookingEntity books : bookingList) {
            sum += books.getTotal();
            //int count = ticketRepo.getNumberTicketByBookingId(book.getBookingId()); 
        }
        model.addAttribute("sum", sum);
        // model.addAttribute("count",count);

        return "operation/listBooking";

    }

    //Search Booking
    @RequestMapping(value = "/searchBooking", method = RequestMethod.GET)
    public String getListBookingByBookingDate(@RequestParam(name = "startDay") Date startDay,
            @RequestParam(name = "endDay") Date endDay, Model model, HttpServletRequest request, ModelMap modelMap) {
        LocalDate start = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(startDay));

        LocalDate end = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(endDay));

        List<BookingEntity> bookingList = (List<BookingEntity>) bookingRepo.findByDateBookingBetween(start, end);

        PagedListHolder pagedListHolder = new PagedListHolder(bookingList);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        modelMap.put("pagedListHolder", pagedListHolder);

        HttpSession session = request.getSession();
        session.setAttribute("bookingList", bookingList);

        return "operation/listBooking";

    }
    
    //Delete Booking
    @RequestMapping(value = "/deleteBooking/{bookingId}", method = RequestMethod.GET)
    public String deleteBooking(@PathVariable(value = "bookingId") int bookingId, HttpServletRequest request, Model model, ModelMap modelMap) {

        try {
            bookingRepo.deleteById(bookingId);
            List<BookingEntity> bookingList = (List<BookingEntity>) bookingRepo.findAll();
            PagedListHolder pagedListHolder = new PagedListHolder(bookingList);
            int page = ServletRequestUtils.getIntParameter(request, "p", 0);
            pagedListHolder.setPage(page);
            pagedListHolder.setPageSize(5);
            modelMap.put("pagedListHolder", pagedListHolder);
        } catch (Exception e) {
            System.out.println(e);
        }

        return "operation/listBooking";
    }
    
    @RequestMapping(value = "/viewTicket/{bookingId}", method = RequestMethod.GET)
    public String displayListTicket(@PathVariable(value = "bookingId") int bookingId, Model model, HttpServletRequest request, ModelMap modelMap) {
        List<TicketEntity> ticketList = (List<TicketEntity>) ticketRepo.getListTicketByBookingId(bookingId);
        PagedListHolder pagedListHolder = new PagedListHolder(ticketList);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        modelMap.put("pagedListHolder", pagedListHolder);
        
        BookingEntity booking = new BookingEntity();
        booking.setTicketList(ticketList);
        book.setBooking(booking);
        
        return "operation/listTicket";
    }
    @RequestMapping(value = "/deleteTicket/{ticketId}", method = RequestMethod.GET)
    public String deleteTicketList(@PathVariable(value = "ticketId") int ticketId, HttpServletRequest request, Model model, ModelMap modelMap) {

        try {
            ticketRepo.deleteById(ticketId);
            List<TicketEntity> ticketList = (List<TicketEntity>) ticketRepo.findAll();
            PagedListHolder pagedListHolder = new PagedListHolder(ticketList);
            int page = ServletRequestUtils.getIntParameter(request, "p", 0);
            pagedListHolder.setPage(page);
            pagedListHolder.setPageSize(5);
            modelMap.put("pagedListHolder", pagedListHolder);
        } catch (Exception e) {
            System.out.println(e);
        }

        return "operation/listBooking";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

}
