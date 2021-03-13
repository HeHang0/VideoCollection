package com.oohoo.videocollection;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.oohoo.widgets.OnPlayerBackListener;
import com.oohoo.widgets.OnShowThumbnailListener;
import com.oohoo.widgets.PlayStateParams;
import com.oohoo.widgets.PlayerView;
import com.oohoo.widgets.VideoijkBean;

import java.util.ArrayList;
import java.util.List;


public class IJKVideoPlayActivity extends Activity {

    private PlayerView player;
    private Context mContext;
    private View rootView;
    private String title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        Bundle bundle = getIntent().getExtras();
        ArrayList<VideoijkBean> pathList = bundle.getParcelableArrayList("VideoUrls");
        title = bundle.getString("VideoTitle");
        boolean isLive = bundle.getBoolean("VideoLive");
        rootView = getLayoutInflater().from(this).inflate(R.layout.ijkplayer_layout, null);
        setContentView(rootView);
        this.mContext = this;

        player = new PlayerView(this, rootView)
                .setIsLive(isLive)
                .setTitle(title)
                .setScaleType(PlayStateParams.fitparent)
                .forbidTouch(false)
                .hideMenu(false)
                .hideCenterPlayer(true)
                .setShowSpeed(true)
                .hideRotation(true)
                .showThumbnail(new OnShowThumbnailListener() {
                    @Override
                    public void onShowThumbnail(ImageView ivThumbnail) {
                        Glide.with(mContext)
                                .load(R.drawable.ijkplayer_background)
                                //.placeholder(R.color.cl_default)
                                //.error(R.color.cl_error)
                                .into(ivThumbnail);
                    }
                })
                .setPlaySource(pathList)
                .setPlayerBackListener(new OnPlayerBackListener() {
                    @Override
                    public void onPlayerBack() {
                        //这里可以简单播放器点击返回键
                        finish();
                    }
                })
                .startPlay();
    }
    @Override
    protected void onPause() {
        super.onPause();
        if (player != null) {
            player.onPause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (player != null) {
            player.onResume();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (player != null) {
            player.onDestroy();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (player != null) {
            player.onConfigurationChanged(newConfig);
        }
    }

    @Override
    public void onBackPressed() {
//        if (player != null && player.onBackPressed()) {
//            return;
//        }
        exit();
//        super.onBackPressed();
    }

    private static boolean isExit = false;    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };
    public void exit() {
        if (!isExit) {
            isExit = true;
            Toast.makeText(getApplicationContext(), "再按一次退出播放",
                    Toast.LENGTH_SHORT).show();
            // 利用handler延迟发送更改状态信息
            handler.sendMessageDelayed(new Message(), 2000);
        } else {
            super.onBackPressed();
//            onDestroy();
//            finish();
        }
    }
}
