package co.edu.unal.se1.dataAccess.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Transfer implements Serializable {

    @PrimaryKey
    public int numTransfer;

    @ColumnInfo(name = "origin")
    public double origin;

    @ColumnInfo(name = "destination")
    public double destination;

    @ColumnInfo(name = "amount")
    public double amount;

    public int getNumTransfer() {
        return numTransfer;
    }

    public void setNumTransfer(int numTransfer) {
        this.numTransfer = numTransfer;
    }

    public double getOrigin() {
        return origin;
    }

    public void setOrigin(double origin) {
        this.origin = origin;
    }

    public double getDestination() {
        return destination;
    }

    public void setDestination(double destination) {
        this.destination = destination;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}