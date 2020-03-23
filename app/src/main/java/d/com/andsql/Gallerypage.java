package d.com.andsql;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Gallerypage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallerypage);
        getSupportActionBar().setTitle("Gallery");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
