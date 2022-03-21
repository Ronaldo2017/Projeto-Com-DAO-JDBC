package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program2 {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("=== TEST 1: DEPARTMENT FINDBYID ====");
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		Department department = departmentDao.findById(2);
		System.out.println(department);

		System.out.println();

		System.out.println();
		System.out.println("=== TESTE 3: DEPARTMENT FINDALL");
		List<Department> list = departmentDao.findAll();

		for (Department obj : list) {
			System.out.println(obj);
		}

		System.out.println();
		System.out.println("=== TEST 4: DEPARTMENT INSERT ====");
		Department newDepartment = new Department(null, "TI");
		departmentDao.insert(newDepartment);

		System.out.println("Inserted! New id = " + newDepartment.getId());
		System.out.println();

		System.out.println();
		System.out.println("=== TEST 6: DEPARTMENT UPDATE ====");
		department = departmentDao.findById(12);
		department.setName("Construção");
		departmentDao.update(department);
		System.out.println("Update completed!");

		System.out.println();
		System.out.println("=== TEST 5: DEPARTMENT DELETED ====");
		System.out.println("Enter id for delete department: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");
	}

}
