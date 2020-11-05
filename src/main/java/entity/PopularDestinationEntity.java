
package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "populardestination")
public class PopularDestinationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int popularDestinationId;
    private String tourName;
    private String place;
    private double price;
    private String imgPopularDestination;

    public PopularDestinationEntity() {
    }

    public int getPopularDestinationId() {
        return popularDestinationId;
    }

    public void setPopularDestinationId(int popularDestinationId) {
        this.popularDestinationId = popularDestinationId;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImgPopularDestination() {
        return imgPopularDestination;
    }

    public void setImgPopularDestination(String imgPopularDestination) {
        this.imgPopularDestination = imgPopularDestination;
    }
    
    
}
