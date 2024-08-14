import java.util.Date;

public class StudentWithClock implements Learner {
    private Learner learner;

    public StudentWithClock(Learner learner) {
        this.learner = learner;
    }

    @Override
    public void learn() {
        Date dateNow = new Date();
        learner.learn();
        System.out.printf("%1$s %2$tH:%2$tM:%2$tS", "Текущее время:", dateNow);
    }
}