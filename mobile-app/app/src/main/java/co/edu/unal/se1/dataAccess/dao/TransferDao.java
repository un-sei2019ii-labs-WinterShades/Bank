package co.edu.unal.se1.dataAccess.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import co.edu.unal.se1.dataAccess.model.Transfer;

@Dao
public interface TransferDao {

    @Query("SELECT * FROM transfer")
    List<Transfer> getAllTransfers();

    @Query("SELECT * FROM transfer WHERE numTransfer = :numTransfer")
    Transfer getTransferById(int numTransfer);

    @Insert
    void createTransfer(Transfer transfer);

    @Update
    void updateTransfer(Transfer transfer);

    @Delete
    void deleteTransfer(Transfer transfer);
}
