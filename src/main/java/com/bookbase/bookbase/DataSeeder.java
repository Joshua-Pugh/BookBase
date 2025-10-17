package com.bookbase.bookbase;
import com.bookbase.bookbase.model.Book;
import com.bookbase.bookbase.repository.BookRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataSeeder {

    private final BookRepository bookRepository;

    @PostConstruct
    public void seedData() {
        if (bookRepository.count() == 0) {
            bookRepository.save(new Book(null,
                    "Pride and Prejudice",
                    "Jane Austen",
                    "A timeless novel of manners, love, and misunderstanding among the British gentry of the early 19th century."
            ));
            bookRepository.save(new Book(null,
                    "1984",
                    "George Orwell",
                    "A chilling dystopian vision of a totalitarian regime that watches and controls every aspect of human life."
            ));
            bookRepository.save(new Book(null,
                    "Moby-Dick",
                    "Herman Melville",
                    "The epic tale of Captain Ahab’s obsessive quest to kill the great white whale, a symbol of fate and defiance."
            ));
            bookRepository.save(new Book(null,
                    "To Kill a Mockingbird",
                    "Harper Lee",
                    "A powerful exploration of racial injustice and moral growth in the Deep South, seen through the eyes of young Scout Finch."
            ));
            bookRepository.save(new Book(null,
                    "Frankenstein",
                    "Mary Shelley",
                    "A gothic masterpiece about creation, ambition, and the consequences of playing god, as Victor Frankenstein gives life to a monster."
            ));
            bookRepository.save(new Book(null,
                    "The Great Gatsby",
                    "F. Scott Fitzgerald",
                    "A tragic story of love, wealth, and disillusionment set in the Roaring Twenties, told through the mysterious Jay Gatsby."
            ));
            bookRepository.save(new Book(null,
                    "The Hobbit",
                    "J.R.R. Tolkien",
                    "A reluctant hobbit embarks on a grand adventure filled with treasure, dragons, and the courage to change his fate."
            ));
            bookRepository.save(new Book(null,
                    "The Picture of Dorian Gray",
                    "Oscar Wilde",
                    "A dark reflection on vanity and morality, following a man whose portrait bears the marks of his corruption while he remains young."
            ));
            bookRepository.save(new Book(null,
                    "Dracula",
                    "Bram Stoker",
                    "The legendary gothic horror that introduced Count Dracula and redefined the vampire myth for modern readers."
            ));
            bookRepository.save(new Book(null,
                    "The Odyssey",
                    "Homer",
                    "An ancient Greek epic following Odysseus’ perilous journey home after the Trojan War, filled with gods, monsters, and trials of endurance."
            ));
            System.out.println("Seeded 10 classic books into the database!");
        } else {
            System.out.println("Database already contains books, skipping seeding.");
        }
    }
}
