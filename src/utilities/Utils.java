package utilities;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.File;

import gui.ComponentFIBQuestion;
import gui.ComponentINTQuestion;
import gui.ComponentRBQuestion;
import gui.ComponentTFQuestion;
import gui.PanelQuestionPanel;
import interfaces.QuestionType;
import model.Questions;

public class Utils {

	public static final Integer COUNTDOWN_INTEGER = 30;
	public static Dimension DIMENSION = Toolkit.getDefaultToolkit().getScreenSize();
	public static final Color SKYBLUE = new Color(12, 99, 199);
	public static final Color DARKBLUE = new Color(40, 15, 122);

	public static PanelQuestionPanel getQuestionPanel(Questions questions) {
		PanelQuestionPanel questionPanel = null;

		switch (questions.getQuestionType()) {
		case "RB":
			// System.out.println("in case RB");
			questionPanel = new ComponentRBQuestion(questions);
			break;

		case "FIB":
			// System.out.println("in case FIB");
			questionPanel = new ComponentFIBQuestion(questions);
			break;

		case "TF":
			// System.out.println("in case TF");
			questionPanel = new ComponentTFQuestion(questions);
			break;
		case "INT":
			// System.out.println("in case INT");
			questionPanel = new ComponentINTQuestion(questions);
			break;
		}

		return questionPanel;
	}

	public static final Font getFont(String fontName) {
		try {
			File font_file = new File("./Fonts/" + fontName + ".ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, font_file);
			Font font2 = font.deriveFont(16f);
			return font2;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
