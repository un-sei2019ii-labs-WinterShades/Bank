package co.edu.unal.se1.dataAccess.repository;

import android.content.Context;

import androidx.room.Room;

import java.util.List;

import co.edu.unal.se1.dataAccess.db.Database;
import co.edu.unal.se1.dataAccess.model.Account;

public class AccountRepository {

    private String DB_NAME = "se1_db_bank";

    private Database database;
    public AccountRepository(Context context) {
        database = Room.databaseBuilder(context, Database.class, DB_NAME).
                allowMainThreadQueries().fallbackToDestructiveMigration().build();
        // Destructive Migration
    }

    public List<Account> getAllAccounts() { return database.accountDao().getAllAccounts(); }

    public Account getAccountById(int id) {
        return database.accountDao().getAccountById(id);
    }

    public void createAccount(final Account account) { database.accountDao().createAccount(account); }

    public void updateAccount(Account account) {
        database.accountDao().updateAccount(account);
    }

    public void deleteAccount(int id) {
        Account account = database.accountDao().getAccountById(id);
        database.accountDao().deleteAccount(account);
    }
}