package comparator;

import java.util.Comparator;

import com.management.student.model.Student;

public class NameAscComparator implements Comparator<Student> {

    public int compare(Student o1, Student o2) {
        return o1.getName().compareTo(o2.getName());
    }

}
