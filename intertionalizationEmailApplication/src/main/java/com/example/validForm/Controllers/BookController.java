package com.example.validForm.Controllers;

import com.example.validForm.Book;
import com.example.validForm.service.BookManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;
@Slf4j
@Controller("bookwebcontroller")
public class BookController {
  private final JavaMailSender emailSender;
  private final TemplateEngine templateEngine;

  @Autowired
  public BookController(JavaMailSender emailSender, TemplateEngine templateEngine){
    this.emailSender = emailSender;
    this.templateEngine = templateEngine;
  }

  @GetMapping("/book")
  public String bookForm(Model model){
    model.addAttribute("book", new Book());
    return "bookForm";
  }

  @PostMapping("/create/book")
  public String processOrderBook(@Valid Book book, Errors errors) throws MessagingException {
    if(errors.hasErrors()){
      return "bookForm";
    }
    log.info("Book created: " + book);

    Context context = new Context();
    context.setVariable("header", "Rejestracja książki");
    context.setVariable("title", "Tytuł: " + book.getTitle());
    context.setVariable("ISBN", "Numer ISBN: " + book.getISBN());


    context.setVariable("author", "Autor: " + book.getAuthor().getName());

    String body = templateEngine.process("template", context);
    MimeMessage mail = emailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(mail,true);

    helper.setTo("robertwe24@gmail.com");
    helper.setText(body, true);
    emailSender.send(mail);
    return "redirect:/";

  }
}
