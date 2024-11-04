package BankingApplication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
//import java.time.LocalTime;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        String formattedDateTime = currentDateTime.format(formatter);
//        System.out.println(formattedDateTime);
        try {
            Class.forName("org.postgresql.Driver"); // Load the driver
            System.out.println("ok");
            String URL = "jdbc:postgresql://localhost:5432/TestDB";
            String USERNAME = "postgres";
            String PASSWORD = "Ganesh@123";
            Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            System.out.println("connection success");
            SqlOperations4.update(conn);
        int a=sc.nextInt();
        Transactions b=new Transactions();
        switch (a) {
            case 1:
                b.Deposite(conn);
                break;
            case 2:
                b.Withdraw(conn);
                break;
            case 3:
                b.Balance(conn);
                break;
            default:
                System.out.println("Invalid Choice ");
        }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
