package br.com.QuizSystem.Main;

import br.com.QuizSystem.DAO.AnswerDAO;
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
        AnswerDAO answerDAO = new AnswerDAO(entityManager);
        while (true) {
            style.createMenu(50);
            int option = createParameter.createInt("Please insert your Option: ");
            switch (option) {
                case 1:
                    List<Question> questions = answerDAO.getAllQuestions();
                    for (Question question : questions){
                        System.out.println("Question:" + question.getQuestion());
                        for (int i = 0 ;i < question.getAnswers().size() ; i++){
                            Answer answer =  question.getAnswers().get(i);
                            System.out.println( i + 1 + " - " + answer.getAnswer());
                        }

                        int userChoice = createParameter.createInt("Choose an option: ");
                        if (userChoice > 1 && userChoice <= question.getAnswers().size()){
                            Answer chosenAnswer = question.getAnswers().get(userChoice - 1);
                            UserAnswers userAnswers = new UserAnswers();
                            String userName = createParameter.createString("Name: ");
                            userAnswers.setName(userName);
                            userAnswers.setAnswer(chosenAnswer);
                            entityManager.getTransaction().begin();
                            entityManager.persist(userAnswers);
                            entityManager.getTransaction().commit();
                        }
                    }
                    break;
                case 2:

                case 3:
                    System.out.println("Exit to the system , bye :)");
                    return;
            }

        }
    }
}