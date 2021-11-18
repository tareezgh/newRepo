package server;
// This file contains material supporting section 3.7 of the textbook:

// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

import java.io.*;

import java.sql.Connection;
import java.util.ArrayList;

import DB.DBConnector;
import logic.Order;
import ocsf.server.*;

/**
 * This class overrides some of the methods in the abstract superclass in order
 * to give more functionality to the server.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;re
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Paul Holden
 * @version July 2000
 */
public class MainServer extends AbstractServer {
	// Class variables *************************************************

	/**
	 * The default port to listen on.
	 */
	final public static int DEFAULT_PORT = 5555;
	ArrayList<Order> array = new ArrayList<Order>();
	public static Order[] order = new Order[6];
	// Constructors ****************************************************

	/**
	 * Constructs an instance of the echo server.
	 *
	 * @param port The port number to connect on.
	 */
	public MainServer(int port) {
		super(port);
	}

	// Instance methods ************************************************

	/**
	 * This method handles any messages received from the client.
	 *
	 * @param msg    The message received from the client.
	 * @param client The connection from which the message originated.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void handleMessageFromClient(Object msg, ConnectionToClient client) {

		int flag = 0;
		System.out.println("Message received: " + msg + " from " + client);
		for (int i = 0; i < 6; i++)

			if (order[i].getRestaurant().equals(msg)) {

				System.out.println("Server Found");

				this.sendToAllClients(order[i].toString());
				flag = 1;

			}
		if (flag != 1) {
			System.out.println("Not Found");
			this.sendToAllClients("Error");

		}

		if (msg instanceof ArrayList<?>) {
			String[] myNewData = new String[6];
			myNewData = ((ArrayList<String>) msg).toArray(new String[6]);
			for (int i = 0; i < 6; i++) {
				if (myNewData[0] == order[i].getRestaurant()) {
					order[i].setRestaurant(myNewData[0]);
					order[i].setOrderNumber(myNewData[1]);
					order[i].setOrderTime(myNewData[2]);
					order[i].setPhoneNumber(myNewData[3]);
					order[i].setTypeOfOrder(myNewData[4]);
					order[i].setOrderAddress(myNewData[5]);
				}
				this.sendToAllClients(order[i].toString());
				
			}
		} 
//		else if (msg instanceof Order) {
//			Connection con = DBConnector.makeAndReturnConnection();
//			Order newOrder = (Order) msg;
//			DBConnector.saveUserToDB(newOrder, con);
//			array = DBConnector.getAllDataFromDB(con);
//		}
	}

//		System.out.println("Message received: " + msg + " from " + client);
//		this.sendToAllClients(msg);

//		ArrayList<Order> arr = null;
//		if (msg instanceof String) {
//			String str = (String) msg;
//			if (str.equals("giveTableData")) {
//				Connection con = DBConnector.makeAndReturnConnection();
//
//				array = DBConnector.getAllDataFromDB(con); //
//			}
//		} else if (msg instanceof Order) {
//			Connection con = DBConnector.makeAndReturnConnection();
//			Order chosen = (Order) msg;
//			DBConnector.saveUserToDB(chosen, con);
//			array = DBConnector.getAllDataFromDB(con);
//		}
//
//		try {
//			// this.sendToAllClients(arr);
//			client.sendToClient(array); // send to specific client
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * This method overrides the one in the superclass. Called when the server
	 * starts listening for connections.
	 */
	protected void serverStarted() {
		System.out.println("Server listening for connections on port " + getPort());

		Connection con = DBConnector.makeAndReturnConnection();
		array = DBConnector.getAllDataFromDB(con);
//		
//		
	}

	/**
	 * This method overrides the one in the superclass. Called when the server stops
	 * listening for connections.
	 */
	protected void serverStopped() {
//		System.out.println("Server has stopped listening for connections.");
		try {
			close();
			System.out.println("Server has stopped listening for connections.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Class methods ***************************************************

	/**
	 * This method is responsible for the creation of the server instance (there is
	 * no UI in this phase).
	 *
	 * @param args[0] The port number to listen on. Defaults to 5555 if no argument
	 *                is entered.
	 */
	public static void main(String[] args) {
		int port = 0; // Port to listen on

		try {
			port = Integer.parseInt(args[0]); // Get port from command line
		} catch (Throwable t) {
			port = DEFAULT_PORT; // Set port to 5555
		}

		MainServer ms = new MainServer(port);

		try {
			ms.listen(); // Start listening for connections
		} catch (Exception ex) {
			System.out.println("ERROR - Could not listen for clients!");
		}
	}
}
//End of EchoServer class
