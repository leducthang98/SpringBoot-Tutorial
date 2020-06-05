package com.sapo.ex6.API;

import com.sapo.ex6.DAO.CategoryDAO;
import com.sapo.ex6.DAO.ProductDAO;
import com.sapo.ex6.DTO.Category;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryAPI {
    ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
    CategoryDAO categoryDAO = (CategoryDAO) context.getBean("DAOCategory");

    @DeleteMapping("/category/{id}")
    public ResponseEntity<Integer> deleteCategory(@PathVariable int id) {
        return new ResponseEntity<>(categoryDAO.deleteCategory(id), HttpStatus.OK);
    }

    @PostMapping("/category")
    public ResponseEntity<Integer> createCategory(@RequestBody Category category) {
        return new ResponseEntity<>(categoryDAO.createCategory(category), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategory() {
        return new ResponseEntity<>(categoryDAO.getAllCategory(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Integer> updateCategory(@RequestParam int id, @RequestParam String name) {
        return new ResponseEntity<>(categoryDAO.updateCategory(id, name), HttpStatus.OK);
    }

}
