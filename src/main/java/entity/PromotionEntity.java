
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
@Table(name = "promotion")
public class PromotionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int promotionId;
    private String promotionName;
    private String description;
    private double valueOfPromotion;
    private String imagePromotion;
    
    @OneToMany(mappedBy = "promotion", fetch = FetchType.LAZY)
    List<FlightEntity> flightList;

    public PromotionEntity() {
    }

    public int getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(int promotionId) {
        this.promotionId = promotionId;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValueOfPromotion() {
        return valueOfPromotion;
    }

    public void setValueOfPromotion(double valueOfPromotion) {
        this.valueOfPromotion = valueOfPromotion;
    }

    public String getImagePromotion() {
        return imagePromotion;
    }

    public void setImagePromotion(String imagePromotion) {
        this.imagePromotion = imagePromotion;
    }
    
    public List<FlightEntity> getFlightList() {
        return flightList;
    }

    public void setFlightList(List<FlightEntity> flightList) {
        this.flightList = flightList;
    }
    
    public double getValue(){
        double value = valueOfPromotion * 100;
        
        return value;
    }
    
}
