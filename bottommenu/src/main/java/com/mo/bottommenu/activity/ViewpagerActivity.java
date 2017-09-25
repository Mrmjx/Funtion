package com.mo.bottommenu.activity;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mo.bottommenu.R;

import java.util.ArrayList;
import java.util.List;

public class ViewpagerActivity extends AppCompatActivity  {

    private View view1, view2, view3;
    private List<View> viewList;// view数组
    private ViewPager viewPager; // 对应的viewPager

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager_main);
        viewPager = (ViewPager) findViewById(R.id.fragments);
        LayoutInflater inflater = getLayoutInflater();
        view1 = inflater.inflate(R.layout.frage_first, null);
        view2 = inflater.inflate(R.layout.frage_second, null);
        view3 = inflater.inflate(R.layout.frage_three, null);

        viewList = new ArrayList<View>();// 将要分页显示的View装入数组中
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);

        PagerAdapter pagerAdapter = new PagerAdapter() {

            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                // TODO Auto-generated method stub
                //根据传来的key，找到view,判断与传来的参数View arg0是不是同一个视图
                //return arg0 == viewList.get((int)Integer.parseInt(arg1.toString()));
                return arg0==arg1;
            }

            @Override
            public int getCount() {
                // TODO Auto-generated method stub
                return viewList.size();
            }

            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                // TODO Auto-generated method stub
                container.removeView(viewList.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                // TODO Auto-generated method stub
                container.addView(viewList.get(position));

                //把当前新增视图的位置（position）作为Key传过去
               // return position;
                return viewList.get(position);
            }
        };

        viewPager.setAdapter(pagerAdapter);

    }

}
