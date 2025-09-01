package com.example.calculator_androidapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView textResultado;
    float numeroA = 0;
    String operacao = "";

    Button buttonClear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.content_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.content_main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textResultado = findViewById(R.id.text_Resultado);


    }

    public void buttonClick(View view){
        if(view.getId() == R.id.buttonClear){
            textResultado.setText("0");
            numeroA=0;
            operacao="";
        }
        else if(view.getId() == R.id.buttonAdd){
            calculate("+");
        }
        else if(view.getId() == R.id.buttonSubtract){
            calculate("-");
        }
        else if(view.getId() == R.id.buttonMultiply){
            calculate("*");
        }
        else if(view.getId() == R.id.buttonDivide){
            calculate("/");
        }
        else if(view.getId() == R.id.buttonEqual){
            calculateResult();
        }
        else{
            String num = ((Button)view).getText().toString();
            getKeyboard(num);
        }
    }

    public void calculate(String operationType){
        numeroA = Float.parseFloat(textResultado.getText().toString());
        operacao = operationType;
        textResultado.setText("0");
    }

    public void getKeyboard(String str){

        String scrCurrent = textResultado.getText().toString();
        if (scrCurrent.equals("0")) {
            scrCurrent = "";
        }
        scrCurrent += str;
        textResultado.setText(scrCurrent);

    }
    public void calculateResult(){
        float numberB = Integer.parseInt(textResultado.getText().toString());
        float result = 0;

        if(operacao.equals("+")){
            result = numeroA + numberB;
        }
        if(operacao.equals("-")){
            result = numeroA - numberB;
        }
        if(operacao.equals("*")){
            result = numeroA * numberB;
        }
        if(operacao.equals("/")){
            result = numeroA / numberB;
        }
        textResultado.setText(String.valueOf(result));
    }
}