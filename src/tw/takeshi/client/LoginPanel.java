package tw.takeshi.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Widget;

public class LoginPanel extends Composite implements ClickHandler{
	private final LoginServiceAsync loginServiceAsync = GWT.create(LoginService.class);
	LoginPanel thisPanel;
	private PasswordTextBox password;
	private TextBox username;
	Label errorMesssage;
	@Override
	protected void initWidget(Widget widget) {
		super.initWidget(widget);
	}
	public LoginPanel() {
		FlexTable flexTable = new FlexTable();
		this.initWidget(flexTable);
		
		flexTable.setSize("416px", "240px");
		
		Label label = new Label("請輸入帳號及密碼");
		flexTable.setWidget(0, 0, label);
		
		errorMesssage = new Label("");
		flexTable.setWidget(0, 1, errorMesssage);
		
		Label label_1 = new Label("帳號");
		flexTable.setWidget(1, 0, label_1);
		
		username = new TextBox();
		flexTable.setWidget(1, 1, username);
		username.setWidth("170px");
		
		Label label_2 = new Label("密碼");
		flexTable.setWidget(2, 0, label_2);
		
		password = new PasswordTextBox();
		flexTable.setWidget(2, 1, password);
		password.setWidth("170px");
		
		Button button = new Button("登入");
		flexTable.setWidget(3, 1, button);
		button.addClickHandler(this);
		
		thisPanel = this;
	}
	@Override
	public void onClick(ClickEvent event) {
		String uname = username.getText();
		String pwd = password.getText();
		loginServiceAsync.login(uname, pwd, new AsyncCallback<Boolean>() {
			
			@Override
			public void onSuccess(Boolean result) {
				if(!result){
					errorMesssage.setText("帳號或密碼有誤");
				} else {
					errorMesssage.setText("登入成功");
					RootPanel.get("loginArea").clear();
					RootPanel.get("mainWin").add(new MainWindow());
				}
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				errorMesssage.setText("伺服器連線錯誤");
				
			}
		});
		
	}
}
