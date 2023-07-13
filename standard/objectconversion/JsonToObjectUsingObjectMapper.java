package objectconversion;
import java.io.*;
import java.util.*;

public class JsonToObjectUsingObjectMapper {

    //Sending an object to wire
    //We first convert to json
/*    Employee emp1 = new Employee("","","");
    ObjectMapper mapper = new ObjectMapper();
    String jsonStr = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);
    System.out.println(jsonStr);*/


    //While receiving anything we will get most responses in JSON
    //So we need to convert back to object
    //Internally converters are written in spring and other frameworks
    //But sometimes we need to explicitly do

/*    System.out.println("Deserializing JSON to Object:");
    Employee convertedEmpObject = mapper.readValue(jsonStr, Employee.class);*/


}


class Employee{
    String name;
    String dept;
    int emp_id;

    //we need to have getter|setter if we need a json to object conversion and vice-versa
    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }
}
