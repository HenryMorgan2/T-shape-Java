package com.raiff.java.lesson2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class EmployeeGroup {

    private String nameGroup;
    private Employees[] listEmployees;

    EmployeeGroup(String nameGroup) {
        this.nameGroup = nameGroup;
        this.listEmployees = new Employees[10];
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public Employees[] getListEmployees() {
        return listEmployees;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    //setlistEmployees не вижу смысла добавлять, т.к. есть методы добавления, удаления и очистки сотрудников
    public void addEmployee(Employees employee) {
        //Ищем место куда можно добавить сотрудника
        boolean employeeAdded = false;
        for (int i = 0; i < listEmployees.length; i++) {
            if (listEmployees[i] == null) {
                listEmployees[i] = employee;
                employeeAdded = true;
                return;
            }
        }

        if (!employeeAdded) {
            System.out.printf("В группе максимальное количество сотрудников(%d). Добавление не возможно!\n", 10);
        }
    }

    public void removeEmployees(int index) {

        try {
            listEmployees[index] = null;
        } catch (Exception e) {
            System.out.printf("Элемента с стаким индексом %d не существует. Элемент не удален!\n", index);
        }
    }

    public void removeAdd() {
        for (int i = 0; i < listEmployees.length; i++) {
            listEmployees[i] = null;
        }
    }

    public void printInfo() {
        for (Employees pair : listEmployees) {
            if (pair != null) {
                pair.printInfo();
            }
        }
    }
}
