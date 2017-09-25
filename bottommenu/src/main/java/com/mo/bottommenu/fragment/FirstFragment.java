package com.mo.bottommenu.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mo.bottommenu.R;
import com.tencent.tauth.Tencent;

/**
 * Created by mjx on 2017/7/20.
 */
public class FirstFragment extends Fragment {
    View view;
    Button viewpagerActivity;
    Tencent mTencent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        inflater = LayoutInflater.from(getActivity());
        view = inflater.inflate(R.layout.frage_first,null);
        viewpagerActivity = (Button)view.findViewById(R.id.viewpager_but);
        viewpagerActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Tencent mTencent  = Tencent.createInstance(APP_ID, this.getApplicationContext());

//                Intent intent = new Intent(getActivity(),ViewpagerActivity.class);
//                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


}
