package application;

import db.DB;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.print("=== TEST 1: seller findById ===" + "\n");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.print("=== TEST 2: seller findByDepartment ===" + "\n");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        list.forEach(System.out::println);

        System.out.print("=== TEST 3: seller findAll ===" + "\n");
        list = sellerDao.findAll();
        list.forEach(System.out::println);

        System.out.print("=== TEST 4: seller insert ===" + "\n");
        Seller newSeller = new Seller(
                null,
                "Greg",
                "greg@gmail.com",
                new Date(),
                4000.0,
                department
        );

        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());

        System.out.print("=== TEST 5: seller update ===" + "\n");
        seller = sellerDao.findById(1);
        seller.setName("Martha Waine");
        sellerDao.update(seller);
        System.out.println("Update completed!");

        System.out.print("=== TEST65: seller delete ===" + "\n");
        System.out.println("Enter id for delete test: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete completed!");

        sc.close();
        DB.closeConnection();
    }
}
