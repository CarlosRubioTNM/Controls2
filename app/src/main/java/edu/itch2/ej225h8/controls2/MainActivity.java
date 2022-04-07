package edu.itch2.ej225h8.controls2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private LinearLayout btnNext;
    private TextView btnSkip; //Declaración
    private TextView lblTermsConditions;
    private ViewPager2 pagerDescription;
    private ImageView option1;
    private ImageView option2;
    private ImageView option3;
    private Context activityContext;
    private String strMessage = "";
    private static final String KEY_MESSAGE = "Message";

    private ArrayList<Description> lstDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Llenar descripciones
        lstDesc = new ArrayList<>();
        lstDesc.add(new Description("Este proyecto fue creado para utilizar conocimientos de Android Studio."));
        lstDesc.add(new Description("Aquí encontrará elementos de creación de ventanas, colores, temas, interfaces gráficas y animaciones."));
        lstDesc.add(new Description("Para después insertar persistencia de datos con sqlite o firebase."));


        btnSkip = findViewById(R.id.btnSkip); //Inicialización
        btnNext = findViewById(R.id.btnNext);
        lblTermsConditions = findViewById(R.id.lblTermsConditions);
        pagerDescription = findViewById(R.id.pagerDescription);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);

        activityContext = this;
        if (savedInstanceState != null) {
            strMessage = savedInstanceState.getString(KEY_MESSAGE);
        }

        DescriptionAdapter adapter = new DescriptionAdapter(lstDesc);
        pagerDescription.setAdapter(adapter);

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

        lblTermsConditions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri webpage = Uri.parse("http://www.chihuahua2.tecnm.mx/");
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                try {
                    startActivity(intent);
                } catch(ActivityNotFoundException ex) {
                    Toast.makeText(activityContext, "No se pudo abrir la página.",Toast.LENGTH_SHORT).show();
                }
            }
        });

        pagerDescription.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                changeColor();
            }


            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
                changeColor();
            }
        });
    }

    public void changeColor() {
        option1.setBackgroundColor(ContextCompat.getColor(this, R.color.primary_svg));
        option2.setBackgroundColor(ContextCompat.getColor(this, R.color.primary_svg));
        option3.setBackgroundColor(ContextCompat.getColor(this, R.color.primary_svg));
        switch(pagerDescription.getCurrentItem()) {
            case 0:
                option1.setBackgroundColor(ContextCompat.getColor(this, R.color.accent_svg));
                break;
            case 1:
                option2.setBackgroundColor(ContextCompat.getColor(this, R.color.accent_svg));
                break;
            case 2:
                option3.setBackgroundColor(ContextCompat.getColor(this, R.color.accent_svg));
                break;
        }
    }

    private View.OnClickListener goToLogin = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //Intent intent = new Intent(activityContext, LoginActivity.class);
            Intent intent = new Intent(activityContext, NavigationActivity.class);
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