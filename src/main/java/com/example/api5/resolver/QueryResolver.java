package com.example.api5.resolver;

import com.example.api5.entity.Author;
import com.example.api5.entity.Book;
import com.example.api5.repository.AuthorRepository;
import com.example.api5.repository.BookRepository;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class QueryResolver {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public QueryResolver(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @QueryMapping
    public List<Book> books() {
        return bookRepository.findAll();
    }

    @QueryMapping
    public List<Author> authors() {
        return authorRepository.findAll();
    }
}
