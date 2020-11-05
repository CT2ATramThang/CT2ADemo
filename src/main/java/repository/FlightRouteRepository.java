
package repository;

import entity.FlightRouteEntity;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRouteRepository extends CrudRepository<FlightRouteEntity, Integer>{
    FlightRouteEntity findById(int flightRouteId);
    
    List<FlightRouteEntity> findByStandPriceOrDistanceOrDuration(double standPrice, double distance, int duration);
}
