package gui;

import java.io.IOException;

import client.OrderFormController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import logic.Order;

public class MainFormController {

	private OrderFormController OFC;

	@FXML
	private Button btnShowOrder = null;

//	@FXML
//	private Button btnEditOrder = null;
	@FXML
	private Button btnExit = null;

	@FXML
	private Label lblOrderNumber;

	@FXML
	private TextField txtOrderNumber;

	public void start(Stage primaryStage) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		AnchorPane root = (AnchorPane) loader.load(getClass().getResource("MainForm.fxml").openStream());

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.setTitle("BiteMe");
		primaryStage.show();

	}

	private String getsOrderNumber() {
		return txtOrderNumber.getText();
	}

	public void getShowOrderBtn(ActionEvent event) throws Exception {
		String OrderNumber;
		FXMLLoader loader = new FXMLLoader();

		OrderNumber = getsOrderNumber();
		if (OrderNumber.trim().isEmpty()) {

			System.out.println("You must enter order number");
		} else {
			BMMainUI.CC.accept(OrderNumber); // ***

//			if (BMClient.o1.getOrderNumber().equals("Error")) {
//				System.out.println("Order number Not Found");
//
//			} else {
//				System.out.println("Order number Found");

			((Node) event.getSource()).getScene().getWindow().hide(); // hide main window and show order details
			FXMLLoader loader1 = new FXMLLoader();
			AnchorPane root = (AnchorPane) loader1.load(getClass().getResource("/client/OrderForm.fxml").openStream());
			Stage primaryStage = new Stage();

//			OrderFormController orderFormController = loader.getController();
//			orderFormController.loadOrder(BMClient.o1); // load data to order form
/// ERROR
			
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.setTitle("BM-Order");
			primaryStage.show();

//			}

		}
	}

//	public void getEditOrderBtn(ActionEvent event) throws Exception {
//		((Node) event.getSource()).getScene().getWindow().hide(); // hide main window
//		FXMLLoader loader2 = new FXMLLoader();
//		AnchorPane root = (AnchorPane) loader2.load(getClass().getResource("/client/EditOrderForm.fxml").openStream());
//		Stage primaryStage = new Stage();
//		Scene scene = new Scene(root);
//		primaryStage.setScene(scene);
//		primaryStage.setResizable(false);
//		primaryStage.setTitle("BM-Edit Order");
//		primaryStage.show();
//
//	}

	public void getExitBtn(ActionEvent event) throws Exception {
		System.out.println("Come back soon:)");
		System.exit(0);
	}

	public void loadOrder(Order o1) {
		this.OFC.loadOrder(o1);
	}

	public void display(String message) {
		System.out.println("message");
	}

}
