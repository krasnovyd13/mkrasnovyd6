package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText txtDisplay;
    private double valueOne, valueTwo;
    private double memoryValue = 0;
    private String operator;
    private boolean isOperatorPressed;
    private Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtDisplay = findViewById(R.id.txtDisplay);
        calculator = new Calculator();

        // Number buttons
        findViewById(R.id.btn0).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn1).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn2).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn3).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn4).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn5).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn6).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn7).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn8).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn9).setOnClickListener(this::onNumberClick);

        // Operators
        findViewById(R.id.btnPlus).setOnClickListener(this::onOperatorClick);
        findViewById(R.id.btnMinus).setOnClickListener(this::onOperatorClick);
        findViewById(R.id.btnMultiply).setOnClickListener(this::onOperatorClick);
        findViewById(R.id.btnDivide).setOnClickListener(this::onOperatorClick);

        // Special buttons
        findViewById(R.id.btnEquals).setOnClickListener(this::onEqualsClick);
        findViewById(R.id.btnC).setOnClickListener(this::onClearClick);
        findViewById(R.id.btnBackspace).setOnClickListener(this::onBackspaceClick);
        findViewById(R.id.btnPlusMinus).setOnClickListener(this::onToggleSignClick);
        findViewById(R.id.btnDot).setOnClickListener(this::onDotClick);

        // Memory buttons
        findViewById(R.id.btnMC).setOnClickListener(this::onMemoryClearClick);
        findViewById(R.id.btnMR).setOnClickListener(this::onMemoryRecallClick);
        findViewById(R.id.btnMS).setOnClickListener(this::onMemorySaveClick);
        findViewById(R.id.btnMPlus).setOnClickListener(this::onMemoryAddClick);
    }

    public void onNumberClick(View view) {
        Button btn = (Button) view;
        if (isOperatorPressed) {
            txtDisplay.setText("");
            isOperatorPressed = false;
        }
        txtDisplay.append(btn.getText().toString());
    }

    public void onOperatorClick(View view) {
        Button btn = (Button) view;
        try {
            valueOne = Double.parseDouble(txtDisplay.getText().toString());
            operator = btn.getText().toString();
            isOperatorPressed = true;
        } catch (NumberFormatException e) {
            txtDisplay.setText("Invalid Input");
        }
    }

    public void onEqualsClick(View view) {
        try {
            valueTwo = Double.parseDouble(txtDisplay.getText().toString());
            double result = calculator.calculate(valueOne, valueTwo, operator);
            txtDisplay.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            txtDisplay.setText("Invalid Number");
        } catch (IllegalArgumentException e) {
            txtDisplay.setText("Invalid Operator");
        } catch (ArithmeticException e) {
            txtDisplay.setText("Error");
        }
    }

    public void onClearClick(View view) {
        txtDisplay.setText("");
        valueOne = 0;
        valueTwo = 0;
        operator = null;
    }

    public void onBackspaceClick(View view) {
        String text = txtDisplay.getText().toString();
        if (!text.isEmpty()) {
            txtDisplay.setText(text.substring(0, text.length() - 1));
        }
    }

    public void onToggleSignClick(View view) {
        try {
            double value = Double.parseDouble(txtDisplay.getText().toString());
            txtDisplay.setText(String.valueOf(-value));
        } catch (NumberFormatException e) {
            txtDisplay.setText("Invalid Input");
        }
    }

    public void onDotClick(View view) {
        String text = txtDisplay.getText().toString();
        if (!text.contains(".")) {
            txtDisplay.append(".");
        }
    }

    // Memory button actions
    public void onMemoryClearClick(View view) {
        memoryValue = 0;
    }

    public void onMemoryRecallClick(View view) {
        txtDisplay.setText(String.valueOf(memoryValue));
    }

    public void onMemorySaveClick(View view) {
        try {
            memoryValue = Double.parseDouble(txtDisplay.getText().toString());
        } catch (NumberFormatException e) {
            txtDisplay.setText("Invalid Input");
        }
    }

    public void onMemoryAddClick(View view) {
        try {
            memoryValue += Double.parseDouble(txtDisplay.getText().toString());
        } catch (NumberFormatException e) {
            txtDisplay.setText("Invalid Input");
        }
    }
}
