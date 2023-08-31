package br.com.QuizSystem.Quiz;

import javax.persistence.*;

@Entity
@Table(name="answers")

public class Answer {

    // Columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private String answer;
    @Column(name = "is_correct")
    private boolean isCorrect;
    @ManyToOne
    @JoinColumn(name="question_id")
    private  Question question ;

    // Getters and setters
    public String getAnswer() {
        return answer;
    }

    public boolean isCorrect(){
        return isCorrect;
    }
}
