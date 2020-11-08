
package app;

import entity.BookDetailsEntity;
import entity.BookEntity;
import entity.CategoryEntity;
import java.time.LocalDate;
import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.BookService;


public class Main {
    private static ClassPathXmlApplicationContext context = 
                new ClassPathXmlApplicationContext("beans.xml");
        
    private static BookService bookService = context.getBean("bookService", BookService.class);
    //lưu cùng static với main vì nếu không có thì sẽ sai, vì không cùng luồng với main, nếu không cùng sẽ chung với hemp
    public static void main(String[] args){
        //listAllBook();
        addNewBook();
        //update();
        //deleteBook();
        //searchByNameLike();
        //getAllBookJPQL();
        //getBookByPriceBetween();
        //getAllBookNativeQuery();
        //getBookByPriceBetweenNative();
    }
    private static void getBookByPriceBetweenNative(){
        double price1 = 50;
        double price2 = 60;
        List<BookEntity> bookList = bookService.getBookByPriceBetweenNative(price1, price2);
        for(BookEntity book: bookList){
            System.out.println(book);
        }
    }
    private static void getAllBookNativeQuery(){
        List<BookEntity> bookList = bookService.getAllBookNativeQuery();
        for(BookEntity book : bookList){
            System.out.println(book);
        }
    }
    private static void getBookByPriceBetween(){
        double price1 = 50;
        double price2 = 60;
        List<BookEntity> bookList = bookService.getBookByPriceBetween(price1, price2);
        for(BookEntity book: bookList){
            System.out.println(book);
        }
    }
    private static void getAllBookJPQL(){
        List<BookEntity> bookList = bookService.getAllBookJPQL();
        for(BookEntity book : bookList){
            System.out.println(book);
        }
    }
    private static void searchByNameLike(){
        System.out.println("Search Name");
        String name = "J";
        
        List<BookEntity> bookList = bookService.getFindByNameLike(name);
        for(BookEntity book: bookList){
            System.out.println(book);
        }
    }
    private static void deleteBook(){
        System.out.println("Delete book");
        int id = 6;
        
        bookService.deleteBookById(id);
        listAllBook();
    }
    private static void update(){
        System.out.println("Update book");
        int id = 6;
        //get book
        BookEntity book = bookService.getBookById(id);
        
        //Update author and price
        book.setAuthor("Miu");
        book.getBookDetails().setPrice(20);
        
        //Save to database
        BookEntity newBook = bookService.updateBook(book);
        
        System.out.println(newBook);
    }
    private static void addNewBook(){
        System.out.println("Add New Book");
        
        BookEntity book = new BookEntity();
        book.setName("PHP");
        book.setAuthor("Joe Murach");
        
        BookDetailsEntity bookDetails = new BookDetailsEntity();
        bookDetails.setIsbn("1800-1-2");
        bookDetails.setNumberOfPage(600);
        bookDetails.setPrice(37.5);
        bookDetails.setPublishedDate(LocalDate.now());
        
        book.setBookDetails(bookDetails); //lệnh này làm nó có liên quan với nhau, để bookDetails là con của book
        
        //phải có categoryId để không bị lỗi khóa ngoại
        String categoryName = "Database";
        CategoryEntity category = bookService.getCategoryName(categoryName);
        
        if(category == null){
            System.out.println("Null category. Try again");
        }else{
            book.setCategory(category);
            try{
            //Save book to database
                 BookEntity newBook = bookService.addNewBook(book);
                System.out.println("Insert success");
                System.out.println(newBook);
            }catch(Exception e){
                System.out.println("Insert fail. Error message: " + e.getCause());
            }
        }
    }
    private static void listAllBook(){
        List<BookEntity> bookList = bookService.getAllBook();
        for(BookEntity book: bookList){
            System.out.println(book);
            
            /*String message = "Id : " + book.getId() + "\n" + 
                            "Name: " + book.getName() + "\n" + 
                            "Author: " + book.getAuthor() + "\n" +
                            "Category Name: " + book.getCategory().getName() + "\n" + 
                            "Isbn: " + book.getBookDetails().getIsbn() + "\n" + 
                            "Number Of Page: " + book.getBookDetails().getNumberOfPage() + "\n" +
                            "Price: " + book.getBookDetails().getPrice() + "\n" +
                            "Published Date: " + book.getBookDetails().getPublishedDate() + "\n";
            
            System.out.println(message);*/
            
        }
    }
}
