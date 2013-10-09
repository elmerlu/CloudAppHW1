package tw.takeshi.server;

import tw.takeshi.client.LoginService;
import tw.takeshi.client.LoginServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class LoginServiceImpl extends RemoteServiceServlet implements LoginService{
	private static final long serialVersionUID = -384389817920530498L;
	

	@Override
	public boolean login(String username, String password)
			throws IllegalArgumentException {
		
		return username.equals("admin") && password.equals("admin");
	}

}
