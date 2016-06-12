package comparator;

import java.util.Comparator;

import com.management.student.model.Student;

public class NameDescComparator implements Comparator<Student> {

    public int compare(Student o1, Student o2) {
        return o2.getName().compareTo(o1.getName());
    }

}
