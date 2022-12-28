package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.List;

public class Program {
    public static void main(String[] args) {
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
    }
}
