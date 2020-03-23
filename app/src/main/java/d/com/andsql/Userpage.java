package d.com.andsql;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class Userpage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userpage);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView=findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
//        if (savedInstanceState==null){
//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new U()).commit();
       navigationView.setCheckedItem(R.id.nav_home);}
//
//    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_home:
                startActivity(new Intent(this,HomePage1.class));
                break;
            case R.id.nav_alumini:
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Aluminipage()).commit();
                startActivity(new Intent(this,Aluminipage2.class));
                break;
            case R.id.nav_aluminiupdate:
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Aluminipage()).commit();
                startActivity(new Intent(this,Updatedetails.class));
                break;

            case R.id.nav_gallery:
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Gallerypage()).commit();
                startActivity(new Intent(this,Gallerypage.class));
                break;
            case R.id.nav_place:
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Gallerypage()).commit();
                startActivity(new Intent(this,Placement.class  ));
                break;
            case R.id.nav_notifications:
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Aluminipage()).commit();
                startActivity(new Intent(this,Notifications.class));
                break;
            case R.id.nav_suggest:
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Aluminipage()).commit();
                startActivity(new Intent(this,AddEnterprenuer.class));
                break;
            case R.id.nav_enterprenuer:
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Aluminipage()).commit();
                startActivity(new Intent(this,Enterprenuer.class));
                break;
            case R.id.nav_achievement:
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Aluminipage()).commit();
                startActivity(new Intent(this,Achievements.class));
                break;

            case R.id.nav_logout:
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Aluminipage()).commit();
                startActivity(new Intent(this,MainActivity.class));
                finish();

                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
