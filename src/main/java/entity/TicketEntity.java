/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name= "Ticket")
public class TicketEntity {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketId;			
    private String ticketName;
    private String description	;
    private double price;
    private String nameOfTheFlyer;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate childDateOfBirth;
    private String cmnd	;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate ticketIssueDate;   
    private String status;
    
    @ManyToOne
    @JoinColumn( name= "bookingId")
    private BookingEntity bookingT;
    
    @ManyToOne
    @JoinColumn( name= "ticketTypeId")
    private TicketTypeEntity ticketType;
    
    @ManyToOne
    @JoinColumn( name= "ticketClassId")
    private TicketClassEntity ticketClass;
    
    @ManyToOne
    @JoinColumn(name = "flightId")
    private FlightEntity flight;
    
    public TicketEntity() {
    }

    public TicketEntity(String ticketName, String nameOfTheFlyer, String cmnd) {
        this.ticketName = ticketName;
        this.nameOfTheFlyer = nameOfTheFlyer;
        this.cmnd = cmnd;
    }
    
    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNameOfTheFlyer() {
        return nameOfTheFlyer;
    }

    public void setNameOfTheFlyer(String nameOfTheFlyer) {
        this.nameOfTheFlyer = nameOfTheFlyer;
    }

    public LocalDate getChildDateOfBirth() {
        return childDateOfBirth;
    }

    public void setChildDateOfBirth(LocalDate childDateOfBirth) {
        this.childDateOfBirth = childDateOfBirth;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public LocalDate getTicketIssueDate() {
        return ticketIssueDate;
    }

    public void setTicketIssueDate(LocalDate ticketIssueDate) {
        this.ticketIssueDate = ticketIssueDate;
    }

    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BookingEntity getBookingT() {
        return bookingT;
    }

    public void setBookingT(BookingEntity bookingT) {
        this.bookingT = bookingT;
    }

    public TicketTypeEntity getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketTypeEntity ticketType) {
        this.ticketType = ticketType;
    }

    public TicketClassEntity getTicketClass() {
        return ticketClass;
    }

    public void setTicketClass(TicketClassEntity ticketClass) {
        this.ticketClass = ticketClass;
    }

    public FlightEntity getFlight() {
        return flight;
    }

    public void setFlight(FlightEntity flight) {
        this.flight = flight;
    }

    public double getRealPriceTicket(){
        return flight.getFlightRoute().getStandPrice()*ticketType.getExchangeRate()*ticketClass.getExchangeRateClass();
    }

    
    
}
