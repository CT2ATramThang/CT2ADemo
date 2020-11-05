/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import component.BookingComponent;
import entity.BookingEntity;
import entity.ImageBannerEntity;
import entity.TicketEntity;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import printExcelPdf.PdfViewTicketList;
import printExcelPdf.ReportPdfView;
import repository.BookingRepository;
import repository.ImageBannerRepository;
import repository.TicketRepository;

@Controller
@Scope(value = "session")
public class CheckBookingCotroller {

    @Autowired
    BookingRepository bookingRepo;
    @Autowired
    TicketRepository ticketRepo;
    @Autowired
    BookingComponent book;
    @Autowired
    ImageBannerRepository imageBannerRepo;

    @RequestMapping(value = "/checkBooking", method = RequestMethod.GET)
    public String booking(Model model) {
        return "checkbooking/checkBooking";
    }

    @RequestMapping(value = "/findBooking", method = RequestMethod.POST)
    public String checkBooking(@RequestParam(name = "searchInput") String searchInput, String searchInput1, Model model) {
        String searchInput2 = "%" + searchInput + "%";

        BookingEntity booking = bookingRepo.findByCodeBooking(searchInput);

        model.addAttribute("booking", booking);
        model.addAttribute("SearchText", searchInput2);

        List<ImageBannerEntity> imageList = (List<ImageBannerEntity>) imageBannerRepo.findAll();
        model.addAttribute("imageList", imageList);

        return "checkbooking/listCheck";
    }

    @RequestMapping(value = "/viewTicketList/{bookingId}", method = RequestMethod.GET)
    public String displayListTicket(@PathVariable(value = "bookingId") int bookingId, Model model) {
        List<TicketEntity> ticketList = (List<TicketEntity>) ticketRepo.getListTicketByBookingId(bookingId);
        model.addAttribute("ticketList", ticketList);
        BookingEntity booking = new BookingEntity();
        booking.setTicketList(ticketList);
        book.setBooking(booking);

        List<ImageBannerEntity> imageList = (List<ImageBannerEntity>) imageBannerRepo.findAll();
        model.addAttribute("imageList", imageList);
        
        return "checkbooking/listTicket";
    }

   /* @RequestMapping(value = "/report67", method = RequestMethod.GET)
    public ModelAndView ticketListReport(HttpServletRequest req) {
        String typeReport = req.getParameter("type");
        List<TicketEntity> ticketList = book.getBooking().getTicketList();
        //book.getBooking().getTicketList();
        
        
        if (typeReport != null && typeReport.equals("pdf")) {
            return new ModelAndView(new PdfViewTicketList(), "ticketList", ticketList);
        }

        return new ModelAndView("ticketListReport", "ticketList", ticketList);

    }*/
   @RequestMapping(value = "/report77/{ticketId}", method = RequestMethod.GET)
  public ModelAndView handleForexRequest(@PathVariable(value="ticketId")int ticketId,Model model) {
      //List<TicketEntity> ticketList = book.getBooking().getTicketList();
        TicketEntity ticket = ticketRepo.findByTicketId(ticketId);
      //for(TicketEntity ticket : ticketList){ 
        return new ModelAndView( new ReportPdfView(),"ticket" ,ticket);
   }

}
