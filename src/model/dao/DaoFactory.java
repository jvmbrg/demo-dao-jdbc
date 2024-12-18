package model.dao;

import model.dao.impl.SellerDaoJDBC;

//Classe reponsavel por instanciar os DAOS por meio de metodos estaticos
public class DaoFactory {

	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC();
	}
	
}
