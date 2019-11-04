package co.edu.unal.se1.dataAccess.db;

import androidx.room.RoomDatabase;

import co.edu.unal.se1.dataAccess.dao.*;
import co.edu.unal.se1.dataAccess.model.*;

@androidx.room.Database(entities = {User.class,Account.class}, version = 2 )
public abstract class Database extends RoomDatabase {

    public abstract UserDao userDao();
    public abstract AccountDao AccountDao();
}