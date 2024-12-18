package model.dao;

import db.DB;
import model.dao.impl.SellerDaoJDBC;

//Classe reponsavel por instanciar os DAOS por meio de metodos estaticos
public class DaoFactory {
	
	//Metodo responsavel por criar um SellerDao, dessa forma, não precisamos expor a implementação, mais ou menos como funciona a injeção de dependencia
	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC(DB.getConnection());
	}
	
}
