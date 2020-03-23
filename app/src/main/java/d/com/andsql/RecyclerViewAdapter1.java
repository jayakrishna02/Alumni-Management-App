package d.com.andsql;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

public class RecyclerViewAdapter1 extends RecyclerView.Adapter<RecyclerViewAdapter1.ViewHolder> {

    Context context;
    List<Report> MainImageUploadInfoList;

    public RecyclerViewAdapter1(Context context, List<Report> TempList) {

        this.MainImageUploadInfoList = TempList;

        this.context = context;
    }
    @Override
    public RecyclerViewAdapter1.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.audioview, parent, false);

        RecyclerViewAdapter1.ViewHolder viewHolder = new RecyclerViewAdapter1.ViewHolder(view);

        return viewHolder;
    }
    @Override
    public void onBindViewHolder(final RecyclerViewAdapter1.ViewHolder holder, final int position) {


        holder.name.setText(MainImageUploadInfoList.get(position).getName());
        holder.mail.setText(MainImageUploadInfoList.get(position).getEmail());
        holder.mLink.setText(MainImageUploadInfoList.get(position).getUrl());
        holder.mDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                downloadfiles(holder.name.getContext(),MainImageUploadInfoList.get(position).getName(),".mp3",DIRECTORY_DOWNLOADS,MainImageUploadInfoList.get(position).getUrl());
            }
        });
        final MediaPlayer mp=new MediaPlayer();
        try{
            //you can change the path, here path is external directory(e.g. sdcard) /Music/maine.mp3
            mp.setDataSource(MainImageUploadInfoList.get(position).getUrl());
            mp.prepare();
        }catch(Exception e){e.printStackTrace();}
        holder.mPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
            }
        });

    }
    public void downloadfiles(Context context, String filename, String fileExtension, String destinationDirectory, String url)
    {
        DownloadManager downloadManager= (DownloadManager) context.getSystemService(context.DOWNLOAD_SERVICE);
        Uri uri= Uri.parse(url);
        DownloadManager.Request request=new DownloadManager.Request(uri);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context,destinationDirectory,filename+fileExtension);
        downloadManager.enqueue(request);
    }



    @Override
    public int getItemCount() {

        return MainImageUploadInfoList.size();
    }
    public void filterlist(ArrayList<Report> filteredlist) {
        MainImageUploadInfoList = filteredlist;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,mail,mLink;
        Button mDownload,mPlay;


        public ViewHolder(View itemView) {
            super(itemView);
            name =  itemView.findViewById(R.id.filename);
            mail =  itemView.findViewById(R.id.filename1);
            mDownload =  itemView.findViewById(R.id.download);
            mPlay =  itemView.findViewById(R.id.play);
            mLink =  itemView.findViewById(R.id.filename11);


        }
    }
}

