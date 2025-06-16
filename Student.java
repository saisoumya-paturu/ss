class Student{
    String name="soumya";
    int roll=22;
    String branch="EEE";
    float cgpa=7.55f;
}
class Employee{
    String name="rajesh";
    String role="python Dev";
    int id=9257;
    float salary=70000.9f;
}
class Main{
    public static void main(String[] args){
        Employee e=new Employee();
        System.out.println("Name:"+e.name);
        System.out.println("role:"+e.role);
        System.out.println("salary:"+e.salary);
    }
}
