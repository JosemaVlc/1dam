package ADABeans;

import java.beans.PropertyChangeEvent;

public class Tournament {

	private String stCode; // Tournament code
	private String stName; // Tournament name
	private PlayerBean objPlayerBean; // Associated player bean
	
	/**
     * Default constructor.
     */
	public Tournament() {}
	
	/**
     * Constructor with code and name.
     * @param stCode The tournament code.
     * @param stName The tournament name.
     */
	public Tournament (String stCode, String stName) {
		this.stCode = stCode;
		this.stName = stName;
	}

    /**
     * Constructor with code, name, and associated player bean.
     * @param stCode The tournament code.
     * @param stName The tournament name.
     * @param objPlayerBean The associated player bean.
     */
	public Tournament (String stCode, String stName, PlayerBean objPlayerBean) {
		this.stCode = stCode;
		this.stName = stName;
		this.objPlayerBean = objPlayerBean;
	}
	
	// Getters and setters
	
	public String getStCode() {
		return stCode;
	}

	public void setStCode(String stCode) {
		this.stCode = stCode;
	}

	public String getStName() {
		return stName;
	}

	public void setStName(String stName) {
		this.stName = stName;
	}

	public PlayerBean getObjPlayerBean() {
		return objPlayerBean;
	}

	public void setObjPlayerBean(PlayerBean objPlayerBean) {
		this.objPlayerBean = objPlayerBean;
	}
}
