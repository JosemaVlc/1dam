package GestProducts;

public class Products {
	private String stName;
	private double dbPrice;
	private int iUnit;
	
	public Products(String stName, double dbPrice, int iUnit) {
		this.stName = stName;
		this.dbPrice = dbPrice;
		this.iUnit = iUnit;
	}

	public String getStName() {
		return stName;
	}

	public void setStName(String stName) {
		this.stName = stName;
	}

	public double getDbPrice() {
		return dbPrice;
	}

	public void setDbPrice(double dbPrice) {
		this.dbPrice = dbPrice;
	}

	public int getiUnit() {
		return iUnit;
	}

	public void setiUnit(int iUnit) {
		this.iUnit = iUnit;
	}
	
	public String toString() {
		return "Product: "+this.stName+", Price: "+this.dbPrice+", Units: "+this.iUnit;
		
	}
}
