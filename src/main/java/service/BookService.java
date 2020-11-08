
package service;

import entity.BookDetailsEntity;
import entity.BookEntity;
import entity.CategoryEntity;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.BookDetailsRepository;
import repository.BookRepository;
import repository.CategoryRepository;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepo;
    
    @Autowired
    private CategoryRepository categoryRepo;
    
    @Autowired
    private BookDetailsRepository bookDetailsRepo;
    
    public List<BookEntity> getAllBook(){
        return (List<BookEntity>)bookRepo.findAll();
    }
    
    public CategoryEntity getCategoryName(String categoryName){
        return categoryRepo.findByName(categoryName);
    }
    
    @Transactional(rollbackOn = Exception.class)
    public BookEntity addNewBook(BookEntity book){
        //Save new book to database
        BookDetailsEntity bookDetails = book.getBookDetails();
        book.setBookDetails(null);
        BookEntity newBook = bookRepo.save(book); //newBook khi lưu xuống sẽ có id, nhưng book thì lại không có id
        
        bookDetails.setId(newBook.getId());
        bookDetailsRepo.save(bookDetails);
        
        return bookRepo.findById(newBook.getId());
    }
    
    public BookEntity getBookById(int id){
        return bookRepo.findById(id);
    }
    
    public BookEntity updateBook(BookEntity book){
        /*BookEntity newBook = bookRepo.save(book);*/
        
        bookRepo.save(book);
        bookDetailsRepo.save(book.getBookDetails());
        
        return bookRepo.findById(book.getId());
    }
    
    //bình thường phải xóa phần con trước bookDetails sau đó đến phần cha book
    public void deleteBookById(int id){
        try{
            bookDetailsRepo.deleteById(id);
        }catch(Exception e){
            System.out.println("There is no bookdetails with id = " + id);
        }
        try{
            bookRepo.deleteById(id);
        }catch(Exception e){
            System.out.println("There is no book with id = " + id);
        }
        
    }
    
    public List<BookEntity> getFindByNameLike(String name){
        name = "%" + name + "%";
        return (List<BookEntity>)bookRepo.findByNameLike(name);
    }
    
    public List<BookEntity> getAllBookJPQL(){
        return bookRepo.getAllBookJPQL();
    }
    
    public List<BookEntity> getBookByPriceBetween(double price1, double price2){
        return bookRepo.findBookByPriceBetween(price1, price2);
    }
    
    public List<BookEntity> getAllBookNativeQuery(){
        return bookRepo.getAllBookNativeQuery();
    }
    
    public List<BookEntity> getBookByPriceBetweenNative(double price1, double price2){
        return bookRepo.getBookByPriceBetweenNative(price1, price2);
    }
}
