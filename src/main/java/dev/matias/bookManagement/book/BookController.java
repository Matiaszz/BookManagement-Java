package dev.matias.bookManagement.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.matias.bookManagement.dto.ResponseMessage;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookRepository bookRepository;

    @GetMapping
    public ResponseEntity<ResponseMessage> get() {
        var allBooks = bookRepository.findAll();
        return ResponseEntity.ok().body(new ResponseMessage("Success", allBooks));
    }
}
