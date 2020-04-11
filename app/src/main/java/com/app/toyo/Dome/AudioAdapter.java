package com.app.toyo.Dome;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.invoke.ConstantCallSite;
import java.util.List;

public class AudioAdapter extends RecyclerView.Adapter<AudioAdapter.AudioViewHolder> {

   String[] AudioList,AudioNameList;
    Activity MainActivity;
    Context mContext;
    Boolean isPlaying=false;

    public AudioAdapter() {
    }

    public AudioAdapter(String[] AudioList, Activity MainActivity, Context mContext,String[] AudioNameList) {
        this.AudioList = AudioList;
        this.MainActivity = MainActivity;
        this.mContext=mContext;
        this.AudioNameList=AudioNameList;


    }

    @Override
    public AudioViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from( parent.getContext()).inflate(R.layout.audio_view, parent, false);

        return new AudioViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final AudioViewHolder holder, final int position) {
     holder.number.setText(String.valueOf(position+1)+ ")");
     holder.AudioName.setText(AudioNameList[position]);
            holder.mainCont.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((MainActivity) mContext).playAudio(AudioList[position]);

                }
            });



    }


    @Override
    public int getItemCount() {
        return AudioList.length;
    }

    public class AudioViewHolder extends RecyclerView.ViewHolder{
       TextView number,AudioName;
       Button StopBtn;
       ConstraintLayout mainCont;
        public AudioViewHolder(View itemView) {
            super(itemView);
            number = (TextView)itemView.findViewById(R.id.number);
            AudioName = (TextView)itemView.findViewById(R.id.AudioName);
            mainCont=(ConstraintLayout)itemView.findViewById(R.id.mainCont);
            StopBtn = (Button) itemView.findViewById(R.id.StopBtn);
        }
    }
}
