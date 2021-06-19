package com.moonspirit.android.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button zero;
    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Button point;
    Button clear;
    Button add;
    Button minus;
    Button multi;
    Button division;
    Button root;
    Button surplus;
    Button equal;
    Button delete;
    TextView theFirstView;
    TextView theOptionView;
    TextView theSecondView;
    TextView theEqualView;
    TextView theAnswerView;
    String option = "";
    String str1 = "";
    String str2 = "";
    double num1;
    double num2;
    int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    public void initView() {
        zero = findViewById(R.id.zero);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        point = findViewById(R.id.point);
        clear = findViewById(R.id.clear);
        add = findViewById(R.id.add);
        minus = findViewById(R.id.substraction);
        multi = findViewById(R.id.muliti);
        division = findViewById(R.id.division);
        root = findViewById(R.id.root);
        surplus = findViewById(R.id.surplus);
        equal = findViewById(R.id.equal);
        delete = findViewById(R.id.delete);
        theFirstView = findViewById(R.id.the_first_number);
        theOptionView = findViewById(R.id.the_option);
        theSecondView = findViewById(R.id.the_second_number);
        theEqualView = findViewById(R.id.the_equal);
        theAnswerView = findViewById(R.id.the_answer);

        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        point.setOnClickListener(this);
        clear.setOnClickListener(this);
        add.setOnClickListener(this);
        minus.setOnClickListener(this);
        multi.setOnClickListener(this);
        division.setOnClickListener(this);
        root.setOnClickListener(this);
        surplus.setOnClickListener(this);
        equal.setOnClickListener(this);
        delete.setOnClickListener(this);
        theFirstView.setOnClickListener(this);
        theOptionView.setOnClickListener(this);
        theEqualView.setOnClickListener(this);
        theSecondView.setOnClickListener(this);
        theAnswerView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.zero:
            case R.id.one:
            case R.id.two:
            case R.id.three:
            case R.id.four:
            case R.id.five:
            case R.id.six:
            case R.id.seven:
            case R.id.eight:
            case R.id.nine:
                if (flag == 0) {
                    if (option.equals("")) {
                        str1 = str1 + ((Button) view).getText().toString();
                        theFirstView.setText(str1);
                    } else {
                        str2 = str2 + ((Button) view).getText().toString();
                        theSecondView.setText(str2);
                    }
                } else {
                    clear();
                    flag = 0;
                    str1 = str1 + ((Button) view).getText().toString();
                    theFirstView.setText(str1);
                }
                break;

            case R.id.add:
                option = "+";
                theOptionView.setText("+");
                break;

            case R.id.substraction:
                option = "-";
                theOptionView.setText("-");
                break;

            case R.id.muliti:
                option = "×";
                theOptionView.setText("×");
                break;

            case R.id.division:
                option = "÷";
                theOptionView.setText("÷");
                break;

            case R.id.surplus:
                option = "%";
                theOptionView.setText("%");
                break;

            case R.id.root:
                if (str1.equals("")) {
                    option = "√";
                    theOptionView.setText("√");
                }
                break;

            case R.id.equal:
                theEqualView.setText("=");
                flag = 1;

                if (option.equals("+")) {
                    num1 = Double.parseDouble(theFirstView.getText().toString());
                    num2 = Double.parseDouble(theSecondView.getText().toString());
                    theAnswerView.setText((num1 + num2) + "");
                }
                if (option.equals("-")) {
                    num1 = Double.parseDouble(theFirstView.getText().toString());
                    num2 = Double.parseDouble(theSecondView.getText().toString());
                    theAnswerView.setText((num1 - num2) + "");
                }
                if (option.equals("×")) {
                    num1 = Double.parseDouble(theFirstView.getText().toString());
                    num2 = Double.parseDouble(theSecondView.getText().toString());
                    theAnswerView.setText((num1 * num2) + "");
                }
                if (option.equals("÷")) {
                    num1 = Double.parseDouble(theFirstView.getText().toString());
                    num2 = Double.parseDouble(theSecondView.getText().toString());
                    if (num2 == 0) {
                        theAnswerView.setText("错误");
                    } else {
                        theAnswerView.setText((num1 / num2) + "");
                    }
                }
                if (option.equals("√")) {
                    num2 = Double.parseDouble(theSecondView.getText().toString());
                    theAnswerView.setText(Math.sqrt(num2) + "");
                }
                if (option.equals("%")) {
                    num1 = Double.parseDouble(theFirstView.getText().toString());
                    num2 = Double.parseDouble(theSecondView.getText().toString());
                    theAnswerView.setText(num1 % num2 + "");
                }
                break;

            case R.id.clear:
                clear();
                break;

            case R.id.point:
                if (!str1.equals("") && option.equals("")) {
                    str1 = str1 + ((Button) view).getText().toString();
                    theFirstView.setText(str1);
                }
                if (!option.equals("") && !str2.equals("")) {
                    str2 = str2 + ((Button) view).getText().toString();
                    theSecondView.setText(str2);
                }
                break;

            case R.id.delete:
                if (theAnswerView.getText().toString().equals("")) {
                    if (!theSecondView.getText().toString().equals("")) {
                        int length = str2.length();
                        if (length == 1) {
                            theSecondView.setText("");
                        } else {
                            str2 = str2.substring(0, length - 1);
                            theSecondView.setText(str2);
                        }
                        break;
                    }
                    if (theSecondView.getText().toString().equals("") && !theOptionView.getText().toString().equals("")) {
                        theOptionView.setText("");
                        break;
                    }
                    if (theSecondView.getText().toString().equals("") && theAnswerView.getText().toString().equals("") && !theFirstView.getText().toString().equals("")) {
                        int length = str1.length();
                        if (length == 1) {
                            theFirstView.setText("");
                        } else {
                            str1 = str1.substring(0, length - 1);
                            theFirstView.setText(str1);
                        }
                        break;
                    }
                }
                break;
        }
    }

    private void clear() {
        str1 = "";
        str2 = "";
        theFirstView.setText("");
        theSecondView.setText("");
        theOptionView.setText("");
        theEqualView.setText("");
        theAnswerView.setText("");
        option = "";
    }
}
