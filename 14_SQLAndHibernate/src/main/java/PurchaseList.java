import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "purchaselist")
public class PurchaseList {

    @EmbeddedId
    private PurchaseListKey id;

    @ManyToOne (cascade = CascadeType.ALL)
    @Column(name = "student_name", insertable = false, updatable = false)
    private String studentName;

    @ManyToMany (cascade = CascadeType.ALL)
    @Column(name = "course_name", insertable = false, updatable = false)
    private String courseName;

    private int price;

    @Column(name = "subscription_date")
    private Date subscriptionDate;
}
