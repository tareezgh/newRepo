package gui;

import client.ClientConsole;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class BMMainUI extends Application {
	public static ClientConsole cc;

	public static void main(String args[]) throws Exception {
		launch(args);
	} // end main

	public void start(Stage primaryStage) throws Exception {

		try {
			FXMLLoader loader = new FXMLLoader();
			AnchorPane root = (AnchorPane) loader.load(getClass().getResource("MainForm.fxml").openStream());
//			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/gui/MainForm.fxml"));

			Scene scene = new Scene(root);
//			scene.getStylesheets().add(getClass().getResource("/gui/MainForm.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.setTitle("BiteMe");
			primaryStage.show();
			// System.out.print(InetAddress.getLocalHost().getHostAddress());
			// IpLable.setAccessibleText(InetAddress.getLocalHost().getHostAddress());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
