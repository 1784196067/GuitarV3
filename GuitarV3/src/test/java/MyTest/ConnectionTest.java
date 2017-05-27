package MyTest;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.GuitarDao;
import dao.dataAccess;
import service.GuitarService;

public class ConnectionTest {

	@Test
	public void test1() {
		dataAccess.daoName = "sqliteDao";
		GuitarService guitarService = new GuitarService();
		System.out.println("用sqlite数据库的测试结果：" + guitarService.getAll().toString());
	}
	
	@Test
	public void test2() {
		dataAccess.daoName = "mysqlDao";
		GuitarService guitarService = new GuitarService();
		System.out.println("用mysql数据库的测试结果：" + guitarService.getAll().toString());
	}

}
