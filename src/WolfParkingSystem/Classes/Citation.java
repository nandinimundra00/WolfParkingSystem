package WolfParkingSystem.Classes;

import java.sql.Date;
import java.sql.Time;

public class Citation {
    private int citationNumber;
    private Date citationDate;
    private Time citationTime;
    private double amount;
    private String paymentStatus;

    public Citation() {
    }

    public Citation(int citationNumber, Date citationDate, Time citationTime, double amount, String paymentStatus) {
        this.citationNumber = citationNumber;
        this.citationDate = citationDate;
        this.citationTime = citationTime;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }

    public int getCitationNumber() {
        return citationNumber;
    }

    public void setCitationNumber(int citationNumber) {
        this.citationNumber = citationNumber;
    }

    public Date getCitationDate() {
        return citationDate;
    }

    public void setCitationDate(Date citationDate) {
        this.citationDate = citationDate;
    }

    public Time getCitationTime() {
        return citationTime;
    }

    public void setCitationTime(Time citationTime) {
        this.citationTime = citationTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return "Citation{" +
                "citationNumber=" + citationNumber +
                ", citationDate=" + citationDate +
                ", citationTime=" + citationTime +
                ", amount=" + amount +
                ", paymentStatus='" + paymentStatus + '\'' +
                '}';
    }
}

