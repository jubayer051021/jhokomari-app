package com.jhokomari.bookapp.repository;

import com.jhokomari.bookapp.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity,Long> {
    BookEntity findByBookNameAndAuthorName(String bookName, String authorName);
}
