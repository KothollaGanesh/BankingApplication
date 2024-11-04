package BankingApplication;

import java.sql.Date;
import java.time.LocalTime;
import java.time.LocalDate;

public class Pozo {
    private int Ac_num;
    private String setAc_type;
    private int deposite_amount;
    private int withdraw_amount;
    private int balance;
    private int PiN_NUm;

    public int getPiN_NUm() {
        return PiN_NUm;
    }

    public void setPiN_NUm(int piN_NUm) {
        PiN_NUm = piN_NUm;
    }

    private LocalDate date;
    private LocalTime time;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public int getAc_num() {
        return Ac_num;
    }

    public void setAc_num(int ac_num) {
        Ac_num = ac_num;
    }

    public String getSetAc_type() {
        return setAc_type;
    }

    public void setSetAc_type(String setAc_type) {
        this.setAc_type = setAc_type;
    }

    public int getDeposite_amount() {
        return deposite_amount;
    }

    public void setDeposite_amount(int deposite_amount) {
        this.deposite_amount = deposite_amount;
    }

    public int getWithdraw_amount() {
        return withdraw_amount;
    }

    public void setWithdraw_amount(int withdraw_amount) {
        this.withdraw_amount = withdraw_amount;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
