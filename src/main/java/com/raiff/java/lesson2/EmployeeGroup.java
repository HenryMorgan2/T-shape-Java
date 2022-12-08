package com.raiff.java.lesson2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class EmployeeGroup {

    private String groupName;
    private Employee[] listEmployee;

    EmployeeGroup(String groupName) {
        this.groupName = groupName;
        this.listEmployee = new Employee[10];
    }

    public String getgroupName() {
        return groupName;
    }

    public Employee[] getListEmployee() {
        return listEmployee;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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
        } catch (Exception e) {
            System.out.printf("Элемента с стаким индексом %d не существует. Элемент не удален!\n", index);
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
