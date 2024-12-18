package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao{
	
	private Connection conn;
	/* Variavel conn utilizada para fazer a conexão com banco de dados foi declarada no construtor da classe para não precisar ser instanciada
	 * dentro dos metodos, assim injetando a dependencia na classe SellerDaoJDBC */
	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("SELECT seller.*,department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE seller.Id = ?"); 
									   
			st.setInt(1, id);
			rs = st.executeQuery();
			
			/* Aqui apos a busca no banco de dados, tabela com os objetos ficou armazenada na variavel "ResultSet rs". Porém, o rs está 
			 * apontado para a posição 0, onde não tem objetos, por isso foi necessário colocar a condiçao if para testar se depois da]
			 * consultad algum objeto foi armazenado nela, caso não tiver vindo, a consulta vai retornar nulo. Caso algum objeto venha 
			 * apos a consulta, o programa vai instanciar uma new Department e acessar as colunas dentro da tabela para setar os dados 
			 * que estamos buscando, no caso, vamos setar o Id e o nome do departamento que foram setados durante a criação das entidades
			 */
			if(rs.next()) {
				/* Aqui, depois de feita a busca dos dados para o id escolhido, a tabela retornada já está armazenada na variavel rs.
				 * Agora, vamos instanciar os objetos e associa-los. Primeiro, foi instanciado o departamento, onde seus atributos foram
				 * setados atraves do comando "rs.get()" que pega as informações na tabela a partir do nome de sua coluna que é passado por
				 * parametro dentro da requisição, aqui é importante passar o nome da coluna exatamente como foi definida no banco de dados.
				 * Depois, instanciamos uma vendedor e fizemos a mesma associação, buscando os dados com o comando "rs.get()" e atribuindo 
				 * os valores de seus atributos de acordo com o que foi obtido na consulta SQL.*/
				Department dep = new Department();
				dep.setId(rs.getInt("DepartmentId"));
				dep.setName(rs.getString("DepName"));
				
				Seller obj = new Seller();
				obj.setId(rs.getInt("Id"));
				obj.setName(rs.getString("Name"));
				obj.setEmail(rs.getString("Email"));
				obj.setBaseSalary(rs.getDouble("BaseSalary"));
				obj.setBirthDate(rs.getDate("BirthDate"));
				obj.setDepartment(dep);
				return obj;
			}
			return null;
			
		} catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		
		finally { //Não vamos fechar a conexão, por que o objeto DAO pode ser utilizado para mais coisas, deixa para ser fechado depois
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
