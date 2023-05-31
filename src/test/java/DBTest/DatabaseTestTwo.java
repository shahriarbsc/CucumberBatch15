package DBTest;


import java.sql.*;

public class DatabaseTestTwo {
    public static void main(String[] args) {

        String url = "jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String username = "syntax_hrm";
        String password = "syntaxhrm123";

        try {
            //we need to establish the connection to the database
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection is created for batch 15");
            //create a statement to send sql queries
            Statement statement = conn.createStatement();
            // ResultSet rset = statement.executeQuery("select Firstname, LastName from person");

            ResultSet rset = statement.executeQuery("select firstname, lastname, age, city " +
                    "from person where city is not null;");


            // while (rset.next()) {

            //  String fName = rset.getString("FirstName");
            //String lName = rset.getString("LastName");
            //  System.out.println(fName + " " + lName);
            // }

            // ResultSerMetaData - object that contains information about the result
            //information such as in the table how many columns are there,
            // name of the columns, rows and number of the rows

            ResultSetMetaData metaData = rset.getMetaData();
            // print all the columns header values

            for (int i = 1; i <= metaData.getColumnCount(); i++) {

                String columnName = metaData.getColumnName(i);
                System.out.println(columnName);
            }
// We want to loop through every column and every row

            while (rset.next()){  // moving from one row to another row

                for (int i = 1; i < metaData.getColumnCount() ; i++) {

                    String value = rset.getString(metaData.getColumnName(i));
                    System.out.println(value + " ");
                }
                // just to change the line statement
                System.out.println();

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}