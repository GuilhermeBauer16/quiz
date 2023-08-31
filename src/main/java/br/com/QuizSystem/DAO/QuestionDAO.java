package br.com.QuizSystem.DAO;

import br.com.QuizSystem.Quiz.Question;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class QuestionDAO {
    private EntityManager entityManager;

    public QuestionDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Question> getAllQuestions() {
        String jpql = "SELECT q FROM Question q ";
        TypedQuery<Question> query = entityManager.createQuery(jpql, Question.class);
        return query.getResultList();
    }


}


