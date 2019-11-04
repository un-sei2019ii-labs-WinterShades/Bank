package co.edu.unal.se1.dataAccess.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import co.edu.unal.se1.dataAccess.model.Admin;

@Dao
public interface AdminDao {

    @Query("SELECT * FROM admin")
    List<Admin> getAllAdmins();

    @Query("SELECT * FROM user WHERE id = :id")
    Admin getAdminById(int id);

    @Insert
    void createAdmin(Admin admin);

    @Update
    void updateAdmin(Admin admin);

    @Delete
    void deleteAdmin(Admin admin);
}
