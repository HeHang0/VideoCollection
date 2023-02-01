package com.oohoo.videoapi.analysis;

import com.oohoo.videoapi.video.NetVideo;
import com.oohoo.videoapi.video.VideoUrlItem;

import java.util.ArrayList;
import java.util.List;

public class DouBanTop250Analyze extends BaseAnalyze {

    private final String TAG = "LiveAnalyze";

    public DouBanTop250Analyze(){
        showSearch = false;
        title = "豆瓣Top250";
    }

    @Override
    public List<NetVideo> getVideoListByHome(){
        List<NetVideo> list =  new ArrayList<>();
        list.add(new NetVideo("《疯狂原始人2：新纪元》","HD高清中字",
                "https://dss0.bdstatic.com/6Ox1bjeh1BF3odCf/it/u=2154531010,1493707399&fm=218&app=2&f=JPEG?w=121&h=75&s=9A91F7A04023C0F406348605030030DF",
                "https://meinv.jingyu-zuida.com/20210223/14238_309a2829/index.m3u8","1"));
        list.add(new NetVideo("《肖申克的救赎》","HD高清中字",
                "https://dss2.bdstatic.com/6Ot1bjeh1BF3odCf/it/u=2749392049,3229169485&fm=218&app=2&f=JPEG?w=121&h=75&s=A6541DC7CB5716CC696D11360300D040",
                "https://vip.okokbo.com/20171211/s4F8krYj/index.m3u8","1"));
        list.add(new NetVideo("《霸王别姬》","HD高清中字",
                "file:///android_asset/404.jpg",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","2"));

        list.add(new NetVideo("《肖申克的救赎》","",
                "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=444496867,3064755494&fm=26&gp=0.jpg",
                "https://www.mmicloud.com:65/20190323/EUzt1oou/index.m3u8","1"));
        list.add(new NetVideo("《霸王别姬》","",
                "https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2561716440.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","2"));
        list.add(new NetVideo("《阿甘正传》","",
                "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p2372307693.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","3"));
        list.add(new NetVideo("《这个杀手不太冷》","",
                "https://img3.doubanio.com/view/photo/s_ratio_poster/public/p511118051.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","4"));
        list.add(new NetVideo("《泰坦尼克号》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p457760035.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","5"));
        list.add(new NetVideo("《美丽人生》","",
                "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p2578474613.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","6"));
        list.add(new NetVideo("《千与千寻》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2557573348.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","7"));
        list.add(new NetVideo("《辛德勒的名单》","",
                "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p492406163.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","8"));
        list.add(new NetVideo("《盗梦空间》","",
                "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p2616355133.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","9"));
        list.add(new NetVideo("《忠犬八公的故事》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p524964039.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","10"));
        list.add(new NetVideo("《星际穿越》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2614988097.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","11"));
        list.add(new NetVideo("《楚门的世界》","",
                "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p479682972.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","12"));
        list.add(new NetVideo("《海上钢琴师》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2574551676.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","13"));
        list.add(new NetVideo("《三傻大闹宝莱坞》","",
                "https://img3.doubanio.com/view/photo/s_ratio_poster/public/p579729551.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","14"));
        list.add(new NetVideo("《机器人总动员》","",
                "https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1461851991.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","15"));
        list.add(new NetVideo("《放牛班的春天》","",
                "https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1910824951.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","16"));
        list.add(new NetVideo("《大话西游之大圣娶亲》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2455050536.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","17"));
        list.add(new NetVideo("《疯狂动物城》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2614500649.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","18"));
        list.add(new NetVideo("《无间道》","",
                "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p2564556863.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","19"));
        list.add(new NetVideo("《熔炉》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p1363250216.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","20"));
        list.add(new NetVideo("《教父》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p616779645.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","21"));
        list.add(new NetVideo("《当幸福来敲门》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2614359276.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","22"));
        list.add(new NetVideo("《龙猫》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2540924496.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","23"));
        list.add(new NetVideo("《怦然心动》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p501177648.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","24"));
        list.add(new NetVideo("《控方证人》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p1505392928.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","25"));
        list.add(new NetVideo("《触不可及》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p1454261925.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","26"));
        list.add(new NetVideo("《蝙蝠侠：黑暗骑士》","",
                "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p462657443.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","27"));
        list.add(new NetVideo("《末代皇帝》","",
                "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p452089833.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","28"));
        list.add(new NetVideo("《活着》","",
                "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p2524040532.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","29"));
        list.add(new NetVideo("《寻梦环游记》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2614500706.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","30"));
        list.add(new NetVideo("《乱世佳人》","",
                "https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1963126880.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","31"));
        list.add(new NetVideo("《何以为家》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2555295759.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","32"));
        list.add(new NetVideo("《指环王3：王者无敌》","",
                "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p691932373.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","33"));
        list.add(new NetVideo("《哈利·波特与魔法石》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2614949805.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","34"));
        list.add(new NetVideo("《飞屋环游记》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p485887754.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","35"));
        list.add(new NetVideo("《摔跤吧！爸爸》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2401676338.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","36"));
        list.add(new NetVideo("《素媛》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2118532944.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","37"));
        list.add(new NetVideo("《少年派的奇幻漂流》","",
                "https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1784592701.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","38"));
        list.add(new NetVideo("《十二怒汉》","",
                "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p2173577632.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","39"));
        list.add(new NetVideo("《哈尔的移动城堡》","",
                "https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2174346180.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","40"));
        list.add(new NetVideo("《鬼子来了》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2553104888.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","41"));
        list.add(new NetVideo("《天空之城》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p1446261379.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","42"));
        list.add(new NetVideo("《大话西游之月光宝盒》","",
                "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p2561721372.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","43"));
        list.add(new NetVideo("《我不是药神》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2561305376.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","44"));
        list.add(new NetVideo("《罗马假日》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2189265085.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","45"));
        list.add(new NetVideo("《闻香识女人》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2550757929.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","46"));
        list.add(new NetVideo("《天堂电影院》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2559577569.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","47"));
        list.add(new NetVideo("《辩护人》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2158166535.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","48"));
        list.add(new NetVideo("《猫鼠游戏》","",
                "https://img3.doubanio.com/view/photo/s_ratio_poster/public/p453924541.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","49"));
        list.add(new NetVideo("《大闹天宫》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2184505167.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","50"));
        list.add(new NetVideo("《搏击俱乐部》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p1910926158.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","51"));
        list.add(new NetVideo("《教父2》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2194138787.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","52"));
        list.add(new NetVideo("《狮子王》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2277799019.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","53"));
        list.add(new NetVideo("《指环王2：双塔奇兵》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p909265336.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","54"));
        list.add(new NetVideo("《钢琴家》","",
                "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p792376093.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","55"));
        list.add(new NetVideo("《死亡诗社》","",
                "https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2575465690.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","56"));
        list.add(new NetVideo("《黑客帝国》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p451926968.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","57"));
        list.add(new NetVideo("《指环王1：魔戒再现》","",
                "https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1354436051.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","58"));
        list.add(new NetVideo("《饮食男女》","",
                "https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1910899751.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","59"));
        list.add(new NetVideo("《美丽心灵》","",
                "https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1665997400.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","60"));
        list.add(new NetVideo("《窃听风暴》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p1808872109.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","61"));
        list.add(new NetVideo("《让子弹飞》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p1512562287.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","62"));
        list.add(new NetVideo("《绿皮书》","",
                "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p2549177902.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","63"));
        list.add(new NetVideo("《两杆大烟枪》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p792443418.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","64"));
        list.add(new NetVideo("《本杰明·巴顿奇事》","",
                "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p2192535722.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","65"));
        list.add(new NetVideo("《海蒂和爷爷》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2554525534.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","66"));
        list.add(new NetVideo("《飞越疯人院》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p792238287.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","67"));
        list.add(new NetVideo("《看不见的客人》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2498971355.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","68"));
        list.add(new NetVideo("《西西里的美丽传说》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2441988159.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","69"));
        list.add(new NetVideo("《拯救大兵瑞恩》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p1014542496.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","70"));
        list.add(new NetVideo("《穿条纹睡衣的男孩》","",
                "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p1473670352.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","71"));
        list.add(new NetVideo("《小鞋子》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2165511465.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","72"));
        list.add(new NetVideo("《音乐之声》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p453788577.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","73"));
        list.add(new NetVideo("《情书》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p449897379.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","74"));
        list.add(new NetVideo("《海豚湾》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2559579779.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","75"));
        list.add(new NetVideo("《美国往事》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p477229647.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","76"));
        list.add(new NetVideo("《致命魔术》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p480383375.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","77"));
        list.add(new NetVideo("《沉默的羔羊》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p1593414327.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","78"));
        list.add(new NetVideo("《禁闭岛》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p1832875827.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","79"));
        list.add(new NetVideo("《低俗小说》","",
                "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p1910902213.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","80"));
        list.add(new NetVideo("《蝴蝶效应》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2209066019.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","81"));
        list.add(new NetVideo("《七宗罪》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2219586434.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","82"));
        list.add(new NetVideo("《心灵捕手》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p480965695.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","83"));
        list.add(new NetVideo("《布达佩斯大饭店》","",
                "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p2178872593.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","84"));
        list.add(new NetVideo("《春光乍泄》","",
                "https://img3.doubanio.com/view/photo/s_ratio_poster/public/p465939041.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","85"));
        list.add(new NetVideo("《摩登时代》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2263408369.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","86"));
        list.add(new NetVideo("《哈利·波特与死亡圣器(下)》","",
                "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p917846733.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","87"));
        list.add(new NetVideo("《被嫌弃的松子的一生》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p884763596.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","88"));
        list.add(new NetVideo("《阿凡达》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2180085848.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","89"));
        list.add(new NetVideo("《喜剧之王》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2579932167.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","90"));
        list.add(new NetVideo("《致命ID》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2558364386.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","91"));
        list.add(new NetVideo("《剪刀手爱德华》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p480956937.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","92"));
        list.add(new NetVideo("《杀人回忆》","",
                "https://img3.doubanio.com/view/photo/s_ratio_poster/public/p657823840.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","93"));
        list.add(new NetVideo("《加勒比海盗》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p1596085504.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","94"));
        list.add(new NetVideo("《勇敢的心》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2004174709.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","95"));
        list.add(new NetVideo("《狩猎》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p1546987967.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","96"));
        list.add(new NetVideo("《请以你的名字呼唤我》","",
                "https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2505525050.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","97"));
        list.add(new NetVideo("《天使爱美丽》","",
                "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p2447590313.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","98"));
        list.add(new NetVideo("《断背山》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2604889017.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","99"));
        list.add(new NetVideo("《红辣椒》","",
                "https://img3.doubanio.com/view/photo/s_ratio_poster/public/p456825720.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","100"));
        list.add(new NetVideo("《7号房的礼物》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p1816276065.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","101"));
        list.add(new NetVideo("《幽灵公主》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p1613191025.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","102"));
        list.add(new NetVideo("《小森林 夏秋篇》","",
                "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p2564498893.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","103"));
        list.add(new NetVideo("《第六感》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2220184425.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","104"));
        list.add(new NetVideo("《阳光灿烂的日子》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2564685215.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","105"));
        list.add(new NetVideo("《重庆森林》","",
                "https://img3.doubanio.com/view/photo/s_ratio_poster/public/p792381411.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","106"));
        list.add(new NetVideo("《唐伯虎点秋香》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2357915564.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","107"));
        list.add(new NetVideo("《超脱》","",
                "https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1305562621.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","108"));
        list.add(new NetVideo("《爱在黎明破晓前》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2555762374.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","109"));
        list.add(new NetVideo("《小森林 冬春篇》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2215147728.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","110"));
        list.add(new NetVideo("《入殓师》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p1583839859.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","111"));
        list.add(new NetVideo("《消失的爱人》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2221768894.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","112"));
        list.add(new NetVideo("《一一》","",
                "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p2567845803.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","113"));
        list.add(new NetVideo("《蝙蝠侠：黑暗骑士崛起》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p1706428744.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","114"));
        list.add(new NetVideo("《菊次郎的夏天》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2620392435.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","115"));
        list.add(new NetVideo("《功夫》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2219011938.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","116"));
        list.add(new NetVideo("《侧耳倾听》","",
                "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p456692072.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","117"));
        list.add(new NetVideo("《倩女幽魂》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2414157745.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","118"));
        list.add(new NetVideo("《超能陆战队》","",
                "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p2614500883.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","119"));
        list.add(new NetVideo("《无人知晓》","",
                "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p661160053.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","120"));
        list.add(new NetVideo("《人生果实》","",
                "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p2544912792.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","121"));
        list.add(new NetVideo("《甜蜜蜜》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2223011274.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","122"));
        list.add(new NetVideo("《萤火之森》","",
                "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p1675053073.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","123"));
        list.add(new NetVideo("《借东西的小人阿莉埃蒂》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p617533616.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","124"));
        list.add(new NetVideo("《爱在日落黄昏时》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2561542458.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","125"));
        list.add(new NetVideo("《玛丽和马克思》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2162822165.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","126"));
        list.add(new NetVideo("《完美的世界》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2190556408.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","127"));
        list.add(new NetVideo("《驯龙高手》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2210954024.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","128"));
        list.add(new NetVideo("《哈利·波特与阿兹卡班的囚徒》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p1910812549.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","129"));
        list.add(new NetVideo("《幸福终点站》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p854757687.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","130"));
        list.add(new NetVideo("《告白》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p689520756.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","131"));
        list.add(new NetVideo("《大鱼》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p692813374.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","132"));
        list.add(new NetVideo("《阳光姐妹淘》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p1374786017.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","133"));
        list.add(new NetVideo("《射雕英雄传之东成西就》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2609063925.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","134"));
        list.add(new NetVideo("《恐怖直播》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2016930906.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","135"));
        list.add(new NetVideo("《天书奇谭》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2515539487.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","136"));
        list.add(new NetVideo("《怪兽电力公司》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2513247938.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","137"));
        list.add(new NetVideo("《神偷奶爸》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p792776858.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","138"));
        list.add(new NetVideo("《哈利·波特与密室》","",
                "https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1082651990.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","139"));
        list.add(new NetVideo("《玩具总动员3》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p1283675359.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","140"));
        list.add(new NetVideo("《傲慢与偏见》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2016401659.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","141"));
        list.add(new NetVideo("《时空恋旅人》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2070153774.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","142"));
        list.add(new NetVideo("《教父3》","",
                "https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2169664351.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","143"));
        list.add(new NetVideo("《釜山行》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2360940399.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","144"));
        list.add(new NetVideo("《血战钢锯岭》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2398141939.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","145"));
        list.add(new NetVideo("《哪吒闹海》","",
                "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p2516566783.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","146"));
        list.add(new NetVideo("《被解救的姜戈》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p1800813767.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","147"));
        list.add(new NetVideo("《七武士》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2215886505.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","148"));
        list.add(new NetVideo("《一个叫欧维的男人决定去死》","",
                "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p2406624993.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","149"));
        list.add(new NetVideo("《喜宴》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2249048907.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","150"));
        list.add(new NetVideo("《电锯惊魂》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2565332644.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","151"));
        list.add(new NetVideo("《风之谷》","",
                "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p1917567652.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","152"));
        list.add(new NetVideo("《我是山姆》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p652417775.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","153"));
        list.add(new NetVideo("《头号玩家》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2516578307.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","154"));
        list.add(new NetVideo("《英雄本色》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2504997087.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","155"));
        list.add(new NetVideo("《上帝之城》","",
                "https://img3.doubanio.com/view/photo/s_ratio_poster/public/p455677490.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","156"));
        list.add(new NetVideo("《谍影重重3》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p792223507.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","157"));
        list.add(new NetVideo("《疯狂原始人》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p1867084027.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","158"));
        list.add(new NetVideo("《未麻的部屋》","",
                "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p1351050722.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","159"));
        list.add(new NetVideo("《三块广告牌》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2510081688.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","160"));
        list.add(new NetVideo("《卢旺达饭店》","",
                "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p470419493.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","161"));
        list.add(new NetVideo("《纵横四海》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2597918718.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","162"));
        list.add(new NetVideo("《岁月神偷》","",
                "https://img3.doubanio.com/view/photo/s_ratio_poster/public/p456666151.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","163"));
        list.add(new NetVideo("《花样年华》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p1910828286.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","164"));
        list.add(new NetVideo("《达拉斯买家俱乐部》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2166160837.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","165"));
        list.add(new NetVideo("《心迷宫》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2276780256.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","166"));
        list.add(new NetVideo("《模仿游戏》","",
                "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p2255040492.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","167"));
        list.add(new NetVideo("《黑客帝国3：矩阵革命》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p443461818.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","168"));
        list.add(new NetVideo("《新世界》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p1903379979.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","169"));
        list.add(new NetVideo("《记忆碎片》","",
                "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p641688453.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","170"));
        list.add(new NetVideo("《头脑特工队》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2266293606.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","171"));
        list.add(new NetVideo("《荒蛮故事》","",
                "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p2584519452.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","172"));
        list.add(new NetVideo("《你的名字。》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2395733377.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","173"));
        list.add(new NetVideo("《忠犬八公物语》","",
                "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p1576418852.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","174"));
        list.add(new NetVideo("《真爱至上》","",
                "https://img3.doubanio.com/view/photo/s_ratio_poster/public/p475600770.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","175"));
        list.add(new NetVideo("《爆裂鼓手》","",
                "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p2220776342.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","176"));
        list.add(new NetVideo("《贫民窟的百万富翁》","",
                "https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2434249040.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","177"));
        list.add(new NetVideo("《萤火虫之墓》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2237136718.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","178"));
        list.add(new NetVideo("《东邪西毒》","",
                "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p1982176012.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","179"));
        list.add(new NetVideo("《海街日记》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2603364117.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","180"));
        list.add(new NetVideo("《黑天鹅》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2549648344.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","181"));
        list.add(new NetVideo("《惊魂记》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p1021883305.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","182"));
        list.add(new NetVideo("《无敌破坏王》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p1735642656.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","183"));
        list.add(new NetVideo("《你看起来好像很好吃》","",
                "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p709670262.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","184"));
        list.add(new NetVideo("《冰川时代》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p1910895719.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","185"));
        list.add(new NetVideo("《小偷家族》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2530599636.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","186"));
        list.add(new NetVideo("《寄生虫》","",
                "https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2561439800.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","187"));
        list.add(new NetVideo("《雨人》","",
                "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p2353324612.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","188"));
        list.add(new NetVideo("《绿里奇迹》","",
                "https://img3.doubanio.com/view/photo/s_ratio_poster/public/p767586451.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","189"));
        list.add(new NetVideo("《哈利·波特与火焰杯》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p735391084.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","190"));
        list.add(new NetVideo("《爱在午夜降临前》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2074715729.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","191"));
        list.add(new NetVideo("《恋恋笔记本》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p483604864.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","192"));
        list.add(new NetVideo("《疯狂的石头》","",
                "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p712241453.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","193"));
        list.add(new NetVideo("《恐怖游轮》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p462470694.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","194"));
        list.add(new NetVideo("《奇迹男孩》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2507709428.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","195"));
        list.add(new NetVideo("《雨中曲》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p1612355875.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","196"));
        list.add(new NetVideo("《魔女宅急便》","",
                "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p456676352.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","197"));
        list.add(new NetVideo("《二十二》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2457609817.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","198"));
        list.add(new NetVideo("《九品芝麻官》","",
                "https://img3.doubanio.com/view/photo/s_ratio_poster/public/p648370300.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","199"));
        list.add(new NetVideo("《海边的曼彻斯特》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2421855655.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","200"));
        list.add(new NetVideo("《房间》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2259715855.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","201"));
        list.add(new NetVideo("《虎口脱险》","",
                "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p2399597512.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","202"));
        list.add(new NetVideo("《人工智能》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p792257137.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","203"));
        list.add(new NetVideo("《2001太空漫游》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2560717825.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","204"));
        list.add(new NetVideo("《色，戒》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p453716305.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","205"));
        list.add(new NetVideo("《可可西里》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2363208684.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","206"));
        list.add(new NetVideo("《罗生门》","",
                "https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1598883511.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","207"));
        list.add(new NetVideo("《城市之光》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2170238828.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","208"));
        list.add(new NetVideo("《终结者2：审判日》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p1910909085.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","209"));
        list.add(new NetVideo("《初恋这件小事》","",
                "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p1505312273.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","210"));
        list.add(new NetVideo("《魂断蓝桥》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2351134499.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","211"));
        list.add(new NetVideo("《牯岭街少年杀人事件》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p848381236.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","212"));
        list.add(new NetVideo("《遗愿清单》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p1481879628.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","213"));
        list.add(new NetVideo("《大佛普拉斯》","",
                "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p2505928032.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","214"));
        list.add(new NetVideo("《波西米亚狂想曲》","",
                "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p2549558913.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","215"));
        list.add(new NetVideo("《新龙门客栈》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p1421018669.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","216"));
        list.add(new NetVideo("《源代码》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p988260245.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","217"));
        list.add(new NetVideo("《青蛇》","",
                "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p2570901292.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","218"));
        list.add(new NetVideo("《海洋》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2559581324.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","219"));
        list.add(new NetVideo("《燃情岁月》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p1023654037.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","220"));
        list.add(new NetVideo("《无耻混蛋》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2575043939.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","221"));
        list.add(new NetVideo("《疯狂的麦克斯4：狂暴之路》","",
                "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p2236181653.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","222"));
        list.add(new NetVideo("《血钻》","",
                "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p1244017073.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","223"));
        list.add(new NetVideo("《步履不停》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2375245718.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","224"));
        list.add(new NetVideo("《穿越时空的少女》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2079334286.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","225"));
        list.add(new NetVideo("《谍影重重2》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p667644866.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","226"));
        list.add(new NetVideo("《阿飞正传》","",
                "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p2525770523.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","227"));
        list.add(new NetVideo("《彗星来的那一夜》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2187896734.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","228"));
        list.add(new NetVideo("《地球上的星星》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p1973489335.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","229"));
        list.add(new NetVideo("《战争之王》","",
                "https://img3.doubanio.com/view/photo/s_ratio_poster/public/p792282381.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","230"));
        list.add(new NetVideo("《完美陌生人》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2522331945.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","231"));
        list.add(new NetVideo("《谍影重重》","",
                "https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1597183981.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","232"));
        list.add(new NetVideo("《香水》","",
                "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p2571500223.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","233"));
        list.add(new NetVideo("《东京教父》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p456703618.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","234"));
        list.add(new NetVideo("《东京物语》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p1925331564.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","235"));
        list.add(new NetVideo("《无间道2》","",
                "https://img3.doubanio.com/view/photo/s_ratio_poster/public/p859621920.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","236"));
        list.add(new NetVideo("《千钧一发》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2195672555.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","237"));
        list.add(new NetVideo("《朗读者》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p1140984198.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","238"));
        list.add(new NetVideo("《黑客帝国2：重装上阵》","",
                "https://img3.doubanio.com/view/photo/s_ratio_poster/public/p443461390.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","239"));
        list.add(new NetVideo("《再次出发之纽约遇见你》","",
                "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p2250287733.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","240"));
        list.add(new NetVideo("《崖上的波妞》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2627847859.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","241"));
        list.add(new NetVideo("《驴得水》","",
                "https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2393044761.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","242"));
        list.add(new NetVideo("《我爱你》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p1075591188.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","243"));
        list.add(new NetVideo("《猜火车》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p513567548.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","244"));
        list.add(new NetVideo("《浪潮》","",
                "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p1344888983.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","245"));
        list.add(new NetVideo("《聚焦》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2263822658.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","246"));
        list.add(new NetVideo("《小萝莉的猴神大叔》","",
                "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2510956726.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","247"));
        list.add(new NetVideo("《追随》","",
                "https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2561545031.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","248"));
        list.add(new NetVideo("《黑鹰坠落》","",
                "https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1910900710.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","249"));
        list.add(new NetVideo("《网络谜踪》","",
                "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2542848758.webp",
                "https://sina.com-h-sina.com/20180807/6205_5be6212a/index.m3u8","250"));

        return list;
    }

    @Override
    public List<VideoUrlItem> getVideoUrlList(NetVideo nv) {
        return null;
    }

    @Override
    public List<NetVideo> getVideoListBySearch(String searchKey) {
        return null;
    }
}
