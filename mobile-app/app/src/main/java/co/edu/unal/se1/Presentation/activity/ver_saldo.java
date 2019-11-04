package co.edu.unal.se1.Presentation.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import co.edu.unal.se1.R;
import co.edu.unal.se1.businessLogic.controller.*;
import co.edu.unal.se1.dataAccess.model.*;

public class ver_saldo extends AppCompatActivity {

    private UserController userController;
    private AccountController accountController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logeado);

        final TextView nombre = findViewById(R.id.Nombre_text);
        final TextView cc = findViewById(R.id.cc_text);
        final TextView saldo = findViewById(R.id.saldo_text);


        Account account;
        nombre.setText(account.getName());
        cc.setText(account.getId());
        saldo.setText(String.valueOf(account.getBalance()));




    }

}
