package server;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import logic.Order;

import java.util.Vector;

public class BMServerUI extends Application {
	final public static int DEFAULT_PORT = 5555;
	public static Vector<Order> order = new Vector<Order>();


	public static void main(String args[]) throws Exception {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		try {
			FXMLLoader loader = new FXMLLoader();
			AnchorPane root = (AnchorPane) loader.load(getClass().getResource("ServerForm.fxml").openStream());
//			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/gui/ServerForm.fxml"));

			Scene scene = new Scene(root);
//			scene.getStylesheets().add(getClass().getResource("/gui/ServerForm.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.setTitle("BM-Server");
			primaryStage.show();
			// System.out.print(InetAddress.getLocalHost().getHostAddress());
			// IpLable.setAccessibleText(InetAddress.getLocalHost().getHostAddress());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void runServer(String p) {
		int port = 0; // Port to listen on

		try {
			port = Integer.parseInt(p); // Set port to 5555

		} catch (Throwable t) {
			System.out.println("ERROR - Could not connect!");
		}

		MainServer ms = new MainServer(port);

		try {
			ms.listen(); // Start listening for connections
		} catch (Exception ex) {
			System.out.println("2ERROR - Could not listen for clients!");
		}
	}

}
