package tw.takeshi.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.Command;

public class MainWindow extends Composite{
	public MainWindow() {
		
		DockLayoutPanel dockLayoutPanel = new DockLayoutPanel(Unit.EM);
		initWidget(dockLayoutPanel);
		
		MenuBar menuBar = new MenuBar(false);
		dockLayoutPanel.addNorth(menuBar, 2.5);
		MenuBar menuBar_1 = new MenuBar(true);
		
		MenuItem mntmFile = new MenuItem("File", false, menuBar_1);
		
		MenuItem mntmOpen = new MenuItem("Open", false, (Command) null);
		menuBar_1.addItem(mntmOpen);
		menuBar.addItem(mntmFile);
		MenuBar menuBar_2 = new MenuBar(true);
		
		MenuItem mntmEdit = new MenuItem("Edit", false, menuBar_2);
		
		MenuItem mntmNoFunction = new MenuItem("no function", false, (Command) null);
		menuBar_2.addItem(mntmNoFunction);
		menuBar.addItem(mntmEdit);
		
	}
}
