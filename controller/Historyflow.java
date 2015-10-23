package controller;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.Stack;

import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class Historyflow {
	static TextFlow tf1, tf2;
	static Stack<msg> msgs;
	int Controllerid;

	Historyflow() {
		if (msgs == null)
			msgs = new Stack<msg>();
	}

	msg getMsgs() {
		return msgs.peek();
	}

	void setTextFlow(TextFlow tf) {
		if (tf1 == null) {
			tf1 = tf;
			Controllerid = 1;
		} else {
			tf2 = tf;
			Controllerid = 2;
		}
	}

	void updateTextFlow() {
		tf1.getChildren().add(msgs.peek().getMsgs());
		tf2.getChildren().add(msgs.peek().getMsgs());
	}

	void setMsgs(String s, String sty, Color c1) {
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		String time = dateFormat.format(now);
		msg m = new msg(time, Controllerid, s, sty, c1);
		msgs.push(m);
	}
}

class msg {

	String msg_body;
	int usr_id;
	String time;
	String style;
	Color c;

	msg() {
	}

	msg(String _time, int userid, String s, String sty, Color color) {
		msg_body = s;
		usr_id = userid;
		time = _time;
		style = sty;
		c = color;
	}

	Date now = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	String Time = dateFormat.format(now);

	Text getMsgs() {
		Text t = new Text();
		String name;

		if (usr_id == 1) {
			name = "GG: ";
		} else
			name = "MM: ";
		t.setText(time + "\n" + name + msg_body + "\n\n");
		// System.out.println("style:" + style);

		t.setStyle(style);
		t.setFill(c);
		return t;

	}
}
