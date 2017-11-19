package com.skripsi.dini.diniskripsi;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
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
        mBinding.btnMeja3.setOnClickListener(this);
        mBinding.btnMeja4.setOnClickListener(this);
        mBinding.btnMeja5.setOnClickListener(this);
        mBinding.btnMeja6.setOnClickListener(this);
        mBinding.btnMeja7.setOnClickListener(this);
        mBinding.btnMeja8.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_meja1) {
            ChooseOptionActivity.startToOption(this, 1);
        } else if (view.getId() == R.id.btn_meja2) {
            ChooseOptionActivity.startToOption(this, 2);
        } else if (view.getId() == R.id.btn_meja3) {
            ChooseOptionActivity.startToOption(this, 3);
        } else if (view.getId() == R.id.btn_meja4) {
            ChooseOptionActivity.startToOption(this, 4);
        } else if (view.getId() == R.id.btn_meja5) {
            ChooseOptionActivity.startToOption(this, 5);
        } else if (view.getId() == R.id.btn_meja6) {
            ChooseOptionActivity.startToOption(this, 6);
        } else if (view.getId() == R.id.btn_meja7) {
            ChooseOptionActivity.startToOption(this, 7);
        } else if (view.getId() == R.id.btn_meja8) {
            ChooseOptionActivity.startToOption(this, 8);
        }
    }
}
