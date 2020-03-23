package d.com.andsql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Updatedetails extends AuthActivity {
TextView t,email;
    EditText name,surname,age,usename,password,branch,year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatedetails);
        getSupportActionBar().setTitle("Update Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent i=getIntent();
      String  s=i.getStringExtra("value");
      String type = "user";
       BackgroundWorker backgroundWorker = new BackgroundWorker(this);
       backgroundWorker.execute(type, s);
        name=(EditText)findViewById(R.id.editText);
        surname=(EditText)findViewById(R.id.editText2);
        age=(EditText)findViewById(R.id.editText3);
        usename=(EditText)findViewById(R.id.editText4);
        password=(EditText)findViewById(R.id.editText5);
        email=(TextView)findViewById(R.id.email);
    }
    public void Updatedetails(View view){
        String str_name = name.getText().toString();
        String str_surname = surname.getText().toString();
        String str_age = age.getText().toString();
        String str_username = usename.getText().toString();
        String str_password= password.getText().toString();
        String str_email=email.getText().toString();
        String type = "Updatedetails";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type,str_name,str_surname,str_age,str_username,str_password,str_email);

    }

    @Override
    public void onAuthComplete() {
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    protected void onAuthFailed(String mes) {



            // textView.setText(message);
//                    String[]  array = message.split(",");
//                    for(int i=0;i<array.length;i++){
//                   textView.setText(array[i]);}
        }
//        String[] words=mes.split(",");
//        e1=(EditText)findViewById(R.id.editText);
//        e1.setText(words[0].toString());



    }

