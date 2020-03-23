package d.com.andsql;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Alumnidata extends AppCompatActivity {
TextView t,a,b,c,d;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumnidata);
        getSupportActionBar().setTitle("Alumni Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent i=getIntent();
        String s=i.getStringExtra("value");
        context = getApplicationContext();
        //t=(TextView)findViewById(R.id.Alumnitest);
      // t.setText(s);
        String data[]=s.split(",");
        t=(TextView)findViewById(R.id.editText7);
        t.setText(data[0]);
        a=(TextView)findViewById(R.id.editText9);
        a.setText(data[1]);
        b=(TextView)findViewById(R.id.editText11);
        b.setText(data[2]);
        c=(TextView)findViewById(R.id.editText13);
        c.setText(data[3]);
        d=(TextView)findViewById(R.id.editText15);
        d.setText(data[4]);

    }
}
