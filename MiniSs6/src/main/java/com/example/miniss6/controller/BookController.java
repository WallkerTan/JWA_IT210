package com.example.miniss6.controller;

import com.example.miniss6.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    List<Book>  books = new ArrayList<>(
            Arrays.asList(
                    new Book(1, "Jack 5 Củ", "Rách", 350000),
                    new Book(2, "Không làm mà đòi ăn", "Huấn cụt ngón", 420000),
                    new Book(3, "Bé Bắp", "Phạm Thoại", 280000),
                    new Book(4, "Bánh Mì", "Cua đông nhiễm nước biển", 500000)
            )
    );

    @GetMapping
    public String list(Model model) {
        model.addAttribute("books", books);
        return "books/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable("id") int id, Model model) {
        Book book = books.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElse(null);

        if (book == null) {
            return "redirect:/books";
        }

        model.addAttribute("book", book);
        return "books/detail";
    }
}
