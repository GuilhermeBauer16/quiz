package br.com.QuizSystem.DAO;

import br.com.QuizSystem.Quiz.Answer;
import br.com.QuizSystem.Quiz.Question;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class AnswerDAO {

    private EntityManager entityManager;

    public AnswerDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void showAll() {
        String jpql = "SELECT a FROM Answer a";
        Query query = entityManager.createQuery(jpql, Answer.class);
        List<Answer> answers = (List<Answer>) query.getResultList();

        for (Answer answer : answers) {

            System.out.println(answer.getAnswer());

        }

    }

    public List<Question> getAllQuestions() {
        String jpql = "SELECT q FROM Question q JOIN FETCH q.answers";
        TypedQuery<Question> query = entityManager.createQuery(jpql, Question.class);
        return query.getResultList();
    }


}
