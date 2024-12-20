package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SellerDao sellerDao = DaoFactory.createSellerDao();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("=== TEST 1: seller findById ===");
		Seller sl = sellerDao.findById(3);
		System.out.println(sl);
		System.out.println();
		
		System.out.println("=== TEST 2: seller findByDepartment ===");
		List<Seller> slist = sellerDao.findByDepartment(new Department(1, null));
		for(Seller seller : slist) {
			System.out.println(seller);
		}
		System.out.println();
		
		System.out.println("=== TEST 3: findAll ===");
		List<Seller> list = sellerDao.findAll();
		for(Seller seller : list) {
			System.out.println(seller);
		} 
		System.out.println();
		
		/*System.out.println("=== TEST 4: seller insert ===");
		Seller seller = new Seller(null, "João Vítor", "masterg4nk3r@gmail.com", sdf.parse("14/06/2000"), 2500.0, new Department(2, null));
		sellerDao.insert(seller);
		System.out.println("Inserted! New id: " + seller.getId());
		System.out.println(); */
		
		/*System.out.println("=== TEST 5: seller update ===");
		Seller seller = new Seller();
		seller = sellerDao.findById(8);
		seller.setName("Marta Wayne");
		sellerDao.update(seller);
		System.out.println("Update complete");
		System.out.println();*/
		
		System.out.println("=== TEST 6: seller delete ===");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
	}

}
