package d.com.andsql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Aluminipage2 extends AuthActivity {

    EditText branch;
    EditText year;
    Button check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluminipage2);
        getSupportActionBar().setTitle("Alumni Search");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        branch = (EditText)findViewById(R.id.editText7);
        year = (EditText)findViewById(R.id.editText8);



    }
    public void Alumsearch(View view){

        String username = branch.getText().toString();
        String password = year.getText().toString();
        String type = "Alumni";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, username, password);


    }

    @Override
    public void onAuthComplete() {

    }

    @Override
    protected void onAuthFailed(String mes) {
        Intent i=new Intent(getApplicationContext(),Alumnidetails.class);
        i.putExtra("value",mes);
        startActivity(i);

    }
}
