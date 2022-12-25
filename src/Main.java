import models.Employee;

public class Main {
    public static final int MAX_SALARY = 300000;
    public static final int MIN_SALARY = 20000;
    public static Employee[] employees = new Employee[10];

    public static void main(String[] args) {
        fillEmployees();
        printEmployees();
        System.out.println("Сумма затрат на зарплаты: "+salarySum());
        System.out.println("Сотрудник с минимальной зарплатой:\n"+findMinSalary().toString());
        System.out.println("Сотрудник с максимальной зарплатой:\n"+findMaxSalary().toString());
        System.out.println("Средняя зарплата: "+medianSalary());
        salaryIndexing(10);
        printEmployees();
        System.out.println("Сотрудник с минимальной зарплатой в отделе:\n"+findMinSalaryInDep(2).toString());
        System.out.println("Сотрудник с максимальной зарплатой в отделе:\n"+findMaxSalaryInDep(2).toString());
        System.out.println("Сумма затрат на зарплаты в отделе: "+salarySumInDep(2));
        System.out.println("Средняя зарплата в отделе: "+medianSalaryInDep(2));
        salaryIndexingInDep(10,2);
        printEmployees();
        printEmployeesInDep(2);
        findEmployeesWithSalaryLess(100000);
        findEmployeesWithSalaryBigger(100000);
    }

    public static void printEmployees(){
        for(int i=0; i<
                employees.length;i++){
             System.out.println(employees[i].toString());
        }
    }

    public static void printEmployeesInDep(int num){
        for(int i=0; i<employees.length;i++){
            if(employees[i].getDepartment()==num)
                System.out.println(employees[i].toStringInDep());
        }
    }

    public static void fillEmployees() {
        for(int i=0;i<employees.length;i++){
            String rFio = "fio"+i;
            int dep = (int)(Math.random()*((5-1)+1))+1;
            int salary = (int)(Math.random()*((MAX_SALARY-MIN_SALARY)+1))+MIN_SALARY;
            employees[i] = new Employee(rFio,dep,salary);
        }
    }

    public static int salarySum(){
        int sum=0;
        for(int i=0;i< employees.length;i++){
            sum+=employees[i].getSalary();
        }
        return sum;
    }

    public static int salarySumInDep(int num){
        int sum=0;
        for(int i=0;i< employees.length;i++){
            if(employees[i].getDepartment()==num)
                sum+=employees[i].getSalary();
        }
        return sum;
    }

    public static Employee findMinSalary(){
        double salary = employees[0].getSalary();
        Employee minEmployee = employees[0];
        for(int i=0;i< employees.length;i++){
            if(employees[i].getSalary()<salary){
                minEmployee = employees[i];
            }
        }

        return minEmployee;
    }

    public static Employee findMinSalaryInDep(int num){
        double salary = MAX_SALARY;
        Employee minEmployee=null;
        for(int i=0;i< employees.length;i++){
            if((employees[i].getSalary()<salary) && (employees[i].getDepartment()==num)){
                minEmployee = employees[i];
            }
        }

        return minEmployee;
    }

    public static Employee findMaxSalary(){
        double salary = employees[0].getSalary();
        Employee maxEmployee = employees[0];
        for(int i=0;i< employees.length;i++){
            if(employees[i].getSalary()>salary){
                maxEmployee = employees[i];
            }
        }

        return maxEmployee;
    }

    public static Employee findMaxSalaryInDep(int num){
        double salary = 0;
        Employee maxEmployee = null;
        for(int i=0;i< employees.length;i++){
            if((employees[i].getSalary()>salary) && (employees[i].getDepartment()==num)){
                maxEmployee = employees[i];
            }
        }

        return maxEmployee;
    }

    public static double medianSalary(){
        double medianSalary = salarySum()/ employees.length;
        return medianSalary;
    }

    public static double medianSalaryInDep(int num){
        double medianSalary = salarySumInDep(num)/findEmployeesInDep(num);
        return medianSalary;
    }

    public static int findEmployeesInDep(int num){
        int k=0;
        for(int i=0;i< employees.length;i++){
            if((employees[i].getDepartment()==num)){
                k++;
            }
        }
        return k;
    }

    public static void findEmployeesWithSalaryLess(int num){
        System.out.println("\nСотрудники с зарплатой меньше "+ num);
        for(int i=0;i< employees.length;i++){
            if((employees[i].getSalary()<num)){
                System.out.println(employees[i].getId()+" "+employees[i].getFio()+" "+employees[i].getSalary());
            }
        }
    }

    public static void findEmployeesWithSalaryBigger(int num){
        System.out.println("\nСотрудники с зарплатой больше "+ num);
        for(int i=0;i< employees.length;i++){
            if((employees[i].getSalary()>=num)){
                System.out.println(employees[i].getId()+" "+employees[i].getFio()+" "+employees[i].getSalary());
            }
        }
    }

    public static void salaryIndexing(double perc){
        for (int i=0;i< employees.length;i++){
            employees[i].setSalary(Math.round(employees[i].getSalary()*(1+(perc/100))));
        }
    }

    public static void salaryIndexingInDep(double perc, int num){
        for (int i=0;i< employees.length;i++){
            if(employees[i].getDepartment()==num)
                employees[i].setSalary(Math.round(employees[i].getSalary()*(1+(perc/100))));
        }
    }

}