package util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import com.mchange.v2.c3p0.ComboPooledDataSource;


public class mysqlDbUtil {
	private static ComboPooledDataSource dataSource=new ComboPooledDataSource();
	 static {
		try {
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
			dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/guitarshop");
			dataSource.setUser("root");
			dataSource.setPassword("123456");
			dataSource.setInitialPoolSize(50);
			dataSource.setMaxPoolSize(100);
			dataSource.setMaxIdleTime(10000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static boolean executeUpdate(String sql,Object[] args){
		Connection conn=null;
		PreparedStatement pst=null;
		int rowsCount=0;
		try{
			conn=dataSource.getConnection();
			pst=conn.prepareStatement(sql);
			if(args!=null&args.length>0){
				for(int i=0;i<args.length;i++){
					pst.setObject(i+1, args[i]);
				}
			}
			rowsCount=pst.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rowsCount>0?true:false;
	}
	public static ResultSet executeQuery(String sql,Object[] args){
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			conn=dataSource.getConnection();
			pst=conn.prepareStatement(sql);
			if(args!=null&args.length>0){
				for(int i=0;i<args.length;i++){
					pst.setObject(i+1, args[i]);
				}
			}
			rs=pst.executeQuery();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rs;
	}
	public static String executeWords(String chart){
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		ResultSetMetaData metaDate=null;
		String words="";
		String exe="";
		int n=0;
		try{
			conn=dataSource.getConnection();
			String sql="select * from "+chart;
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			metaDate=rs.getMetaData();
			n=metaDate.getColumnCount();
			for(int i=1;i<n;i++){
				exe=metaDate.getColumnName(i)+"=?,";
				words+=exe;
			}
			words+=metaDate.getColumnName(n)+"=?";
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return words;
	}
}
