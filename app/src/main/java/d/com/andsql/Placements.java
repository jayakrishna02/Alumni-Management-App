package d.com.andsql;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Placements extends AppCompatActivity {
    RecyclerView recyclerView;
    private ArrayList<Placement> arrayList;
    List<ImageUploadInfo> list = new ArrayList<>();
    FirebaseRecyclerOptions<Placement> options;
    FirebaseRecyclerAdapter<Placement,FirebaseViewHolder> adapter;
    DatabaseReference databaseReference;
    DatabaseReference databaseReference11;
    ProgressDialog progressDialog;
    RecyclerView.Adapter adapter11 ;
    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placements);
        recyclerView=findViewById(R.id.plrecy);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Placements Details");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        progressDialog = new ProgressDialog(Placements.this);
        progressDialog.setMessage("Loading Images From Firebase.");
        progressDialog.show();
        arrayList=new ArrayList<Placement>();
        databaseReference= FirebaseDatabase.getInstance().getReference().child("Placements");
        databaseReference11 = FirebaseDatabase.getInstance().getReference(AddPlacement.Database_Path);
        databaseReference.keepSynced(true);
        databaseReference11.keepSynced(true);
        options=new FirebaseRecyclerOptions.Builder<Placement>().setQuery(databaseReference,Placement.class).build();
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("MyNotifications", "MyNotifications", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
//        FirebaseMessaging.getInstance().subscribeToTopic("Placements").addOnCompleteListener(new OnCompleteListener<Void>() {
//
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//                String msg ="Successful";
//                if (!task.isSuccessful()) {
//                    msg="Failed";
//                }
//                Toast.makeText(PlacementDetails.this, msg, Toast.LENGTH_SHORT).show();
//            }
//        });
        databaseReference11.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                for (DataSnapshot postSnapshot : snapshot.getChildren()) {

                    ImageUploadInfo imageUploadInfo = postSnapshot.getValue(ImageUploadInfo.class);

                    list.add(imageUploadInfo);
                }

                adapter11 = new RecyclerViewAdapter(getApplicationContext(), list);

                recyclerView.setAdapter(adapter11);

                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                // Hiding the progress dialog.
                progressDialog.dismiss();

            }
        });

        adapter=new FirebaseRecyclerAdapter<Placement, FirebaseViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull FirebaseViewHolder holder, int position, @NonNull Placement model) {
                holder.pllname.setText(model.getCompanyname());
                holder.pllupdate.setText(model.getUploadtime());
                holder.plldrdate.setText(model.getDrivedate());
                holder.pllelbranch.setText(model.getEligiblebranch());
                holder.pllelyear.setText(model.getEligibleyear());

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    }
                });
            }

            @NonNull
            @Override
            public FirebaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                return new FirebaseViewHolder(LayoutInflater.from(Placements.this).inflate(R.layout.list_placement,viewGroup,false));
            }
        };
        recyclerView.setAdapter(adapter);


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
