package br.com.QuizSystem.Quiz;


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

    public String getName() {
        return name;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public void setName(String name) {
        this.name = name;
    }
}
