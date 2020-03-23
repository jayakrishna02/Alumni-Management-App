package d.com.andsql;

import android.app.ActionBar;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class HomePage1 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    TextView t;
    public String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page1);

      //  getSupportActionBar().setTitle("HOME");
//        getSupportActionBar().setBackgroundDrawable(
//                new ColorDrawable(Color.parseColor("#b36b00")));
        Intent i=getIntent();
       s=i.getStringExtra("value");

//        t=(TextView)findViewById(R.id.text5);
//        t.setText(s);


        TextView txt = findViewById(R.id.marquee1);
        txt.setSelected(true);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

//    @Override
//    public void onBackPressed() {
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_page1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(this,MainActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


//       if (id == R.id.nav_home){
//            startActivity(new Intent(this, HomePage1.class));
//      } else
        if (id == R.id.nav_alumini) {
            startActivity(new Intent(this,Aluminipage2.class));
        }

         else if (id == R.id.nav_aluminiupdate) {
           // startActivity(new Intent(this,Updatedetails.class));
            Intent i=new Intent(getApplicationContext(),Updatedetails.class);
            i.putExtra("value",s);
            startActivity(i);
        }

       else if (id == R.id.nav_gallery) {
            startActivity(new Intent(this, ViewGallery.class));
     }
     else if (id == R.id.nav_place) {
            startActivity(new Intent(this,Placements.class  ));
      }
      else if (id == R.id.nav_notifications) {
            String date= new SimpleDateFormat("YYYY-MM-dd", Locale.getDefault()).format(new Date());
            //Toast.makeText(getApplicationContext(),date,Toast.LENGTH_SHORT).show();
            Intent i=new Intent(this,Notifications.class);
            i.putExtra("value",date);
            startActivity(i);
            //startActivity(new Intent(this, RecordActivity.class));

        }
        else if (id == R.id.nav_suggest) {
            startActivity(new Intent(this, RecordActivity.class));

        }
        else if (id == R.id.nav_enterprenuer) {
            startActivity(new Intent(this, Enterprenuer.class));

        }
        else if (id == R.id.nav_achievement) {
            startActivity(new Intent(this, ViewContacts.class));

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Really Exit?")
                .setMessage("Are you sure you want to Logout?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        HomePage1.super.onBackPressed();
                    }
                }).create().show();
    }
}
