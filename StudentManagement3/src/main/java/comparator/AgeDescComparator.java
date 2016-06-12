package comparator;

import java.util.Comparator;

import com.management.student.model.Student;

public class AgeDescComparator  implements Comparator<Student> {

    public int compare(Student o1, Student o2) {
        return o2.getAge() >= o1.getAge() ? 1 :-1;
    }

}
