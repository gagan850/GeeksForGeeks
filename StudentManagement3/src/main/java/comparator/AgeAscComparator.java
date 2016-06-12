package comparator;

import java.util.Comparator;

import com.management.student.model.Student;

public class AgeAscComparator  implements Comparator<Student> {

    public int compare(Student o1, Student o2) {
        return o1.getAge() > o2.getAge() ? 1 : -1;
    }

}
