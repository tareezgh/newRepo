package client;

import java.util.ArrayList;

import DB.DBConnector;
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

public class EditOrderFormController {

	@FXML
	private Label lblOrderAddress;
	@FXML
	private Label lblTypeOfOrder;

	@FXML
	private TextField txtOrderAddress;
	@FXML
	private TextField txtTypeOfOrder;

	@FXML
	private Button btnSave = null;
	@FXML
	private Button btnBack = null;

	private String getsOrderAddress() {
		return txtOrderAddress.getText();
	}

	private String getsTypeOfOrder() {
		return txtTypeOfOrder.getText();
	}

	@FXML
	public void getSaveBtn(ActionEvent event) throws Exception {
		ArrayList<String> al = new ArrayList<String>();
		String OrderAddress, TypeOfOrder;
		OrderAddress = getsOrderAddress();
		TypeOfOrder = getsTypeOfOrder();
		al.add(OrderAddress);
		al.add(TypeOfOrder);

		
		BMClientUI.accept(al); // accept empty 
		System.out.println("Saved");

	}

	@FXML // return to main window
	public void getBackBtn(ActionEvent event) throws Exception {
		((Node) event.getSource()).getScene().getWindow().hide(); // hide order window
		FXMLLoader loader = new FXMLLoader();
		AnchorPane root = (AnchorPane) loader.load(getClass().getResource("/gui/MainForm.fxml").openStream());
		Stage primaryStage = new Stage();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.setTitle("BiteMe");
		primaryStage.show();
	}
}
