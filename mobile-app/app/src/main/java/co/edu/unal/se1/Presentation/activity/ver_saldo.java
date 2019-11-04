package co.edu.unal.se1.Presentation.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import co.edu.unal.se1.R;
import co.edu.unal.se1.businessLogic.controller.*;

public class ver_saldo extends AppCompatActivity {

    private UserController userController;
    private AccountController accountController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ver_saldo);

        final TextView nombre = findViewById(R.id.Nombre_text);
        final TextView cc = findViewById(R.id.cc_text);
        final TextView saldo = findViewById(R.id.saldo_text);

        UserController userController = new UserController();
        AccountController accountController = new AccountController();

        nombre.setText( userController.getNameById( MainActivity.idUser , getApplicationContext() ) );
        cc.setText( MainActivity.idUser );
        saldo.setText(String.valueOf( accountController.getBalanceById( MainActivity.idUser , getApplicationContext() ) ) );

    }

}
