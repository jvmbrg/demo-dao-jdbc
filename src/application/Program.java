package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		Department dp = new Department(1, "Books");
		System.out.println(dp);
		
		Seller sl = new Seller(1, "Joao Vitor", "jvitormbraga@gmail.com", sdf.parse("14/06/2000"), 1500.0, dp);
		System.out.println(sl);
	}

}
