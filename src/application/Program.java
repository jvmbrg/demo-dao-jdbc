package application;

import java.text.ParseException;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		
		System.out.println("=== TEST 1: seller findById ===");
		Seller sl = sellerDao.findById(3);
		System.out.println(sl);
		System.out.println();
		
		System.out.println("=== TEST 2: seller department ===");
		List<Seller> slist = sellerDao.findByDepartment(new Department(1, null));
		for(Seller seller : slist) {
			System.out.println(seller);
		}
	}

}
