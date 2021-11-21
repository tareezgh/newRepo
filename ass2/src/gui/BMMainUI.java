package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class BMMainUI extends Application {
	public static ClientConsole order;

	public static void main(String args[]) throws Exception {
		launch(args);
	} // end main

	public void start(Stage primaryStage) throws Exception {
		order = new ClientConsole("localhost",5555, order);
		MainFormController aFrame = new MainFormController(); // create StudentFrame
		 
		aFrame.start(primaryStage);
	}

}
