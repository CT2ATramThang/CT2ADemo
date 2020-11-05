/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name= "Creditcard")
public class CreditCardEntity {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int creditCardId ;		
   private String accountNumber	;	
   private String accountName 	;
   @DateTimeFormat(pattern= "yyyy-MM-dd")
   private LocalDate  releasesDate;		
   private String securityCode	;	
   private double cardAmount   ;
   
   @OneToMany(mappedBy = "creditCard", fetch = FetchType.LAZY)
    private List<PaymentEntity> paymentList;

    public CreditCardEntity() {
    }

    public CreditCardEntity(int creditCardId, String accountNumber, String accountName, LocalDate releasesDate, String securityCode, double cardAmount, List<PaymentEntity> paymentList) {
        this.creditCardId = creditCardId;
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.releasesDate = releasesDate;
        this.securityCode = securityCode;
        this.cardAmount = cardAmount;
        this.paymentList = paymentList;
    }

    

    public int getCreditCardId() {
        return creditCardId;
    }

    public void setCreditCardId(int creditCardId) {
        this.creditCardId = creditCardId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public LocalDate getReleasesDate() {
        return releasesDate;
    }

    public void setReleasesDate(LocalDate releasesDate) {
        this.releasesDate = releasesDate;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public double getCardAmount() {
        return cardAmount;
    }

    public void setCardAmount(double cardAmount) {
        this.cardAmount = cardAmount;
    }

    public List<PaymentEntity> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<PaymentEntity> paymentList) {
        this.paymentList = paymentList;
    }
   
   
}
