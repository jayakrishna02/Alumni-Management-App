package d.com.andsql;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AuthActivity {
    EditText UsernameEt;
    public String a;
    EditText PasswordEt;

    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        UsernameEt = (EditText)findViewById(R.id.etUserName);
        PasswordEt = (EditText)findViewById(R.id.etPassword);

    }
    public void OnLogin(View view) {
        String username = UsernameEt.getText().toString();
        String password = PasswordEt.getText().toString();
        if(username.equals("admin") && password.equals("admin")){
            Intent i=new Intent(getApplicationContext(),Admin.class);
            i.putExtra("value",a);
            startActivity(i);
        }
        else {
            String type = "login";
            a = username;
            BackgroundWorker backgroundWorker = new BackgroundWorker(this);
            backgroundWorker.execute(type, username, password);
        }
    }

    public void openRegister(View view){

        startActivity(new Intent(this,Register.class));
    }
    public void forget(View view){

        startActivity(new Intent(this,Forgetpassword.class));
    }

    @Override
    public void onAuthComplete() {
        // on login complete, perform this
        Intent i=new Intent(getApplicationContext(),HomePage1.class);
        i.putExtra("value",a);
        startActivity(i);
//        Toast.makeText(getApplicationContext(),a,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onAuthFailed(String mes) {

    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Really Exit?")
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        MainActivity.super.onBackPressed();
                    }
                }).create().show();
    }
}
