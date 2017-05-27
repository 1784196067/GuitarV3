package sqliteDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.GuitarDao;
import model.Guitar;
import util.sqliteDbUtil;

public class GuitarDaoImpl implements GuitarDao {

	@Override
	public void addGuitar(Guitar guitar) {
		String sql = "insert into guitar values(?,?,?,?,?,?,?)";
		sqliteDbUtil.executeUpdate(sql, new Object[]{guitar.getSerialNumber(),guitar.getPrice(),guitar.getBuilder(),guitar.getModel(),guitar.getType(),guitar.getBackWood(),guitar.getTopWood()});
	}
	 
	@Override
	public List<Guitar> getAll() {
		List<Guitar> results = new ArrayList<Guitar>();
		Guitar guitar;
		try{
			ResultSet rs =  sqliteDbUtil.executeQuery("select * from guitar;", new Object[]{});
			while(rs.next()){
				guitar = new Guitar();
				guitar.setSerialNumber(rs.getString(1));
				guitar.setPrice(rs.getDouble(2));
				guitar.setBuilder(rs.getString(3));
				guitar.setModel(rs.getString(4));
				guitar.setType(rs.getString(5));
				guitar.setBackWood(rs.getString(6));
				guitar.setTopWood(rs.getString(7));
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
		sqliteDbUtil.executeUpdate(sql, new Object[]{serialNumber});
	}

}
