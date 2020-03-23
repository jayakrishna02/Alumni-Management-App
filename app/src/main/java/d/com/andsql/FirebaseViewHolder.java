package d.com.andsql;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class FirebaseViewHolder extends RecyclerView.ViewHolder {
    public TextView email, message;
    public TextView pllname,pllupdate,plldrdate,pllelbranch,pllelyear;
    public ImageView logo;
    public FirebaseViewHolder(@NonNull View itemView) {
        super(itemView);
        email=itemView.findViewById(R.id.repname);
        message=itemView.findViewById(R.id.repp);


        pllname=itemView.findViewById(R.id.ImageNameTextView);
        pllupdate=itemView.findViewById(R.id.uploadeddate);
        plldrdate=itemView.findViewById(R.id.drivedate);
        pllelbranch=itemView.findViewById(R.id.elbranch);
        pllelyear=itemView.findViewById(R.id.passyear);
        logo=itemView.findViewById(R.id.imageView);

    }
}
