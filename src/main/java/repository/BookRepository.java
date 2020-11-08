
package repository;

import entity.BookEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Integer>{
    BookEntity findById(int id);
    
    List<BookEntity> findByNameLike(String name);
    
    //Use JPQL
    @Query(value = "Select b from BookEntity b")
    List<BookEntity> getAllBookJPQL();
    
    @Query(value = "Select b from BookEntity b Where b.bookDetails.price=?1")
    List<BookEntity> findBookByPrice(double price);
    
    @Query(value = "Select b from BookEntity b" + " Where b.bookDetails.price between ?1 and ?2")
    List<BookEntity> findBookByPriceBetween(double price1, double price2);
    
    //Native query
    @Query(value = "Select * from Book", nativeQuery = true)
    List<BookEntity> getAllBookNativeQuery();
    
    @Query(value = "Select b.* from Book b Join BookDetails bd On b.id=bd.id " 
            + "where bd.price between ?1 and ?2", nativeQuery = true)
    List<BookEntity> getBookByPriceBetweenNative(double price1, double price2);
}
