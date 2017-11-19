package com.epam.JDBC;

import com.epam.Exceptions.ReadPropertiesTask2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DBConnection {

    public static final String CREATE =
            "CREATE TABLE IF NOT EXISTS Employee (id IDENTITY," +
                    "first_name VARCHAR(20),last_name  VARCHAR(30), job VARCHAR(20));";
    public static final String INSERTDEV =
"INSERT INTO Employee (first_name, last_name, job)"+
        "VALUES ('Max', 'Rand', 'Dev');";
    public static final String INSERTFIN =
            "INSERT INTO Employee (first_name, last_name, job)"+
                    "VALUES ('Olga', 'Katch', 'Fin');";
    public static final String DROPTABLE =
            "DROP TABLE  Employee;";

    public static final String SQLSELECT =
            "SELECT first_name, last_name, job FROM Employee;";

    public static final String SQLSELECTDEV =
            "SELECT first_name, last_name, job FROM Employee WHERE job='Dev';";



    public static void main(String... args) {

        ReadPropertiesTask2 readPropert = new ReadPropertiesTask2();
        readPropert.readPropFile("jdbc");
        try {
            String driv=readPropert.getObject("driver");
            Class.forName(driv);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = readPropert.getObject("url");

        try (Connection con = DriverManager.getConnection(url);
             Statement st = con.createStatement()) {

            st.execute(getInitSql());
           int count=st.executeUpdate(CREATE);
                System.out.println(count);
            count=st.executeUpdate(INSERTDEV);
            System.out.println(count);
            count=st.executeUpdate(INSERTFIN);
            System.out.println(count);

            try (ResultSet rs = st.executeQuery(SQLSELECTDEV)) {
                while (rs.next()) {
                    System.out.printf("%s %s %s%n",
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getString("job"));
                }
            }
            try (ResultSet rs = st.executeQuery(SQLSELECT)) {
                while (rs.next()) {
                    System.out.printf("%s %s %s%n",
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getString("job"));
                }
                count=st.executeUpdate(DROPTABLE);
                System.out.println(count);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

  }

    private static String getInitSql() {
        try (Stream<String> lines = Files.lines(
                Paths.get("./src/main/resources/h2.sql"),
                StandardCharsets.UTF_8)) {
            return lines.collect(Collectors.joining());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
