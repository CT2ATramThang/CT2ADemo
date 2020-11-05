/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import component.BookingComponent;
import entity.BookingEntity;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import printExcelPdf.ExcelBookingReportView;
import repository.BookingRepository;
import repository.CustomerRepository;
import repository.TicketRepository;

@Controller
@Scope(value="session")
@SessionAttributes("bookingList")
public class ReportController {
    @Autowired
    BookingRepository bookingRepo;
    @Autowired
    CustomerRepository customerRepo;
    @Autowired
    TicketRepository ticketRepo;
    @Autowired
    BookingComponent book;
    
    @RequestMapping(value = "/report", method = RequestMethod.GET)
    public String getAllListBooking(HttpServletRequest request, Model model, ModelMap modelMap) {

        List<BookingEntity> bookingList = (List<BookingEntity>) bookingRepo.findAll();
        
        PagedListHolder pagedListHolder = new PagedListHolder(bookingList);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        modelMap.put("pagedListHolder", pagedListHolder);
        
        model.addAttribute("bookingList", bookingList);
        double sum= 0;
    
        for(BookingEntity books : bookingList){
            sum += books.getTotal();
           //int count = ticketRepo.getNumberTicketByBookingId(book.getBookingId()); 
        }
        model.addAttribute("sum",sum);
       // model.addAttribute("count",count);

        return "operation/report";
        
    }
    @RequestMapping(value = "/reportByBookDate", method = RequestMethod.GET)
    public String getListBookingByBookingDate(@RequestParam(name= "startDay")Date startDay,
                                    @RequestParam(name= "endDay")Date endDay,Model model, HttpServletRequest httpServlet) {
        LocalDate start = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(startDay));
        
        LocalDate end = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(endDay));
        List<BookingEntity> bookingList = (List<BookingEntity>) bookingRepo.findByDateBookingBetween(start, end);
        model.addAttribute("bookingList", bookingList);
        HttpSession session = httpServlet.getSession();
        session.setAttribute("bookingList", bookingList);
      
        
        
        return "operation/report";
        
    }
    @RequestMapping(value = "/report1", method = RequestMethod.GET)
    public ModelAndView bookingListReport(HttpServletRequest req , HttpSession session ){
        String  typeReport = req.getParameter("type");
       // HttpSession session = httpServlet.getSession();
        List<BookingEntity> bookingList = (List<BookingEntity>) session.getAttribute("bookingList");
        if(typeReport!= null && typeReport.equals("xls")){
            return new ModelAndView( new ExcelBookingReportView(),"bookingList", bookingList);
        }
        
            return new ModelAndView("bookingListReport","bookingList", bookingList);  
    } 
     @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    } 
}
