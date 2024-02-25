import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class OnlineExamination {
    private static final int EXAM_DURATION_MINUTES = 30;
    private static final int QUESTION_COUNT = 10;
    private static final int TOTAL_MARKS = 100;
    
    private String username;
    private String password;
    private int marksObtained;

    private List<Question> questions;
    private Timer timer;

    public OnlineExamination(String username, String password) {
        this.username = username;
        this.password = password;
        this.marksObtained = 0;

        // Initialize questions
        this.questions = initializeQuestions();

        // Set up timer for exam duration
        this.timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("\nTime's up! Auto-submitting your answers.");
                submitExam();
            }
        }, EXAM_DURATION_MINUTES * 60 * 1000);
    }

    private List<Question> initializeQuestions() {
        List<Question> questions = new ArrayList<>();
        // Add your MCQs here
        // Example:
        questions.add(new Question("What is the capital of France?", 
                                   new String[]{"A. Berlin", "B. Paris", "C. London", "D. Rome"},
                                   1)); // Correct answer is B
        // Add more questions...

        return questions;
    }

    public void startExam() {
        System.out.println("Welcome, " + username + "!");
        System.out.println("You have " + EXAM_DURATION_MINUTES + " minutes to complete the exam.");

        for (Question question : questions) {
            displayQuestion(question);
            int selectedOption = getSelectedOption();
            if (selectedOption == question.getCorrectOption()) {
                marksObtained += TOTAL_MARKS / QUESTION_COUNT;
            }
        }

        submitExam();
    }

    private void displayQuestion(Question question) {
        System.out.println("\n" + question.getQuestionText());
        for (String option : question.getOptions()) {
            System.out.println(option);
        }
    }

    private int getSelectedOption() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Select your answer (A, B, C, or D): ");
        String selectedOption = scanner.nextLine().toUpperCase();
        
        switch (selectedOption) {
            case "A":
                return 1;
            case "B":
                return 2;
            case "C":
                return 3;
            case "D":
                return 4;
            default:
                System.out.println("Invalid option. Please select A, B, C, or D.");
                return getSelectedOption();
        }
    }

    private void submitExam() {
        timer.cancel(); // Stop the timer

        System.out.println("\nExam submitted!");
        System.out.println("Marks Obtained: " + marksObtained + "/" + TOTAL_MARKS);

        // You can add code to store results, update the user profile, etc.

        System.exit(0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        OnlineExamination exam = new OnlineExamination(username, password);
        exam.startExam();
    }
}

class Question {
    private String questionText;
    private String[] options;
    private int correctOption;

    public Question(String questionText, String[] options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectOption() {
        return correctOption;
    }
}
