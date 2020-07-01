package sonc.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DeckPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Web_asw_t3 implements EntryPoint {
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
	private final ManagerServiceAsync managerService = GWT.create(ManagerService.class);


	/*
	private  class loginPanel extends Composite {

		public loginPanel() {

		}
	}

	private  class editorPanel extends Composite {
		public  editorPanel() {

		}
	}

	private  class viewerPanel extends Composite {
		public  editorPanel() {

		}
	}

	private  class commandPanel extends Composite {
		public  commandPanel() {

		}
	}

	 */

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {	
		// Create DeckPanel widget
		final DeckPanel deckPanel = new DeckPanel();
		deckPanel.setSize("1000px", "400px");
		deckPanel.setStyleName("deckpanel");

		//Content on deck
		Label label1 = new Label("Editor");
		Label label2 = new Label("Movie");

		deckPanel.add(label1);
		deckPanel.add(label2);


		//show first label
		deckPanel.showWidget(0);

		//create button bar
		HorizontalPanel buttonBar = new HorizontalPanel();
		buttonBar.setSpacing(10);
		buttonBar.setStyleName("buttonbar");

		// create button and add click handlers
		// show different labels on click of different buttons
		Button button1 = new Button("Editor");
		button1.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				deckPanel.showWidget(0);
			}
		});

		Button button2 = new Button("Viewer");
		button2.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				deckPanel.showWidget(1);
			}
		});

		Button button3 = new Button("Console");
		button3.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				deckPanel.showWidget(2);
			}
		});

		buttonBar.add(button1);
		buttonBar.add(button2);
		buttonBar.add(button3);


		// Creates Login Widget
		VerticalPanel loginMenu = new VerticalPanel();
		Label userLabel = new Label("Username:");
		TextBox loginField = new TextBox();
		Button loginButton = new Button("LOGIN");
		PasswordTextBox passwordField = new PasswordTextBox();
		Label loginLabel = new Label("Password:");
		loginMenu.setSpacing(10);
		loginMenu.add(userLabel);
		loginMenu.add(loginField);
		loginMenu.add(loginLabel);
		loginMenu.add(passwordField);
		HorizontalPanel tempH = new HorizontalPanel();
		Button registerButton = new Button("REGISTER");
		tempH.setSpacing(10);
		tempH.add(registerButton);
		tempH.add(loginButton);
		loginMenu.add(tempH);
		loginMenu.setStyleName("login");

		// Command Widget
		VerticalPanel commandPanel = new VerticalPanel();
		final TextArea topText = new TextArea();
		topText.setReadOnly(true);
		final TextBox botText = new TextBox();
		topText.setPixelSize(990,350);
		botText.setPixelSize(990,25);
		deckPanel.add(commandPanel);
		// On enter keypress drop input to top table a exec command
		botText.addKeyDownHandler(new KeyDownHandler() {
			public void onKeyDown(KeyDownEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					String temp = topText.getText();
					String botTemp = botText.getText();
					temp.concat("\n");
					temp.concat(botTemp);
					// handle command here !
					topText.setText(temp);
					botText.setText("");
				}
			}
		});
		commandPanel.add(topText);
		commandPanel.add(botText);


		// Main panel later to be added to root
		VerticalPanel vPanel = new VerticalPanel();
		vPanel.add(buttonBar);
		vPanel.add(deckPanel);

		HorizontalPanel hPanel = new HorizontalPanel();
		hPanel.add(vPanel);
		hPanel.add(loginMenu);
		hPanel.setSpacing(25);
		hPanel.setStyleName("root");
		// Add the widgets to the root panel.
		RootPanel.get().add(hPanel);
		
	}


	public static String getServerError() {
		return SERVER_ERROR;
	}


	public GreetingServiceAsync getGreetingService() {
		return greetingService;
	}


	public ManagerServiceAsync getManagerService() {
		return managerService;
	}
}