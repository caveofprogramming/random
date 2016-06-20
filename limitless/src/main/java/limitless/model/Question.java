package limitless.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="question")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	long id;

	@ManyToOne
	@JoinColumn(name = "question_type_id")
	QuestionType type;

	@ManyToOne
	@JoinColumn(name = "group_id")
	QuestionGroup group;

	@Column(name = "correct")
	boolean correct;

	@Column(name = "time")
	int time;

	public Question() {

	}

	public Question(boolean correct, int time) {
		this.correct = correct;
		this.time = time;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public QuestionType getType() {
		return type;
	}

	public void setType(QuestionType type) {
		this.type = type;
	}

	public QuestionGroup getGroup() {
		return group;
	}

	public void setGroup(QuestionGroup group) {
		this.group = group;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

}
