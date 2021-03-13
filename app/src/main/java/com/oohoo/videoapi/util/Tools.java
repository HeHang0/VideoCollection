package com.oohoo.videoapi.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.BatteryManager;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


public class Tools {
    public static int[] getScreenSize(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        assert wm != null;
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return new int[]{outMetrics.widthPixels, outMetrics.heightPixels};
    }

    static boolean saveBitmap(Bitmap bitmap, File file) {
        if (bitmap == null)
            return false;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    @SuppressLint("SimpleDateFormat")
    public static String getShortTime(){
        return new SimpleDateFormat("HH:mm").format(new Date());
    }

    public static int getBatterLevel(Context context){
        BatteryManager batteryManager=(BatteryManager)context.getSystemService(Context.BATTERY_SERVICE);
        if (batteryManager == null) return 100;
        return batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY );
    }



    public static void HideKeyboard(View v)
    {
        InputMethodManager imm = ( InputMethodManager ) v.getContext( ).getSystemService( Context.INPUT_METHOD_SERVICE );
        assert imm != null;
        if ( imm.isActive( ) ) {
            imm.hideSoftInputFromWindow( v.getApplicationWindowToken( ) , 0 );

        }
    }

    public static String getStrWithRegular(String pattern, String str){
        Matcher m = Pattern.compile(pattern).matcher(str);
        if (m.find()) {
            return m.group(1);
        }
        return "";
    }

    public static List<String> getStrListWithRegular(String pattern, String str){
        List<String> list = new ArrayList<>();
        Pattern p=Pattern.compile(pattern);
        Matcher matcher = p.matcher(str);
        while (matcher.find()) {
            list.add(matcher.group());
        }
        return list;
    }

    public static String md5Encoder(String str){
        try
        {
            byte[] arrayOfByte = MessageDigest.getInstance("MD5").digest(str.getBytes());
            str = "";
            for (int i=0;i < arrayOfByte.length;i++)
            {
                String byteStr = Integer.toHexString(arrayOfByte[i] & 0xFF);
                str += byteStr.length() == 1 ? "0" + byteStr : byteStr;
            }
            return str;
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return "";
    }

    public static int getStatusHeight(Context context){
        int statusBarHeight = (int)Math.ceil(25 * context.getResources().getDisplayMetrics().density);
        return statusBarHeight;
    }
}
