package d.com.andsql;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Achievements extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);
        getSupportActionBar().setTitle("Achievements");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
