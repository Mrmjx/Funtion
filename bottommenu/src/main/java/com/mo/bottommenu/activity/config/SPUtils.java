package com.mo.bottommenu.activity.config;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by lijiarui on 2017/3/29.
 *
 * 文件保存类
 */
public class SPUtils {

    /**
     * 保存在手机里的文件名
     */
    public static final String FILE_NAME = "demo_share_date";

    /**
     * int
     */
    public static void putInt(Context context, String key, int a){
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(key, a).commit();
    }


    /**
     * 取出保存的数据 int 类型
     */
    public static int getInt(Context context, String key, int defaultResult){
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        return sp.getInt(key, defaultResult);
    }

    /**
     * 删除数据
     * @param context
     * @param key
     */
    public static void delete(Context context, String key){
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
        editor.commit();
    }

    /**
     * 清除 sp 中所有的数据
     */
    public static void cleanAll(Context context){
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.commit();
    }

}
