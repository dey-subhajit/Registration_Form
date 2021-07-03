package com.example.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    TextView tv_f_name_error_message, tv_last_name_error_message, tv_email_error_message, tv_pwd_error_message, tv_c_pwd_error_message;
    EditText et_f_name, et_l_name;
    Button btn_cancle, btn_submit;
    int i = 0;
    Boolean t_c_check = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_f_name_error_message = findViewById(R.id.tv_f_name_error_message);
        tv_last_name_error_message = findViewById(R.id.tv_last_name_error_message);
        tv_email_error_message = findViewById(R.id.tv_email_error_message);
        tv_pwd_error_message = findViewById(R.id.tv_pwd_error_message);
        tv_c_pwd_error_message = findViewById(R.id.tv_c_pwd_error_message);
        et_f_name = findViewById(R.id.et_f_name);
        et_l_name = (EditText)findViewById(R.id.et_l_name);
        EditText et_emaild = (EditText)findViewById(R.id.et_emaild);
        RadioButton rb_male = (RadioButton)findViewById(R.id.rb_male);
        rb_male.setChecked(true);
        RadioButton rb_female = (RadioButton)findViewById(R.id.rb_female);
        RadioButton rb_other = (RadioButton)findViewById(R.id.rb_other);
        EditText et_pwd = (EditText)findViewById(R.id.et_pwd);
        EditText et_c_pwd = (EditText)findViewById(R.id.et_c_pwd);
        CheckBox ck_t_c = (CheckBox)findViewById(R.id.ck_t_c);
        btn_submit = findViewById(R.id.btn_submit);
        btn_cancle = findViewById(R.id.btn_cancle);

        ck_t_c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked == true){
                    t_c_check = true;
                }
            }
        });

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean isValidate = true;
                String f_name = et_f_name.getText().toString();
                String l_name = et_l_name.getText().toString();
                String email = et_emaild.getText().toString();
                String pwd = et_pwd.getText().toString();
                String c_pwd = et_c_pwd.getText().toString();

                /*Initilize*/
                tv_f_name_error_message.setText("");
                tv_last_name_error_message.setText("");
                tv_email_error_message.setText("");
                tv_pwd_error_message.setText("");
                tv_pwd_error_message.setText("");
                ck_t_c.setError(null);

                /*Basic Validation*/
                if(f_name.isEmpty()){
                    tv_f_name_error_message.setText("First Name Required");
                    isValidate = false;
                }
                if(l_name.isEmpty()){
                    tv_last_name_error_message.setText("Last name Required");
                    isValidate = false;
                }
                if(email.isEmpty()) {
                    tv_email_error_message.setText("Email ID Required");
                    isValidate = false;
                }
                if(pwd.isEmpty()){
                    tv_pwd_error_message.setText("Password Required");
                    isValidate = false;
                }
                if(c_pwd.isEmpty()){
                    tv_c_pwd_error_message.setText("Confirm Password Required");
                    isValidate = false;
                }
                if(t_c_check == false){
                    ck_t_c.setError("Please accept");
                    isValidate = false;
                }

                if(isValidate){
                    Intent show_data = new Intent(MainActivity.this, ShowData.class);
                    show_data.putExtra("full_name", f_name+" "+l_name);
                    show_data.putExtra("email", email);
                    startActivity(show_data);
                }
            }
        });

        btn_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                Toast.makeText(MainActivity.this, "Clicked"+ i, Toast.LENGTH_LONG).show();
                tv_f_name_error_message.setText("Error");
                /*et_f_name.setError("Error");*/
            }
        });
    }
}