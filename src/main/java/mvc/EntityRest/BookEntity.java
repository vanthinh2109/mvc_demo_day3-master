package mvc.EntityRest;

public class BookEntity {
    private int id;
    private String name;
    private  Double price;
    private String author;

    public BookEntity(int id, String name, Double price, String author){
        this.id = id;
        this.name = name;
        this.price = price;
        this.author = author;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BookEntity(){

    }
}
