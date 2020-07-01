package tests;


import sonc.client.GreetingService;
import sonc.client.GreetingServiceAsync;
import sonc.client.ManagerService;
import sonc.client.ManagerServiceAsync;
import sonc.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Web_asw_t3_old implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network " + "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
	//private final ManagerServiceAsync managerService = GWT.create(ManagerService.class);
	
	private  class loginPanel extends Composite {
		public loginPanel() {
			VerticalPanel panel = new VerticalPanel();
			TextBox userField = new TextBox();
			PasswordTextBox passField = new PasswordTextBox();
			final Label user = new Label("User:");
			final Label pass = new Label("Pass:");
			final Button loginButton = new Button("Login");
			initWidget(panel);
		}
	}

	private  class tabPanel extends Composite {
		public  tabPanel() {
			VerticalPanel panel = new VerticalPanel();
			TabLayoutPanel tabPanel = new TabLayoutPanel(2.5, Unit.EM);
			TextArea commandArea = new TextArea();
			initWidget(panel);
		}
	}
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {	
		RootPanel rootPanel = RootPanel.get();
		SplitLayoutPanel main = new SplitLayoutPanel();
		Widget login =new loginPanel();
		Widget editor = new tabPanel();
		main.addEast(login,0);
		main.addNorth(editor, 0);
		rootPanel.add(login);
		rootPanel.add(editor);
	}
}