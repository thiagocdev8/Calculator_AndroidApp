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

        textResultado = findViewById(R.id.text_Resultado);
        buttonClear = findViewById(R.id.buttonClear);
    }

    public void buttonClick(View view){
        if(view.getId() == R.id.buttonClear){
            textResultado.setText("0");
            numeroA=0;
            operacao="";
        }
        if(view.getId() == R.id.buttonAdd){
            calculate("+");
        }
        if(view.getId() == R.id.buttonSubtract){
            calculate("-");
        }
        if(view.getId() == R.id.buttonMultiply){
            calculate("*");
        }
        if(view.getId() == R.id.buttonDivide){
            calculate("/");
        }
        if(view.getId() == R.id.buttonEqual){
            calculateResult();
        }
        else{
            String num;
            num = ((Button)view).getText().toString();
            getKeyboard(num);
        }
    }

    public void calculate(String operationType){
        numeroA = Float.parseFloat(textResultado.getText().toString());
        operacao = operationType;
        textResultado.setText("0");
    }

    public void getKeyboard(String str){

        String ScrCurrent = textResultado.getText().toString();
        ScrCurrent += str;
        textResultado.setText(ScrCurrent);
    }

    public void calculateResult(){
        float numberB = Integer.parseInt(textResultado.getText().toString());
        float result = 0;

        if(operacao.equals("+")){
            result = numberB + numeroA;
        }
        if(operacao.equals("-")){
            result = numberB - numeroA;
        }
        if(operacao.equals("*")){
            result = numberB * numeroA;
        }
        if(operacao.equals("/")){
            result = numberB / numeroA;
        }
        textResultado.setText(String.valueOf(result));
    }
}