package com.example.validForm;

import com.example.validForm.validator.ISBN;

public class Book {
  private String id;
  private String title;
  @com.example.validForm.validator.ISBN
  private String ISBN;
  private Person author;
  public Book(String title, String firstName, Person yob) {
    this.title = title;
    this.ISBN = firstName;
    this.author = yob;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Book() {
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getISBN() {
    return ISBN;
  }

  public void setISBN(String ISBN) {
    this.ISBN = ISBN;
  }

  public Person getAuthor() {
    return author;
  }

  public void setAuthor(Person author) {
    this.author = author;
  }

  @Override
  public String toString() {
    return "Book{" +
            "id='" + id + '\'' +
            ", title='" + title + '\'' +
            ", ISBN='" + ISBN + '\'' +
            ", author=" + author.getName() +
            '}';
  }
}
