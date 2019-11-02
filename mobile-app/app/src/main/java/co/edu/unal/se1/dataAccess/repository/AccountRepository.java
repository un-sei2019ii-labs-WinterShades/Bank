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

    public List<Account> getAllAccounts() {
        return database.AccountDao().getAllAccounts();
    }

    public Account getAccountById(int id) {
        return database.AccountDao().getAccountById(id);
    }

    public void createAccount(final Account account) {
        database.AccountDao().createAccount(account);
    }

    public void updateAccount(Account account) {
        database.AccountDao().updateAccount(account);
    }

    public void deleteAccount(int id) {
        Account account = database.AccountDao().getAccountById(id);
        database.AccountDao().deleteAccount(account);
    }
}