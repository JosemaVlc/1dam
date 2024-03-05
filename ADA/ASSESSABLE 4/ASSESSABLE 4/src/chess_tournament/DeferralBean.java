package chess_tournament;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.time.LocalDateTime;

public class DeferralBean implements Serializable, PropertyChangeListener {
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
    public DeferralBean() {

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
		if (evt.getPropertyName().equals("changeDeferralDate")) {
			if ((LocalDateTime)evt.getOldValue() == null 
					&& (LocalDateTime)evt.getNewValue() != null
					&& objPlayerBean.getStGameResult().equals("PENDING")) {
				String message = "--------------------------\n";
				message += "HI, DEFERRALBEAN SPEAKING!";
				System.out.println(message);
				objPlayerBean.setStDeferralResult("REQUESTED");
				DBBean.insertDeferral(objPlayerBean);
				objPlayerBean.setbHasADeferral(true);
				DBBean.updateHasADeferral(objPlayerBean, objPlayerBean.getLsbHasADeferral());
			}else if ((LocalDateTime)evt.getOldValue() != null 
					&& (LocalDateTime)evt.getNewValue() == null) {
				String message = "--------------------------\n";
				message += "HI, DEFERRALBEAN SPEAKING!";
				System.out.println(message);
				objPlayerBean.setStDeferralResult("REJECTED");
				DBBean.updateDeferralResult(objPlayerBean, objPlayerBean.getStDeferralResult());
				objPlayerBean.setbHasADeferral(false);
				DBBean.updateHasADeferral(objPlayerBean, objPlayerBean.getLsbHasADeferral());				
			}
		}
	}
	
}
