package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class MainViewController implements Initializable {
	
	@FXML 
	private MenuItem menuItemBanco;
	
	@FXML 
	private MenuItem menuItemProduto;
	
	@FXML 
	private MenuItem menuItemEmpresa;
	
	@FXML 
	private MenuItem menuItemManual;
	
	@FXML 
	public void onMenuItemBancoAction() {
		System.out.println("onMenuItemBancoAction");
	}
	@FXML 
	public void onMenuItemProdutoAction() {
		System.out.println("onMenuItemProdutoAction");
	}
	@FXML 
	public void onMenuItemEmpresaAction() {
		System.out.println("onMenuItemEmpresaAction");
	}
	
	@FXML 
	public void onMenuItemManualAction() {
		loadView("/gui/Manual.fxml");
	}
	
	

	@Override
	public void initialize(URL uri, ResourceBundle rb) {		
	}
	
	private synchronized void loadView(String absoluteName) {
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newBox = loader.load();
			
			Scene maiScene = Main.getMainScene();
			VBox mainVBox = (VBox)((ScrollPane)maiScene.getRoot()).getContent();
			
			Node mainMenu = mainVBox.getChildren().get(0);
			mainVBox.getChildren().clear();
			mainVBox.getChildren().add(mainMenu);
			mainVBox.getChildren().addAll(newBox.getChildren());
		} catch (IOException e) {
			Alerts.showAlert("IOException", "Error Loading view", e.getMessage(),AlertType.ERROR);
		}
		
	}

	
}
