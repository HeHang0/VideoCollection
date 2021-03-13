package com.oohoo.videoapi.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.os.Environment;
import android.util.Base64;
import android.util.Log;


import androidx.annotation.NonNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AnalysisUtils {
    @SuppressLint("StaticFieldLeak")
    private static Context context = null;

    /**
     * 设置Context
     */
    public static void setContext(Context ctx){
        context = ctx;
    }


    /**
     * 获取cache路径
     */
    public static String getDiskCachePath() {
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
                || !Environment.isExternalStorageRemovable()) {
            return context.getExternalCacheDir().getPath();
        } else {
            return context.getCacheDir().getPath();
        }
    }

    /**
     * 判断文件是否存在
     */
    public static boolean fileExists(String strFile)
    {
        try
        {
            File f=new File(strFile);
            if(f.exists())
            {
                return true;
            }

        }
        catch (Exception e){ }

        return false;
    }

    /**
     * 下载文件
     */
    public static void downloadFile1(String url, String dirName, String fileName) {
        try{
            //获取文件名
            URL myURL = new URL(url);
            URLConnection conn = myURL.openConnection();
            conn.connect();
            InputStream is = conn.getInputStream();
            int fileSize = conn.getContentLength();//根据响应获取文件大小
            if (fileSize <= 0) throw new RuntimeException("无法获知文件大小 ");
            if (is == null) throw new RuntimeException("stream is null");
            File file1 = new File(dirName);
            if(!file1.exists()){
                file1.mkdirs();
            }
            //把数据存入路径+文件名
            FileOutputStream fos = new FileOutputStream(dirName+File.separator+fileName);
            byte buf[] = new byte[1024];
            do{
                //循环读取
                int numread = is.read(buf);
                if (numread == -1)
                {
                    break;
                }
                fos.write(buf, 0, numread);
            } while (true);
            is.close();
        } catch (Exception ex) {
        }
    }


    /**
     * AES 加密
     */
    public static String aesEncrypt(String str, String key)  {
        String iv = "0102030405060708";
        if (str == null || key == null) return "";
        try {
            //Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            //cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes("utf-8"), "AES"), new IvParameterSpec(iv.getBytes("utf-8")));
            //byte[] bytes = cipher.doFinal(str.getBytes("utf-8"));

            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes("utf-8"));
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes("utf-8"), "AES"), ivParameterSpec);
            String base64Str = Base64.encodeToString(cipher.doFinal(str.getBytes("utf-8")), Base64.DEFAULT);
            return base64Str.replaceAll("\n", "").replaceAll("\r", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    @NonNull
    public static String sendDataByGet(String path, String user_agent){
        HttpURLConnection conn;//声明连接对象
        InputStream is;
        StringBuilder resultData = new StringBuilder();
        try {
            URL url = new URL(path); //URL对象
            conn = (HttpURLConnection)url.openConnection(); //使用URL打开一个链接,下面设置这个连接
            conn.setRequestMethod("GET"); //使用get请求
            if (user_agent.length() > 0)
                conn.setRequestProperty("User-agent",user_agent);
            if(conn.getResponseCode()==200){//返回200表示连接成功
                is = conn.getInputStream(); //获取输入流
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader bufferReader = new BufferedReader(isr);
                String inputLine;
                while((inputLine = bufferReader.readLine()) != null){
                    resultData.append(inputLine);
                }
                is.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultData.toString();
    }

    @NonNull
    public static String sendDataByPost(String path){
        HttpURLConnection conn;//声明连接对象
        InputStream is;
        StringBuilder resultData = new StringBuilder();
        try {
            URL url = new URL(path); //URL对象
            conn = (HttpURLConnection)url.openConnection(); //使用URL打开一个链接,下面设置这个连接
            conn.setRequestMethod("POST"); //使用get请求
            int index = path.indexOf(".com");
            if (index > 4) conn.setRequestProperty("referer", path.substring(0, index+4));
            //conn.setRequestProperty("User-agent","Win32");
            if(conn.getResponseCode()==200){//返回200表示连接成功
                is = conn.getInputStream(); //获取输入流
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader bufferReader = new BufferedReader(isr);
                String inputLine;
                while((inputLine = bufferReader.readLine()) != null){
                    resultData.append(inputLine);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultData.toString();
    }

    private static boolean saveBitmapToTmp(Bitmap bitmap, String name) {
        try {
            String tmpImagesDir = getDiskCachePath() + File.separator +
                    "tmp" + File.separator +
                    "images" + File.separator;
            File file = new File(tmpImagesDir);                                 //已File来构建
            if (!file.exists()) {                                     //如果不存在  就mkdirs()创建此文件夹
                file.mkdirs();
            }
            Log.i("SaveImg", "file uri==>" + tmpImagesDir + name);
            File mFile = new File(tmpImagesDir + name);                        //将要保存的图片文件
            if (mFile.exists()) {
                return false;
            }

            FileOutputStream outputStream = new FileOutputStream(mFile);     //构建输出流
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);  //compress到输出outputStream
            return true;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static Bitmap getBitmapFromTmp(String name) {
        String tmpImagesDir = getDiskCachePath() + File.separator +
                "tmp" + File.separator +
                "images" + File.separator;
        Bitmap bitmap = null;
        try  {
            InputStream is = new FileInputStream(tmpImagesDir + name);
            bitmap = BitmapFactory.decodeStream(is);
        }catch (Exception e){ }
        return bitmap;
    }

    public static Bitmap getImageThumbnailRemote(String imagePath, int width, int height) {
        String name = string2MD5(imagePath)+width+height;
        Bitmap bitmap = getBitmapFromTmp(name);
        if(bitmap != null) return bitmap;
        bitmap = getBitmapFromRemoteUrl(imagePath, width, height);
        if(bitmap != null) saveBitmapToTmp(bitmap, name);
        return bitmap;
    }

    public static Bitmap getBitmapFromRemoteUrl(String imagePath, int width, int height) {
        Bitmap bitmap = null;
        try {
            URL url = new URL(imagePath);
//            InputStream is = url.openStream();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            bitmap = BitmapFactory.decodeStream(url.openStream(), null, options);
            // 获取这个图片的宽和高，注意此处的bitmap为null
            // bitmap = BitmapFactory.decodeFile(imagePath, options);
            options.inJustDecodeBounds = false; // 设为 false
            // 计算缩放比
            int h = options.outHeight;
            int w = options.outWidth;
            int beWidth = w / width;
            int beHeight = h / height;
            int be = 1;
            be = Math.min(beWidth, beHeight);
            if (be <= 0) {
                be = 1;
            }
            options.inSampleSize = be;
            if (be == 1){
                bitmap =  BitmapFactory.decodeStream(url.openStream());
            }else{
                // 重新读入图片，读取缩放后的bitmap，注意这次要把options.inJustDecodeBounds 设为 false
                bitmap = BitmapFactory.decodeStream(url.openStream(), null, options);
                // 利用ThumbnailUtils来创建缩略图，这里要指定要缩放哪个Bitmap对象
                bitmap = ThumbnailUtils.extractThumbnail(bitmap, width, height,
                        ThumbnailUtils.OPTIONS_RECYCLE_INPUT);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    /***
     * MD5加码 生成32位md5码
     */
    public static String string2MD5(String inStr) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuilder hexValue = new StringBuilder();
        for (byte md5Byte : md5Bytes) {
            int val = ((int) md5Byte) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString().toLowerCase();
    }

    public static Map<String, String> VideoUrlType = new HashMap<String, String>(){
        {
            put("SPEED", "极速");
            put("SD", "标清");
            put("HD", "高清");
            put("SUPERHD", "超清");
            put("1080P", "1080P");
            put("240", "标清");
            put("480", "高清");
            put("720", "超清");
            put("720P", "超清");
            put("1080", "1080P");
            put("ORIGINAL", "1080P");
        }
    };

    public static Map<String, String> areaAbb = new HashMap<String, String>() {{
        put("北京","京");
        put("天津","津");
        put("上海","沪");
        put("重庆","渝");
        put("河北","冀");
        put("山西","晋");
        put("辽宁","辽");
        put("吉林","吉");
        put("黑龙","黑");
        put("江苏","苏");
        put("浙江","浙");
        put("安徽","皖");
        put("四川","川");
        put("福建","闽");
        put("江西","赣");
        put("山东","鲁");
        put("河南","豫");
        put("湖北","鄂");
        put("湖南","湘");
        put("广东","粤");
        put("海南","琼");
        put("贵州","黔");
        put("云南","滇");
        put("陕西","陕");
        put("甘肃","甘");
        put("青海","青");
        put("台湾","台");
        put("内蒙","蒙");
        put("广西","桂");
        put("西藏","藏");
        put("宁夏","宁");
        put("新疆","新");
        put("香港","港");
        put("澳门","澳");
    }};
}
