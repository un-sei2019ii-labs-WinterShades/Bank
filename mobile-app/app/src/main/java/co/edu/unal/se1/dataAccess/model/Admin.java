package co.edu.unal.se1.dataAccess.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Admin implements Serializable {

    @PrimaryKey
    public int id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "lastName")
    public String lastName;

    @ColumnInfo(name = "mail")
    public String mail;

    @ColumnInfo(name = "password")
    public String password;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getMail() { return mail; }

    public void setMail(String mail) { this.mail = mail; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }
}