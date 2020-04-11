package com.app.toyo.Dome;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Settings extends AppCompatActivity {
private Button button;
TextView Login,username,logout,Report,About;

String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Login=(TextView)findViewById(R.id.Login);
        username=(TextView)findViewById(R.id.username);
        logout=(TextView)findViewById(R.id.logout);
        Report=(TextView)findViewById(R.id.Report);
        About = (TextView) findViewById(R.id.About);
        Intent i=getIntent();
        name=i.getStringExtra("name");

        if(name!=null )
        {
            Login.setVisibility(View.GONE);
            username.setText(name);
            logout.setVisibility(View.VISIBLE);

        }else
        {
            logout.setVisibility(View.GONE);
            Login.setVisibility(View.VISIBLE);
        }
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Settings.this,login.class);
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), name +" Logout", Toast.LENGTH_LONG).show();
                Intent intent =new Intent(Settings.this,login.class);
                startActivity(intent);
                finishAffinity();
            }
        });


        About.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Settings.this,About.class );
                startActivity(intent);
            }
        });


        Report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ "akshitsharma.09@gmail.com"});
                email.putExtra(Intent.EXTRA_SUBJECT, "Report");
                email.putExtra(Intent.EXTRA_TEXT, "");

                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));
            }
        });
    }
}
