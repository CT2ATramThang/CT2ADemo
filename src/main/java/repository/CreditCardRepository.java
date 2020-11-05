
package repository;

import entity.CreditCardEntity;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends CrudRepository<CreditCardEntity, Integer>{
    @Query(value = "select cc.*"
            + " from creditcard cc"
            + " where cc.accountNumber = ?1 and cc.accountName = ?2"
            + "	and cc.releasesDate = ?3 and cc.securityCode = ?4", nativeQuery = true)
    CreditCardEntity checkCreditCard(String accountNumber, String accountName, LocalDate releasesDate, String securityCode);
}