
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
@Table(name = "country")
public class CountryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int countryId;
    private String countryName;
    private String countryCode;
    
    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
    List<AirPortStationEntity> airPortStationEntityList;

    public CountryEntity() {
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public List<AirPortStationEntity> getAirPortStationEntityList() {
        return airPortStationEntityList;
    }

    public void setAirPortStationEntityList(List<AirPortStationEntity> airPortStationEntityList) {
        this.airPortStationEntityList = airPortStationEntityList;
    }
    
    
}
