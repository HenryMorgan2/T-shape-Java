package com.raiff.java.lesson2;

public class Employee {

    private String name;
    private String email;
    private int age;
    private String position;

    Employee(String name, String email, int age, String position) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.position = position;

    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getPosition() {
        return position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public static void main(String[] args) {
        Employee sotr1 = new Employee("Данил", "taraskovd@gmail.com", 37, "программист");
        Employee sotr2 = new Employee("ВасЁк", "vasek@gmail.com", 20, "программист");
        Employee sotr3 = new Employee("Петя", "petya@gmail.com", 27, "программист");
        sotr1.printInfo();
        System.out.println("**********************************************");

        EmployeeGroup employeeGroup = new EmployeeGroup("Программисты");
        employeeGroup.addEmployee(sotr1);
        employeeGroup.addEmployee(sotr2);
        employeeGroup.addEmployee(sotr3);
        employeeGroup.addEmployee(sotr3);
        employeeGroup.addEmployee(sotr3);
        employeeGroup.addEmployee(sotr3);
        employeeGroup.addEmployee(sotr3);
        employeeGroup.addEmployee(sotr3);
        employeeGroup.addEmployee(sotr3);
        employeeGroup.addEmployee(sotr3);
        employeeGroup.addEmployee(sotr3);

        employeeGroup.printInfo();

        employeeGroup.removeEmployees(2);
        employeeGroup.removeEmployees(15);

        System.out.println("Полная очистка!!!");
        employeeGroup.removeAll();

        employeeGroup.removeEmployees(0);

    }

    public void printInfo(){
        System.out.printf("Сотрудник: %s, email: %s, возраст: %d, должность: %s\n", name, email, age, position);
    }

}
