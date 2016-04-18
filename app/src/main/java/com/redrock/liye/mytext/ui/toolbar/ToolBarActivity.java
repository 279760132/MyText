package com.redrock.liye.mytext.ui.toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.redrock.liye.mytext.R;
import com.redrock.liye.mytext.ui.About.AboutActivity;
import com.redrock.liye.mytext.ui.fragment.SimpleFragmentPagerAdapter;


/**
 * Created by a on 2016/4/17.
 */
public class ToolBarActivity extends AppCompatActivity {
    private SimpleFragmentPagerAdapter pagerAdapter;

    private ViewPager viewPager;

    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar);
        getSupportActionBar().hide();
        initToolBar();
        initFragment();
    }
    private void initToolBar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setLogo(R.drawable.ic_logo);//设置app logo
        toolbar.setTitle("日靡难眼的APP");//设置主标题
        toolbar.setSubtitle("小也君的私人APP");//设置副标题
        toolbar.inflateMenu(R.menu.base_toolbar_menu);//设置右上角的填充菜单
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int menuItemId = item.getItemId();
                if (menuItemId == R.id.action_item1) {
                    Toast.makeText(ToolBarActivity.this, "设置", Toast.LENGTH_SHORT).show();

                } else if (menuItemId == R.id.action_item2) {
                    Toast.makeText(ToolBarActivity.this, "关于", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ToolBarActivity.this, AboutActivity.class);
                    startActivity(intent);
                }
                return true;
            }
        });
    }
    private void initFragment(){
        pagerAdapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager(), this);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(pagerAdapter);
        tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(pagerAdapter.getTabView(i));
        }
    }
}
