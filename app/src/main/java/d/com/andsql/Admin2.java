package d.com.andsql;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Admin2 extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList< Report> downloadArrayList=new ArrayList<>();
    RecyclerViewAdapter1 myAdapter;
    ProgressDialog progressDialog;
    DatabaseReference databaseReference;
    ArrayList<String> names;
    EditText sea;
    Button bb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin2);
//        searchbar=findViewById(R.id.search);
        // bb=findViewById(R.id.sse);
        //sea=findViewById(R.id.search);
        EditText editText = findViewById(R.id.edittext);
        TextView textView=findViewById(R.id.res);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });
        progressDialog = new ProgressDialog(Admin2.this);
        progressDialog.setMessage("Loading Audio From Firebase.");
        progressDialog.show();
        setUpRV();
        setUpFB();
        dataFromFirebase();
    }


    private void dataFromFirebase() {

        if (downloadArrayList.size()>0)
        {
            downloadArrayList.clear();
        }
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                names=new ArrayList<String>();
                for (DataSnapshot post:dataSnapshot.getChildren())
                {
                    Report upload=post.getValue(Report.class);
                    downloadArrayList.add(upload);
                    names.add(post.getValue().toString());

                }
                myAdapter=new RecyclerViewAdapter1(Admin2.this,downloadArrayList);
                recyclerView.setAdapter(myAdapter);
                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                progressDialog.dismiss();
            }
        });
//        db.collection("audio").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                for (DocumentSnapshot documentSnapshot:task.getResult())
//                {
//                    Record record=new Record(documentSnapshot.getString("name"),documentSnapshot.getString("url"));
//                    downloadArrayList.add(record);
//
//                }
//                myAdapter=new MyAdapter(Admin.this,downloadArrayList);
//                recyclerView.setAdapter(myAdapter);
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Toast.makeText(getApplicationContext(),"Error..",Toast.LENGTH_LONG).show();
//            }
//        });

    }

    private void setUpFB() {
        databaseReference= FirebaseDatabase.getInstance().getReference().child("Suggest_Audio");
        databaseReference.keepSynced(true);
    }

    private void setUpRV() {
        recyclerView=findViewById(R.id.audiorecy);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(Admin2.this));
    }
    public void filter(String text) {
        ArrayList<Report> filteredlist = new ArrayList<>();

        for (Report item : downloadArrayList) {
            if(item.getName().toLowerCase().contains(text.toLowerCase())) {
                filteredlist.add(item);
            }
        }

        myAdapter.filterlist(filteredlist);
    }

}
