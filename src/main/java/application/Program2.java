package application;

import db.DB;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.print("=== TEST 1: department insert ===" + "\n");
        Department newDepartment = new Department(null, "Food");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id = " + newDepartment.getId());

        System.out.print("=== TEST 2: department update ===" + "\n");
        newDepartment = departmentDao.findById(1);
        newDepartment.setName("Drinks");
        departmentDao.update(newDepartment);
        System.out.println("Update completed!");

        System.out.print("=== TEST 3: department delete ===" + "\n");
        System.out.print("Enter id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed!");

        System.out.print("=== TEST 4: department findAll ===" + "\n");
        List<Department> list = new ArrayList<>();
        list = departmentDao.findAll();
        list.forEach(System.out::println);

        sc.close();
        DB.closeConnection();
    }
}
