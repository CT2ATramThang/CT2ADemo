
package repository;

import entity.AircraftEntity;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AircraftRepository extends CrudRepository<AircraftEntity, Integer>{
    AircraftEntity findById(int aircraftId);
    
    List<AircraftEntity> findByAirNumberLikeOrNumberOfCommercialSeatsOrNumberOfVIP(String airNumber,
            int numberOfCommercialSeats, int numberOfVIP);
}
