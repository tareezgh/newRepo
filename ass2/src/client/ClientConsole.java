package client;
// This file contains material supporting section 3.7 of the textbook:

// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

import java.io.*;

import java.util.ArrayList;
import java.util.Optional;

import client.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import logic.Order;
import ocsf.client.AbstractClient;
//import common.*;

/**
 * This class constructs the UI for a BM client. It implements the BM interface
 * in order to activate the display() method. Warning: Some of the code here is
 * cloned in ServerConsole
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;re
 * @version July 2000
 */
public class ClientConsole extends AbstractClient {

//Class variables *************************************************

	public static ArrayList<Order> order;

	/**
	 * The default port to connect on.
	 */
	final public static int DEFAULT_PORT = 5555;

	// Instance variables **********************************************

	/**
	 * The instance of the client that created this ConsoleBM.
	 */
	ClientConsole BMclient;

	// Constructors ****************************************************

	/**
	 * Constructs an instance of the ClientConsole UI.
	 *
	 * @param host The host to connect to.
	 * @param port The port to connect on.
	 */
	public ClientConsole(String host, int port, ClientConsole BMclient) {
		super(host, port);
		this.BMclient = BMclient;
		try {
			openConnection();
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Exception Dialog");
			alert.setHeaderText("error");
			alert.setContentText("Incorrect IP");
			alert.setGraphic(null);
			alert.showAndWait();
			// alert.getOnCloseRequest(event -> {clientUI.getstage().hide()});
			Optional<ButtonType> result = alert.showAndWait();
			result.ifPresent(btnType -> {
//				BMclient.getstage().hide(); //**
			});
			if (result.get() == ButtonType.OK) {
//				BMclient.getstage().hide(); //**
				// ClientConnectController s=new ClientConnectController();
				// s.start(new Stage());
			}

		}
	}

	// Instance methods ************************************************

	/**
	 * This method waits for input from the console. Once it is received, it sends
	 * it to the client's message handler.
	 * @param string 
	 */
	public void accept(String string) {
		ArrayList<String> list = new ArrayList<String>();
		try {
			BufferedReader fromConsole = new BufferedReader(new InputStreamReader(System.in));
			String message = "";
//      System.out.println("Please enter your details: User Name, Id, Depatrment, Tel");
			System.out.println("Client");
//      while (!message.equals("send")) 
//      {
//        message = fromConsole.readLine();
//        if (!message.toLowerCase().equals("send"))
//        	list.add(message);
//      }
//      BMclient.handleMessageFromClientUI(list.toString());

		} catch (Exception ex) {
			System.out.println("Unexpected error while reading from console!");
		}
	}

	/**
	 * This method overrides the method in the ChatIF interface. It displays a
	 * message onto the screen.
	 *
	 * @param message The string to be displayed.
	 */
	public void display(String message) {
		System.out.println(">> " + message);
	}

	// Class methods ***************************************************

	/**
	 * This method is responsible for the creation of the Client UI.
	 *
	 * @param args[0] The host to connect to.
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		String host = "";
		int port = 0; // The port number

		try {
			host = args[0];
		} catch (ArrayIndexOutOfBoundsException e) {
			host = "localhost";
		}
//		ClientConsole cc = new ClientConsole(host, DEFAULT_PORT);
//		cc.accept(); // Wait for console data
	}

	@Override
	protected void handleMessageFromServer(Object msg) {
		if (msg instanceof ArrayList<?>) {
			order = (ArrayList<Order>) msg;
//		rc.InsertDataToTable(order);}

		}
	}
}
