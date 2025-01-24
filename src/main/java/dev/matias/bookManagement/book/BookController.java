package dev.matias.bookManagement.book;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.matias.bookManagement.dto.BookSummaryDTO;
import dev.matias.bookManagement.dto.ResponseMessage;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookRepository bookRepository;

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<ResponseMessage> getSummaryOfAllBooks() {
        var allBooks = bookRepository.findAll();
        var booksSummaries = allBooks.stream().map((book) -> new BookSummaryDTO(book));
        return ResponseEntity.ok().body(new ResponseMessage("Success", booksSummaries));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseMessage> getById(@PathVariable UUID id) {
        var book = bookRepository.findById(id);
        var bookSummary = new BookSummaryDTO(book.get());

        if (book.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(new ResponseMessage("Success", bookSummary));
    }

    @PostMapping
    public ResponseEntity<ResponseMessage> create(@RequestBody BookModel bookModel) {

        String[] fields = {
                bookModel.getTitle(),
                bookModel.getShortDescription(),
                bookModel.getLongDescription(),
                bookModel.getCoverImgUrl(),
                bookModel.getPublisher(),
                bookModel.getGenre(),
                bookModel.getAuthor()
        };

        int[] maxLengths = { 100, 255, 1000, 255, 100, 50, 100 };

        List<String> errors = bookService.validateBookFields(fields, maxLengths);

        if (bookModel.getAverageRating() == null) {
            errors.add("Average rating is required.");
        }

        if (bookRepository.findByTitle(bookModel.getTitle()) != null) {
            errors.add("Title already exists.");
        }

        if (!errors.isEmpty()) {
            return ResponseEntity.badRequest().body(new ResponseMessage("Validation Error", null, errors));
        }

        var bookCreated = bookRepository.save(bookModel);
        return ResponseEntity.ok()
                .body(new ResponseMessage("Book created successfully", bookCreated, null));
    }

}
