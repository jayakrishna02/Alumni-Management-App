package d.com.andsql;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context context;
    List<ImageUploadInfo> MainImageUploadInfoList;

    public RecyclerViewAdapter(Context context, List<ImageUploadInfo> TempList) {

        this.MainImageUploadInfoList = TempList;

        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_items, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ImageUploadInfo UploadInfo = MainImageUploadInfoList.get(position);

        holder.imageNameTextView.setText(UploadInfo.getImageName());
        Glide.with(context).load(UploadInfo.getImageURL()).into(holder.imageView);
        holder.pllupdate.setText(UploadInfo.getUploadtime());
        holder.plldrdate.setText(UploadInfo.getDrivedate());
        holder.pllelbranch.setText(UploadInfo.getEligiblebranch());
        holder.pllelyear.setText(UploadInfo.getEligibleyear());



        //Loading image from Glide library.

    }

    @Override
    public int getItemCount() {

        return MainImageUploadInfoList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView imageNameTextView,pllname,pllupdate,plldrdate,pllelbranch,pllelyear;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            imageNameTextView = (TextView) itemView.findViewById(R.id.ImageNameTextView);
//            pllname=itemView.findViewById(R.id.companyname);
            pllupdate=itemView.findViewById(R.id.uploadeddate);
            plldrdate=itemView.findViewById(R.id.drivedate);
            pllelbranch=itemView.findViewById(R.id.elbranch);
            pllelyear=itemView.findViewById(R.id.passyear);
        }
    }
}