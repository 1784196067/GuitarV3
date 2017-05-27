package service;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import dao.GuitarDao;
import dao.dataAccess;
import model.Guitar;
import model.GuitarSpec;
import model.Inventory;

public class GuitarService {
	private GuitarDao guitarDao = dataAccess.createGuitarDao();
	
	public void addGuitar(Guitar guitar){
		guitarDao.addGuitar(guitar);
	}
	
	public JSONArray search(GuitarSpec guitarSpec) {
		Inventory inventroy = getInventory();
        List<Guitar> guitarList2 = new ArrayList<Guitar>();
		try {
			guitarList2 = inventroy.search(guitarSpec);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return divert(guitarList2);
	}
	
	public JSONArray getAll(){
		List<Guitar> list = guitarDao.getAll();
		return divert(list);
	}
	
	public void deleteGuitar(String serailNumber){
		guitarDao.delete(serailNumber);
	}
	
	public JSONArray divert(List<Guitar> list){
		 JSONArray jsonArray = new JSONArray();
			for(Guitar guitar : list){
				JSONObject jo = new JSONObject();
				jo.put("price", guitar.getPrice());
				jo.put("serialNumber", guitar.getSerialNumber());
				jo.put("backWood", guitar.getBackWood());
				jo.put("builder", guitar.getBuilder());
				jo.put("model", guitar.getModel());
				jo.put("topWood", guitar.getTopWood());
				jo.put("type", guitar.getType());
				jsonArray.put(jo);
			}
			return jsonArray;
	}
	
	public Inventory getInventory(){
		Inventory inventroy = new Inventory();
		List<Guitar> list = guitarDao.getAll();
		inventroy.setGuitars(list);
		return inventroy;
	}
	
	
}
