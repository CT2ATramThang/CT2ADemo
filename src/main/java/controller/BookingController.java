/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import component.BookingComponent;
import entity.BookingEntity;
import entity.CreditCardEntity;
import entity.CustomerEntity;
import entity.FlightEntity;
import entity.PaymentEntity;
import entity.TicketClassEntity;
import entity.TicketEntity;
import entity.TicketTypeEntity;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import repository.BookingRepository;
import repository.CreditCardRepository;
import repository.CustomerRepository;
import repository.FlightRepository;
import repository.PaymentRepository;
import repository.TicketClassRepository;
import repository.TicketRepository;
import repository.TicketTypeRepository;

@Scope(value = "session")
@Controller
public class BookingController {

    @Autowired
    TicketRepository ticketRepo;
    @Autowired
    TicketTypeRepository ticketTypeRepo;
    @Autowired
    TicketClassRepository ticketClassRepo;
    @Autowired
    FlightRepository flightRepo;
    @Autowired
    CustomerRepository customerRepo;
    @Autowired
    BookingRepository bookingRepo;
    @Autowired
    CreditCardRepository creditCardRepo;
    @Autowired
    PaymentRepository paymentRepo;

    @Autowired
    BookingComponent book;

    @Autowired
    JavaMailSender javaMailSender;

    @RequestMapping(value = "/addTicketToCart/{flightId}/{ticketClassId}/{adult}/{child}", method = RequestMethod.GET)
    public String addTicketToCart(Model model, @PathVariable(value = "flightId") int flightId,
            @PathVariable(value = "ticketClassId") int ticketClassId,
            @PathVariable(value = "adult") int adult,
            @PathVariable(value = "child") int child) {
        String status = "have tickets";
        List<TicketEntity> ticketList = (List<TicketEntity>) ticketRepo.getTicketByFlightId(status, flightId);
        List<TicketEntity> newTicketList = new ArrayList<>();
        // TicketEntity newTicket = new TicketEntity();

        String type1 = "Adults";
        TicketTypeEntity adultType = ticketTypeRepo.findByType(type1);
        String type2 = "Children";
        TicketTypeEntity childType = ticketTypeRepo.findByType(type2);
        int n = adult + child;//so ve muon dat
        for (int i = 0; i < n; i++) {
            TicketEntity ticket = ticketList.get(i);
            //nguoi lon  
            //tre em
            if (i < adult) {
                ticket.setStatus("hold tickets");
                ticket.setTicketType(adultType);
                TicketClassEntity adultClass = ticketClassRepo.findByTicketClassId(ticketClassId);
                ticket.setTicketClass(adultClass);
                ticket.setPrice(ticket.getRealPriceTicket());
                newTicketList.add(ticket);
                
            } else {
                ticket.setStatus("hold tickets");
                ticket.setTicketType(childType);
                TicketClassEntity childClass = ticketClassRepo.findByTicketClassId(ticketClassId);
                ticket.setTicketClass(childClass);
                ticket.setPrice(ticket.getRealPriceTicket());
                newTicketList.add(ticket);
            }
        }
        

        FlightEntity flight = flightRepo.findByFlightId(flightId);

        model.addAttribute("flight", flight);
        
        model.addAttribute("ticketClass", newTicketList.get(0).getTicketClass().getTypeClass());

        //model.addAttribute("ticketList",newTicketList);
        BookingEntity booking = new BookingEntity();
        booking.setTicketList(newTicketList);
        book.setBooking(booking);
        model.addAttribute("booking", booking);
        // model.addAttribute("booking2",book);

        return "booking/booking";
    }
    @RequestMapping(value= "/customer", method = RequestMethod.GET)
    public String displaytoCustomer( Model model){
        model.addAttribute("booking", book.getBooking());
        return "booking/customer";
    }

    @RequestMapping(value = "/inforCustomer", method = RequestMethod.POST)
    public String saveInputFormCustomer(BookingEntity booking, Model model) {
        for (int i = 0; i < booking.getTicketList().size(); i++) {
            book.getBooking().getTicketList().get(i).setTicketIssueDate(LocalDate.now());
            book.getBooking().getTicketList().get(i).setNameOfTheFlyer(booking.getTicketList().get(i).getNameOfTheFlyer());
            book.getBooking().getTicketList().get(i).setChildDateOfBirth(booking.getTicketList().get(i).getChildDateOfBirth());
            book.getBooking().getTicketList().get(i).setCmnd(booking.getTicketList().get(i).getCmnd());
            book.getBooking().setDateBooking(LocalDate.now());
            Random rd = new Random();
            int n = 1000000;
            int number = rd.nextInt(n);
            String codeBooking = Integer.toString(number);
            book.getBooking().setCodeBooking(codeBooking);

        }
        model.addAttribute("booking", book);
        model.addAttribute("customer", new CustomerEntity());
        model.addAttribute("booking", book.getBooking());

        return "payment/payment";
    }
    
    @Transactional(rollbackFor = Exception.class)
    @RequestMapping(value = "/checkAccount", method = RequestMethod.POST)
    public String checkPaymentAccount(@RequestParam(name = "accountNumber") String accountNumber,
            @RequestParam(name = "accountName") String accountName,
            @RequestParam(name = "releasesDate") Date releasesDate,
            @RequestParam(name = "securityCode") String securityCode,
            Model model, CustomerEntity customer) {
        LocalDate releases = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(releasesDate));

        try {
            //book.getBooking().setCustomer(customer);
            CreditCardEntity creditCard = creditCardRepo.checkCreditCard(accountNumber, accountName, releases, securityCode);

            double total = book.getBooking().getTotal();

            CustomerEntity newCustomer = customerRepo.save(customer);
            book.getBooking().setCustomer(newCustomer);
            BookingEntity newBooking = book.getBooking();
            String codeBooking = newBooking.getCodeBooking();
            model.addAttribute("codeBooking",codeBooking );
            bookingRepo.save(newBooking);
            List<TicketEntity> newTicketList = book.getBooking().getTicketList();

            for (TicketEntity ticket : newTicketList) {
                //ticket.setTicketId(newTicket.getTicketId());
                ticket.setBookingT(newBooking);
                ticket.setStatus("out sold");
                ticketRepo.save(ticket);
            }
            if (total <= creditCard.getCardAmount()) {

                double balance = creditCard.getCardAmount() - total;
                creditCard.setCardAmount(balance);
                creditCardRepo.save(creditCard);

                PaymentEntity payment = new PaymentEntity();

                List<PaymentEntity> paymentList = new ArrayList<>();
                payment.setTransactionDate(LocalDate.now());
                payment.setDescription(null);
                payment.setTransactionAmount(total);
                payment.setBooking(book.getBooking());
                payment.setCreditCard(creditCard);
                paymentRepo.save(payment);

                paymentList.add(payment);
                book.getBooking().setPaymentList(paymentList);
                
            } else {
                System.out.println("NGHEO DUNG CHUYEN TIEN !!");
                // return va thong bao loi
            }
            
            //send mail
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setTo(customer.getEmail());
            msg.setSubject("Airline");
            msg.setText("Congratulations! You have successfully registered for an account. "
                    + "Code Booking: " + newBooking.getCodeBooking());
            javaMailSender.send(msg);
        } catch (Exception e) {
            System.out.println(e);

        }

        return "payment/thanks";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
}
