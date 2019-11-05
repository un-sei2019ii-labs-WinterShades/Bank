package co.edu.unal.se1.Presentation.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import co.edu.unal.se1.R;
import co.edu.unal.se1.businessLogic.controller.*;

public class show_balance extends AppCompatActivity {

    private UserController userController;
    private AccountController accountController;

    public void abrir_transfer( View view){
        Intent intent = new Intent(this, transfer_money.class );
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_balance);

        final TextView nombre = findViewById(R.id.Nombre_text);
        final TextView cc = findViewById(R.id.cc_text);
        final TextView saldo = findViewById(R.id.saldo_text);

        UserController userController = new UserController();
        AccountController accountController = new AccountController();

        nombre.setText( userController.getNameById( MainActivity.idUser , getApplicationContext() ) );
        cc.setText( String.valueOf(MainActivity.idUser) );
        saldo.setText(String.valueOf( accountController.getBalanceById( MainActivity.idUser , getApplicationContext() ) ) );

    }

}
