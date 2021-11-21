package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class BMMainUI extends Application {
	public static ClientController CC;  //  ClientConsole

	public static void main(String args[]) throws Exception {
		launch(args);
	} // end main

	public void start(Stage primaryStage) throws Exception {
		CC = new ClientController("localhost",5555);
		
		MainFormController aFrame = new MainFormController(); // create Main Frame
		 
		aFrame.start(primaryStage);
	}

}
