package entity;

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

@Entity
@Table(name = "flightroute")
public class FlightRouteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int flightRouteId;
    private double standPrice;
    private double distance;
    private int duration;

    @ManyToOne
    @JoinColumn(name = "flightRouteFrom")
    private AirPortStationEntity airPortStationFrom;

    @ManyToOne
    @JoinColumn(name = "flightRouteTo")
    private AirPortStationEntity airPortStationTo;

    @OneToMany(mappedBy = "flightRoute", fetch = FetchType.LAZY)
    List<FlightEntity> flightList;

    public FlightRouteEntity() {
    }

    public int getFlightRouteId() {
        return flightRouteId;
    }

    public void setFlightRouteId(int flightRouteId) {
        this.flightRouteId = flightRouteId;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public AirPortStationEntity getAirPortStationFrom() {
        return airPortStationFrom;
    }

    public void setAirPortStationFrom(AirPortStationEntity airPortStationFrom) {
        this.airPortStationFrom = airPortStationFrom;
    }

    public AirPortStationEntity getAirPortStationTo() {
        return airPortStationTo;
    }

    public void setAirPortStationTo(AirPortStationEntity airPortStationTo) {
        this.airPortStationTo = airPortStationTo;
    }

    public List<FlightEntity> getFlightList() {
        return flightList;
    }

    public void setFlightList(List<FlightEntity> flightList) {
        this.flightList = flightList;
    }

    public double getStandPrice() {
        return standPrice;
    }

    public void setStandPrice(double standPrice) {
        this.standPrice = standPrice;
    }

    
}
