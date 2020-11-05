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
@Table(name= "Payment")
public class PaymentEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int transactionId;
   @DateTimeFormat(pattern= "yyyy-MM-dd")
   private LocalDate  transactionDate; 
    private String description ;
    private double transactionAmount;
    
    @ManyToOne
    @JoinColumn( name= "creditCardId")
    private CreditCardEntity creditCard;
    
    @ManyToOne
    @JoinColumn( name= "bookingId")
    private BookingEntity booking;

    public PaymentEntity() {
    }

    public PaymentEntity(int transactionId, LocalDate transactionDate, String description, double transactionAmount, CreditCardEntity creditCard, BookingEntity booking) {
        this.transactionId = transactionId;
        this.transactionDate = transactionDate;
        this.description = description;
        this.transactionAmount = transactionAmount;
        this.creditCard = creditCard;
        this.booking = booking;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public CreditCardEntity getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCardEntity creditCard) {
        this.creditCard = creditCard;
    }

    public BookingEntity getBooking() {
        return booking;
    }

    public void setBooking(BookingEntity booking) {
        this.booking = booking;
    }
    
    
}
