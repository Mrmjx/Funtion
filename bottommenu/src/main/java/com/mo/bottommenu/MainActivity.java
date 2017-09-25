package com.mo.bottommenu;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    FragmentTransaction fragmentTransaction;
    String[] fragmentName = {"FirstFragment", "SecondFragment", "ThirthFragment", "fouthFragment"};
    Fragment[] fragments = new Fragment[4];  //保存碎片
    int currIndex = -1;   //当前显示的碎片下标
    LinearLayout tab,first,second,third,four;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        first = (LinearLayout)findViewById(R.id.first);
        second = (LinearLayout)findViewById(R.id.second);
        third = (LinearLayout)findViewById(R.id.third);
        four = (LinearLayout)findViewById(R.id.four);
        first.setOnClickListener(this);
        second.setOnClickListener(this);
        third.setOnClickListener(this);
        four.setOnClickListener(this);


        tab = (LinearLayout)findViewById(R.id.tab);
        tab.getChildAt(0).setSelected(true);
        showFragment(0);
    }

    public void showFragment(int index) {
        if (index == currIndex) return;
        fragmentTransaction = getFragmentManager().beginTransaction();  //获取到碎片事务管理
        if (currIndex != -1) {
            //将上一个碎片隐藏
            fragmentTransaction.hide(fragments[currIndex]);
            tab.getChildAt(currIndex).setSelected(false);
        }
        if (fragments[index] == null) {  // 还没创建该碎片实例
            CreadeFragment(index); //创建碎片
            /**显示当前碎片视图
             * 参数int：显示的FrameLayout的id； fragment：在该视图中显示的fragement; string:tag视图标志，可以自定义
             * */
            fragmentTransaction.add(R.id.fragments, fragments[index], index + "");
        } else { //已存在碎片实例
            fragmentTransaction.show(fragments[index]);//直接显示
        }
        tab.getChildAt(index).setSelected(true);
        currIndex = index;   // 更新当前显示的碎片
        fragmentTransaction.commit();//提交事务
    }

    public void CreadeFragment(int index) {
        try {
            //利用反射 创建当前碎片的实例
            fragments[index] = (Fragment) Class.forName("com.mo.bottommenu.fragment." + fragmentName[index]).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {
        String tag = (String) view.getTag();//拿到选中的imageview的tag
        showFragment(Integer.parseInt(tag)); //直接设置显示碎片
        tab.getChildAt(Integer.parseInt(tag)).setSelected(true);       //底部菜单图片转换
    }
}
