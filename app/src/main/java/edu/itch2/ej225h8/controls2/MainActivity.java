package edu.itch2.ej225h8.controls2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private LinearLayout btnNext;
    private TextView btnSkip; //Declaración
    private Context activityContext;
    private String strMessage = "";
    private static final String KEY_MESSAGE = "Message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSkip = findViewById(R.id.btnSkip); //Inicialización
        btnNext = findViewById(R.id.btnNext);
        activityContext = this;
        if (savedInstanceState != null) {
            strMessage = savedInstanceState.getString(KEY_MESSAGE);
        }
        //Algo sd = new Algo();
        //btnSkip.setOnClickListener(sd);
        /*btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/
        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Algo algo = new Algo();
                Algo algo2 = new Algo();
                String s = "No son iguales.";
                if (algo.equals(algo2)) {
                    s = "Son iguales.";
                }
                s = s.toUpperCase().concat(" Y esto es extra.").substring(5);
                Toast t = Toast.makeText(activityContext,s, Toast.LENGTH_SHORT);
                t.show();
            }
        });
        btnNext.setOnClickListener(goToLogin);
    }

    private View.OnClickListener goToLogin = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(activityContext, LoginActivity.class);
            startActivity(intent);
        }
    };

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString(KEY_MESSAGE, strMessage);

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        strMessage = savedInstanceState.getString(KEY_MESSAGE);
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

class Algo implements View.OnClickListener {
    public String hola = "Objeto utilizado correctamente.";
    private int x = 1;
    @Override
    public void onClick(View view) {
        x++;
    }

    public static int suma(int a, int b) {
        return a+b;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Algo)) {
            return false;
        }
        Algo temp = (Algo)obj;

        return temp.hola == this.hola;
    }
}