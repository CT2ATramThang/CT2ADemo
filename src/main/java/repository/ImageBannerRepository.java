
package repository;

import entity.ImageBannerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageBannerRepository extends CrudRepository<ImageBannerEntity, Integer>{
   ImageBannerEntity findByImgId(int imgId);
}
