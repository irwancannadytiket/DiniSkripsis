package com.skripsi.dini.diniskripsi.menus;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.skripsi.dini.diniskripsi.R;
import com.skripsi.dini.diniskripsi.commons.Injection;
import com.skripsi.dini.diniskripsi.databinding.ActivityMenusBinding;
import com.skripsi.dini.diniskripsi.model.DaftarMenuList;
import com.skripsi.dini.diniskripsi.model.DaftarMenuListResponse;

import java.util.List;

/**
 * Created by irwancannady on 11/10/17.
 */

public class MenusActivity extends AppCompatActivity implements MenusContract.View{

    private ActivityMenusBinding mBining;
    private MenusContract.Presenter mPresenter;
    private MenusAdapter mAdapter;
    public static final String NUMBER_TABLE = "number table";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBining = DataBindingUtil.setContentView(this, R.layout.activity_menus);

        String meja = getIntent().getStringExtra(NUMBER_TABLE);
        Toast.makeText(this, meja, Toast.LENGTH_SHORT).show();

        mPresenter = initPresenter();
        mPresenter.bind(this);
        mPresenter.getDataMakanan();
    }

    @Override
    public MenusContract.Presenter initPresenter() {
        return new MenusPresenter(Injection.provideCoreAppRepository(getApplicationContext()),
                Injection.provideSchedulerProvider());
    }

    @Override
    public void showDataMakanan(List<DaftarMenuList> daftarMenuLists) {
        if (mAdapter == null){
            mAdapter = createAdapter(daftarMenuLists);
        }
        if (mBining.rvListMenu.getAdapter() == null){
            mBining.rvListMenu.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            mBining.rvListMenu.setAdapter(mAdapter);
        }
    }

    private MenusAdapter createAdapter(List<DaftarMenuList> daftarMenuLists){
        mAdapter = new MenusAdapter(daftarMenuLists, this);
        return mAdapter;
    }

    public static void startToMenu(Activity activity, int numberTable){
        Intent intent = new Intent(activity, MenusActivity.class);
        intent.putExtra(NUMBER_TABLE , String.valueOf(numberTable));
        activity.startActivity(intent);
    }
}
