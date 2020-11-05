
package entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name= "ticketclass")
public class TicketClassEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int ticketClassId;
   private String typeClass;
   private double exchangeRateClass;
   
   @OneToMany(mappedBy = "ticketClass", fetch = FetchType.EAGER)
   private List<TicketEntity> ticketList;

    public TicketClassEntity() {
    }

    public int getTicketClassId() {
        return ticketClassId;
    }

    public void setTicketClassId(int ticketClassId) {
        this.ticketClassId = ticketClassId;
    }

    public String getTypeClass() {
        return typeClass;
    }

    public void setTypeClass(String typeClass) {
        this.typeClass = typeClass;
    }

    public double getExchangeRateClass() {
        return exchangeRateClass;
    }

    public void setExchangeRateClass(double exchangeRateClass) {
        this.exchangeRateClass = exchangeRateClass;
    }

    public List<TicketEntity> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<TicketEntity> ticketList) {
        this.ticketList = ticketList;
    }

    

    
   
   
}
