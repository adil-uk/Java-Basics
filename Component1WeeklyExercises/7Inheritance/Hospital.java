class Employee {
    private String name;
    private int employee_number;

    public Employee(int employee_number, String name) {
        this.name = name;
        this.employee_number = employee_number;
    }

    public int getEmployee_number() {
        return this.employee_number;
    }

    public String getEmployee_name() {
        return this.name;
    }
}

class Nurse extends Employee {
    public Nurse(int employee_number, String name) {
        super(employee_number, name);
    }

    public void printNurseInfo() {
        System.out.println("Nurse (" + getEmployee_name() + ")" + ", Emp#" + getEmployee_number() + " has patients");
    }
}

class Doctor extends Employee {

    private String speciality;

    public Doctor(int employee_number, String name, String speciality) {
        super(employee_number, name);
        this.speciality = speciality;
    }

    public void printDoctorInfo() {
        System.out.println("Doctor (" + getEmployee_name() + ")" + ", Emp#" + getEmployee_number() + " specialises in " + speciality);
    }
}

class Receptionist extends Employee {
    public Receptionist(int employee_number, String name) {
        super(employee_number, name);
    }

    public void printReceptionistInfo() {
        System.out.println("Receptionist (" + getEmployee_name() + ")" + ", Emp#" + getEmployee_number() + " manages appointments");
    }
}

class Cleaner extends Employee {
    public Cleaner(int employee_number, String name) {
        super(employee_number, name);
    }

    public void printCleanerInfo() {
        System.out.println("Cleaner (" + getEmployee_name() + ")" + ", Emp#" + getEmployee_number() + " cleans the hospital");
    }
}


public class Hospital
{
    public static void main(String[] args) {
        Nurse n1 = new Nurse(5, "Mary");
        n1.printNurseInfo();

        Doctor d1 = new Doctor(7, "James", "Cardiology");
        d1.printDoctorInfo();

        Receptionist r1 = new Receptionist(3, "Sarah");
        r1.printReceptionistInfo();

        Cleaner c1 = new Cleaner(4, "John");
        Cleaner c2 = new Cleaner(231, "Jane");
        c1.printCleanerInfo();
        c2.printCleanerInfo();


    }
}
