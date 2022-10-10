package main;


import main.model.Book;
import main.model.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


//@RestController
@Controller
public class DefaultController {

    @Autowired
    BookRepository bookRepository;

    @RequestMapping("/")
    public String index(Model model) {

        Iterable<Book> bookIterable = bookRepository.findAll();
        ArrayList<Book> books = new ArrayList<Book>();
        for (Book book : bookIterable) {
            books.add(book);
        }
        model.addAttribute("books", books);
        model.addAttribute("booksCount", books.size());
        return "index";
    }
}
