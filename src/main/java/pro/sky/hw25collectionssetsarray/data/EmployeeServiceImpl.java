package pro.sky.hw25collectionssetsarray.data;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final Employee[] employees;
    private int counter = 0;
    private final String[] errors = { "Employee was not found in the database",
            "Wrong index argument in EmployeeService.removeEmployee() method",
            "Null pointer argument in EmployeeService.removeEmployee() method",
            "Employee is already in the database",
            "Employees array is full"
    };


    public EmployeeServiceImpl(){
        employees = new Employee[20];
        employees[0] = new Employee("Ivan", "Ivanov");
        employees[1] = new Employee("Petr", "Petrov");
        employees[2] = new Employee("Sidor", "Sidorov");
        employees[3] = new Employee("Afanasii", "Ukupnikov");
        employees[4] = new Employee("Maria", "Mariaskina");
        employees[5] = new Employee("Elena", "Fedotova");
        employees[6] = new Employee("Afanasii", "Morozov");
        employees[7] = new Employee("Vasily", "Alibabaev");
        employees[8] = new Employee("Semen", "Gorbunkov");
        employees[9] = new Employee("Svetlana", "Fedotova");
        counter = 10;
    }

    public Employee addEmployee(String firstName, String lastName){
        Employee e = new Employee(firstName, lastName);
        if(counter == employees.length)
            throw new ArrayIsFullException(errors[4]);
        for (int i = 0; i < counter; i++) {
            if(employees[i].equals(e))
                throw new EmployeeAlreadyAddedException(errors[3]);
        }
        employees[counter] = e;
        counter++;
        return e;
    }

    public Employee removeEmployee(String firstName, String lastName){
        if(firstName == null || lastName == null)
            throw new NullPointerException(errors[2]);
        Employee e = new Employee(firstName, lastName);
        for (int i = 0; i < counter; i++) {
            if(employees[i].equals(e)) {
                for(int j = i+1; j < counter-1; j++)
                    employees[j] = employees[j+1];
                counter--;
                return e;
            }
        }
        throw new EmployeeNotFoundException(errors[0]);
    }

    public Employee findEmployee(String firstName, String lastName){
        Employee e = new Employee(firstName, lastName);
        for (Employee employee : employees) {
            if (employee.equals(e))
                return employee;
        }
        throw new EmployeeNotFoundException(errors[0]);
    }

    public Employee[] allEmployeeList(){
        Employee[] array = new Employee[counter];
        System.arraycopy(employees, 0, array, 0, counter);
        return array;
    }

}
