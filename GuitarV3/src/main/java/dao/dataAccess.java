package dao;

//import mysqlDao.GuitarDaoImpl;

import sqliteDao.GuitarDaoImpl;

public class dataAccess {
	public static String daoName = "sqliteDao";
	
	public static GuitarDao createGuitarDao(){
		GuitarDao result = null;
		try{
			Object o = Class.forName(daoName + "." + "GuitarDaoImpl").newInstance();
			result = (GuitarDaoImpl)o;
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
}
