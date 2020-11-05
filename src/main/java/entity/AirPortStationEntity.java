package entity;

import java.util.List;
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
@Table(name = "airportstation")
public class AirPortStationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int airPortStationId;
    private String airportName;
    
    @ManyToOne
    @JoinColumn(name = "countryId")
    private CountryEntity country;
    
    @OneToMany(mappedBy = "airPortStationFrom", fetch = FetchType.LAZY)
    List<FlightRouteEntity> flightrouteList1;
    
    @OneToMany(mappedBy = "airPortStationTo", fetch = FetchType.LAZY)
    List<FlightRouteEntity> flightrouteList2;

    public AirPortStationEntity() {
    }

    public int getAirPortStationId() {
        return airPortStationId;
    }

    public void setAirPortStationId(int airPortStationId) {
        this.airPortStationId = airPortStationId;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public CountryEntity getCountry() {
        return country;
    }

    public void setCountry(CountryEntity country) {
        this.country = country;
    }

    public List<FlightRouteEntity> getFlightrouteList1() {
        return flightrouteList1;
    }

    public void setFlightrouteList1(List<FlightRouteEntity> flightrouteList1) {
        this.flightrouteList1 = flightrouteList1;
    }

    public List<FlightRouteEntity> getFlightrouteList2() {
        return flightrouteList2;
    }

    public void setFlightrouteList2(List<FlightRouteEntity> flightrouteList2) {
        this.flightrouteList2 = flightrouteList2;
    }

}
