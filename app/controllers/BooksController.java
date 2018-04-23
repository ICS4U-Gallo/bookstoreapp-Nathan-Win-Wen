package controllers;

import play.data.FormFactory;
import play.mcv.Controller;
import play.mcv.Result;

import views.html.books.*;

import javax.inject.Inject;
import java.util.Set;


public class BooksController  extends Controller{

    @inject
    FormFactory formFactory;

    //for all books
    public Result index(){
        Set<Book> books = Book.allBooks();

        return ok(index.render(books));
    }

    //to create book
    public Result create(){
        Form<Book> bookForm = formFactory.form(Book.class);

        return ok(create.render(bookForm));
    }

    //to save book
    public Result save() {
        Form<Book> bookForm = FormFactory.form(Book.class).bindFromRequest();
        Book book = bookForm.get();
        Book.add(book);
        return redirect(routes.BooksController.index());
    }

    public Result edit(Integer id) {

        Book book = Book.findById(id);
        if(book==null){
            return notFound("Book not Found");
        }

        Form<Book> bookForm = FormFactory.form(Book.class).fill(book);
        return ok(edit.render(bookForm));
    }

    public Result update() {
        return TODO;
    }

    public Result destroy(Integer id) {
        return TODO;
    }

    //for book details
    public Result show(Integer id) {
        return TODO;
    }
}
