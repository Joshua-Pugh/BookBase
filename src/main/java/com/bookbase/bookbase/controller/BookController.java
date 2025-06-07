package com.bookbase.bookbase.controller;

import com.bookbase.bookbase.exception.ResourceNotFoundException;
import com.bookbase.bookbase.repository.BookRepository;
import com.bookbase.bookbase.model.Book;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    // Get API to fetch all books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/findOne/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable(value = "id") Long bookId)
            throws ResourceNotFoundException {

            Book book = bookRepository.findById(bookId)
                    .orElseThrow(() -> new ResourceNotFoundException("Book not found for this id:: " + bookId));
            return ResponseEntity.ok(book);

    }

    @PostMapping("/createOne")
    public Book createBook(@Valid @RequestBody Book book) {
        return bookRepository.save(book);
    }

    @PutMapping("/updateOne/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable(value = "id") Long bookId,
                                           @Valid @RequestBody Book bookDetails) throws ResourceNotFoundException{
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found for this id:: " + bookId));

        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        final Book updatedBook = bookRepository.save(book);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/deleteOne/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found for this id:: " + id));

        bookRepository.delete(book);
        return ResponseEntity.ok("Book deleted successfully.");
    }

}