package d.com.andsql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Birthdaydetails extends AuthActivity2 {
    TextView t;
    ListView listView;
    TextView textView;
    public String a;
    int j = 0, i = 0;
    public  int z;
   public ArrayList<String> words = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthdaydetails);
        Intent i = getIntent();
        String s = i.getStringExtra("value");

        String festivals[] = s.split(",");
        // Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();

        while (j < festivals.length) {
            String b = festivals[j];
            j++;
            b = b + " " + festivals[j];

            words.add(b);

            // Toast.makeText(getApplicationContext(), b, Toast.LENGTH_SHORT).show();
            j=j+2;
        }

        listView = (ListView) findViewById(R.id.listVie);
        textView = (TextView) findViewById(R.id.textView);

        final ArrayAdapter adapter = new ArrayAdapter(this,
                R.layout.list_view, R.id.textView, words);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // TODO Auto-generated method stub

                /* appending Happy with festival name */
                Object value = adapter.getItem(position);

               // Toast.makeText(getApplicationContext(), no, Toast.LENGTH_SHORT).show();
                /* Display the Toast */
                a = value.toString();
                onCheck(a);
            }


        });
    }

    public void onCheck(String a) {
        String type = "Alumnicheck";
        String data[] = a.split(" ");

        String firstname = data[0];
        String lastname = data[1];


//        for (z=0;z<words.length();z++){
//
//        }
       // Toast.makeText(getApplicationContext(), z, Toast.LENGTH_SHORT).show();

      BackgroundRunning backgroundWorker = new BackgroundRunning(this);
        backgroundWorker.execute(type, firstname, lastname);
    }

    @Override
    public void onAuthComplete() {

    }

    @Override
    protected void onAuthFailed(String mes) {
        Intent i = new Intent(getApplicationContext(), Showbirthday.class);
        i.putExtra("value", mes);
        startActivity(i);

    }
}