package br.com.QuizSystem.DAO;

import br.com.QuizSystem.Quiz.UserAnswers;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class UserAnswersDAO {

    private EntityManager entityManager;

    public UserAnswersDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void showAll() {
        String jpql = "SELECT u FROM UserAnswers u";
        Query query = entityManager.createQuery(jpql, UserAnswers.class);
        List<UserAnswers> userAnswers = query.getResultList();
        System.out.println("=".repeat(50));
        System.out.printf("| %-4s | %-30s | %-4s |%n", "ID", "Name", "Score");
        System.out.println("=".repeat(50));
        for (UserAnswers userAnswer : userAnswers) {

            System.out.printf("| %-4s | %-30s | %-4s |%n",
                    userAnswer.getId(), userAnswer.getName(), userAnswer.getUserScore());
        }

    }

    public void insert(UserAnswers userAnswers) {
        entityManager.getTransaction().begin();
        entityManager.persist(userAnswers);
        entityManager.getTransaction().commit();

    }
}

