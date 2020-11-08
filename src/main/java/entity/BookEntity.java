
package entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String author;
    
    //Setup relationship with Category n-1
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private CategoryEntity category;
    
    //Setup relationship with bookdetails 1-1
    @OneToOne() //cascade = CascadeType.ALL  //thêm bảng book thì thêm luôn bookdetails, xóa thì cũng vậy 
    @PrimaryKeyJoinColumn
    private BookDetailsEntity bookDetails;

    public BookEntity() {
    }

    public BookEntity(int id, String name, String author, CategoryEntity category, BookDetailsEntity bookDetails) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.category = category;
        this.bookDetails = bookDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public BookDetailsEntity getBookDetails() {
        return bookDetails;
    }

    public void setBookDetails(BookDetailsEntity bookDetails) {
        this.bookDetails = bookDetails;
    }
    
    @Override
    public String toString(){
        String message = "Id: " + id + "\n" + 
                        "Name: " + name + "\n" + 
                        "Author: " + author + "\n";
        if(category != null){
            message+= "Category Name: " + category.getName() + "\n";
        }
        if(bookDetails != null){
            message+= "Isbn: " + bookDetails.getIsbn() + "\n" + 
                    "Number Of Page: " + bookDetails.getNumberOfPage() + "\n" +
                    "Price: " + bookDetails.getPrice() + "\n" +
                    "Published Date: " + bookDetails.getPublishedDate() + "\n";
        }
        return message;         
    }
}
