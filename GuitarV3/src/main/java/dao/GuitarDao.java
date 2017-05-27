package dao;



import java.util.List;
import org.json.JSONArray;
import model.Guitar;
import model.GuitarSpec;

public interface GuitarDao {
	public void delete(String serailNumber);
	public void addGuitar(Guitar guitar);
	public List<Guitar> getAll();
}
