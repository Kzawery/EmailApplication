package com.example.validForm.service;


import com.example.validForm.Book;

import java.util.List;

public interface BookManager {

  void addBook(Book book);

  Book findById(String id);

  List<Book> getAllBooks();

  void remove(String id);
}
