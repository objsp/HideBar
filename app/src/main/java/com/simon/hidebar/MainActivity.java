package com.simon.hidebar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycleView;
    private FloatingActionButton fab;
    private Toolbar toolBar;
    private List<String> list;
    private boolean isRotation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycleView = (RecyclerView) findViewById(R.id.recycle);
        toolBar = (Toolbar) findViewById(R.id.toolbar);
        fab = (FloatingActionButton) findViewById(R.id.fab);

        setSupportActionBar(toolBar);
        toolBar.setTitle("Simon Hidden");
        toolBar.setTitleTextColor(Color.WHITE);
        toolBar.setLogo(R.mipmap.ic_launcher);
        toolBar.setNavigationIcon(R.drawable.ic_menu_back);

        list = getDatas();
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        recycleView.setAdapter(new RecycleViewAdapter(list));
        recycleView.addOnScrollListener(new RecycleScrollListener() {
            @Override
            public void onHidden() {
                toolBar.animate().translationY(-toolBar.getHeight());
                int hight = ((FrameLayout.LayoutParams) fab.getLayoutParams()).bottomMargin;
                fab.animate().translationY(fab.getHeight() + hight);
            }

            @Override
            public void onShow() {
                toolBar.animate().translationY(0);
                fab.animate().translationY(0);
            }
        });

        fabClick();
    }

    private void fabClick() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isRotation) {
                    fab.animate().rotation(0);
                } else {
                    fab.animate().rotation(90);
                }
                isRotation = !isRotation;
                Snackbar.make(v, "结束当前Acitivty", Snackbar.LENGTH_LONG)
                        .setAction("确定", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        })
                        .show();
            }
        });
    }

    private List<String> getDatas() {
        list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add("simon >>> " + i);
        }
        return list;
    }

}
