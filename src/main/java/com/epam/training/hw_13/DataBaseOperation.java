package com.epam.training.hw_13;

import java.sql.*;

public class DataBaseOperation {

    protected static final String DATA_BASE_PATH = "jdbc:sqlite:src/main/resources/db/employees.db";
    protected static final String INSERT_NEW_EMPLOYEE_SQL = "INSERT INTO Employees(id,firstname,lastname) VALUES(?,?,?)";
    protected static final String DELETE_FROM_EMPLOYEES_SQL = "DELETE from Employees where ID= ?";
    protected static final String SELECT_ALL_FROM_EMPLOYEES_SQL = "select * from Employees";

    private Connection connect() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DATA_BASE_PATH);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    public void insertNewEmployee(int id, String firstName, String lastName) {
        try (Connection connection = this.connect()) {
            PreparedStatement prepareStatement = connection.prepareStatement(INSERT_NEW_EMPLOYEE_SQL);
            {
                prepareStatement.setInt(1, id);
                prepareStatement.setString(2, firstName);
                prepareStatement.setString(3, lastName);
                prepareStatement.executeUpdate();
                connection.close();
                prepareStatement.close();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteEmployeeById(int id) {
        try (Connection connection = this.connect()) {
            PreparedStatement prepareStatement = connection.prepareStatement(DELETE_FROM_EMPLOYEES_SQL);
            {
                prepareStatement.setString(1, String.valueOf(id));
                prepareStatement.executeUpdate();
                connection.close();
                prepareStatement.close();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void viewAllEmployees() {
        ResultSet resultSet;
        try (Connection connection = this.connect()) {
            PreparedStatement prepareStatement = connection.prepareStatement(SELECT_ALL_FROM_EMPLOYEES_SQL);
            {
                resultSet = prepareStatement.executeQuery();
                while (resultSet.next()) {
                    String id = resultSet.getString("id");
                    String firstname = resultSet.getString(2);
                    String lastname = resultSet.getString(3);
                    System.out.println(id + " " + firstname + " " + lastname);
                }
                connection.close();
                prepareStatement.close();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
