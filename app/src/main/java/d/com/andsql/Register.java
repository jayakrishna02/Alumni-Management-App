package d.com.andsql;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Register extends AuthActivity {
        EditText name,surname,age,usename,password,email,branch,year;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setTitle("Register");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        name=(EditText)findViewById(R.id.editText);
        surname=(EditText)findViewById(R.id.editText2);
        age=(EditText)findViewById(R.id.editText3);
        usename=(EditText)findViewById(R.id.editText4);
        password=(EditText)findViewById(R.id.editText5);
        email=(EditText)findViewById(R.id.email);
        branch=(EditText)findViewById(R.id.branch);
        year=(EditText)findViewById(R.id.year);
    }
    public void OnReg(View view){
        String str_name = name.getText().toString();
        String str_surname = surname.getText().toString();
        String str_age = age.getText().toString();
        String str_username = usename.getText().toString();
        String str_password= password.getText().toString();
        String str_email=email.getText().toString();
        String str_branch=branch.getText().toString();
        String str_year=year.getText().toString();

        String type = "register";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type,str_name,str_surname,str_age,str_username,str_password,str_email,str_branch,str_year);

    }
    public void Loginpage(View view) {
        startActivity(new Intent(this,MainActivity.class));
    }
    public void OpenReg(View view) {
    }

    @Override
    public void onAuthComplete() {
        // on register complete this method is called
        startActivity(new Intent(this,Mainpage.class));

    }

    @Override
    protected void onAuthFailed(String mes) {

    }
}
