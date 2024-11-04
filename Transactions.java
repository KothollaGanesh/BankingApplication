package BankingApplication;

import java.sql.Connection;
import java.util.Scanner;
import java.time.LocalTime;
import java.time.LocalDate;
public class Transactions {
    public static void Withdraw(Connection conn) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter withdrawal amount:");
        int withdrawAmount = sc.nextInt();
        System.out.println("Enter account number:");
        int acNum = sc.nextInt();
        System.out.println("Enter PIN number:");
        int pinNum = sc.nextInt();

        Pozo pozo = new Pozo();
        pozo.setAc_num(acNum);
        pozo.setPiN_NUm(pinNum);

        // Check if account details are valid
        if (SqlOperations4.fetchingAcountdetails(conn, pozo)) {
            String accountType = sc.next();  // Ask for account type only if account is valid
            int lastBalance = SqlOperations4.sqlquery(conn);

            if (lastBalance >= withdrawAmount) {  // Check for sufficient balance
                pozo.setWithdraw_amount(withdrawAmount);
                pozo.setSetAc_type(accountType);
                pozo.setBalance(lastBalance - withdrawAmount); // Update balance after withdrawal
                pozo.setDate(LocalDate.now());
                pozo.setTime(LocalTime.now());

                SqlOperations4.Insertquery(conn, pozo);
                System.out.println("Withdrawal successful.");
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Failed to validate account. Withdrawal process terminated.");
        }
    }

    public static void Deposite(Connection conn) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter deposit amount:");
        int deposit = sc.nextInt();
        System.out.println("Enter account number:");
        int acNum = sc.nextInt();
        System.out.println("Enter PIN number:");
        int pinNum = sc.nextInt();

        Pozo pozo = new Pozo();
        pozo.setAc_num(acNum);
        pozo.setPiN_NUm(pinNum);

        // Check if account details are valid
        if (SqlOperations4.fetchingAcountdetails(conn, pozo)) {
            System.out.println("Enter account type:");
            String accountType = sc.next();
            int lastBalance = SqlOperations4.sqlquery(conn);

            pozo.setDeposite_amount(deposit);
            pozo.setSetAc_type(accountType);
            pozo.setBalance(lastBalance);
            pozo.setDate(LocalDate.now());
            pozo.setTime(LocalTime.now());

            SqlOperations4.Insertquery(conn, pozo);
        } else {
            System.out.println("Failed to validate account. Deposit process terminated.");
        }
    }

    public static void Balance(Connection conn){
        int a=SqlOperations4.sqlquery(conn);
        Pozo pozo=new Pozo();
        pozo.setBalance(a);
        System.out.print("YOUR BALANCE: ");
        System.out.println(pozo.getBalance());
    }
}
