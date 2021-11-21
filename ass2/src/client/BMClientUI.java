package client;

import java.util.ArrayList;


import DB.DBConnector;
import gui.ClientConsole;
import gui.MainFormController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import logic.Order;
import ocsf.client.AbstractClient;

public class BMClientUI extends Application {

	public static ClientConsole order;
//	public BMClientUI(String host, int port) {
//
//		// TODO Auto-generated constructor stub
//	}

	public static void main(String args[]) throws Exception {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {

	
	}
		

	public static void accept(ArrayList<String> al) {
		// TODO Auto-generated method stub
//		DBConnector.saveUserToDB(al, );
	}

	// **************************//

}
