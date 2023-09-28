package mvc.Restcontroller;

import mvc.EntityRest.BookEntity;
import mvc.reponsitoryrest.BookRepositoryRest;
import mvc.reponsitoryrest.BookRepositoryRest;
import mvc.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/restbook")
public class BookcontrollerRest {
    @Autowired
    BookRepositoryRest bookRepositoryRest;

    @RequestMapping(method = RequestMethod.GET)
    public Object getAllbook(){
        List<BookEntity> bookEntityList = bookRepositoryRest.findAll();

        return bookEntityList;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Object addNewBook(@RequestBody BookEntity newBookEntity){
         BookEntity result = bookRepositoryRest.save(newBookEntity);
         return result;
    }
    @RequestMapping(method = RequestMethod.PUT)
    public Object updateBook(@RequestBody BookEntity updateBookEntity){
        BookEntity result = bookRepositoryRest.update(updateBookEntity);
        if (result == null){
            Map<String, String> error = new HashMap<String, String>(){{
                put("error",updateBookEntity.getId() + "does not exist");
            }};
            return error;
        }
        return result;
    }
    @RequestMapping(value = "/{bookID}",method = RequestMethod.DELETE)
    public Object deleteBook(@PathVariable(value = "bookID") String bookID){
            Boolean result = bookRepositoryRest.delete(Integer.valueOf(bookID));
            if (!result){
                Map<String, String > error = new HashMap<String, String>(){{
                    put("error", "A book which book ID =" +bookID +"does not exist");
                }};
                return error;
            }else {
                Map<String, String> susccess = new HashMap<String, String>(){{
                   put("success", "A book which book ID ="+ bookID +" has been delete successfully");
                }};
                return susccess;
            }
    }
}
