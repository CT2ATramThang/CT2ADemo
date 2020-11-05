/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name= "Booking")
public class BookingEntity {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId ;			
    @DateTimeFormat(pattern= "yyyy-MM-dd")
    private LocalDate  dateBooking;    			
    private String codeBooking;	
    
    @OneToMany(mappedBy = "booking", fetch = FetchType.LAZY)
    private List<PaymentEntity> paymentList;
    
    @OneToMany(mappedBy = "bookingT", fetch = FetchType.EAGER)
    private List<TicketEntity> ticketList;
    
    @ManyToOne
    @JoinColumn( name= "customerId")
    private CustomerEntity customer;

    public BookingEntity() {
    }

    public BookingEntity(int bookingId, String codeBooking) {
        this.bookingId = bookingId;
        this.codeBooking = codeBooking;
    }

    

    
    


    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }



    public LocalDate getDateBooking() {
        return dateBooking;
    }

    public void setDateBooking(LocalDate dateBooking) {
        this.dateBooking = dateBooking;
    }

    public String getCodeBooking() {
        return codeBooking;
    }

    public void setCodeBooking(String codeBooking) {
        this.codeBooking = codeBooking;
    }

    public List<PaymentEntity> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<PaymentEntity> paymentList) {
        this.paymentList = paymentList;
    }

    public List<TicketEntity> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<TicketEntity> ticketList) {
        this.ticketList = ticketList;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }
    
    public double getTotal(){
        double sum = 0;
        for(TicketEntity t:ticketList){
            sum+= t.getFlight().getFlightRoute().getStandPrice()*t.getTicketType().getExchangeRate()*
                    t.getTicketClass().getExchangeRateClass();
        }
        return sum;
    }
    
    
 
}
