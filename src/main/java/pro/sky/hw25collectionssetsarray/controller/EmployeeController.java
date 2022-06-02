package pro.sky.hw25collectionssetsarray.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.hw25collectionssetsarray.data.Employee;
import pro.sky.hw25collectionssetsarray.data.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    public final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName){
        return employeeService.addEmployee(firstName, lastName);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName){
        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName){
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping("/list")
    public Employee[] employeeList(){
        return employeeService.allEmployeeList();
    }

}
