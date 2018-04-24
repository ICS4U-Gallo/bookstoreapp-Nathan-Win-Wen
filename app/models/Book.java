package models;

import java.util.HashSet;
import java.util.Set;

public class Book {

    Integer id;
    String title;
    Integer price;
    String author;

    public Book(){

    }

    public Book(Integer id, String title, Integer price, String author) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.author = author;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
    public Integer getPrice() {
        return price;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public String getAuthor() {
        return author;
    }


    private static Set<Book> books;

    static {
        books = new HashSet<>();
        books.add(new Book(1,"C++",20,"ABC"));
        books.add(new Book(2,"Java",30,"ABC"));
    }

    public static Set<Book> allbooks(){
        return books;
    }

    public static Book findById(Integer id) {
        for (Book book : books) {
            if(id.equals(book.id)) {
                return book;
            }
        }

        return null;
    }

    public static void add(Book book) {
        books.add(book);
    }

    public static boolean remove(Book book) {
        return books.remove(book);
    }
}
