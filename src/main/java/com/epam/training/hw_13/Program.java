package com.epam.training.hw_13;

import java.io.*;
import java.sql.*;

public class Program {

    DataBaseOperation dataBaseOperation = new DataBaseOperation();
    private static final String MENU_TEXT =
            "Press >1 to enter new employee.\r\n" +
                    "Press >2 to display all employees.\r\n" +
                    "Press >3 to delete employee by id.\r\n" +
                    "Type <Exit> to exit from program.";

    private void runMenu() {
        String input = "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (!input.equals("Exit")) {
                System.out.println(MENU_TEXT);
                input = br.readLine();
                switch (input) {
                    case "1": {
                        System.out.println("Enter id");
                        int id = Integer.parseInt(br.readLine());
                        System.out.println("Enter a name");
                        String firstName = br.readLine();
                        System.out.println("Enter a last name");
                        String lastName = br.readLine();
                        dataBaseOperation.insertNewEmployee(id, firstName, lastName);
                        break;
                    }
                    case "2": {
                        dataBaseOperation.viewAllEmployees();
                    }
                    break;
                    case "3": {
                        System.out.println("Enter employees id to delete from data");
                        int id = Integer.parseInt(br.readLine());
                        dataBaseOperation.deleteEmployeeById(id);
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Program program = new Program();
        program.runMenu();
    }
}
