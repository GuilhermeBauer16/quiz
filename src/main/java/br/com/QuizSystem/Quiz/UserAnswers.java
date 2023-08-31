package br.com.QuizSystem.Quiz;


import br.com.QuizSystem.Functions.CreateParameter;

import javax.persistence.*;

@Entity
@Table(name = "user_answer")
public class UserAnswers {
    // Columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private String name;
    @Column(name = "user_score")
    private int userScore;

    // Getters and setters
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


}