
package entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "aircraft")
public class AircraftEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aircraftId;
    private String airNumber;
    private int numberOfCommercialSeats;
    private int numberOfVIP;
    
    

    public AircraftEntity() {
    }

    public int getAircraftId() {
        return aircraftId;
    }

    public void setAircraftId(int aircraftId) {
        this.aircraftId = aircraftId;
    }

    public String getAirNumber() {
        return airNumber;
    }

    public void setAirNumber(String airNumber) {
        this.airNumber = airNumber;
    }

    public int getNumberOfCommercialSeats() {
        return numberOfCommercialSeats;
    }

    public void setNumberOfCommercialSeats(int numberOfCommercialSeats) {
        this.numberOfCommercialSeats = numberOfCommercialSeats;
    }

    public int getNumberOfVIP() {
        return numberOfVIP;
    }

    public void setNumberOfVIP(int numberOfVIP) {
        this.numberOfVIP = numberOfVIP;
    }

    
    

    

    
    
    
}
