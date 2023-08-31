package br.com.QuizSystem.Main;

import br.com.QuizSystem.DAO.QuestionDAO;
import br.com.QuizSystem.DAO.UserAnswersDAO;
import br.com.QuizSystem.Functions.CreateParameter;
import br.com.QuizSystem.Functions.Style;
import br.com.QuizSystem.Quiz.Answer;
import br.com.QuizSystem.Quiz.Question;
import br.com.QuizSystem.Quiz.UserAnswers;
import br.com.QuizSystem.Util.JPAUtil;


import javax.persistence.EntityManager;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        Style style = new Style();
        CreateParameter createParameter = new CreateParameter();
        EntityManager entityManager = new JPAUtil().getEntityManager();
        UserAnswersDAO userAnswersDAO = new UserAnswersDAO(entityManager);
        QuestionDAO questionDAO = new QuestionDAO(entityManager);

        while (true) {
            style.createMenu(50);
            int option = createParameter.createInt("Please insert your Option: ");
            switch (option) {
                case 1:
                    System.out.println(style.title("Quiz", 50));
                    String userName = createParameter.createString("Please type your Name: ");
                    UserAnswers userAnswers = new UserAnswers();
                    userAnswers.setName(userName);
                    int userScore = userAnswers.getUserScore();
                    List<Question> questions = questionDAO.getAllQuestions();

                    for (Question question : questions) {
                        System.out.println("Question: " + question.getQuestion());

                        for (int i = 0; i < question.getAnswers().size(); i++) {
                            
                            Answer answer = question.getAnswers().get(i);
                            System.out.println((i + 1) + " - " + answer.getAnswer());
                        }

                        int userChoice = createParameter.createInt("Choose an option: ");

                        if (userChoice >= 1 && userChoice <= question.getAnswers().size()) {
                            Answer chosenAnswer = question.getAnswers().get(userChoice - 1);

                            if (chosenAnswer.isCorrect()) {
                                userScore += 10;
                            }

                            System.out.println();

                        } else {
                            System.out.println("Invalid choice.");
                        }
                    }

                    userAnswers.setUserScore(userScore);
                    userAnswersDAO.insert(userAnswers);

                    System.out.printf("The score of %s was %d points", userName, userScore);
                    System.out.println();
                    break;

                case 2:

                    userAnswersDAO.showAll();
                    break;

                case 3:

                    System.out.println("Exit to the system , bye :)");
                    return;

            }

        }
    }
}