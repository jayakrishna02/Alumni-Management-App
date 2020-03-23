package d.com.andsql;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Notifications extends AuthActivity2 {
    private ProgressDialog progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        getSupportActionBar().setTitle("Notifications");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent i=getIntent();
        String date=i.getStringExtra("value");
        String a[]=date.split("-");
        String day=a[2];
        String mon=a[1];
        String type = "Notifications";
        BackgroundRunning backgroundRunning=new BackgroundRunning(this);
        backgroundRunning.execute(type,day,mon);
        progress = new ProgressDialog(this);
        progress.setMessage("Retriving Details..");
        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progress.setIndeterminate(true);
        progress.setProgress(0);
        progress.show();

        final int totalProgressTime = 100;
        final Thread t = new Thread() {
            @Override
            public void run() {
                int jumpTime = 0;

                while(jumpTime < totalProgressTime) {
                    try {
                        sleep(200);
                        jumpTime += 5;
                        progress.setProgress(jumpTime);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();
    }
        //Toast.makeText(getApplicationContext(),a[1],Toast.LENGTH_SHORT).show();


    @Override
    public void onAuthComplete() {

    }

    @Override
    protected void onAuthFailed(String mes) {
        Intent i=new Intent(getApplicationContext(),Birthdaydetails.class);
        i.putExtra("value",mes);
        startActivity(i);


    }
}
