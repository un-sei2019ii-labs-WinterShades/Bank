package co.edu.unal.se1.dataAccess.repository;

import android.content.Context;

import androidx.room.Room;

import java.util.List;

import co.edu.unal.se1.dataAccess.db.Database;
import co.edu.unal.se1.dataAccess.model.Transfer;

public class TransferRepository {

    private String DB_NAME = "se1_db_bank";

    private Database database;
    public TransferRepository(Context context) {
        database = Room.databaseBuilder(context, Database.class, DB_NAME).
                allowMainThreadQueries().fallbackToDestructiveMigration().build();
        // Destructive Migration
    }

    public List<Transfer> getAllTransfers() { return database.transferDao().getAllTransfers(); }

    public Transfer getTransferById(int id) {
        return database.transferDao().getTransferById(id);
    }

    public void createTransfer(final Transfer transfer) { database.transferDao().createTransfer(transfer); }

    public void updateTransfer(Transfer transfer) { database.transferDao().updateTransfer(transfer); }

    public void deleteTransfer(int id) {
        Transfer transfer = database.transferDao().getTransferById(id);
        database.transferDao().deleteTransfer(transfer);
    }
}