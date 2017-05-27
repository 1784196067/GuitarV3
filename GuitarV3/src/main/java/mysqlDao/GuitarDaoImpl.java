package mysqlDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.GuitarDao;
import model.Guitar;
import util.mysqlDbUtil;

public class GuitarDaoImpl implements GuitarDao {
	@Override
	public void addGuitar(Guitar guitar) {
		String sql = "insert into guitar values(?,?,?,?,?,?,?,?)";
		mysqlDbUtil.executeUpdate(sql, new Object[]{null,guitar.getSerialNumber(),guitar.getPrice(),guitar.getBuilder(),guitar.getModel(),guitar.getType(),guitar.getBackWood(),guitar.getTopWood()});
	}
	 
	@Override
	public List<Guitar> getAll() {
		List<Guitar> results = new ArrayList<Guitar>();
		Guitar guitar;
		try{
			ResultSet rs =  mysqlDbUtil.executeQuery("select * from guitar;", new Object[]{});
			while(rs.next()){
				guitar = new Guitar();
				guitar.setSerialNumber(rs.getString(2));
				guitar.setPrice(rs.getDouble(3));
				guitar.setBuilder(rs.getString(4));
				guitar.setModel(rs.getString(5));
				guitar.setType(rs.getString(6));
				guitar.setBackWood(rs.getString(7));
				guitar.setTopWood(rs.getString(8));
				results.add(guitar);
			}					
		}catch(SQLException e){
			e.printStackTrace();
		}
		return results;
	}

	@Override
	public void delete(String serialNumber) {
		String sql = "delete from guitar where serialNumber=?";
		mysqlDbUtil.executeUpdate(sql, new Object[]{serialNumber});
	}

}
