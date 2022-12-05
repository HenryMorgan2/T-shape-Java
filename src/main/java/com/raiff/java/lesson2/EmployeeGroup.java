package com.raiff.java.lesson2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class EmployeeGroup {

    private String nameGroup;
    private ArrayList<Employees> listEmployees;

    EmployeeGroup(String nameGroup) {
        this.nameGroup = nameGroup;
        this.listEmployees = new ArrayList(10);
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public ArrayList<Employees> getListEmployees() {
        return listEmployees;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    //setlistEmployees не вижу смысла добавлять, т.к. есть методы добавления, удаления и очистки сотрудников
    public void addEmployee(Employees employee) {
        int countEmployees = listEmployees.size();
        if (countEmployees == 10) {
            System.out.printf("В группе максимальное количество сотрудников(%d). Добавление не возможно!\n", 10);
            return;
        }

        listEmployees.add(employee);
    }

    public void removeEmployees(int index) {
        int countEmployees = listEmployees.size();
        if (countEmployees == 0) {
            System.out.println("В группе отсутствуют сотрудники. Удаление не возможно!");
            return;
        }

        try {
            listEmployees.remove(index);
        } catch (Exception e) {
            System.out.printf("Элемента с стаким индексом %d не существует. Элемент не удален!\n", index);
        }
    }

    public void removeAdd() {
        listEmployees.clear();
    }

    public void printInfo() {
        for (Employees pair : listEmployees) {
            pair.printInfo();
        }
    }
}
