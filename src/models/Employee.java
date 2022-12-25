package models;

public class Employee {
    public static int count;
    private String fio;
    private int id;
    private int department;
    private double salary;

    public Employee(String fio,int department,int salary){
        addCount();
        this.id = getCount();
        this.fio = fio;
        this.department = department;
        this.salary = salary;

    }

    public String getFio() {
        return fio;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public static int getCount() {
        return count;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void addCount(){
        count++;
    }

    public String toString(){
        return "ID: "+this.id+" Ф.И.О: "+this.fio +" Отдел: "+this.department+" Зарплата: "+this.salary;
    }

    public String toStringInDep(){
        return "ID: "+this.id+" Ф.И.О: "+this.fio+" Зарплата: "+this.salary;
    }
}
