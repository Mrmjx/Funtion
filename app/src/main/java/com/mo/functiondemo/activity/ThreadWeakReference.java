package com.mo.functiondemo.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.mo.functiondemo.tools.WeakAsyncTask;

import java.lang.ref.WeakReference;

/**
 * Created by mjx on 2017/7/25.
 */
public class ThreadWeakReference extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new MyThread(this).start();   //调用弱引用线程，防止内存泄漏

        new MyTask(this).execute();  //调用弱引用异步，防止内存泄漏
    }

    public void doSomething() {
        //耗时操作
    }

    /**
     * 假设MyThread的run函数是一个很费时的操作，当我们开启该线程后，将设备的横屏变为了竖屏，
     * 一般情况下当屏幕转换时会重新创建Activity，按照我们的想法，老的Activity应该会被销毁才对，然而事实上并非如此。
     * 由于我们的线程是Activity的内部类，所以MyThread中保存了Activity的一个引用，当MyThread的run函数没有结束时，
     * MyThread是不会被销毁的，因此它所引用的老的Activity也不会被销毁，因此就出现了内存泄露的问题。
     */
    public static class MyThread extends Thread {
        WeakReference<ThreadWeakReference> threadWeakReference;  //使用弱引用来防止内存泄漏

        public MyThread(ThreadWeakReference threadWeakReference) {
            this.threadWeakReference = new WeakReference<>(threadWeakReference);
        }

        @Override
        public void run() {
            super.run();
            if (threadWeakReference == null) return;
            if (threadWeakReference.get() != null) {
                threadWeakReference.get().doSomething();
            }
        }
    }


    /**
     * Thread只有在run函数不结束时才出现这种内存泄露问题，然而AsyncTask内部的实现机制是运用了ThreadPoolExcutor,
     * 该类产生的Thread对象的生命周期是不确定的，是应用程序无法控制的，
     * 因此如果AsyncTask作为Activity的内部类，就更容易出现内存泄露的问题。
     */
    private static class MyTask extends WeakAsyncTask<Void, Void, String, ThreadWeakReference> {
        public MyTask(ThreadWeakReference target) {
            super(target);
        }

        @Override
        protected String doInBackground(ThreadWeakReference target, Void... params) { // 获取context,
            // 执行一些操作
            Context context = target;
            return "Hello Android    !!!!!";
        }

        @Override
        protected void onPostExecute(ThreadWeakReference target, String s) {
            // 执行操作
        }

        @Override
        protected void onPreExecute(ThreadWeakReference threadWeakReference) {
            super.onPreExecute(threadWeakReference);
        }
    }

}
