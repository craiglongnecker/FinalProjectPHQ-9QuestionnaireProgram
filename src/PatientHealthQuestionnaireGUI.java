import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import java.awt.Color;

//Craig Longnecker.
//https://www.ncbi.nlm.nih.gov/pmc/articles/PMC1495268/
//US National Library of Medicine.
//National Institutes of Health.
//The development of the PHQ-9 was underwritten by an educational
//grant from Pfizer US Pharmaceuticals, New York, NY. PRIME-MD is
//a trademark of Pfizer Copyright held by Pfizer.

public class PatientHealthQuestionnaireGUI extends JPanel { // class PatientHealthQuestionnaireGUI extends JPanel.

	// Variables, new Questionnaire, JTextAreas, ButtonGroup, RadioButtons,
	// JProgressBar and JButton.
	/**
	 * Variables
	 */
	private static final long serialVersionUID = 1L;
	private int aNum; // Tracks questions.
	private final int EndOfPoints = 9, EndOf10 = 10, EndOf11 = 11; // 3 Sections to Questionnaire.
	// New Questionnaire named form.
	private Questionnaire form = new Questionnaire();

	/**
	 * JTextArea
	 */
	JTextArea statementTextArea = new JTextArea();
	JTextArea instructionsTextArea = new JTextArea();
	JTextArea PHQTextArea = new JTextArea();
	JTextArea qTextArea = new JTextArea();

	/**
	 * ButtonGroup
	 */
	ButtonGroup buttons = new ButtonGroup();

	/**
	 * JRadioButtons
	 */
	JRadioButton new0RadioButton = new JRadioButton("Not At All");
	JRadioButton new1RadioButton = new JRadioButton("Several Days");
	JRadioButton new2RadioButton = new JRadioButton("More Than Half The Days");
	JRadioButton new3RadioButton = new JRadioButton("Nearly Every Day");

	/**
	 * JProgressBar
	 */
	JProgressBar progressBar = new JProgressBar();
	/**
	 * JButton
	 */
	JButton nextButton = new JButton("Next ->");

	/**
	 * Create the panel.
	 */
	public PatientHealthQuestionnaireGUI() { // Create the panel.
		setBackground(Color.CYAN);
		setLayout(null);
		qTextArea.setBackground(Color.CYAN);

		qTextArea.setFont(new Font("Arial Black", Font.PLAIN, 14));
		qTextArea.setWrapStyleWord(true);
		qTextArea.setLineWrap(true);
		qTextArea.setBounds(10, 149, 346, 140);
		qTextArea.setText(form.questions.remove());
		add(qTextArea);
		new0RadioButton.setBackground(Color.CYAN);

		new0RadioButton.setBounds(375, 152, 200, 23);
		add(new0RadioButton);
		new1RadioButton.setBackground(Color.CYAN);

		new1RadioButton.setBounds(375, 190, 200, 23);
		add(new1RadioButton);
		new2RadioButton.setBackground(Color.CYAN);

		new2RadioButton.setBounds(375, 228, 200, 23);
		add(new2RadioButton);
		new3RadioButton.setBackground(Color.CYAN);

		new3RadioButton.setBounds(375, 266, 200, 23);
		add(new3RadioButton);

		buttons.add(new0RadioButton);
		buttons.add(new1RadioButton);
		buttons.add(new2RadioButton);
		buttons.add(new3RadioButton);
		statementTextArea.setBackground(Color.CYAN);

		statementTextArea.setWrapStyleWord(true);
		statementTextArea.setLineWrap(true);
		statementTextArea.setFont(new Font("Arial", Font.ITALIC, 14));
		statementTextArea
				.setText("Over the last 2 weeks, how often have you been bothered by any of the following problems?");
		statementTextArea.setBounds(10, 115, 672, 23);
		add(statementTextArea);
		nextButton.setBackground(Color.LIGHT_GRAY);

		nextButton.addActionListener(new ActionListener() { // AddActionListener.
			public void actionPerformed(ActionEvent arg0) { // ActionPerformed.
				boolean answerSelected = true; // If, else if, and else statements to see what radio button is selected.
				if (new0RadioButton.isSelected())
					form.setAnswer(aNum, 0);
				else if (new1RadioButton.isSelected())
					form.setAnswer(aNum, 1);
				else if (new2RadioButton.isSelected())
					form.setAnswer(aNum, 2);
				else if (new3RadioButton.isSelected())
					form.setAnswer(aNum, 3);
				else
					answerSelected = false;

				if (answerSelected && aNum <= EndOf11) { // If statement to verify that an answer was provided for the
															// current question, before moving on to the next question.
					// Clear buttons.
					buttons.clearSelection();

					// Move progressBar.
					progressBar.setValue(aNum++);
					progressBar.setString(aNum + " of " + EndOf11);

					if (aNum == EndOfPoints) { // If statement to give description to radio buttons for question 10.
						new0RadioButton.setText("Not difficult at all");
						new1RadioButton.setText("Somewhat difficult");
						new2RadioButton.setText("Very difficult");
						new3RadioButton.setText("Extremely difficult");
					} // Close if statement to give description to radio buttons for question 10.
					if (aNum == EndOf10) { // If statement to give description to radio buttons for question 11.
						new0RadioButton.setText("Not at all");
						new1RadioButton.setText("Sometimes");
						new2RadioButton.setText("Always");
						new3RadioButton.setVisible(false);
					} // Close if statement to give description to radio buttons for question 11.
					if (aNum == EndOf11) { // If statement to conclude questionnaire, show results and save results if
											// desired.
											// Disable buttons and process questionnaire.
						nextButton.setEnabled(false);
						form.processQuestionnaire();

						// Show the sum of the first 9 questions.
						String msg = form.getResults();
						JOptionPane.showMessageDialog(null, msg, "Final Score", JOptionPane.PLAIN_MESSAGE);

						// Ask whether to save the results of the questionnaire.
						int choice = JOptionPane.showConfirmDialog(null, "Save form data?", "Choose",
								JOptionPane.YES_NO_OPTION);
						if (choice == 0)
							form.saveQuestionnaire();
					} // Close if statement to conclude questionnaire, show results and save results
						// if desired.
					else { // Else statement to clear the buttons, push and peek to the Stack, remove the
							// current question in the Priority Queue, and proceed to the next question in
							// the Priority Queue.
						buttons.clearSelection();
						form.answeredStack.push(form.questions.remove());
						qTextArea.setText(form.answeredStack.peek());
					} // Close else statement to clear the buttons, push and peek to the Stack, remove
						// the current question in the Priority Queue, and proceed to the next question
						// in the Priority Queue.
				} // Close if statement to verify that an answer was provided for the current
					// question, before moving on to the next question.
			} // Complete ActionPerformed.
		}); // Close the AddActionListener.

		// Next button.
		nextButton.setBounds(610, 316, 80, 23);
		add(nextButton);
		PHQTextArea.setBackground(Color.CYAN);

		// Heading at top of the GUI.
		PHQTextArea.setFont(new Font("Arial Black", Font.PLAIN, 14));
		PHQTextArea.setText("PATIENT HEALTH QUESTIONNAIRE-9 (PHQ-9)");
		PHQTextArea.setBounds(10, 11, 375, 25);
		add(PHQTextArea);

		// Instructions for taking PHQ-9.
		instructionsTextArea.setBackground(Color.CYAN);
		instructionsTextArea.setLineWrap(true);
		instructionsTextArea.setFont(new Font("Arial", Font.PLAIN, 14));
		instructionsTextArea.setText(
				"INSTRUCTIONS: This questionnaire helps determine if you are depressed and at what level of depression you may have.  Answer the following 11 questions.  After all 11 questions have been answered, the results will be shown and you may save them.");
		instructionsTextArea.setBounds(10, 47, 672, 57);
		add(instructionsTextArea);

		// Progress bar.
		progressBar.setStringPainted(true);
		progressBar.setMaximum(EndOf11 - 1);
		progressBar.setBounds(10, 316, 346, 23);
		add(progressBar);
	} // Close create the panel.

	/**
	 * CreateAndShowGUI Method
	 */
	private static void createAndShowGUI() { // createAndShowGUI method.
		// Create and set up the window.
		JFrame frame = new JFrame("Patient Health Questionnaire - 9");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create and set up the content pane.
		JComponent newContentPane = new PatientHealthQuestionnaireGUI();
		newContentPane.setOpaque(true); // content panes must be opaque
		frame.setContentPane(newContentPane);

		// Display the window.
		frame.pack();
		frame.setSize(800, 500);
		frame.setVisible(true);
	} // Close createAndShowGUI method.

	public static void main(String[] args) { // Begin main.
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() { // invokeLater.
			public void run() { // Run.
				createAndShowGUI();
			} // Stop run.
		}); // Stop invokeLater
	} // Close main.
} // Close class PatientHealthQuestionnaireGUI extends JPanel.
