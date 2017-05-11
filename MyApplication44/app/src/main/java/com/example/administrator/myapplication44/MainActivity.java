package com.example.administrator.myapplication44;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
    Button btn_0;//0数字按钮
    Button btn_1;//1数字按钮
    Button btn_2;//2数字按钮
    Button btn_3;//3数字按钮
    Button btn_4;//4数字按钮
    Button btn_5;//5数字按钮
    Button btn_6;//6数字按钮
    Button btn_7;//7数字按钮
    Button btn_8;//8数字按钮
    Button btn_9;//9数字按钮
    Button btn_point;//小数点按钮
    Button btn_clear;//清除按钮
    Button btn_del;//删除按钮
    Button btn_plus;//加好按钮
    Button btn_minus;//减号按钮
    Button btn_divide;//除号按钮
    Button btn_multiply;//乘号按钮
    Button btn_equle;//等于按钮
    //以上建立按钮
    EditText et_input;//显示输出内容的显示屏
    boolean clear_flag;//清空标识，用于等号之后清空

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);//控制xml为content_main

        btn_0 = (Button) findViewById(R.id.btn_0);
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_8 = (Button) findViewById(R.id.btn_8);
        btn_9 = (Button) findViewById(R.id.btn_9);
        btn_point = (Button) findViewById(R.id.btn_point);
        btn_del = (Button) findViewById(R.id.btn_del);
        btn_plus = (Button) findViewById(R.id.btn_plus);
        btn_clear = (Button) findViewById(R.id.btn_clear);
        btn_minus = (Button) findViewById(R.id.btn_minus);
        btn_multiply = (Button) findViewById(R.id.btn_multiply);
        btn_divide = (Button) findViewById(R.id.btn_divide);
        btn_equle = (Button) findViewById(R.id.btn_equal);
        //以上是实例化按钮

        et_input = (EditText) findViewById(R.id.et_input);//实例化显示屏

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
        btn_point.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_multiply.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        btn_equle.setOnClickListener(this);
        //以上设置按钮的点击事件
    }

    @Override
    public void onClick(View v) {
        String str = et_input.getText().toString();  //取出显示屏内容
        switch (v.getId()){  //判断点的是那个按钮
            case R.id.btn_0:  //建立数字0—9和.
            case R.id.btn_1:
            case R.id.btn_2:
            case R.id.btn_3:
            case R.id.btn_4:
            case R.id.btn_5:
            case R.id.btn_6:
            case R.id.btn_7:
            case R.id.btn_8:
            case R.id.btn_9:
            case R.id.btn_point:
                if(clear_flag){  //
                    clear_flag =false;
                    str = "";  //计算下一个时候，应将原来的设置为空
                    et_input.setText("");
                }
                et_input.setText(str+((Button)v).getText());  //将点击的文字添加到输入框里面（str原来输入框中内容）
                break;
            case R.id.btn_plus:  //建立+-×÷
            case R.id.btn_minus:
            case R.id.btn_multiply:
            case R.id.btn_divide:
                if(clear_flag){
                    clear_flag =false;
                    str = "";  //计算下一个时候，应将原来的设置为空
                    et_input.setText("");
                }
                et_input.setText(str+" "+((Button)v).getText()+" ");//将点击的运算符添加到输入框前后有“ ”用于区别
                break;
            case R.id.btn_del: //建立删除
                if(clear_flag){
                    clear_flag= false;
                    str = "";  //计算下一个时候，应将原来的设置为空
                    et_input.setText("");
                }else if (str != null &&!str.equals("")) { //如果显示屏里面不是NULL也不是空
                    et_input.setText(str.substring(0,str.length()-1)); //从后面长度减一
                }
                break;
            case R.id.btn_clear:  //建立清除
                clear_flag = false;
                str = "";  //计算下一个时候，应将原来的设置为空
                et_input.setText("");   //将显示屏内容置空
                break;
            case R.id.btn_equal:  //建立等于
                getResult();     //获取结算结果
                break;
        }
    }

    //进行计算
    private void getResult(){
        String exp = et_input.getText().toString(); //取出显示屏内容并转化为String
        if (exp == null||exp.equals("")){//如果内容为null和空，直接返回
            return;
        }
        if(!exp.contains(" ")){//如果不包含空格（运算符前面有空格），直接返回（比如点了数字，没有运算符）
            return;
        }
        if(clear_flag){
            clear_flag = false;
            return;
        }
        clear_flag = true;
        double result = 0;  //定义一个double的result=0
        String s1 = exp.substring(0,exp.indexOf(' '));//截取运算符前面的字符
        String op = exp.substring(exp.indexOf(' ')+1,exp.indexOf(' ')+2);//截取运算符
        String s2 = exp.substring(exp.indexOf(' ')+3);//截取运算符后面的字符
        if(!s1.equals("")&&!s2.equals("")){ //如果S1或者S2不为空
            double d1 = Double.parseDouble(s1);  //强制将S1转换为double类型
            double d2 = Double.parseDouble(s2);  //强制将S2转换为double类型
            if(op.equals("+")){  //如果op为四中情况的方案
                result = d1+d2;
            }else if(op.equals("-")){
                result = d1-d2;
            }else if(op.equals("×")){
                result = d1*d2;
            }else if(op.equals("÷")){
                if(d2==0){
                    Toast.makeText(MainActivity.this, "除数不能为0！！！",Toast.LENGTH_LONG).show();
                    et_input.setText("0");
                }else{
                    result = d1/d2;
                }
            }
            if(!s1.contains(".")&&!s2.contains(".")&&!op.equals("÷")){  //如果没有小数点则为int类型且op不为÷
                int r = (int)result;  //强制转换为int类型
                et_input.setText(r+"");
            }else{    //其中含有小数点，则输出double类型
                et_input.setText(result+"");
            }
        }else if(!s1.equals("")&&s2.equals("")){  //S1不为空，S2为空
            double d1 = Double.parseDouble(s1);
            result = d1;
            Toast.makeText(MainActivity.this, "不具备运算",Toast.LENGTH_LONG).show();
            et_input.setText(result+"");  //不进行计算,返回S1
        }else if(s1.equals("")&&!s2.equals("")){  //S1为空，S2不为空
            double d2 = Double.parseDouble(s2);
            if(op.equals("+")){
                result = 0+d2;
            }else if(op.equals("-")){
                result = 0-d2;
            }else if(op.equals("×")){
                result = 0;
            }else if(op.equals("÷")){
                result = 0;
            }
            if(!s2.contains(".")){
                int r = (int)result;
                et_input.setText(r+"");
            }else{
                et_input.setText(result+"");
            }
        }else{
            et_input.setText("");
        }
    }
}  
