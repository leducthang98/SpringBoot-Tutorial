package com.sapo.ex6;

import com.sapo.ex6.DAO.ProductDAO;
import com.sapo.ex6.DTO.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class Ex6Application implements CommandLineRunner {

    public static void main(String[] args) {

        SpringApplication.run(Ex6Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        ProductDAO productDAO = (ProductDAO) context.getBean("DAOProduct");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1.Create");
            System.out.println("2.Read");
            System.out.println("3.Update");
            System.out.println("4.Delete");
            System.out.println("5.Exit");
            int input = sc.nextInt();
            sc.nextLine();
            switch (input) {
                case 1:
                    System.out.println("name:");
                    String name = sc.nextLine();
                    System.out.println("img_link:");
                    String imageLink = sc.nextLine();
                    System.out.println("price:");
                    int price = sc.nextInt();
                    sc.nextLine();
                    System.out.println("number:");
                    int number = sc.nextInt();
                    sc.nextLine();
                    int sold = 0;
                    System.out.println("description:");
                    String description = sc.nextLine();
                    System.out.println("cat_id:");
                    int catId = sc.nextInt();
                    sc.nextLine();
                    boolean response = productDAO.createProduct(new Product(name, imageLink, description, catId, price, number, sold));
                    if (response) {
                        System.out.println("Create product success.");
                    } else {
                        System.out.println("Create product fail.");
                    }
                    break;
                case 2:
                    List<Product> products = productDAO.getAllProduct();
                    for (int i = 0; i < products.size(); i++) {
                        System.out.println(products.get(i).toString());
                    }
                    break;
                case 3:
                    System.out.println("id:");
                    int idUpdate = sc.nextInt();
                    sc.nextLine();
                    System.out.println("new name:");
                    String newName = sc.nextLine();
                    int result = productDAO.updateProduct(idUpdate, newName);
                    if (result == 0) {
                        System.out.println("id not exist.");
                    } else if (result == 1) {
                        System.out.println("success.");
                    } else {
                        System.out.println("unknown error.");
                    }
                    break;
                case 4:
                    System.out.println("id:");
                    int idDelete = sc.nextInt();
                    int res = productDAO.deleteProduct(idDelete);
                    if (res == 0) {
                        System.out.println("id not exist.");
                    } else if (res == 1) {
                        System.out.println("success.");
                    } else {
                        System.out.println("unknown error.");
                    }
                    break;
                case 5:
                    return;

            }
        }

    }

}
