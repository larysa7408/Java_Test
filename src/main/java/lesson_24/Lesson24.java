package lesson_24;

import java.sql.*;

public class Lesson24 {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/larisabuga/Documents/SQLiteStudio/sqlite_db");
        Statement stmt = connection.createStatement();
        add("Lila", "cohort 40.0",stmt);
        read(stmt);

        //CRUD- create, read, update, delete

        ResultSet rs = stmt.executeQuery("SELECT * FROM students;");
        while ((rs.next())) {
            System.out.println(
                    rs.getInt("id") + "," +
                            rs.getString("name") + "," +
                            rs.getString("group_name"));
        }
        stmt.close();
        connection.close();
    }
    static void add(String name, String groupName, Statement stmt) throws SQLException {
        stmt.executeUpdate("INSERT INTO students(name, group_name)VALUES('"+ name+ "','" + groupName+"')");
    }
    static void read(Statement stmt) throws SQLException{
        ResultSet rs = stmt.executeQuery("SELECT * FROM students;");
        while (rs.next()) {
            System.out.println(
                    rs.getInt(1) + "," +
                            rs.getString(2) + "," +
                            rs.getString(3));
        }
    }
    static void delete (int id, Statement stmt)throws SQLException{  // implemen delete by id
        stmt.executeUpdate("DELETE FROM students WHERE id = " + id);
    }
    static void update(String name, String group_name, Statement stmt)throws SQLException{
        //implemen update group_ name, name
        stmt.executeUpdate("UPDATE students SET group_name = '"+ group_name + "' WHERE name = '"+
                name + "'");
    }
    }

