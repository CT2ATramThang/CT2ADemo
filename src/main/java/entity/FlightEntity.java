
package entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Table(name = "flight")
public class FlightEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int flightId;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate flightDate;
    
    //@Column(name="flightTimeFrom",columnDefinition="Time") 
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime flightTimeFrom;
    
    //@Column(name="flightTimeTo",columnDefinition="Time") 
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime flightTimeTo;
    
    @ManyToOne
    @JoinColumn(name = "flightRouteId")
    private FlightRouteEntity flightRoute;
    
    @ManyToOne
    @JoinColumn(name = "aircraftId")
    private AircraftEntity aircraft;
    
    @ManyToOne
    @JoinColumn(name = "promotionId")
    private PromotionEntity promotion;
    
    @OneToMany(mappedBy = "flight", fetch = FetchType.LAZY)
    List<TicketEntity> ticketList;

    public FlightEntity() {
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public LocalDate getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(LocalDate flightDate) {
        this.flightDate = flightDate;
    }

    public LocalTime getFlightTimeFrom() {
        return flightTimeFrom;
    }

    public void setFlightTimeFrom(LocalTime flightTimeFrom) {
        this.flightTimeFrom = flightTimeFrom;
    }

    public LocalTime getFlightTimeTo() {
        return flightTimeTo;
    }

    public void setFlightTimeTo(LocalTime flightTimeTo) {
        this.flightTimeTo = flightTimeTo;
    }

    public FlightRouteEntity getFlightRoute() {
        return flightRoute;
    }

    public void setFlightRoute(FlightRouteEntity flightRoute) {
        this.flightRoute = flightRoute;
    }

    public AircraftEntity getAircraft() {
        return aircraft;
    }

    public void setAircraft(AircraftEntity aircraft) {
        this.aircraft = aircraft;
    }

    public PromotionEntity getPromotion() {
        return promotion;
    }

    public void setPromotion(PromotionEntity promotion) {
        this.promotion = promotion;
    }

    public List<TicketEntity> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<TicketEntity> ticketList) {
        this.ticketList = ticketList;
    }

    
    
}
