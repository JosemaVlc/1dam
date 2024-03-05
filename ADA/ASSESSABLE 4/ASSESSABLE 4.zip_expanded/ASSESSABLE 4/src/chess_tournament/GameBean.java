package chess_tournament;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.time.LocalDateTime;

public class GameBean implements Serializable, PropertyChangeListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PlayerBean objPlayerBean;

    /*
	 * ------------------------------------------
	 * METHODS
	 * ------------------------------------------
	 */
	
	/*
	 * Empty constructor
	 */
    public GameBean() {

    }
    
    /*
	 * ------------------------------------------
	 * SETTERS
	 * ------------------------------------------
	 */
    public void setObjPlayerBean(PlayerBean objPlayerBean) {
        this.objPlayerBean = objPlayerBean;
    }

    /*
   	 * -------------------------
   	 * LISTENERS. EVENTS RAISED
   	 * -------------------------
   	 */
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals("changeMatchDate")) {
			if ((LocalDateTime)evt.getOldValue() == null 
					&& (LocalDateTime)evt.getNewValue() != null) {
				String message = "--------------------------\n";
				message += "HI, GAMEBEAN SPEAKING!";
				System.out.println(message);
				objPlayerBean.setbHasAMatch(true);
				DBBean.insertGame(objPlayerBean);	
				objPlayerBean.setStGameResult("PENDING");
				DBBean.updateHasAMatch(objPlayerBean, objPlayerBean.getLsbHasAMatch());
			} else if ((LocalDateTime)evt.getOldValue() != null 
					&& (LocalDateTime)evt.getNewValue() == null
					&& !objPlayerBean.getStGameResult().equals("PENDING")) {
				String message = "--------------------------\n";
				message += "HI, GAMEBEAN SPEAKING!";
				System.out.println(message);
				DBBean.updateGameResult(objPlayerBean, objPlayerBean.getStGameResult());	
				objPlayerBean.setbHasAMatch(false);
				DBBean.updateHasAMatch(objPlayerBean, objPlayerBean.getLsbHasAMatch());				
			}
		}
	}	
}
