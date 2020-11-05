
package repository;

import entity.PromotionEntity;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRepository extends CrudRepository<PromotionEntity, Integer>{
    PromotionEntity findById(int promotionId);
    
    List<PromotionEntity> findByPromotionNameLikeOrValueOfPromotion(String promotionName, double valueOfPromotion);
}
