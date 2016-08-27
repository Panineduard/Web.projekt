package DAO.Sql;


import DAO.DataGenerator;
import model.FlatOwner.Person;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ������ on 28.07.15.
 */
public class GenerationDb {
    private static String ADDRES = "jdbc:postgresql://localhost:5432/Utilities_payments";
    private static String NAME = "postgres";
    private static String PASWORD = "123";

    private static Connection getDbConnection() {
        Connection dbConnection = null;
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(ADDRES, NAME, PASWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }

    private static void createDb() throws SQLException, IOException {
        Connection dbConnection = null;
        Statement statement = null;
        List<String> comand = new ArrayList<String>();
        BufferedReader bufferedReader = null;
        String createTableSQL = null;
        StringBuffer stringBuffer=new StringBuffer();
        try {
        bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\JAVA\\SqlCreat.txt")));
        String word;
        while ((word=bufferedReader.readLine())!=null){
            stringBuffer.append(word);
               }
            createTableSQL = stringBuffer.toString();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            bufferedReader.close();
        }

        try {
            dbConnection = getDbConnection();
            statement = dbConnection.createStatement();
            statement.execute(createTableSQL);
            System.out.println("Table is created!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }
    private static void deleteAllData()throws SQLException{
    Connection connection = getDbConnection();
        Statement st = connection.createStatement();
        String deletSql="DELETE FROM \"People\";DELETE FROM \"PaymentHistory\";DELETE FROM \"Login\";DELETE FROM \"Flat\";" +
                "DELETE FROM \"CounterHistory\";DELETE FROM \"Adress\"";
        st.execute(deletSql);
        st.close();
        connection.close();
}


    public static void main(String[]args) throws SQLException, IOException {
//createDb();

//deleteAllData();
 }

}
