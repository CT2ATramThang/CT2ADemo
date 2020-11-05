package repository;

import entity.TicketEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends CrudRepository<TicketEntity, Integer> {

    @Query(value = " select t.* from ticket t "
            + " where t.status = ?1 and t.flightId = ?2 ", nativeQuery = true)
    List<TicketEntity> getTicketByFlightId(String status, int flightId);
    @Query(value = " select count(*) from ticket t "
            + " where t.bookingId = ?1 ", nativeQuery = true)
    int getNumberTicketByBookingId( int bookingId);
    
    @Query(value = " select t.* from ticket t "
            + " where t.bookingId = ?1 ", nativeQuery = true)
    List<TicketEntity> getListTicketByBookingId(int bookingId);
    TicketEntity findByTicketId(int ticketId);
}
