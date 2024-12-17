package com.example.api5.resolver;

import com.example.api5.entity.Author;
import com.example.api5.entity.Book;
import com.example.api5.repository.AuthorRepository;
import com.example.api5.repository.BookRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class MutationResolver {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public MutationResolver(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @MutationMapping
    public Book addBook(@Argument String title, @Argument String genre, @Argument Long authorId) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException("Author not found"));
        Book book = new Book();
        book.setTitle(title);
        book.setGenre(genre);
        book.setAuthor(author);
        return bookRepository.save(book);
    }

    @MutationMapping
    public Author addAuthor(@Argument String name) {
        Author author = new Author();
        author.setName(name);
        return authorRepository.save(author);
    }
}
