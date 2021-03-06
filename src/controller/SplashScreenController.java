package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SplashScreenController implements Initializable {

	@FXML
	private AnchorPane splashScreen;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		new SplashScreen().start();
	}

	public static String path = System.getProperty("user.dir") + "/resources/sound/Fruit-Ninja-Theme-Song.mp3";

	public static Media media = new Media(new File(path).toURI().toString());
	
	public static MediaPlayer mediaPlayer = new MediaPlayer(media);
	
	class SplashScreen extends Thread {
		@Override
		public void run() {
			try {
				Thread.sleep(7000);

				Platform.runLater(new Runnable() {

					@Override
					public void run() {
						try {
							Parent root = FXMLLoader.load(getClass().getResource("/view/UserManager.fxml"));
							
							Scene scene = new Scene(root);
							Stage stage = new Stage();

							stage.initStyle(StageStyle.UNDECORATED);
							
							stage.setScene(scene);
							stage.show();
							
							splashScreen.getScene().getWindow().hide();
						} catch (IOException e) {
							ButtonHandler.alert();
							e.printStackTrace();
						}


					}
				});
			} catch (InterruptedException e) {
				ButtonHandler.alert();
				e.printStackTrace();
			}



		}

	}

}

