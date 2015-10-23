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
import controller.ms2_controller;

import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.Vector;

import application.Main;

public class ms1_controller implements Initializable {
	ObservableList<String> list1 = FXCollections.observableArrayList("black", "silver", "gray", "pink", "white", "gold",
			"blue");
	ObservableList<String> list2 = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6");
	ObservableList<String> list3 = FXCollections.observableArrayList("black", "silver", "gray", "pink", "white", "gold",
			"blue");

	Historyflow m1 = new Historyflow();
	@FXML
	private AnchorPane ap;
	@FXML
	public TextArea ms1_input;
	@FXML
	public TextFlow ms1_history;
	@FXML
	private ComboBox<String> ms1Cb1;
	@FXML
	private ComboBox<String> ms1Cb2;
	@FXML
	private ComboBox<String> ms1Cb3;
	String textsize = "-fx-font-size: 10pt;";
	String textcolor = "-fx-text-fill: black;";
	Color c1 = Color.BLACK;

	@FXML
	private void ms1SendFunc() {
		System.out.println("ms1 send button");
		System.out.println(textsize + textcolor);

		m1.setMsgs(ms1_input.getText(), textsize, c1);
		m1.updateTextFlow();
		ms1_input.clear();
	}

	@FXML
	private void ms1ClearFunc() {
		System.out.println("ms1 clear button");
		ms1_history.getChildren().clear();
	}

	@FXML // Theme
	private void ms1Cb1Selected(ActionEvent event) {
		// System.out.println(ms1Cb1.getValue().equals("black"));
		if (ms1Cb1.getValue().equals("black"))
			ap.setStyle("-fx-background-color: black;");
		else if (ms1Cb1.getValue().equals("silver"))
			ap.setStyle("-fx-background-color: silver;");
		else if (ms1Cb1.getValue().equals("gray"))
			ap.setStyle("-fx-background-color: gray;");
		else if (ms1Cb1.getValue().equals("pink"))
			ap.setStyle("-fx-background-color: pink;");
		else if (ms1Cb1.getValue().equals("white"))
			ap.setStyle("-fx-background-color: white;");
		else if (ms1Cb1.getValue().equals("gold"))
			ap.setStyle("-fx-background-color: gold;");
		else if (ms1Cb1.getValue().equals("blue"))
			ap.setStyle("-fx-background-color: blue;");
		else
			ap.setStyle("-fx-background-color: white;");
	}

	@FXML // Text size
	private void ms1Cb2Selected() {
		if (ms1Cb2.getValue().equals("1")) {
			textsize = "-fx-font-size: 10pt;";
			ms1_input.setStyle(textsize + textcolor);
		} else if (ms1Cb2.getValue().equals("2")) {
			textsize = "-fx-font-size: 15pt;";
			ms1_input.setStyle(textsize + textcolor);
		} else if (ms1Cb2.getValue().equals("3")) {
			textsize = "-fx-font-size: 20pt;";
			ms1_input.setStyle(textsize + textcolor);
		} else if (ms1Cb2.getValue().equals("4")) {
			textsize = "-fx-font-size: 25pt;";
			ms1_input.setStyle(textsize + textcolor);
		} else if (ms1Cb2.getValue().equals("5")) {
			textsize = "-fx-font-size: 30pt;";
			ms1_input.setStyle(textsize + textcolor);
		} else if (ms1Cb2.getValue().equals("6")) {
			textsize = "-fx-font-size: 35pt;";
			ms1_input.setStyle(textsize + textcolor);
		} else {
			textsize = "-fx-font-size: 10pt;";
			ms1_input.setStyle(textsize + textcolor);
		}
	}

	@FXML // Text color
	private void ms1Cb3Selected() {
		if (ms1Cb3.getValue().equals("black")) {
			c1 = Color.BLACK;
			textcolor = "-fx-text-fill: black;";
			ms1_input.setStyle(textsize + textcolor);
		} else if (ms1Cb3.getValue().equals("silver")) {
			c1 = Color.SILVER;
			textcolor = "-fx-text-fill: silver;";
			ms1_input.setStyle(textsize + textcolor);
		} else if (ms1Cb3.getValue().equals("gray")) {
			c1 = Color.GRAY;
			textcolor = "-fx-text-fill: gray;";
			ms1_input.setStyle(textsize + textcolor);
		} else if (ms1Cb3.getValue().equals("pink")) {
			c1 = Color.PINK;
			textcolor = "-fx-text-fill: pink;";
			ms1_input.setStyle(textsize + textcolor);
		} else if (ms1Cb3.getValue().equals("white")) {
			c1 = Color.WHITE;
			textcolor = "-fx-text-fill: white;";
			ms1_input.setStyle(textsize + textcolor);
		} else if (ms1Cb3.getValue().equals("gold")) {
			c1 = Color.GOLD;
			textcolor = "-fx-text-fill: gold;";
			ms1_input.setStyle(textsize + textcolor);
		} else if (ms1Cb3.getValue().equals("blue")) {
			c1 = Color.BLUE;
			textcolor = "-fx-text-fill: blue;";
			ms1_input.setStyle(textsize + textcolor);
		} else {
			c1 = Color.BLACK;
			textcolor = "-fx-text-fill: black;";
			ms1_input.setStyle(textsize + textcolor);
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// m2.ms2_history.setText(ms1_input.getText());
		ms1Cb1.setValue("Theme");
		ms1Cb1.setItems(list1);
		ms1Cb2.setValue("Size");
		ms1Cb2.setItems(list2);
		ms1Cb3.setValue("Color");
		ms1Cb3.setItems(list3);
		m1.setTextFlow(ms1_history);

		Callback<ListView<String>, ListCell<String>> factory = new Callback<ListView<String>, ListCell<String>>() {
			@Override
			public ListCell<String> call(ListView<String> list) {
				return new ColorRectCell();
			}
		};
		ms1Cb3.setCellFactory(factory);
		ms1Cb3.setButtonCell(factory.call(null));
	}
}

class ColorRectCell extends ListCell<String> {
	@Override
	public void updateItem(String item, boolean empty) {
		super.updateItem(item, empty);
		Rectangle rect = new Rectangle(80, 18);
		if (item != null) {
			rect.setFill(Color.web(item));
			setGraphic(rect);
		}
	}
}