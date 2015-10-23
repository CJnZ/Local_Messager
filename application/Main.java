package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import controller.ms1_controller;
import controller.ms2_controller;
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Stage primaryStage2 = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/view/Main1.fxml"));
		
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setX(550);
			primaryStage.setY(100);
			primaryStage.setTitle("Messager 1");
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();

			Parent root2 = FXMLLoader.load(getClass().getResource("/view/Main2.fxml"));
			Scene scene2 = new Scene(root2);
			scene2.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage2.setX(1000);
			primaryStage2.setY(100);
			primaryStage2.setTitle("Messager 2");
			primaryStage2.setResizable(false);
			primaryStage2.setScene(scene2);
			primaryStage2.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
	
}
