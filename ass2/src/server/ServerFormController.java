package server;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ServerFormController {

	@FXML
	private Label IpLabel;

	@FXML
	private Label PortLabel;

	@FXML
	private TextField IpTextField;
	@FXML
	private TextField PortTextField;

	@FXML
	private Button ExitBtn = null;
	@FXML
	private Button ConnectBtn = null;
	@FXML
	private Button DisconnectBtn = null;

	public void Done(ActionEvent event) throws Exception {
		String port;

		port = getport();
		if (port.trim().isEmpty()) {
			System.out.println("You must enter a port number");

		} else {
			((Node) event.getSource()).getScene().getWindow().hide(); // hiding primary window
			BMServerUI.runServer(port); // send port to connect
		}
	}

	private String getport() {
		return PortTextField.getText();

	}

	public void getExitBtn(ActionEvent event) throws Exception {
		System.out.println("Exit Server Window");
		System.exit(0);
	}

//	public void getConnectBtn(ActionEvent event) throws Exception {
//		System.out.println("Connect Server");
//		
//
//	}

	public void getDisconnectBtn(ActionEvent event) throws Exception {
		System.out.println("Disconnect Server");
	}

}
