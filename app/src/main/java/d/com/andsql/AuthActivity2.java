package d.com.andsql;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import java.util.TimerTask;

public abstract class AuthActivity2 extends AppCompatActivity  {
    public String mes;
    public void getMessage(final String message, final boolean isSuccess) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                mes=message;
                String[] words=mes.split(",");
//                EditText  e1=(EditText)findViewById(R.id.editText);
//                EditText e2=(EditText) findViewById(R.id.editText2);
//                EditText e3=(EditText) findViewById(R.id.editText3);
//                EditText e4=(EditText) findViewById(R.id.editText4);
//                EditText e5=(EditText) findViewById(R.id.editText5);
//                TextView e6 = (TextView)findViewById(R.id.email);


              //  if (e1 != null) {
//                    e1.setText(words[0].toString());
//                    e2.setText(words[1].toString());
//                    e3.setText(words[2].toString());
//                    e4.setText(words[3].toString());
//                    e5.setText(words[4].toString());
//                    e6.setText(words[5].toString());
                    // textView.setText(message);
//                    String[]  array = message.split(",");
//                    for(int i=0;i<array.length;i++){
//                   textView.setText(array[i]);}
             //   }

                new java.util.Timer().schedule(
                        new TimerTask() {
                            @Override
                            public void run() {
                                if (isSuccess) {
                                    // String a=String.valueOf(isSuccess);
                                    // textView.setText(message+a);
                                    onAuthComplete();
                                }
                                else if(isSuccess==false){

                                    onAuthFailed(mes);

                                }
                            }
                        }, 1000
                );
            }
        });
    }

    public  abstract void onAuthComplete();
    protected abstract void onAuthFailed(String mes);
}

