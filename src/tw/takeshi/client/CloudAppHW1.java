package tw.takeshi.client;



import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class CloudAppHW1 implements EntryPoint {
	
	

	/**
	 * This is the entry point method.
	 */
	
	public void onModuleLoad() {
		
		RootPanel.get("loginArea").add(new LoginPanel());
		
		
		
	}
}
