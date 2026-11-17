package com.example.kartkowka_mobilne3pt2gr;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random random = new Random();
    private Button buttonLosuj;
    private TextView textViewWylosowana;
    private Button buttonMinus1;
    private TextView textViewLiczba1;
    private Button buttonPlus1;
    private Button buttonMinus2;
    private TextView textViewLiczba2;
    private Button buttonPlus2;
    private Button buttonMinus3;
    private TextView textViewLiczba3;
    private Button buttonPlus3;

    private int wylosowana = 0;
    private int liczba1 = 1;
    private int liczba2 = 1;
    private int liczba3 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        buttonLosuj = findViewById(R.id.button);
        textViewWylosowana = findViewById(R.id.textView);

        buttonMinus1 = findViewById(R.id.button4);
        textViewLiczba1 = findViewById(R.id.textView2);
        buttonPlus1 = findViewById(R.id.button5);

        buttonMinus2 = findViewById(R.id.button6);
        textViewLiczba2 = findViewById(R.id.textView3);
        buttonPlus2 = findViewById(R.id.button7);

        buttonMinus3 = findViewById(R.id.button9);
        textViewLiczba3 = findViewById(R.id.textView4);
        buttonPlus3 = findViewById(R.id.button10);

        if (savedInstanceState != null) {
            wylosowana = savedInstanceState.getInt("WYLOSOWANA", 0);
            textViewWylosowana.setText(String.valueOf(wylosowana));

            liczba1 = savedInstanceState.getInt("LICZBA1", 0);
            textViewLiczba1.setText(String.valueOf(liczba1));

            liczba2 = savedInstanceState.getInt("LICZBA2", 0);
            textViewLiczba2.setText(String.valueOf(liczba2));

            liczba3 = savedInstanceState.getInt("LICZBA3", 0);
            textViewLiczba3.setText(String.valueOf(liczba3));
        }

        buttonLosuj.setOnClickListener(view -> {
            wylosowana = random.nextInt(1,11);
            textViewWylosowana.setText(String.valueOf(wylosowana));

            if (liczba1 == wylosowana) {
                textViewLiczba1.setTextColor(Color.GREEN);
            } else {
                textViewLiczba1.setTextColor(Color.RED);
            }

            if (liczba2 == wylosowana) {
                textViewLiczba2.setTextColor(Color.GREEN);
            } else {
                textViewLiczba2.setTextColor(Color.RED);
            }

            if (liczba3 == wylosowana) {
                textViewLiczba3.setTextColor(Color.GREEN);
            } else {
                textViewLiczba3.setTextColor(Color.RED);
            }
        });

        buttonMinus1.setOnClickListener(view -> {
            if (liczba1 == 1) return;
            liczba1--;
            textViewLiczba1.setText(String.valueOf(liczba1));
        });

        buttonPlus1.setOnClickListener(view -> {
            if (liczba1 == 10) return;
            liczba1++;
            textViewLiczba1.setText(String.valueOf(liczba1));
        });

        buttonMinus2.setOnClickListener(view -> {
            if (liczba2 == 1) return;
            liczba2--;
            textViewLiczba2.setText(String.valueOf(liczba2));
        });

        buttonPlus2.setOnClickListener(view -> {
            if (liczba2 == 10) return;
            liczba2++;
            textViewLiczba2.setText(String.valueOf(liczba2));
        });

        buttonMinus3.setOnClickListener(view -> {
            if (liczba3 == 1) return;
            liczba3--;
            textViewLiczba3.setText(String.valueOf(liczba3));
        });

        buttonPlus3.setOnClickListener(view -> {
            if (liczba3 == 10) return;
            liczba3++;
            textViewLiczba3.setText(String.valueOf(liczba3));
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("WYLOSOWANA", wylosowana);
        outState.putInt("LICZBA1", liczba1);
        outState.putInt("LICZBA2", liczba2);
        outState.putInt("LICZBA3", liczba3);
    }
}