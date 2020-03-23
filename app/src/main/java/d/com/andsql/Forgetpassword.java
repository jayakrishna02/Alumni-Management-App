package d.com.andsql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Forgetpassword extends AuthActivity {
    EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpassword);
        email=(EditText)findViewById(R.id.email);

    }
    public void pass(View view){
        String emai=email.getText().toString();
        String type = "forgetpassword";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type,emai);

    }
    @Override
    public void onAuthComplete() {
        // on register complete this method is called
        startActivity(new Intent(this,Mainpage.class));

    }

    @Override
    protected void onAuthFailed(String mes) {

    }
}
