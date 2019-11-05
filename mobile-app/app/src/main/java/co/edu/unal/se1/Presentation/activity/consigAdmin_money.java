package co.edu.unal.se1.Presentation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import co.edu.unal.se1.R;
import co.edu.unal.se1.businessLogic.controller.AccountController;
import co.edu.unal.se1.businessLogic.controller.AdminController;
import co.edu.unal.se1.businessLogic.controller.UserController;

public class consigAdmin_money extends AppCompatActivity {

    private UserController userController;
    private AccountController accountController;

    public void abrir_eliminar (View view){
        Intent intent = new Intent (this, delete_acc.class);
        startActivity(intent);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        final TextView destAcc = findViewById(R.id.destAccount);
        final TextView  value= findViewById(R.id.amount);


        UserController userController = new UserController();
        AdminController adminController = new AdminController();

        Button send = findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int dest =  Integer.parseInt(destAcc.getText().toString());
                long amount =  Long.parseLong(value.getText().toString());
                AdminController adminController = new AdminController();
                adminController.depositMoney( MainActivity.idUser , dest , amount , getApplicationContext() );
            }
        });

    }

}
