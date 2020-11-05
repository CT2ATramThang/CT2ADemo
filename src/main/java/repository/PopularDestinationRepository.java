
package repository;

import entity.PopularDestinationEntity;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PopularDestinationRepository extends CrudRepository<PopularDestinationEntity, Integer>{
    PopularDestinationEntity findByPopularDestinationId(int popularDestinationId);
    
    List<PopularDestinationEntity> findByTourNameLikeOrPlaceLikeOrPrice(String tourName, String place, double price);
    
    List<PopularDestinationEntity> findByTourNameLike(String tourName);
}
