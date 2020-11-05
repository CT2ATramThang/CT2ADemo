package repository;

import entity.FlightEntity;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends CrudRepository<FlightEntity, Integer> {

    FlightEntity findByFlightId(int flightId);
    
    List<FlightEntity> findByFlightDate(LocalDate flightDate);

    @Query(value = " select f.* from flight f "
            + " join flightroute fb on fb.flightrouteId = f.flightrouteId "
            + " where fb.flightroutefrom = ?1 and fb.flightrouteto = ?2 and flightDate = ?3 ", nativeQuery = true)
    List<FlightEntity> getFlightNativeQuery(int airportIdFrom, int airportIdTo, LocalDate depart);
}
