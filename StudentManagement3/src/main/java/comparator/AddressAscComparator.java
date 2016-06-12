package comparator;

import java.util.Comparator;

import com.management.student.model.Student;

public class AddressAscComparator  implements Comparator<Student> {

    public int compare(Student o1, Student o2) {
        return o1.getAddress().compareTo(o2.getAddress());
    }

}
