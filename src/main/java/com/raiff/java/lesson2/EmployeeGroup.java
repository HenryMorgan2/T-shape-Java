package com.raiff.java.lesson2;

public class EmployeeGroup {

    private String name;
    private Employee[] listEmployee;

    EmployeeGroup(String name) {
        this.name = name;
        this.listEmployee = new Employee[10];
    }

    public String getgroupName() {
        return name;
    }

    public Employee[] getListEmployee() {
        return listEmployee;
    }

    public void setName(String name) {
        this.name = name;
    }

    //setlistEmployee не вижу смысла добавлять, т.к. есть методы добавления, удаления и очистки сотрудников
    public void addEmployee(Employee employee) {
        //Ищем место куда можно добавить сотрудника
        boolean employeeAdded = false;
        for (int i = 0; i < listEmployee.length; i++) {
            if (listEmployee[i] == null) {
                listEmployee[i] = employee;
                employeeAdded = true;
                return;
            }
        }

        if (!employeeAdded) {
            System.out.printf("В группе максимальное количество сотрудников(%d). Добавление не возможно!\n", 10);
        }
    }

    public void removeEmployee(int index) {

        try {
            listEmployee[index] = null;
        }
        catch (IndexOutOfBoundsException e){
            System.out.printf("Элемента с стаким индексом %d не существует. Элемент не удален!\n", index);
        }
        catch (Exception e) {
            System.out.printf("Неизвестное исключение!");
        }
    }

    public void removeAdd() {
        for (int i = 0; i < listEmployee.length; i++) {
            listEmployee[i] = null;
        }
    }

    public void printInfo() {
        for (Employee pair : listEmployee) {
            if (pair != null) {
                pair.printInfo();
            }
        }
    }
}
