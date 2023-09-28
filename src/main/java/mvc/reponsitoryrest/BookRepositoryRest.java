package mvc.reponsitoryrest;

import mvc.EntityRest.BookEntity;
import org.springframework.stereotype.Repository;


import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepositoryRest {
    private List<BookEntity> bookList = new ArrayList<>();

    @PostConstruct
    public void init() {
        bookList.add(new BookEntity(1, "Java A-Z", 13.2, "Roger"));
        bookList.add(new BookEntity(2, ".Net tutorial", 23.9, "Peter"));
    }

    public List<BookEntity> findAll() {
        return bookList;
    }

    public BookEntity save(BookEntity bookEntity) {
        bookList.add(bookEntity);
        return bookEntity;
    }

    public BookEntity update(BookEntity newBookData) {
        boolean isFound = false;
        BookEntity foundBook = null;
        for (BookEntity book : bookList) {
            if (book.getId() == newBookData.getId()) {
                isFound = true;
                foundBook = book;
                break;
            }
        }
        if (!isFound) {
            return null;
        }
        bookList.remove(foundBook);
        newBookData.setId(foundBook.getId());
        bookList.add(newBookData);
        return newBookData;
    }
   public boolean delete(int bookID){
        boolean isFound = false;
        BookEntity foundBook = null;
        for (BookEntity book: bookList){
            if (book.getId() == bookID){
                isFound = true;
                foundBook = book;
                break;
            }
        }
        if (!isFound) {
            return false;
        }
        bookList.remove(foundBook);
        return true;
   }

}


