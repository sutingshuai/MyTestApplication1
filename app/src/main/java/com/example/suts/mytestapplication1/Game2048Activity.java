package com.example.suts.mytestapplication1;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.suts.mytestapplication1.myviews.game2048.GameView;
import com.example.suts.mytestapplication1.myviews.game2048.ListDemo;
import com.example.suts.mytestapplication1.myviews.game2048.MyAdapter;

import java.util.ArrayList;

public class Game2048Activity extends BaseActivity {

    private TextView tvScore;
    private int score;
    private GameView game;
    private MediaPlayer mediaPlayer;
    private ListView listView;
    public Game2048Activity() {
        mainActivity = this;
    }

    public static Game2048Activity getMainActivity() {
        return mainActivity;
    }

    private static Game2048Activity mainActivity = null;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_game2048);

        listView = (ListView) findViewById(R.id.listview);
        ArrayList<ListDemo> arrayList = new ArrayList<>();
        for (int i = 0;i < 50; i++) {
            ListDemo listDemo = new ListDemo(R.mipmap.ic_launcher,"岳文亮" + i,"你可牛逼了"+i);

            arrayList.add(listDemo);
        }
        listView.setAdapter(new MyAdapter(getBaseContext(),arrayList));



        tvScore = (TextView) findViewById(R.id.tvScore);
        game = (GameView) findViewById(R.id.gameView);

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("小鬼，开始游戏不！！！");
        dialog.setPositiveButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                System.exit(0);
            }
        }).setNegativeButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                StopMusic();
                Toast.makeText(Game2048Activity.this, "长按苹果继续播放", Toast.LENGTH_LONG).show();
            }
        });

        dialog.create().show();
        ImageView img = (ImageView) findViewById(R.id.img);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StopMusic();
                Toast.makeText(Game2048Activity.this, "长按苹果继续播放", Toast.LENGTH_LONG).show();
            }
        });
        img.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                OpenMusic();
                return true;
            }
        });

    }
    //记分的实现
    public void clearScore() {
        score = 0;
        showScore();
    }
    public void showScore() {
        tvScore.setText(score + "");
    }

    public void addScore(int s) {
        score += s;


        showScore();
    }

    public void OpenMusic() {

        mediaPlayer = MediaPlayer.create(this, R.raw.run);
        mediaPlayer.start();
        Toast.makeText(Game2048Activity.this, "暂停播放请按苹果", Toast.LENGTH_LONG).show();
        Toast.makeText(Game2048Activity.this, "暂停播放请按苹果", Toast.LENGTH_LONG).show();
    }

    public void StopMusic() {
        mediaPlayer.pause();
    }

    public void GameMusic() {
        MediaPlayer mediaPlayer1 = MediaPlayer.create(this, R.raw.ooo);
        mediaPlayer1.start();
    }
}

