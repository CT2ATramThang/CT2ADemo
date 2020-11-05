
package repository;

import entity.FlightEntity;
import entity.TicketTypeEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketTypeRepository extends CrudRepository<TicketTypeEntity, Integer>{
    @Query(value = "Select tt.* "
                  + " from TicketType tt"
                  + " where type = ?1", nativeQuery = true)
    List<TicketTypeEntity> getListType(String type);
    
    TicketTypeEntity findById(int ticketTypeId);
      TicketTypeEntity findByType(String type);
}
