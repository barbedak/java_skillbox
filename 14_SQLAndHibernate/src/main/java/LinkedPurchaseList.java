import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "linkedpurchaselist")
public class LinkedPurchaseList {

    @EmbeddedId
    private LinkedPurchaseListKey id;

    public void setStudentId(Integer studentId) {
        id.setStudentId(studentId);
    }

    public void setCourseId(Integer courseId) {
        id.setCourseId(courseId);
    }

    public LinkedPurchaseList() {
        this.id = new LinkedPurchaseListKey();
    }
}
