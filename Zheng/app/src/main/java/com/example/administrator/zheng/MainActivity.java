package com.example.administrator.zheng;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn_0;
    Button btn_1;
    Button btn_2;
    Button btn_3;
    Button btn_4;
    Button btn_5;
    Button btn_6;
    Button btn_7;
    Button btn_8;
    Button btn_9;
    Button btn_point;
    Button btn_clear;
    Button btn_del;
    Button btn_equal;
    Button btn_plus;
    Button btn_minus;
    Button btn_multiply;
    Button btn_divide;

    EditText et_input;
    boolean clear_flag;//清空标识
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_0=(Button)findViewById(R.id.but_0);
        btn_1=(Button)findViewById(R.id.but_1);
        btn_2=(Button)findViewById(R.id.but_2);
        btn_3=(Button)findViewById(R.id.but_3);
        btn_4=(Button)findViewById(R.id.but_4);
        btn_5=(Button)findViewById(R.id.but_5);
        btn_6=(Button)findViewById(R.id.but_6);
        btn_7=(Button)findViewById(R.id.but_7);
        btn_8=(Button)findViewById(R.id.but_8);
        btn_9=(Button)findViewById(R.id.but_9);
        btn_point=(Button)findViewById(R.id.but_point);

        btn_equal=(Button)findViewById(R.id.but_equal);
        btn_clear=(Button)findViewById(R.id.but_clear);
        btn_minus=(Button)findViewById(R.id.but_minus);
        btn_multiply=(Button)findViewById(R.id.but_multiply);
        btn_del=(Button)findViewById(R.id.but_del);
        btn_plus=(Button)findViewById(R.id.but_plus);
        btn_divide=(Button)findViewById(R.id.but_divide);


        et_input=(EditText)findViewById(R.id.et_input);

        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
        btn_point.setOnClickListener(this);
        btn_multiply.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        btn_equal.setOnClickListener(this);




    }
    @Override
    public void onClick(View v){
        String str=et_input.getText().toString();
        switch (v.getId()){
            case R.id.but_0:
            case R.id.but_1:
            case R.id.but_2:
            case R.id.but_3:
            case R.id.but_4:
            case R.id.but_5:
            case R.id.but_6:
            case R.id.but_7:
            case R.id.but_8:
            case R.id.but_9:
            case R.id.but_point:
                if(clear_flag){
                    clear_flag=false;
                    str="";
                    et_input.setText(" ");
                }
                et_input.setText(str+((Button)v).getText());
                break;
            case R.id.but_divide:
            case R.id.but_minus:
            case R.id.but_multiply:
            case R.id.but_plus:
                if(clear_flag){
                    clear_flag=false;
                    str="";
                    et_input.setText(" ");
                }
                et_input.setText(str + " " + ((Button) v).getText() + " ");
                break;
            case R.id.but_del:
                if(clear_flag){
                    clear_flag=false;
                    str="";
                    et_input.setText(" ");
                }else if(str!=null&&!str.equals("")){
                    et_input.setText(str.substring(0,str.length()-1));
                }
                break;

            case R.id.but_clear:
                clear_flag=false;
                str="";
                et_input.setText(" ");
                break;
            case R.id.but_equal:
                getResult();
                break;
        }

    }

    private void getResult(){
        String exp=et_input.getText().toString();
        if(exp==null||exp.equals("")){
            return;
        }
        if(!exp.contains(" ")){
            return;
        }
        if(clear_flag){
            clear_flag=false;
            return;
        }
        clear_flag=true;
        double result=0;
        String s1=exp.substring(0,exp.indexOf(" "));
        String op=exp.substring(exp.indexOf(" ")+1,exp.indexOf(" ")+2);
        String s2=exp.substring(exp.indexOf(" ")+3);
        if(!s1.equals(" ")&&!s2.equals(" ")){
            double d1=Double.parseDouble(s1);
            double d2=Double.parseDouble(s2);
            if(op.equals("+")){
                result=d1+d2;
            }else if(op.equals("-")){
                result=d1-d2;
            }else if(op.equals("*")){
                result=d1*d2;
            }else if(op.equals("/")){
                if(d2==0){
                    result=0;
                }else {
                    result = d1 / d2;
                }
            }

            if(!s1.contains(".")&&!s2.contains(".")&&!op.equals("/")){
                int r=(int)result;
                et_input.setText(r+"");
            }else {
                et_input.setText(result + "");
            }

        }else if(s1.equals(" ")&&!s2.equals(" ")){
            et_input.setText(exp);
        }else if(!s1.equals(" ")&&s2.equals(" ")){
            double d2=Double.parseDouble(s2);

            if(op.equals("+")){
                result=0+d2;
            }else if(op.equals("-")){
                result=0-d2;
            }else if(op.equals("*")){
                result=0;
            }else if(op.equals("/")){
                result = 0;
            }

            if(!s2.contains(".")){
                int r=(int)result;
                et_input.setText(r+"");
            }else {
                et_input.setText(result + "");
            }
        }else{
            et_input.setText(exp);
        }
    }
}

