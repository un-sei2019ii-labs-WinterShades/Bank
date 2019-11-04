package co.edu.unal.se1.Presentation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import co.edu.unal.se1.R;
import co.edu.unal.se1.businessLogic.controller.*;
import co.edu.unal.se1.dataAccess.model.Admin;

public class MainActivity extends AppCompatActivity {

    public static int idUser;

    public void abrir_create( View view){
        Intent intent = new Intent(this, crear_usuario.class );
        startActivity(intent);
    }

    public void abrir_saldo (View view){
        Intent intent = new Intent (this, ver_saldo.class);
        startActivity(intent);

    }

    public void abrir_admin (View view){
        Intent intent = new Intent (this, consigAdmin_money.class);
        startActivity(intent);

    }


    private UserController userController;
    private AccountController accountController;


    public boolean verificar (int id, String password){
        UserController userController = new UserController();
        return userController.verifyUser( id , password , getApplicationContext() );
    }

    public boolean verificarAdmin (int id, String password){
        AdminController adminController = new AdminController();
        return adminController.verifyAdmin( id , password , getApplicationContext() );
    }

    public void createAdmin( int id , String pass ){
        AdminController adminController = new AdminController();
        if( adminController.adminExists( getApplicationContext() ) ) return;
        Admin admin = new Admin();
        admin.setId(id);
        admin.setName("Admin0");
        admin.setPassword(pass);
        adminController.createAdmin( admin , getApplicationContext() );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createAdmin( 0 , "qwertyui" );

        final EditText idInput = findViewById(R.id.userID);
        final EditText passInput = findViewById(R.id.password);



        Button login = findViewById(R.id.logIn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println( Integer.parseInt( idInput.getText().toString() ) + " : " + passInput.getText().toString() );
                final boolean verify = verificar( Integer.parseInt( idInput.getText().toString() ) , passInput.getText().toString() ) ;
                if (verify){
                    idUser = Integer.parseInt( idInput.getText().toString() );
                    System.out.println("HOLAA");
                    abrir_saldo(v);
                }else if( verificarAdmin( Integer.parseInt( idInput.getText().toString() ) , passInput.getText().toString() ) ){
                    idUser = Integer.parseInt( idInput.getText().toString() );
                    abrir_admin(v);
                }
            }
        });




    }



}