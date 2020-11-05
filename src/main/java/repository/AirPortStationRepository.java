
package repository;

import entity.AirPortStationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirPortStationRepository extends CrudRepository<AirPortStationEntity, Integer>{
    
}
