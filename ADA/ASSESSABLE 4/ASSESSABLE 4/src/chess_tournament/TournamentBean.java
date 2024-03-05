package chess_tournament;


public class TournamentBean {
	
	private PlayerBean objPlayerBean;
	private String stCode;
	private String stName;

	/*
	 * ------------------------------------------
	 * GETTERS
	 * ------------------------------------------
	 */
	public PlayerBean getObjPlayerBean() {
		return objPlayerBean;
	}
	public String getStCode() {
		return stCode;
	}
	public String getStName() {
		return stName;
	}
	
    /*
	 * ------------------------------------------
	 * SETTERS
	 * ------------------------------------------
	 */
	public void setObjPlayerBean(PlayerBean objPlayerBean) {
		this.objPlayerBean = objPlayerBean;
	}
	public void setStCode(String stCode) {
		this.stCode = stCode;
	}
	public void setStName(String stName) {
		this.stName = stName;
	}
}

