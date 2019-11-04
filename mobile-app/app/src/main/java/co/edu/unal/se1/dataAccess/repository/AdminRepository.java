package co.edu.unal.se1.dataAccess.repository;

import android.content.Context;

import androidx.room.Room;

import java.util.List;

import co.edu.unal.se1.dataAccess.db.Database;
import co.edu.unal.se1.dataAccess.model.Admin;

public class AdminRepository {

    private String DB_NAME = "se1_db_bank";

    private Database database;
    public AdminRepository(Context context) {
        database = Room.databaseBuilder(context, Database.class, DB_NAME).
                allowMainThreadQueries().fallbackToDestructiveMigration().build();
        // Destructive Migration
    }

    public List<Admin> getAllAdmins() { return database.adminDao().getAllAdmins(); }

    public Admin getAdminById(int id) {
        return database.adminDao().getAdminById(id);
    }

    public void createAdmin(final Admin admin) {
        database.adminDao().createAdmin(admin);
    }

    public void updateAdmin(Admin admin) {
        database.adminDao().updateAdmin(admin);
    }

    public void deleteAdmin(int id) {
        Admin admin = database.adminDao().getAdminById(id);
        database.adminDao().deleteAdmin(admin);
    }
}