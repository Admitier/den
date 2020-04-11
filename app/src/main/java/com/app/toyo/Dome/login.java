package com.app.toyo.Dome;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {
private EditText name;
private EditText password;
private TextView info;
private Button login;
private int counter=5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        name = (EditText) findViewById(R.id.uname);
        password =(EditText) findViewById(R.id.upassword);
        info = (TextView) findViewById(R.id.attempts);
        login = (Button) findViewById(R.id.ubutton);
        info.setText("No of Attempts Remaining :5");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(name.getText().toString(), password.getText().toString());

            }
        });
    }

private void validate(String userName, String userPassword)
{
    if(userName!=null && !userName.equals("") && !userName.isEmpty())
    {
        if(userPassword!=null && !userPassword.equals("") && !userPassword.isEmpty()){
            if((userName.equals("Akshit"))  && (userPassword.equals("12345"))) {
                Intent intent = new Intent(login.this, MainActivity .class);
                intent.putExtra("Login_success",true);
                intent.putExtra("name" ,userName);
                startActivity(intent);
            } else if((userName.equals("Anand"))  && (userPassword.equals("Anand"))) {
                Intent intent = new Intent(login.this, MainActivity.class);
                intent.putExtra("Login_success",true);
                intent.putExtra("name" ,userName);
                startActivity(intent);
            } else if((userName.equals("PoojaBatra"))  && (userPassword.equals("PoojaBatra"))) {
                Intent intent = new Intent(login.this, MainActivity.class);
                intent.putExtra("Login_success",true);
                intent.putExtra("name" ,userName);
                startActivity(intent);
            } else  if((userName.equals("YojnaArora"))  && (userPassword.equals("YojnaArora"))) {
                Intent intent = new Intent(login.this, MainActivity.class);
                intent.putExtra("Login_success",true);
                intent.putExtra("name" ,userName);
                startActivity(intent);
            }else if((userName.equals("MonikaSoni"))  && (userPassword.equals("MonikaSoni"))) {
                Intent intent = new Intent(login.this, MainActivity.class);
                intent.putExtra("Login_success",true);
                intent.putExtra("name" ,userName);
                startActivity(intent);
            }
            else{
                counter--;
                Toast.makeText(this, "Wrong Username or Password", Toast.LENGTH_SHORT).show();
                info.setText("No of Attempts Remaining: " + " " + String.valueOf(counter));
                if(counter == 0){
                    login.setEnabled(false);
                    Toast.makeText(this, "You can not login right not", Toast.LENGTH_SHORT).show();
                }
            }
        }
        else
        {
            Toast.makeText(this, "Please enter a valid password", Toast.LENGTH_SHORT).show();
        }
    }else
    {
        Toast.makeText(this, "Please enter a valid User-Name", Toast.LENGTH_SHORT).show();
    }

    }
}






