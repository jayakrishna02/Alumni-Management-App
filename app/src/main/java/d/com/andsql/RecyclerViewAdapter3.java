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

public class RecyclerViewAdapter3 extends RecyclerView.Adapter<RecyclerViewAdapter3.ViewHolder>{
    Context context;
    List<Contact1> MainImageUploadInfoList;
    public RecyclerViewAdapter3(Context context, List<Contact1> TempList) {

        this.MainImageUploadInfoList = TempList;

        this.context = context;
    }

    @Override
    public RecyclerViewAdapter3.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_contact, parent, false);

        RecyclerViewAdapter3.ViewHolder viewHolder = new RecyclerViewAdapter3.ViewHolder(view);

        return viewHolder;
    }
    @Override
    public void onBindViewHolder(RecyclerViewAdapter3.ViewHolder holder, int position) {
        Contact1 UploadInfo = MainImageUploadInfoList.get(position);

        holder.coname.setText(UploadInfo.getName1());
        holder.cophone.setText(UploadInfo.getPhone1());
        holder.coemail.setText(UploadInfo.getEmail1());
        holder.codesign.setText(UploadInfo.getDesignation());
        Glide.with(context).load(UploadInfo.getProfileurl()).into(holder.de);


        //Loading image from Glide library.

    }

    @Override
    public int getItemCount() {

        return MainImageUploadInfoList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView de;
        public TextView coname,cophone,coemail,codesign;

        public ViewHolder(View itemView) {
            super(itemView);
            coname = (TextView) itemView.findViewById(R.id.rename);
            cophone=itemView.findViewById(R.id.rephone);
            coemail=itemView.findViewById(R.id.reemail);
            codesign=itemView.findViewById(R.id.redesign);
            de = (ImageView) itemView.findViewById(R.id.reimage);
        }
    }
}
