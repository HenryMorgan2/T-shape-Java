package com.raiff.java.lesson2;

import java.util.ArrayList;

public class EmployeeGroup {

    private String nameGroup;
    private ArrayList<Employee> listEmployees;

    EmployeeGroup(String nameGroup) {
        this.nameGroup = nameGroup;
        this.listEmployees = new ArrayList(10);
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public ArrayList<Employee> getListEmployees() {
        return listEmployees;
    }

    public void setNameGroup(String name) {
        this.nameGroup = name;
    }

    //setlistEmployees не вижу смысла добавлять, т.к. есть методы добавления, удаления и очистки сотрудников
    public void addEmployee(Employee employee) {
        int countEmployees = listEmployees.size();
        if (countEmployees == 10) {
            System.out.printf("В группе максимальное количество сотрудников(%d). Добавление не возможно!\n", 10);
            return;
        }

        if (employee == null){
            System.out.println("Параметр employee равен null. Добавление не возможно!\n");
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
        } catch (IndexOutOfBoundsException e) {
            System.out.printf("Элемента с стаким индексом %d не существует. Элемент не удален!\n", index);
        }
    }

    public void removeAll() {
        listEmployees.clear();
    }

    public void printInfo() {
        for (Employee pair : listEmployees) {
            pair.printInfo();
        }
    }
}
