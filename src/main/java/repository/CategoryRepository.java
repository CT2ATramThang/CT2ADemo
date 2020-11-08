
package repository;

import entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<CategoryEntity, Integer>{
    //để find name làm cái của categoryId
    CategoryEntity findByName(String categoryName);
}
