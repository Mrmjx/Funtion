package com.mo.functiondemo.tools;

import android.os.AsyncTask;

import java.lang.ref.WeakReference;

/**
 * Created by mjx on 2017/7/25.
 * 弱引用异步
 */
public abstract class WeakAsyncTask<Params, Progress, Result, WeakTarget>
        extends AsyncTask<Params, Progress, Result> {
    protected WeakReference<WeakTarget> mTarget;

    public WeakAsyncTask(WeakTarget target) {
        mTarget = new WeakReference<>(target);
    }

    @Override
    protected final void onPreExecute() {
        final WeakTarget target = mTarget.get();
        if (target != null) {
            this.onPreExecute(target);
        }
    }

    @Override
    protected final Result doInBackground(Params... params) {
        final WeakTarget target = mTarget.get();
        if (target != null) {
            return this.doInBackground(target, params);
        } else {
            return null;
        }
    }

    @Override
    protected final void onPostExecute(Result result) {
        final WeakTarget target = mTarget.get();
        if (target != null) {
            this.onPostExecute(target, result);
        }
    }

    protected void onPreExecute(WeakTarget target) {
        // Nodefaultaction
    }

    protected abstract Result doInBackground(WeakTarget target,
                                             Params... params);

    protected void onPostExecute(WeakTarget target, Result result) {
        // Nodefaultaction
    }
}
