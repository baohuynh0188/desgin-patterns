package programming.code;

import java.util.ArrayList;
import java.util.List;

public class SortObjectTest {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Bao", 21));
        employeeList.add(new Employee("Huy", 20));
        employeeList.add(new Employee("Nhan", 23));
        employeeList.add(new Employee("Sang", 74));
        employeeList.add(new Employee("Thong", 94));

//        employeeList.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));

        employeeList.sort((o1, o2) -> o2.getAge() - o1.getAge());

        employeeList.forEach(e -> System.out.println(e.getName()));
    }
}
