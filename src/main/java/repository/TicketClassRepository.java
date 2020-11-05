package repository;

import entity.TicketClassEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketClassRepository extends CrudRepository<TicketClassEntity, Integer> {

    TicketClassEntity findByTypeClass(String typeName);
    
    TicketClassEntity findByTicketClassId(int ticketClassId);
}
