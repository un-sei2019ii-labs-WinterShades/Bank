package co.edu.unal.se1.Presentation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import co.edu.unal.se1.R;
import co.edu.unal.se1.businessLogic.controller.AccountController;
import co.edu.unal.se1.businessLogic.controller.UserController;

public class transfer_money extends AppCompatActivity {

    private UserController userController;
    private AccountController accountController;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);

        final TextView destAcc = findViewById(R.id.destAccount);
        final TextView  value= findViewById(R.id.amount);


        UserController userController = new UserController();
        AccountController accountController = new AccountController();

        Button send = findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int dest =  Integer.parseInt(destAcc.getText().toString());
                long amount =  Long.parseLong(value.getText().toString());
                AccountController accountController = new AccountController();
                accountController.sendMoney( MainActivity.idUser , dest , amount , getApplicationContext() );
            }
        });

    }

}
