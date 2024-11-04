package BankingApplication;
import BankingApplication.Pozo;
import org.postgresql.util.OSUtil;

import java.io.PrintStream;
import java.sql.*;
import java.util.Scanner;
public class SqlOperations4 {

    public static int sqlquery(Connection conn) {
        String query = "SELECT balance FROM bank";
        int lastbalance = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lastbalance = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lastbalance;
    }

    public static void Insertquery(Connection connection, Pozo pozo) {
        String query = "INSERT INTO bank VALUES(?,?,?,?,?,?,?)";
        int r = pozo.getBalance();
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, pozo.getAc_num());
            ps.setString(2, pozo.getSetAc_type());
            ps.setInt(3, pozo.getDeposite_amount());
            ps.setInt(4, pozo.getWithdraw_amount());
            ps.setInt(5, pozo.getBalance() + pozo.getDeposite_amount() - pozo.getWithdraw_amount());
            ps.setDate(6, Date.valueOf(pozo.getDate()));
            ps.setTime(7, Time.valueOf(pozo.getTime()));
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void update(Connection connection) {
        String query = "UPDATE bank SET balance=? where balance=?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, 5000);

            ps.setInt(2, 1);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("c.mksjkcn");
            throw new RuntimeException(e);
        }
    }

    public static boolean fetchingAcountdetails(Connection conn, Pozo pozo) {
        String query = "SELECT * FROM bankdetails";

        int acnum,acpin;
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                acnum = rs.getInt(1);
                acpin=rs.getInt(2);
                if (acnum==pozo.getAc_num() && acpin==pozo.getPiN_NUm())  {
                        return true;
                }

            }
            System.out.println("Invalid Account number or PIN.");
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //return lastbalance;
    }
}
