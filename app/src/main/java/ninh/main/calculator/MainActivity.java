package ninh.main.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    TextView tv;
    String number = "", str = "", tmp = "";
    float num = 0;
    float result;
    String check = "";
    String check2 = "";
    boolean start=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textView);
    }
    public void show(String s){
        // tmp: Lay so Hang can tinh
        if (s != "+" && s != "-" && s != "x" && s != "/") tmp = tmp + s;
        str = str + s; // CHI DUOC DUNG de HIEN THI ra TextView
        tv.setText(str);
    }
    public void onClickNum(View view){
        Button btn = (Button) view;
        number = btn.getText().toString();
        show(number);
    }
    public void calculator(String dau){
        num = Float.parseFloat(tmp);
        if (start == true){
            result = num;
            start = false;
            check2 = dau;
        } else {
            switch (dau){
                case "+":
                    result += num;
                    break;
                case "-":
                    result -= num;
                    break;
                case "*":
                    result *= num;
                    break;
                case "/":
                    if (num == 0) {
                        show("ERROR!");
                    } else {
                        result /= num;
                        break;
                    }
            }
        }
        check2 = dau;
        tmp = "";
    }
    public void processMark(View view) {
        switch (view.getId()){
            case (R.id.buttonCong):
                check = "+";
                show("+");
                break;
            case (R.id.buttonTru):
                check = "-";
                show("-");
                break;
            case (R.id.buttonNhan):
                check = "*";
                show("x");
                break;
            case (R.id.buttonChia):
                check = "/";
                show("/");
                break;
        }
        calculator(check);
    }

    public void processOperation(View view){
        str = ""; // Xoa TextView de Hien thi ra Result;
        calculator(check);
        show(result+"");
        Toast.makeText(this, tmp, Toast.LENGTH_SHORT).show();
        check = "";
        start = true;
    }

    public void onClickAC(View view) { //Xoa sach TextView + Result
        str = "";
        tmp = "";
        result = 0;
        check = "";
        start=true;
        show(str);
    }
}