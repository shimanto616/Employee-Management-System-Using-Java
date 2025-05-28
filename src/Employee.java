

class Employee{
    String name;
    String salary;
    String address;
    String phoneNumber;
    String email;
    String bloodGroup;
    String graduationSubject;
    String designation;
    String department;
    int employeeID;
    public Employee(String name, String salary, String address, String phoneNumber, String email, String bloodGroup,
            String graduationSubject, String designation, String department, int employeeID) {
        this.name = name;
        this.salary = salary;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.bloodGroup = bloodGroup;
        this.graduationSubject = graduationSubject;
        this.designation = designation;
        this.department = department;
        this.employeeID = employeeID;
    }
    @Override
    public String toString() {
        return "Employee [name=" + name + ", salary=" + salary + ", address=" + address + ", phoneNumber=" + phoneNumber
                + ", email=" + email + ", bloodGroup=" + bloodGroup + ", graduationSubject=" + graduationSubject
                + ", designation=" + designation + ", department=" + department + ", employeeID=" + employeeID + "]";
    }

    
}