package d.com.andsql;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Showbirthday extends AuthActivity2 {

    TextView t,a,b,c,d;
    Context context;
    EditText wish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showbirthday);
        getSupportActionBar().setTitle("Send Wishes");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent i=getIntent();
        String s=i.getStringExtra("value");
        context = getApplicationContext();
        //t=(TextView)findViewById(R.id.Alumnitest);
        // t.setText(s);
        String data[]=s.split(",");
        t=(TextView)findViewById(R.id.first_name);
        t.setText(data[0]);
        a=(TextView)findViewById(R.id.last_name);
        a.setText(data[1]);
        b=(TextView)findViewById(R.id.birthday);
        b.setText(data[2]);
        c=(TextView)findViewById(R.id.e_mail);
        c.setText(data[3]);
        wish=(EditText)findViewById(R.id.wish);

    }
    public void Send(View view){

        String str_email = c.getText().toString();
        String str_wish= wish.getText().toString();

        String type = "SendWishes";
       // Toast.makeText(getApplicationContext(),str_name,Toast.LENGTH_LONG).show();
        BackgroundRunning backgroundRunning=new BackgroundRunning(this);
        backgroundRunning.execute(type,str_email,str_wish);
    }

    @Override
    public void onAuthComplete() {

    }

    @Override

    protected void onAuthFailed(String mes) {

    }
}
