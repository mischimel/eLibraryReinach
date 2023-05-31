package ch.fhnw.elibrary.elib.business.service;

import java.util.List;
import org.springframework.stereotype.Service;
import ch.fhnw.elibrary.elib.data.domain.Author;
import ch.fhnw.elibrary.elib.data.repository.AuthorRepository;

// AuthorService class author @michimel

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    // checks if the author with the given firstname and lastname already exists, if
    // not, the author is saved
    public Author createAuthor(Author author) throws Exception {
        if (author.getFirstName() != null && author.getLastName() != null) {
            if (authorRepository.findByFirstNameAndLastName(author.getFirstName(), author.getLastName()) == null)
                return authorRepository.save(author);
            else
                throw new Exception("Author " + author.getFirstName() + author.getLastName() + " already exists");

        }
        throw new Exception("Invalid author name");
    }

    // to update an existing author, after finding the author by ID, the author is
    // updated with the new values
    public Author updateAuthor(Long authorID, Author authorDetails) {
        Author author = authorRepository.findByAuthorID(authorID);
        if (author == null) {
            throw new RuntimeException("Author not found for this ID :: " + authorID);
        }
        author.setFirstName(authorDetails.getFirstName());
        author.setLastName(authorDetails.getLastName());
        author.setCountry(authorDetails.getCountry());
        return authorRepository.save(author);
    }

    /*
     * the following methods are not used in the application,
     * as budibase provides the functionality to search via the filter function,
     * but for completeness we provide the methods below
     */

    public List<Author> getAuthorsByFirstName(String firstName) {
        return authorRepository.findByFirstName(firstName);
    }

    public List<Author> getAuthorsByLastName(String lastName) {
        return authorRepository.findByLastName(lastName);
    }

    public Author getAuthorByFirstNameAndLastName(String firstName, String lastName) {
        return authorRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    public List<Author> getAuthorsByCountry(String country) {
        return authorRepository.findByCountry(country);
    }

    /* never used locally
    private Author getAuthorById(Long authorID) {
        return authorRepository.findByAuthorID(authorID);
    }
    */
}
