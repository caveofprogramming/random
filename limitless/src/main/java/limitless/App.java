package limitless;

import java.util.Random;
import java.util.Scanner;

import limitless.model.Question;
import limitless.model.QuestionDao;
import limitless.model.QuestionGroup;
import limitless.model.QuestionType;
import limitless.model.User;

public class App {

	private Random random = new Random();
	private Scanner scanner = new Scanner(System.in);

	private final String type = "two three digit additions";

	

	public static void main(String[] args) throws Exception {
		App app = new App();
		app.run();
	}


	public void run() {

		QuestionDao questionDao = new QuestionDao();
		questionDao.connect();
		
		
		System.out.print("Enter your name > ");
		String name = scanner.nextLine();

		QuestionType questionType = questionDao.getQuestionType(type);
		
		User user = questionDao.getUser(name);
		QuestionGroup group = new QuestionGroup(user);

		for (int i = 0; i < 2; i++) {
			int first = random.nextInt(100);
			int second = random.nextInt(100);

			System.out.println(first + " + " + second);

			System.out.print("> ");

			long start = System.currentTimeMillis();

			int answer = scanner.nextInt();

			long time = System.currentTimeMillis() - start;

			boolean correct = answer == first + second;

			Question question = new Question(correct, (int) time);
			group.setUser(user);
			question.setGroup(group);
			question.setType(questionType);

			if (correct) {
				System.out.println("OK");
			} else {
				System.out.println("Wrong.");
			}

			System.out.println();

		}

		scanner.close();
		questionDao.disconnect();
	}

}
