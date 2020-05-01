package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class PauseMenuController implements Initializable {

	@FXML
	private Button quitButton;
	
	@FXML
	private Button returnButton;
	
	@FXML
	private Button muteButton;
	
	public void quitButtonAction(ActionEvent event){
		ButtonHandler.returnButtonAction(event);
		GameScreenController.getGameScreen().close();
		ButtonHandler.goToDifferentScreen(event, "/view/MainMenu.fxml");
	}
	
	public void returnButtonAction(ActionEvent event) {
		ButtonHandler.returnButtonAction(event);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

}
