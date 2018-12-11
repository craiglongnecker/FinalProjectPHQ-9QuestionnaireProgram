import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.Stack;

// Craig Longnecker.
// https://www.ncbi.nlm.nih.gov/pmc/articles/PMC1495268/
// US National Library of Medicine.
// National Institutes of Health.
// The development of the PHQ-9 was underwritten by an educational
// grant from Pfizer US Pharmaceuticals, New York, NY. PRIME-MD is
// a trademark of Pfizer Copyright held by Pfizer.
/**
 * @author Craig Longnecker Patient Health Questionnaire-9 (PHQ-9)
 *
 */
public class Questionnaire { // Begin class Questionnaire.
	/**
	 * Variables Arrays
	 */
	private final int NUMQ = 11; // Final variable with number of questions.
	private final int EndOfPoints = 9; // Final variable with End of points gathered for Questionnaire
	private Date date; // Date taken.
	private int[] answer; // Array for 11 elements
	private int overallScore; // Overall score for first 9 questions
	private int[] categorySum; // Sum of 9 element array, plus 1 answer for question 10 and 1 answer for
								// question 11.

	// Priority Queue
	/**
	 * Priority Queue
	 */
	public PriorityQueue<String> questions = new PriorityQueue<>();

	// Stack
	/**
	 * Stack
	 */
	public Stack<String> answeredStack = new Stack<String>();

	/**
	 * Constructor for questions and answers to PHQ-9
	 */
	public Questionnaire() { // Begin Constructor.
		this.date = new Date();
		this.answer = new int[NUMQ];

		questions.add("QUESTION 01. LITTLE INTEREST OR PLEASURE IN DOING THINGS?");
		questions.add("QUESTION 02. FEELING DOWN, DEPRESSED OR HOPELESS?");
		questions.add("QUESTION 03. TROUBLE FALLING ASLEEP, OR SLEEPING TOO MUCH?");
		questions.add("QUESTION 04. FEELING TIRED OR HAVING LITTLE ENERGY?");
		questions.add("QUESTION 05. POOR APPETITE OR OVEREATING?");
		questions.add(
				"QUESTION 06. FEELING BAD ABOUT YOURSELF? - OR THAT YOU ARE A FAILURE OR HAVE LET YOURSELF OR YOUR FAMILY DOWN?");
		questions.add("QUESTION 07. TROUBLE CONCENTRATING ON THINGS, SUCH AS READING THE NEWSPAPER OR WATCHING TV?");
		questions.add(
				"QUESTION 08. MOVING OR SPEAKING SO SLOWLY THAT OTHERS MAY HAVE NOTICED?  OR BEING SO RESTLESS THAT YOU HAVE BEEN MOVING MORE THAN USUAL?");
		questions.add("QUESTION 09. THOUGHTS THAT YOU WOULD BE BETTER OFF DEAD OR OF HURTING YOURSELF IN SOME WAY?");
		questions.add(
				"QUESTION 10. IF YOU IDENTIFIED ANY PROBLEMS IN THE FIRST 9 QUESTIONS, HOW DIFFICULT HAVE THESE PROBLEMS MADE IT FOR YOU TO DO YOUR WORK, TAKE CARE OF THINGS AT HOME, OR GET ALONG WITH OTHER PEOPLE?");
		questions.add(
				"QUESTION 11. DURING THE PAST 4 WEEKS, HOW OFTEN DID YOU TAKE ALL OF YOUR MEDICATIONS AS PRESCRIBED?");

		this.answer = new int[NUMQ];
		this.categorySum = new int[3];
	} // Close Constructor.

	/**
	 * GetDate
	 * 
	 * @return
	 */
	public Date getDate() { // Getter and setter for getDate and setDate.
		return date;
	}

	/**
	 * SetDate
	 * 
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * GetAnswer
	 * 
	 * @param index
	 * @return
	 */
	public int getAnswer(int index) { // Getter and setter for getAnswer and setAnswer.
		return this.answer[index];
	}

	/**
	 * SetAnswer
	 * 
	 * @param index
	 * @param value
	 */
	public void setAnswer(int index, int value) {
		this.answer[index] = value;
	}

	/**
	 * GetOverallScore
	 * 
	 * @return
	 */
	public int getOverallScore() { // Getter and setter for getOverallScore and setOverallScore
		return overallScore;
	}

	/**
	 * SetOverallScore
	 * 
	 * @param overallScore
	 */
	public void setOverallScore(int overallScore) {
		this.overallScore = overallScore;
	}

	/**
	 * GetCategorySum
	 * 
	 * @return
	 */
	public int[] getCategorySum() { // Getter and setter for getCategorySum and setCategorySum
		return categorySum;
	}

	/**
	 * SetCategorySum
	 * 
	 * @param categorySum
	 */
	public void setCategorySum(int[] categorySum) {
		this.categorySum = categorySum;
	}

	/**
	 * Stack<String> GetAnsweredStack
	 * 
	 * @return
	 */
	public Stack<String> getAnsweredStack() { // Getter and setter for getAnsweredStack and setAnsweredStack.
		return answeredStack;
	}

	/**
	 * SetAnsweredStack
	 * 
	 * @param answerStack
	 */
	public void setAnsweredStack(Stack<String> answerStack) {
		this.answeredStack = answerStack;
	}

	/**
	 * PriorityQueue<String> GetQuestions
	 * 
	 * @return
	 */
	public PriorityQueue<String> getQuestions() { // Getter and setter for getQuestions and setQuestions.
		return questions;
	}

	/**
	 * SetQuestions
	 * 
	 * @param questions
	 */
	public void setQuestions(PriorityQueue<String> questions) {
		this.questions = questions;
	}

	/**
	 * getNUMQ
	 * 
	 * @return
	 */
	public int getNUMQ() { // Getter for getNUMQ.
		return NUMQ;
	}

	/**
	 * ProcessQuestionnaire Method
	 */
	void processQuestionnaire() { // processQuestionnaire method.
		for (int i = 0; i < EndOfPoints; i++) { // Begin if statement.
			overallScore += this.answer[i];
		} // Close if statment.
	} // Complete processQuestionnaire method.

	/**
	 * SaveQuestionnaire Method
	 * 
	 * @return
	 */
	boolean saveQuestionnaire() { // saveQuestionnaire method.
		// Get date questionnaire is taken.
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		String strDate = dateFormat.format(date);

		String ratingStr = "";
		for (int i = 0; i < answer.length; i++) { // Begin for loop.
			ratingStr += (char) ('0' + answer[i]);
		} // Close for loop.
			// Print results.
		System.out.println(ratingStr + " " + ratingStr.length());
		System.out.println("Score = " + this.overallScore + " " + this.answer[9] + " " + this.answer[10]);
		// Save results to .txt file.
		File dataFile = new File("src/PHQdata.txt");

		try { // Begin try
			BufferedWriter out = new BufferedWriter(new FileWriter(dataFile, dataFile.exists()));
			out.write(strDate + " " + overallScore + " " + ratingStr + "\n");
			out.close();
		} // Close try.
		catch (IOException e) { // Begin catch.
			System.out.println("Exception occurred " + e);
		} // Close catch.
		return true;
	} // Complete saveQuestionnaire method.

	/**
	 * GetResults Method
	 * 
	 * @return
	 */
	String getResults() { // getResults method.
		// Strings for converting integer answers to all 11 questions into results and suggestions of action to take.
		String results = "Total Score: " + overallScore + "\nSeverity of Depression: ";
		String r10[] = { "Great!  Keep doing well at work and home, and getting along with people.",
				"You can do it!.  Keep working at it with your mental health professional.  You can do well at work and at home, and get along with people.  You deserve it.",
				"I know it can be a struggle to do well at work and at home, and get along with people.  Be patient and continue working with your mental health professional.",
				"Please get immediate help with your mental health professional!  You need to be able function at work and at home, and be able to get along with people." };
		String r11[] = {
				"WARNING! You need to take all of your medications every day!  Discuss this with your mental health professional to find a way to help you remember to take your medications every day.",
				"You don't want to forget to take your medications every day.  Maybe get a pill box to help you remember to take your medications every day.",
				"Great!  Keep taking all of your medications every day!  If they don't seem to be working, talk to your mental health professional and maybe try another medication." };
		if (overallScore < 5) { // Begin if statement.
			results += "None. \n";
		} // Close if statement.
		else if (overallScore < 10) { // Begin else if statement.
			results += "Mild Depression. \n";
		} // Close else if statement.
		else if (overallScore < 15) { // Begin else if statement.
			results += "Moderate Depression. \n";
		} // Close else if statement.
		else if (overallScore < 20) { // Begin else if statement.
			results += "Moderately Severe Depression. \n";
		} // Close else if statement.
		else { // Begin else statement.
			results += "Severe Depression. \n";
		} // Close else statement.
		results += r10[answer[9]] + "\n" + r11[answer[10]]; // Get results from questions 10 and 11 and convert integer
															// entered into string.
		return results;
	} // Complete getResults method.

	/**
	 * ReadForm Method
	 * 
	 * @return
	 */
	boolean readForm() { // readForm method.
		return true;
	} // Complete readForm method.
} // Close class Questionnaire.
