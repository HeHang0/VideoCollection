package com.oohoo.videocollection;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Insets;
import android.media.AudioManager;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.google.android.material.navigation.NavigationView;
import com.oohoo.videoapi.analysis.BaseAnalyze;
import com.oohoo.videoapi.analysis.BilibiliAnalyze;
import com.oohoo.videoapi.analysis.CloudMusicAnalyze;
import com.oohoo.videoapi.analysis.DouBanTop250Analyze;
import com.oohoo.videoapi.analysis.IQiYiAnalyze;
import com.oohoo.videoapi.analysis.LiveAnalyze;
import com.oohoo.videoapi.analysis.LiveConst;
import com.oohoo.videoapi.analysis.QQLiveAnalyze;
import com.oohoo.videoapi.analysis.YouKuAnalyze;
import com.oohoo.videoapi.analysis.YouTubeAnalyze;
import com.oohoo.videoapi.util.AnalysisUtils;
import com.oohoo.videoapi.util.Tools;
import com.oohoo.videoapi.video.NetVideo;
import com.oohoo.videoapi.video.VideoUrlItem;
import com.oohoo.widgets.MyListAdapter;
import com.oohoo.widgets.VideoijkBean;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;


public class MainActivity extends AppCompatActivity {

    private final List<NetVideo> netVideoList = new ArrayList<>();
    private final Map<String, BaseAnalyze> analyzeMap = new HashMap<>();
    private final List<String> analyzeList = new ArrayList<>();
    private SharedPreferences localSP;
    private Toolbar toolbar;
    private View currentView;
    private TextView searchText;
    private ListView videoListView;
    private String searchStr = "";
    private NetVideo netVideo;
    private SoundPool mSoundPoll;
    private int mLastSoundPollId = -1;
    private int mSound404Id;
    private boolean isPlayVideoInBrowser = false;
    private BaseAnalyze analyzeSelected = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnalysisUtils.setContext(getApplicationContext());
        localSP = getSharedPreferences("video_collection_config_info", Context.MODE_PRIVATE);
        setStatusBarTransparent();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        initWelcomeBefore();
        initWelcome();
    }

    public int getScreenHeight() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            WindowMetrics windowMetrics = getWindowManager().getCurrentWindowMetrics();
            Insets insets = windowMetrics.getWindowInsets()
                    .getInsetsIgnoringVisibility(WindowInsets.Type.systemBars());
            return windowMetrics.getBounds().height() - insets.top - insets.bottom;
        } else {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.heightPixels;
        }
    }

    private void initWelcomeBefore() {
        int height = getScreenHeight()/6;

        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator animatorLogo = ObjectAnimator.ofFloat(findViewById(R.id.welcome_before_logo),
                "translationY", -height);
        ObjectAnimator animatorLayout = ObjectAnimator.ofFloat(findViewById(R.id.welcome_layout),
                "alpha", 1);
        animatorSet.play(animatorLogo).with(animatorLayout);
        animatorSet.setDuration(1500).addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                initWelcome();
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                findViewById(R.id.welcome_before_layout).setVisibility(View.GONE);
                findViewById(R.id.welcome_layout_logo).setVisibility(View.VISIBLE);
                findViewById(R.id.drawer_layout).setBackgroundColor(getResources().getColor(R.color.white));
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animatorSet.start();
    }

    private void initWelcome() {
        TextView welcome = findViewById(R.id.welcome_btn);
        welcome.setOnClickListener(v -> findViewById(R.id.welcome_layout).animate()
                .alpha(0)
                .setDuration(800)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        initMainView();
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        findViewById(R.id.welcome_layout).setVisibility(View.GONE);
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                }));
    }

    private void initMainView() {
        initLiveChannel();
        initSoundPool();
        initAnalysis();
        initView();
        initNavigation();
    }

    @SuppressLint("ClickableViewAccessibility")
    private void initView() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        CoordinatorLayout coordinatorLayout = drawer.findViewById(R.id.screen_main);
        coordinatorLayout.setVisibility(View.VISIBLE);

        LayoutInflater mInflater = LayoutInflater.from(this);
        mInflater.inflate(R.layout.video_list, coordinatorLayout);
        currentView = findViewById(R.id.video_list_layout);

        searchText = currentView.findViewById(R.id.search_text);
        videoListView = currentView.findViewById(R.id.video_list);
        searchText.setOnEditorActionListener(onSearchTextAction);


        MyListAdapter adapter = new MyListAdapter(MainActivity.this, netVideoList);
        videoListView.setAdapter(adapter);
        videoListView.setOnItemClickListener(onVideoItemClick);
    }

    private final AdapterView.OnItemClickListener onVideoItemClick = (adapterView, view, position, l) -> {
        showLoading(true);
        netVideo = netVideoList.get(position);
        new Thread(() -> {
            List<VideoUrlItem> urlList = netVideo.getVideoUrls();
            List<VideoUrlItem> nvList = analyzeSelected.getVideoUrlList(netVideo);
            if(nvList == null || nvList.size() == 0) runOnUiThread(this::tipsEmpty);
            else {
                urlList.addAll(nvList);
                ArrayList<VideoijkBean> vList = new ArrayList<>();
                for (int i = 0; i < urlList.size(); i ++) {
                    vList.add(new VideoijkBean(i,
                            urlList.get(i).getDescription(),
                            urlList.get(i).getUrl(),
                            urlList.get(i).getHeaders()));
                }
                runOnUiThread(() -> openVideo(vList, netVideo.getTitle(), analyzeSelected.getLive()));
            }
        }).start();
    };

    private final TextView.OnEditorActionListener onSearchTextAction = (v, actionId, event) -> {
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            searchStr = v.getText().toString();
            Tools.HideKeyboard(v);
            v.clearFocus();
            v.setFocusable(false);
            v.setFocusableInTouchMode(false);
            netVideoList.clear();
            MyListAdapter la = (MyListAdapter) videoListView.getAdapter();
            la.notifyDataSetChanged();
            showLoading(true);
            new Thread(() -> {
                List<NetVideo> nvList = analyzeSelected.getVideoListBySearch(searchStr);
                if(nvList != null) netVideoList.addAll(nvList);
                runOnUiThread(this::onSearchResult);
            }).start();
        }
        return false;
    };

    private void initAnalysis() {
        BaseAnalyze analyze = new LiveAnalyze().setIconId(R.drawable.ic_menu_live);
        analyzeMap.put(analyze.getTitle(), analyze);
        analyzeList.add(analyze.getTitle());
        analyze = new CloudMusicAnalyze().setIconId(R.drawable.ic_menu_cloudmusic);
        analyzeMap.put(analyze.getTitle(), analyze);
        analyzeList.add(analyze.getTitle());
        analyze = new DouBanTop250Analyze().setIconId(R.drawable.ic_menu_douban);
        analyzeMap.put(analyze.getTitle(), analyze);
        analyzeList.add(analyze.getTitle());
        analyze = new BilibiliAnalyze().setIconId(R.drawable.ic_menu_bilibili);
        analyzeMap.put(analyze.getTitle(), analyze);
        analyzeList.add(analyze.getTitle());
        analyze = new QQLiveAnalyze().setIconId(R.drawable.ic_menu_qqlive);
        analyzeMap.put(analyze.getTitle(), analyze);
        analyzeList.add(analyze.getTitle());
        analyze = new IQiYiAnalyze().setIconId(R.drawable.ic_menu_iqiyi);
        analyzeMap.put(analyze.getTitle(), analyze);
        analyzeList.add(analyze.getTitle());
        analyze = new YouKuAnalyze().setIconId(R.drawable.ic_menu_youku);
        analyzeMap.put(analyze.getTitle(), analyze);
        analyzeList.add(analyze.getTitle());
        analyze = new YouTubeAnalyze().setIconId(R.drawable.ic_menu_youtube);
        analyzeMap.put(analyze.getTitle(), analyze);
        analyzeList.add(analyze.getTitle());
    }

    private void setStatusBarTransparent() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }


    private final NavigationView.OnNavigationItemSelectedListener onNavigationItemSelected =
            item -> {
                String title = item.getTitle().toString();
                localSP.edit().putString("nav_title",title).commit();
                analyzeSelected = analyzeMap.get(title);
                if(analyzeSelected == null) return false;
                toolbar.setTitle(analyzeSelected.getTitle());
                OpenPlatePage();
                DrawerLayout drawer = findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            };


    private final View.OnClickListener onNavHeaderClick = v -> {
        Object tag = v.getTag();
        String tagString = tag != null ? tag.toString() : "";
        final String itsMeText = getResources().getString(R.string.its_me);
        final String myGitText = getResources().getString(R.string.my_git);
        if(tagString.equals(itsMeText) || tagString.equals(myGitText)){
            showToGit();
        }else {
            DrawerLayout drawer = findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
        }
    };

    private void initNavigation() {
        NavigationView navigationView = findViewById(R.id.nav_view);
        Menu menu = navigationView.getMenu();
        int i = 1;
        final int MENU_MAIN_GROUP_ID = 12326;
        final int MENU_ABOUT_GROUP_ID = 12327;
        boolean openPage = false;
        for(String analyzeKey : analyzeList){
            MenuItem item = menu.add(MENU_MAIN_GROUP_ID, i++, i, analyzeKey);
            BaseAnalyze analyze = analyzeMap.get(analyzeKey);
            if(analyze.getIconId() != -1){
                item.setIcon(analyze.getIconId());
            }else if(analyze.getIcon() != null) {
                item.setIcon(analyze.getIcon());
            }else {
                item.setIcon(R.drawable.ic_menu_share);
            }
            String localTitle = localSP.getString("nav_title","直播");
            if (!openPage && analyze.getTitle().contains(localTitle)) {
                onNavigationItemSelected.onNavigationItemSelected(item);
                openPage = true;
            }
        }
        menu.setGroupCheckable(MENU_MAIN_GROUP_ID, true, true);
        SubMenu about = menu.addSubMenu(MENU_ABOUT_GROUP_ID, 100, 100, R.string.about);
        about.add(R.string.share).setIcon(R.drawable.ic_menu_share);
        about.add(R.string.send).setIcon(R.drawable.ic_menu_send);
        navigationView.setNavigationItemSelectedListener(onNavigationItemSelected);
        View navHeaderView = navigationView.getHeaderView(0);
        navHeaderView.setOnClickListener(onNavHeaderClick);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.action_settings:
                if (item.isChecked()){
                    isPlayVideoInBrowser = true;
                    item.setTitle(R.string.open_video_with_browser);
                    item.setChecked(false);
                }else{
                    isPlayVideoInBrowser = false;
                    item.setTitle(R.string.open_video_with_me);
                    item.setChecked(true);
                }
                break;
            case R.id.action_open_video:
                openExternalFile();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void openExternalFile(){
        EditText inputServer = new EditText(this);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("输入文件路径或链接")
                .setView(inputServer)
                .setIcon(android.R.drawable.ic_dialog_email)
                .setNegativeButton("取消", null)
                .setPositiveButton("确定", (dialog, which) -> {
                    String text = inputServer.getText().toString();
                    String localPath = Environment.getExternalStorageDirectory().getPath() + text;
                    if(new File(localPath).exists()){
                        text = localPath;
                    }
                    ArrayList<VideoijkBean> vList = new ArrayList<>();
                    vList.add(new VideoijkBean(0, "测试", text));
                    openVideo(vList, "测试", false);
                    dialog.dismiss();
                }).show();
    }

    private void showToGit(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("提示");
        builder.setMessage("是否打开HeHang的GitHub？");
        builder.setPositiveButton("确定", (dialogInterface, i) -> {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse("https://github.com/HeHang0"));
            intent.setClassName("com.android.browser","com.android.browser.BrowserActivity");
            startActivity(intent);
        });
        builder.show();
    }

    public void initSoundPool() {
        mSoundPoll =  new SoundPool.Builder()
                .setMaxStreams(100)   //设置允许同时播放的流的最大值
                .build() ;
        try {
            mSound404Id = mSoundPoll.load(getAssets().openFd("404.mp3"), 1);
        }catch (Exception ignored){}
    }

    public void initLiveChannel() {
        try {
            InputStreamReader inputReader = new InputStreamReader(getAssets().open("channel.txt"));
            BufferedReader bufReader = new BufferedReader(inputReader);
            String line="";
            StringBuilder result=new StringBuilder();
            while((line = bufReader.readLine()) != null)
                result.append(line);
            LiveConst.Channel = result.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            InputStreamReader inputReader = new InputStreamReader(getAssets().open("image.json"));
            BufferedReader bufReader = new BufferedReader(inputReader);
            String line;
            StringBuilder result=new StringBuilder();
            while((line = bufReader.readLine()) != null)
                result.append(line);
            JSONArray jsonArray = JSON.parseArray(result.toString());
            for (int i = 0; i < jsonArray.size(); i++) {
                Vector<String> vv = new Vector<>();
                String text = jsonArray.getJSONObject(i).getString("name");
                if(text == null || text.isEmpty()) continue;
                vv.add(jsonArray.getJSONObject(i).getString("src"));
                vv.add(text);
                LiveConst.ImageList.add(vv);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void playAudioTips404() {
        AudioManager am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        // 获取当前音量
        float streamVolumeCurrent = am
                .getStreamVolume(AudioManager.STREAM_MUSIC);
        // 获取系统最大音量
        float streamVolumeMax = am
                .getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        // 计算得到播放音量
        float volume = streamVolumeCurrent / streamVolumeMax;
        // 调用SoundPool的play方法来播放声音文件
        if(mLastSoundPollId != -1){
            mSoundPoll.pause(mLastSoundPollId);
        }
        mLastSoundPollId = mSoundPoll.play(mSound404Id, volume, volume, 1, 0, 1.0f);
    }

    private void OpenPlatePage(){
        if(analyzeSelected == null) return;
        searchText.setVisibility(analyzeSelected.getShowSearch() ? View.VISIBLE : View.GONE);
        netVideoList.clear();
        showLoading(true);
        new Thread(() -> {
            List<NetVideo> nvList = analyzeSelected.getVideoListByHome();
            if(nvList != null) netVideoList.addAll(nvList);
            runOnUiThread(this::onSearchResult);
        }).start();
    }

    private void showLoading(boolean show) {
        ProgressBar loading = currentView.findViewById(R.id.video_loading);
//        loading.setpr(R.drawable.side_status_bar);
        loading.setVisibility(show ? View.VISIBLE : View.INVISIBLE);
    }

    private void onSearchResult() {
        ListView videoListView = currentView.findViewById(R.id.video_list);
        MyListAdapter la = (MyListAdapter) videoListView.getAdapter();
        la.notifyDataSetChanged();
        if(netVideoList.size() == 0){
            Toast.makeText(MainActivity.this, "未获取到数据！",
                    Toast.LENGTH_SHORT).show();
            playAudioTips404();
        }
        new Thread(() -> {
            for(int i = 0; i < netVideoList.size(); i++){
                NetVideo nv = netVideoList.get(i);
                if (nv.getImg() == null && nv.getImgUrl() != null && !nv.getImgUrl().isEmpty()){
                    nv.setImg(AnalysisUtils.getImageThumbnailRemote(nv.getImgUrl(), 320, 180));
                    if ((i+1) % 6 == 0 || (i+1) == netVideoList.size()){
                        runOnUiThread(this::onVideoImageUpdate);
                    }
                }
            }
        }).start();
        searchText.setFocusable(true);
        searchText.setFocusableInTouchMode(true);
        showLoading(false);
    }

    private void onVideoImageUpdate() {
        ListView videoListView1 = currentView.findViewById(R.id.video_list);
        if (videoListView1 != null){
            MyListAdapter la1 = (MyListAdapter) videoListView1.getAdapter();
            la1.notifyDataSetChanged();
        }
    }

    private void tipsEmpty(){
        Toast.makeText(MainActivity.this, "未获取到数据！",
                Toast.LENGTH_SHORT).show();
        playAudioTips404();
        showLoading(false);
    }

    private void openVideo(ArrayList<VideoijkBean> videoUrls, String videoTitle, boolean isLive){
        if(videoUrls.size() > 0){
            Intent intent;
            if (isPlayVideoInBrowser){
                intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(videoUrls.get(0).getUrl()));
                intent.setClassName("com.android.browser","com.android.browser.BrowserActivity");
            }else{
                intent = new Intent(MainActivity.this, IJKVideoPlayActivity.class);
                intent.putParcelableArrayListExtra("VideoUrls", videoUrls);
                intent.putExtra("VideoTitle", videoTitle);
                intent.putExtra("VideoLive", isLive);
            }
            startActivity(intent);
        }
        showLoading(false);
    }

    private static boolean isExit = false;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
    private void exit() {
        if (!isExit) {
            isExit = true;
            Toast.makeText(getApplicationContext(), "再按一次退出程序",
                    Toast.LENGTH_SHORT).show();
            // 利用handler延迟发送更改状态信息
            new Thread(() -> {
                try {
                    Thread.sleep(2000);
                    runOnUiThread(() -> isExit = false);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        } else {
            finish();
            System.exit(0);
        }
    }
}
