package com.app.toyo.Dome;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView,recyclerViewAudio;
    Vector<YouTubeVideos> youtubeVideos = new Vector<YouTubeVideos>();
    String[] Audio= new String[10];
    String[] AudioName= new String[10];
    ImageView settings;
    String name;
    FloatingActionButton item2,item1,item3;
    ConstraintLayout mainCont;
    Boolean login_success,Audio_View=false,Video_View=true;
    FloatingActionMenu floatingActionMenu;
    AudioAdapter audioAdapter;
    MediaPlayer mPlayer;
    Button StopBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        item1 =(FloatingActionButton) findViewById(R.id.item1);
        item2 =(FloatingActionButton) findViewById(R.id.item2);
        item3 =(FloatingActionButton) findViewById(R.id.item3);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerViewAudio = (RecyclerView) findViewById(R.id.recyclerViewAudio);
        floatingActionMenu=(FloatingActionMenu)findViewById(R.id.floatingActionMenu);
        settings=(ImageView)findViewById(R.id.settings);
        StopBtn=(Button)findViewById(R.id.StopBtn);
        mainCont= (ConstraintLayout) findViewById(R.id.mainCont);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));
        recyclerViewAudio.setHasFixedSize(true);
        recyclerViewAudio.setLayoutManager( new LinearLayoutManager(this));
        mPlayer = new MediaPlayer();
        Intent i = getIntent();
        name = i.getStringExtra("name");
        if(name!=null && !name.isEmpty() && !name.equals(""))
        {
            floatingActionMenu.setVisibility(View.VISIBLE);
        }else
        {
            floatingActionMenu.setVisibility(View.GONE);
        }

        login_success = i.getBooleanExtra("Login_success",false);
        if (login_success)
        {
            Toast.makeText(this, name +"Login SuccessFull", Toast.LENGTH_LONG).show();
        }

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this,Settings.class);
                i.putExtra("name" ,name);
                startActivity(i);
            }

        });
        item2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              floatingActionMenu.close(true);
                Audio_View=false;
                Video_View=true;
                switcher();
            }

        });
        item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }

        });
        item3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                floatingActionMenu.close(true);
                Audio_View=true;
                Video_View=false;
                switcher();
            }

        });
        youtubeVideos.add( new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/S3vw81mV64g\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/hQ6E1TkfzKA\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/GJQsT-h0FTU\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/Vq89rXhvmN8\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/jMM2Iv9N2PQ\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/HTAFyTYM8sI\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/wrMM5ArhBsA\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/_j1SHpXT_5E\" frameborder=\"0\" allowfullscreen></iframe>") );

        youtubeVideos.add( new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/0WKSuzNtKiE\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/fksfvrrBm-4\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/83WcbBXsluE\" frameborder=\"0\" allowfullscreen></iframe>") );

        youtubeVideos.add( new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/lWtEin3-ryE\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/ZQPm2CjejVg\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/2VeYkS6FfM8\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/ebsS9tEi5zc\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/jhkfExFG2B8\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/hMy5za-m5Ew\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/tLqtnGLfm4Q\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/ggISrFwe3KE\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/SLD9xzJ4oeU\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/YRAImdAcl5g\" frameborder=\"0\" allowfullscreen></iframe>") );

        Audio[0]= "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3";
        Audio[1]= "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-2.mp3";
        Audio[2]= "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-3.mp3";
        Audio[3]= "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-4.mp3";
        Audio[4]= "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-5.mp3";
        Audio[5]= "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-6.mp3";
        Audio[6]= "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-7.mp3";
        Audio[7]= "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-8.mp3";
        Audio[8]= "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-9.mp3";
        Audio[9]= "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-10.mp3";

        AudioName[0]= "Audio 1";
        AudioName[1]= "Audio 2";
        AudioName[2]= "Audio 3";
        AudioName[3]= "Audio 4";
        AudioName[4]= "Audio 5";
        AudioName[5]= "Audio 6";
        AudioName[6]= "Audio 7";
        AudioName[7]= "Audio 8";
        AudioName[8]= "Audio 9";
        AudioName[9]= "Audio 10";




        VideoAdapter videoAdapter = new VideoAdapter(youtubeVideos,MainActivity.this);
        recyclerView.setAdapter(videoAdapter);
        audioAdapter = new AudioAdapter(Audio,MainActivity.this,MainActivity.this,AudioName);
        recyclerViewAudio.setAdapter(audioAdapter);
    }


    public void switcher()
    {
        if(Video_View)
        {
            recyclerView.setVisibility(View.VISIBLE);
            recyclerViewAudio.setVisibility(View.GONE);
            StopBtn.setVisibility(View.GONE);
        }else
        {
            recyclerViewAudio.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
            StopBtn.setVisibility(View.GONE);
        }
    }

    public void playAudio(String url)
    {
        String AudioUrl = url;
            mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            try{
                mPlayer.setDataSource(AudioUrl);
                mPlayer.prepare();
                mPlayer.start();

                // Inform user for audio streaming
                Toast.makeText(this,"Playing",Toast.LENGTH_SHORT).show();
            }catch (IOException e){
                // Catch the exception
                e.printStackTrace();
            }catch (IllegalArgumentException e){
                e.printStackTrace();
            }catch (SecurityException e){
                e.printStackTrace();
            }catch (IllegalStateException e){
                e.printStackTrace();
            }
            mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    Toast.makeText(MainActivity.this,"End",Toast.LENGTH_SHORT).show();
                    mPlayer.stop();
                    mPlayer.reset();
                }
            });
            StopBtn.setVisibility(View.VISIBLE);
            StopBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    StopBtn.setVisibility(View.GONE);
                    stopMedia();
                }
            });
        }


   public void stopMedia()
   {
       mPlayer.stop();
       mPlayer.reset();
   }
    }

