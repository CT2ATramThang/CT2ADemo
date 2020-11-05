
package repository;

import entity.BookingEntity;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends CrudRepository<BookingEntity, Integer>{
   List<BookingEntity> findByDateBookingBetween(LocalDate startMonth, LocalDate endMonth);
   BookingEntity findByCodeBooking(String codeBooking);
   
}
