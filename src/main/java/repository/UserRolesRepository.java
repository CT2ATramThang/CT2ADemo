
package repository;

import entity.UserRolesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRolesRepository extends CrudRepository<UserRolesEntity, Integer>{
    UserRolesEntity findByUserRolesId(int userRolesId);
}
