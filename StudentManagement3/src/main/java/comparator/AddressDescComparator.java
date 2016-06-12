package comparator;

import java.util.Comparator;

import com.management.student.model.Student;

public class AddressDescComparator  implements Comparator<Student> {

    public int compare(Student o1, Student o2) {
        return o2.getAddress().compareTo(o1.getAddress());
    }

}
