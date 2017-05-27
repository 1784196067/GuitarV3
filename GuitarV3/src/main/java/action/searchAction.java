package action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import com.opensymphony.xwork2.ActionSupport;

import model.Guitar;
import model.GuitarSpec;
import service.GuitarService;


public class searchAction extends ActionSupport {
		private InputStream inputStream;
		private Guitar guitar;
		private GuitarSpec guitarSpec;
		private String serialNumber;	


		public String getSerialNumber() {
			return serialNumber;
		}

		public void setSerialNumber(String serialNumber) {
			this.serialNumber = serialNumber;
		}

		public Guitar getGuitar() {
			return guitar;
		}

		public void setGuitar(Guitar guitar) {
			this.guitar = guitar;
		}

		public GuitarSpec getGuitarSpec() {
			return guitarSpec;
		}

		public void setGuitarSpec(GuitarSpec guitarSpec) {
			this.guitarSpec = guitarSpec;
		}

		public InputStream getResult()
		{
			return inputStream;
		}
		
		static{
			HttpServletResponse response=ServletActionContext.getResponse();  
	        response.setContentType("text/html");
	        response.setContentType("text/plain; charset=utf-8");
		}
		
		public String searchGuitar() throws Exception{		
	        GuitarService guitarService = new GuitarService();
	        JSONArray jsonArray = guitarService.search(guitarSpec);
			inputStream =new ByteArrayInputStream(jsonArray.toString()
					.getBytes("UTF-8"));
			return SUCCESS;
		}
		
		public String loadGuitars() throws Exception{
	        GuitarService guitarService = new GuitarService();
	        JSONArray jsonArray = guitarService.getAll();
	        inputStream =new ByteArrayInputStream(jsonArray.toString()
					.getBytes("UTF-8"));
	        return SUCCESS;		
		}

		public String deleteGuitar() throws Exception{
			GuitarService guitarService = new GuitarService();
			guitarService.deleteGuitar(serialNumber);
			inputStream =new ByteArrayInputStream("success"
					.getBytes("UTF-8"));
			return SUCCESS;	
		}
		
		public String addGuitar() throws Exception{
			GuitarService guitarService = new GuitarService();
			guitarService.addGuitar(guitar);
			inputStream =new ByteArrayInputStream("success"
					.getBytes("UTF-8"));
			return SUCCESS;
		}
		
		
}
