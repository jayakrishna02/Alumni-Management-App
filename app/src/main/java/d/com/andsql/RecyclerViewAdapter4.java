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

public class RecyclerViewAdapter4 extends RecyclerView.Adapter<RecyclerViewAdapter4.ViewHolder> {
    Context context;
    List<Enterpr> MainImageUploadInfoList;

    public RecyclerViewAdapter4(Context context, List<Enterpr> TempList) {

        this.MainImageUploadInfoList = TempList;

        this.context = context;
    }
    @Override
    public RecyclerViewAdapter4.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_contact, parent, false);

        RecyclerViewAdapter4.ViewHolder viewHolder = new RecyclerViewAdapter4.ViewHolder(view);

        return viewHolder;
    }
    @Override
    public void onBindViewHolder(RecyclerViewAdapter4.ViewHolder holder, int position) {
        Enterpr UploadInfo = MainImageUploadInfoList.get(position);
        Glide.with(context).load(UploadInfo.getEnurl()).into(holder.de);
        holder.coname.setText(UploadInfo.getEnname());
        holder.cophone.setText(UploadInfo.getEnbatch());
        holder.coemail.setText(UploadInfo.getEndep());
        holder.codesign.setText(UploadInfo.getEnpos());

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
