public class Pizzas {
	private int iId;
	private String stName;
	private double dbPrice;
	
	public Pizzas(String stName, double dbPrice, int iId) {
		this.stName = stName;
		this.dbPrice = dbPrice;
		this.iId = iId;
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
	
	public int getiId() {
		return iId;
	}
	
	public void setiId(int iId) {
		this.iId = iId;
	}
	
	public String toString() {
		return "Product: "+this.stName+", Price: "+this.dbPrice+", ID: "+this.iId;
		
	}

}
