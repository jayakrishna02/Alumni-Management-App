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

public class RecyclerViewAdapter2 extends RecyclerView.Adapter<RecyclerViewAdapter2.ViewHolder>{
    Context context;
    List<Contact> MainImageUploadInfoList;
    public RecyclerViewAdapter2(Context context, List<Contact> TempList) {

        this.MainImageUploadInfoList = TempList;

        this.context = context;
    }

    @Override
    public RecyclerViewAdapter2.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery, parent, false);

        RecyclerViewAdapter2.ViewHolder viewHolder = new RecyclerViewAdapter2.ViewHolder(view);

        return viewHolder;
    }
    @Override
    public void onBindViewHolder(RecyclerViewAdapter2.ViewHolder holder, int position) {
        Contact UploadInfo = MainImageUploadInfoList.get(position);
        Glide.with(context).load(UploadInfo.getProfileurl()).into(holder.de);


        //Loading image from Glide library.

    }

    @Override
    public int getItemCount() {

        return MainImageUploadInfoList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView de;

        public ViewHolder(View itemView) {
            super(itemView);
            de = (ImageView) itemView.findViewById(R.id.g111);
        }
    }
}
