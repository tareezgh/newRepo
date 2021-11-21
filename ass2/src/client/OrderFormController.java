package client;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import logic.Order;


public class OrderFormController{ // implements Initializable {
	private Order order;
	@FXML
	private Label lblRestaurant;
	@FXML
	private Label lblOrderNumber;
	@FXML
	private Label lblOrderTime;
	@FXML
	private Label lblPhoneNumber;
	@FXML
	private Label lblTypeOfOrder;
	@FXML
	private Label lblOrderAddress;
	
	
	@FXML
	private TextField txtRestaurant;
	@FXML
	private TextField txtOrderNumber;
	@FXML
	private TextField txtOrderTime;
	@FXML
	private TextField txtPhoneNumber;
	@FXML
	private TextField txtTypeOfOrder;
//	@FXML
//	private ComboBox cmbTypeOfOrder;
	@FXML
	private TextField txtOrderAddress;
	
//	@FXML
//	private ComboBox cmbTypeOfOrder;

	@FXML
	private Button btnEditOrder = null;
	@FXML
	private Button btnBack = null;
	
	ObservableList<String> list;
	
	

	public void loadOrder(Order o1) {
		this.order = o1;
		this.txtRestaurant.setText(order.getRestaurant());
		this.txtOrderNumber.setText(order.getOrderNumber());
		this.txtOrderTime.setText(order.getOrderTime());
		this.txtPhoneNumber.setText(order.getPhoneNumber());
//		this.txtTypeOfOrder.setText(order.getTypeOfOrder());
//		this.cmbTypeOfOrder.setValue(order.getTypeOfOrder());
		this.txtOrderAddress.setText(order.getOrderAddress());


	}
	
//	private void setOrderTypeComboBox() {
//		ArrayList<String> al = new ArrayList<String>();	
//		al.add("order-in");
//		al.add("take-out");
//		
//		list = FXCollections.observableArrayList(al);
//		cmbTypeOfOrder.setItems(list);
//	}
//
//	@Override
//	public void initialize(URL arg0, ResourceBundle arg1) {
//		setOrderTypeComboBox();
//		
//	}
	
	
	@FXML // Errors // ********
	public void getEditOrder(ActionEvent event) throws Exception {
		((Node) event.getSource()).getScene().getWindow().hide(); // hide main window
		FXMLLoader loader2 = new FXMLLoader();
		AnchorPane root = (AnchorPane) loader2.load(getClass().getResource("/client/EditOrderForm.fxml").openStream());
		Stage primaryStage = new Stage();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.setTitle("BM-Edit Order");
		primaryStage.show();
		
		
		
//		order.setRestaurant(txtRestaurant.getText());
//		order.setOrderNumber(txtOrderNumber.getText());
//		order.setOrderTime(txtOrderTime.getText());	
//		System.out.println(order);
		
//		String selectedObject =  cmbFaculty.getValue().toString();		
//		Faculty abc = new Faculty(  cmbFaculty.getValue().toString(), s.getFc().getFPhone());		
//		s.setFc(abc);
		//student.setFc(Faculty.getFaculty(cmbFaculty.getValue().toString()));		
//	    ClientConsole.accept(order.toString());
		//ChatClient.accept((Object)student);
//		System.out.println("\n"+order);
		//sendToServer(txtName.getText());
	}
	
	@FXML // return to main window
	public void getBackBtn(ActionEvent event) throws Exception {
		((Node) event.getSource()).getScene().getWindow().hide(); // hide order window
		FXMLLoader loader = new FXMLLoader();
		AnchorPane root = (AnchorPane) loader.load(getClass().getResource("/gui/MainForm.fxml").openStream());
//		AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/gui/MainForm.fxml"));
		Stage primaryStage = new Stage();
		Scene scene = new Scene(root);
//		scene.getStylesheets().add(getClass().getResource("/gui/MainForm.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.setTitle("BiteMe");
		primaryStage.show();
	}

}
