import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "subscriptions")
public class Subscription {
    @EmbeddedId
    private SubscriptionKey id;

    @Column(name = "student_id", insertable = false, updatable = false)
    @ManyToOne (cascade = CascadeType.ALL)
    private int studentId;

    @Column(name = "course_id", insertable =false, updatable = false)
    @ManyToOne (cascade = CascadeType.ALL)
    private int courseId;

    @Column (name = "subscription_date")
    private Date subscriptionDate;
}
