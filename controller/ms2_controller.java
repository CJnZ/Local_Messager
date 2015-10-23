package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.util.Callback;

import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.Vector;

import application.Main;

public class ms2_controller implements Initializable {
	ObservableList<String> list4 = FXCollections.observableArrayList("black", "silver", "gray", "pink", "white", "gold",
			"blue");
	ObservableList<String> list5 = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6");
	ObservableList<String> list6 = FXCollections.observableArrayList("black", "silver", "gray", "pink", "white", "gold",
			"blue");

	Historyflow m2 = new Historyflow();
	@FXML
	private AnchorPane ap2;
	@FXML
	public TextArea ms2_input;
	@FXML
	public TextFlow ms2_history;
	@FXML
	private ComboBox<String> ms2Cb1;
	@FXML
	private ComboBox<String> ms2Cb2;
	@FXML
	private ComboBox<String> ms2Cb3;

	String textsize = "-fx-font-size: 10pt;";
	String textcolor = "-fx-text-fill: black;";
	Color c1 = Color.BLACK;

	@FXML
	private void ms2SendFunc() {
		System.out.println("ms2 send button");
		System.out.println(textsize + textcolor);

		m2.setMsgs(ms2_input.getText(), textsize, c1);
		m2.updateTextFlow();
		ms2_input.clear();

	}

	@FXML
	private void ms2ClearFunc() {
		System.out.println("ms2 clear button");
		ms2_history.getChildren().clear();
	}

	@FXML // Theme
	private void ms2Cb1Selected(ActionEvent event) {
		// System.out.println(ms2Cb1.getValue().equals("black"));
		if (ms2Cb1.getValue().equals("black"))
			ap2.setStyle("-fx-background-color: black;");
		else if (ms2Cb1.getValue().equals("silver"))
			ap2.setStyle("-fx-background-color: silver;");
		else if (ms2Cb1.getValue().equals("gray"))
			ap2.setStyle("-fx-background-color: gray;");
		else if (ms2Cb1.getValue().equals("pink"))
			ap2.setStyle("-fx-background-color: pink;");
		else if (ms2Cb1.getValue().equals("white"))
			ap2.setStyle("-fx-background-color: white;");
		else if (ms2Cb1.getValue().equals("gold"))
			ap2.setStyle("-fx-background-color: gold;");
		else if (ms2Cb1.getValue().equals("blue"))
			ap2.setStyle("-fx-background-color: blue;");
		else
			ap2.setStyle("-fx-background-color: white;");
	}

	@FXML // Text size
	private void ms2Cb2Selected() {
		if (ms2Cb2.getValue().equals("1")) {
			textsize = "-fx-font-size: 10pt;";
			ms2_input.setStyle(textsize + textcolor);
		} else if (ms2Cb2.getValue().equals("2")) {
			textsize = "-fx-font-size: 15pt;";
			ms2_input.setStyle(textsize + textcolor);
		} else if (ms2Cb2.getValue().equals("3")) {
			textsize = "-fx-font-size: 20pt;";
			ms2_input.setStyle(textsize + textcolor);
		} else if (ms2Cb2.getValue().equals("4")) {
			textsize = "-fx-font-size: 25pt;";
			ms2_input.setStyle(textsize + textcolor);
		} else if (ms2Cb2.getValue().equals("5")) {
			textsize = "-fx-font-size: 30pt;";
			ms2_input.setStyle(textsize + textcolor);
		} else if (ms2Cb2.getValue().equals("6")) {
			textsize = "-fx-font-size: 35pt;";
			ms2_input.setStyle(textsize + textcolor);
		} else {
			textsize = "-fx-font-size: 10pt;";
			ms2_input.setStyle(textsize + textcolor);
		}
	}

	@FXML // Text color
	private void ms2Cb3Selected() {
		if (ms2Cb3.getValue().equals("black")) {
			c1 = Color.BLACK;
			textcolor = "-fx-text-fill: black;";
			ms2_input.setStyle(textsize + textcolor);
		} else if (ms2Cb3.getValue().equals("silver")) {
			c1 = Color.SILVER;
			textcolor = "-fx-text-fill: silver;";
			ms2_input.setStyle(textsize + textcolor);
		} else if (ms2Cb3.getValue().equals("gray")) {
			c1 = Color.GRAY;
			textcolor = "-fx-text-fill: gray;";
			ms2_input.setStyle(textsize + textcolor);
		} else if (ms2Cb3.getValue().equals("pink")) {
			c1 = Color.PINK;
			textcolor = "-fx-text-fill: pink;";
			ms2_input.setStyle(textsize + textcolor);
		} else if (ms2Cb3.getValue().equals("white")) {
			c1 = Color.WHITE;
			textcolor = "-fx-text-fill: white;";
			ms2_input.setStyle(textsize + textcolor);
		} else if (ms2Cb3.getValue().equals("gold")) {
			c1 = Color.GOLD;
			textcolor = "-fx-text-fill: gold;";
			ms2_input.setStyle(textsize + textcolor);
		} else if (ms2Cb3.getValue().equals("blue")) {
			c1 = Color.BLUE;
			textcolor = "-fx-text-fill: blue;";
			ms2_input.setStyle(textsize + textcolor);
		} else {
			c1 = Color.BLACK;
			textcolor = "-fx-text-fill: black;";
			ms2_input.setStyle(textsize + textcolor);
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// m2.ms2_history.setText(ms2_input.getText());
		ms2Cb1.setValue("Theme");
		ms2Cb1.setItems(list4);
		ms2Cb2.setValue("Size");
		ms2Cb2.setItems(list5);
		ms2Cb3.setValue("Color");
		ms2Cb3.setItems(list6);
		m2.setTextFlow(ms2_history);
		Callback<ListView<String>, ListCell<String>> factory = new Callback<ListView<String>, ListCell<String>>() {
			@Override
			public ListCell<String> call(ListView<String> list) {
				return new ColorRectCell();
			}
		};
		ms2Cb3.setCellFactory(factory);
		ms2Cb3.setButtonCell(factory.call(null));
	}
}
