package com.dave.android_custom_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        CustomItemView customItemView1 = (CustomItemView) findViewById(R.id.custom_view1);
        customItemView1.setTitle(getResources().getString(R.string.custom_view_title_1));
        customItemView1.setDataAndView(Arrays.asList(1, 2, 3, 4, 5));

        CustomItemView customItemView2 = (CustomItemView) findViewById(R.id.custom_view2);
        customItemView2.setTitle(getResources().getString(R.string.custom_view_title_2));
        customItemView2.setDataAndView(Arrays.asList(10, 20, 30, 40, 50));

        CustomItemView customItemView3 = (CustomItemView) findViewById(R.id.custom_view3);
        customItemView3.setTitle(getResources().getString(R.string.custom_view_title_3));
        customItemView3.setDataAndView(Arrays.asList(100, 200, 300, 400, 500));
    }
}
