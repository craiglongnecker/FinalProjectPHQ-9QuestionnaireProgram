# FinalProjectPHQ-9QuestionnaireProgram
My final project is based on the PHQ-9 questionnaire.  It consists of 11 questions.  These are the 11 questions:

QUESTION 1. LITTLE INTEREST OR PLEASURE IN DOING THINGS?
QUESTION 2. FEELING DOWN, DEPRESSED OR HOPELESS?
QUESTION 3. TROUBLE FALLING ASLEEP, OR SLEEPING TOO MUCH?
QUESTION 4. FEELING TIRED OR HAVING LITTLE ENERGY?"
QUESTION 5. POOR APPETITE OR OVEREATING?
QUESTION 6. FEELING BAD ABOUT YOURSELF? - OR THAT YOU ARE A FAILURE OR HAVE LET YOURSELF OR YOUR FAMILY DOWN?
QUESTION 7. TROUBLE CONCENTRATING ON THINGS, SUCH AS READING THE NEWSPAPER OR WATCHING TV?
QUESTION 8. MOVING OR SPEAKING SO SLOWLY THAT OTHERS MAY HAVE NOTICED?  OR BEING SO RESTLESS THAT YOU HAVE BEEN MOVING MORE THAN USUAL?
QUESTION 9. THOUGHTS THAT YOU WOULD BE BETTER OFF DEAD OR OF HURTING YOURSELF IN SOME WAY?
QUESTION 10. IF YOU IDENTIFIED ANY PROBLEMS IN THE FIRST 9 QUESTIONS, HOW DIFFICULT HAVE THESE PROBLEMS MADE IT FOR YOU TO DO YOUR WORK, TAKE CARE OF THINGS AT HOME, OR GET ALONG WITH OTHER PEOPLE?
QUESTION 11. DURING THE PAST 4 WEEKS, HOW OFTEN DID YOU TAKE ALL OF YOUR MEDICATIONS AS PRESCRIBED?

The first nine questions are asked and the person answers each of these questions with a points system of 0, 1, 2, or 3.  These are “Not at all” for 0 points, “Several days” for 1 point, “More than half the days” for 2 points, and “Nearly every day” for 3 points.

The sum of points for these nine questions are then totaled and the total points are reflective of five possible stages of depression. 0 to 4 total points are “None”, 5 to 9 total points are “Mild Depression”, 10 to 14 total points are “Moderate Depression”, 15 to 19 total points are “Moderately Severe Depression”, and anything 20 total points or more are “Severe Depression”.

Question 10 asks that if the person has identified any problems in the first nine questions, how difficult have these problems made it for the person to do their work, take care of things at home, or whether they are able to get along with other people.  The possible answers are “Not difficult at all”, “Somewhat difficult”, “Very difficult”, or “Extremely difficult”.  I assigned an integer of 0, 1, 2, and 3 respectively to the answer to that question.

Question 11 asks if the during the past four weeks, how often the person has taken all of their medications as prescribed.  The possible answers to this question are “Not at all”, “Sometimes”, or “Always”.  Again, I assigned an integer of 0, 1, and 2 respectively to the answer to that question.

Before I get into the specifics of the program itself, here is a brief description of the PHQ-9 questionnaire from the US National Library of Medicine, National Institutes of Health website:

OBJECTIVE

While considerable attention has focused on improving the detection of depression, assessment of severity is also important in guiding treatment decisions. Therefore, we examined the validity of a brief, new measure of depression severity.

MEASUREMENTS

The Patient Health Questionnaire (PHQ) is a self-administered version of the PRIME-MD diagnostic instrument for common mental disorders. The PHQ-9 is the depression module, which scores each of the 9 DSM-IV criteria as “0” (not at all) to “3” (nearly every day). The PHQ-9 was completed by 6,000 patients in 8 primary care clinics and 7 obstetrics-gynecology clinics. Construct validity was assessed using the 20-item Short-Form General Health Survey, self-reported sick days and clinic visits, and symptom-related difficulty. Criterion validity was assessed against an independent structured mental health professional (MHP) interview in a sample of 580 patients.
RESULTS
As PHQ-9 depression severity increased, there was a substantial decrease in functional status on all 6 SF-20 subscales. Also, symptom-related difficulty, sick days, and health care utilization increased. Using the MHP reinterview as the criterion standard, a PHQ-9 score ≥10 had a sensitivity of 88% and a specificity of 88% for major depression. PHQ-9 scores of 5, 10, 15, and 20 represented mild, moderate, moderately severe, and severe depression, respectively. Results were similar in the primary care and obstetrics-gynecology samples.

CONCLUSION

In addition to making criteria-based diagnoses of depressive disorders, the PHQ-9 is also a reliable and valid measure of depression severity. These characteristics plus its brevity make the PHQ-9 a useful clinical and research tool.

Going to the program itself, I used a Priority Queue for the questions and a Stack for the answers as my two data structures.  The Questionnaire file is full of code that makes the GUI go.  The Questionnaire Constructor is designed to ask the questions and store the answers.  The questions get removed in the Priority Queue as the are asked in the GUI application.  There are getters and setters for the date, answer, overall score, category sum, the get answered Stack, the questions Priority Queue, and the NUMQ (number of questions, a final integer).  There are methods in the Questionnaire file including saving the questionnaire, getting the results, and reading the form.

The PatientHealthQuestionnaireGUI file contains the GUI for the application.  It has the title of the application, “PATIENT HEALTH QUESTIONNAIRE-9 (PHQ-9), instructions on how to take this questionnaire, the questions, radio buttons for the possible answers, a next button to continue to the next question (provided the person provides an answer for the current question), and a bar graph showing the person the progression through the questionnaire.  After the person has answered all 11 questions a window pops up showing the total number of points for the answers to the first nine questions, the level of depression that person may be at, a suggestion based on the answer to question 10 and a suggestion based on the answer to question 11.  The person then clicks ok button in the window and another window opens asking the person if they would like the results saved.  If they do, the date the questionnaire was taken, the total points, and the points of each question answered are saved to a text file named PGQdata.txt.  If the person chooses not to save the results, the window closes.

Acknowledgments:
https://www.ncbi.nlm.nih.gov/pmc/articles/PMC1495268/
US National Library of Medicine.
National Institutes of Health.
The development of the PHQ-9 was underwritten by an educational grant from Pfizer US Pharmaceuticals, New York, NY. PRIME-MD is
a trademark of Pfizer Copyright held by Pfizer.

