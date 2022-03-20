package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("=== TEST 1: SELLER FINDBYID ====");
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		Seller seller = sellerDao.findById(3);
		
		System.out.println();
		System.out.println(seller);
		
		Department department = new Department(2, null);
		System.out.println("=== TEST 2: SELLER FINDBYDEPARTMENT ====");
		List<Seller> list = sellerDao.findByDepartment(department);
		
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println();
		System.out.println("=== TEST 3: SELLER FINDALL ====");
		list = sellerDao.findAll();
		
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println();
		System.out.println("=== TEST 4: SELLER INSERT ====");
		Seller newSeller = new Seller(null, "Juca", "juca@gmail.com", new Date(), 4000.0, department);
		
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println();
		System.out.println("=== TEST 5: SELLER UPDATE ====");
		seller = sellerDao.findById(1);
		seller.setName("Juca da Silva");
		sellerDao.update(seller);
		System.out.println("update completed!");
		
		System.out.println();
		System.out.println("=== TEST 6: SELLER DELETE ====");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed!");
	}

}
