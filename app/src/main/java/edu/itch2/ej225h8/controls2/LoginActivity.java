package edu.itch2.ej225h8.controls2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private Context thisContext;
    private EditText txtEmail;
    private EditText txtPassword;
    private LinearLayout btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        thisContext = this;
        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = txtEmail.getText().toString();
                String pass = txtPassword.getText().toString();
                if (mail.equals("admin") && pass.equals("admin")) {
                    startActivity(new Intent(thisContext, NavigationActivity.class));
                } else {
                    Toast.makeText(thisContext, "Credenciales incorrectas.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}