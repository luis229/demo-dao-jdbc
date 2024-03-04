package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

       System.out.println("=== TEST 1: department Insert =====");
        Department newdepartment = new Department(null, "sports");
        departmentDao.insert(newdepartment);
        System.out.println("Inserted! new id = "+ newdepartment.getId());

        System.out.println("\n=== TEST 2: department findById =====");
        Department department = departmentDao.findBYId(7);
        System.out.println(department);

        System.out.println("\n=== TEST 3: department Update =====");
        department = departmentDao.findBYId(7);
        department.setName("Tech");
        departmentDao.update(department);
        System.out.println("Update Completed");

        System.out.println("\n=== TEST 4: department delete =====");
        System.out.print("Enter id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("delete completed");

        System.out.println("\n=== TEST 5: department findByAll =====");
        List<Department> list = departmentDao.findAll();
        for (Department dep : list){
            System.out.println(dep);
        }

    }
}
