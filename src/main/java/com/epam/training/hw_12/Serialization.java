package com.epam.training.hw_12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Serialization {

    private static ArrayList<Employee> employees;
    private static final String FILE_PATH = "src/main/java/com/epam/training/hw_12/data.txt";
    private static final String MENU_TEXT = "Press >1 to enter new employee.\r\n" +
            "Press >2 to save just added employees.\r\n" +
            "Press >3 to display all employees.\r\n" +
            "Press >4 to delete employee by id.\r\n" +
            "Type <Exit> to exit from program.";

    public static void main(String[] args) {
        Serialization serialization = new Serialization();
        serialization.startProgram();
    }

    private void startProgram() {
        loadFile();
        runMenu();
    }

    private void runMenu() {
        String input = "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (!input.equals("Exit")) {
                System.out.println(MENU_TEXT);

                input = br.readLine();
                if (input.equals("1")) {
                    Employee employee = new Employee();

                    System.out.println("Enter id");
                    input = br.readLine();
                    employee.setId(input);

                    System.out.println("Enter a name");
                    input = br.readLine();
                    employee.setFirstName(input);

                    System.out.println("Enter a last name");
                    input = br.readLine();
                    employee.setLastName(input);

                    employees.add(employee);

                } else if (input.equals("2")) {
                    saveFile();
                } else if (input.equals("3")) {

                    for (Employee employee : employees) {
                        System.out.println(employee.getId() + " " +
                                employee.getFirstName() + " " +
                                employee.getLastName());
                    }
                } else if (input.equals("4")) {
                    System.out.println("Enter employees id to delete from data");
                    input = br.readLine();
                    for (Employee employee : employees) {
                        if (employee.getId().equals(input)) {
                            employees.remove(employee);
                            break;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveFile() {
        File f = new File(FILE_PATH);
        f.delete();
        try {
            f.createNewFile();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))) {
            oos.writeObject(employees);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private void loadFile() {
        File f = new File(FILE_PATH);
        if (f.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
                employees = (ArrayList<Employee>) ois.readObject();
            } catch (IOException e) {
                f.delete();
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                f.delete();
            }
        } else {
            employees = new ArrayList<>();
        }
    }
}
