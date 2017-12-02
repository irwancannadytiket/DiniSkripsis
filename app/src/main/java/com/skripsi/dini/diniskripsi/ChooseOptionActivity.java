package com.skripsi.dini.diniskripsi;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.skripsi.dini.diniskripsi.databinding.DialogOptionBinding;
import com.skripsi.dini.diniskripsi.menus.MenusActivity;

/**
 * Created by irwancannady on 11/18/17.
 */

public class ChooseOptionActivity extends AppCompatActivity {

    private DialogOptionBinding mBinding;
    public static final String NUMBER_TABLE = "number table";
    private String noMeja;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.dialog_option);

        setSupportActionBar(mBinding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mBinding.toolbar.setTitle(R.string.choose_option);
        mBinding.toolbar.setTitleTextColor(getResources().getColor(R.color.whte));

        noMeja = getIntent().getStringExtra(NUMBER_TABLE);

        mBinding.llPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MenusActivity.startToMenu(ChooseOptionActivity.this, Integer.parseInt(noMeja));
            }
        });

        mBinding.llLihatTagihan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        mBinding.llLihatProses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChooseOptionActivity.this, ShowStatusActivity.class));
            }
        });
    }

    public static void startToOption(Activity activity, int numberTable){
        Intent intent = new Intent(activity, ChooseOptionActivity.class);
        intent.putExtra(NUMBER_TABLE , String.valueOf(numberTable));
        activity.startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
