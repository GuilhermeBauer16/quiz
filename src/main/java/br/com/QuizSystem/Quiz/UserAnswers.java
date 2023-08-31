package br.com.QuizSystem.Quiz;


import br.com.QuizSystem.Functions.CreateParameter;

import javax.persistence.*;

@Entity
@Table(name = "user_answer")
public class UserAnswers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private String name;

    @ManyToOne
    @JoinColumn(name = "answer_id")
    private Answer answer ;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @Column(name = "user_score")
    private int userScore;
    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public int getUserScore() {
        return userScore;
    }

    public void setUserScore(int userScore) {
        this.userScore = userScore;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}