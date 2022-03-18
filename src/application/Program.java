package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Department obj = new Department(1, "Books");
		Seller seller = new Seller(21, "Bob", "bob@gmail.com", new Date(), 3000.0, obj);
		System.out.println(obj);
		System.out.println(seller);
	}

}
