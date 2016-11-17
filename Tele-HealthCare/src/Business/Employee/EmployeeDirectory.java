package Business.Employee;

import java.util.ArrayList;
import persistence.EmployeeDao;
import persistence.InitializeDataSource;

public class EmployeeDirectory {
    
    private ArrayList<Employee> employeeList;

    public EmployeeDirectory() {
        
        employeeList = new ArrayList<>();
    }

    /**
     * Recupera a lista de employees do banco
     * @return 
     */
    public ArrayList<Employee> getEmployeeList() {               
//        EmployeeDao employeeDao = new EmployeeDao();
//        employeeList = employeeDao.findAll();
        return employeeList;
    }
    
    public Employee createEmployee(String name) throws Exception {        
//        InitializeDataSource.createDatabase();
        Employee employee = new Employee();        
        EmployeeDao employeeDao = new EmployeeDao();
        employee.setName(name);
        employeeDao.insert(employee);
        return employee;
    }
}