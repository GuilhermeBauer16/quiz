package br.com.QuizSystem.Quiz;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String question ;

    @OneToMany(mappedBy = "question" , cascade = CascadeType.ALL)
    private List<Answer> answers = new ArrayList<>();

    public String getQuestion() {
        return question;
    }

    public  List<Answer> getAnswers(){
        return answers;
    }
}
