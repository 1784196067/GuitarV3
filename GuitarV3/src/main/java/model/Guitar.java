package model;

public class Guitar {	
	private String serialNumber;
	
	private double price;
	
	private String builder; 
	
	private String model;
	
	private String type;
	
	private String backWood;
	
	private String topWood;
	
	private GuitarSpec guitarSpec;
	
	
	public Guitar(String serialNumber, double price, GuitarSpec guitarSpec) {
		super();
		this.serialNumber = serialNumber;
		this.price = price;
		this.guitarSpec = guitarSpec;
	}

	public Guitar() {
		super();
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public GuitarSpec getGuitarSpec() {
		return new GuitarSpec(builder, model, type, backWood, topWood);
	}

	public void setGuitarSpec(GuitarSpec guitarSpec) {
		this.guitarSpec = guitarSpec;
	}

	public String getBuilder() {
		return builder;
	}

	public void setBuilder(String builder) {
		this.builder = builder;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBackWood() {
		return backWood;
	}

	public void setBackWood(String backWood) {
		this.backWood = backWood;
	}

	public String getTopWood() {
		return topWood;
	}

	public void setTopWood(String topWood) {
		this.topWood = topWood;
	}
	
}
