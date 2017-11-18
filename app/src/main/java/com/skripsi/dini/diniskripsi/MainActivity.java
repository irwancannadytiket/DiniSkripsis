package com.skripsi.dini.diniskripsi;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.skripsi.dini.diniskripsi.databinding.ActivityMainBinding;
import com.skripsi.dini.diniskripsi.menus.MenusActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mBinding.btnMeja1.setOnClickListener(this);
        mBinding.btnMeja2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_meja1){
            MenusActivity.startToMenu(this, 1);
        } else if (view.getId() == R.id.btn_meja2){
            MenusActivity.startToMenu(this, 2);
        }
    }
}
