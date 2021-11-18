package client;

import java.util.ArrayList;

import DB.DBConnector;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import logic.Order;
import ocsf.client.AbstractClient;

public class BMClientUI extends Application {

//	public BMClientUI(String host, int port) {
//
//		// TODO Auto-generated constructor stub
//	}

	public static void main(String args[]) throws Exception {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {

		try {
			FXMLLoader loader = new FXMLLoader();
			AnchorPane root = (AnchorPane) loader.load(getClass().getResource("ClientForm.fxml").openStream());
//			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/gui/ClientForm.fxml"));

			Scene scene = new Scene(root);
//			scene.getStylesheets().add(getClass().getResource("/gui/ClientForm.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.setTitle("BM-Client");
			primaryStage.show();
			// System.out.print(InetAddress.getLocalHost().getHostAddress());
			// IpLable.setAccessibleText(InetAddress.getLocalHost().getHostAddress());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void accept(ArrayList<String> al) {
		// TODO Auto-generated method stub
//		DBConnector.saveUserToDB(al, );
	}

	// **************************//

}
