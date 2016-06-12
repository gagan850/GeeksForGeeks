package comparator;

import java.util.Comparator;

import com.management.student.model.Student;

public class RollDescComparator  implements Comparator<Student> {

    public int compare(Student o1, Student o2) {
        return o2.getRollNumber().compareTo(o1.getRollNumber());
    }

}
