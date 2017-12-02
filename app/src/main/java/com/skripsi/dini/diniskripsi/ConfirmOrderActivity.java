package com.skripsi.dini.diniskripsi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by wandy on 12/3/17.
 */

public class ConfirmOrderActivity extends AppCompatActivity {

    public final static String HENDRA_B_UTAMA = "Hendra B Utama";
    private final static String TAG = ConfirmOrderActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final String rawRequest = getIntent().getStringExtra(HENDRA_B_UTAMA);
        Log.d(TAG, rawRequest);
    }
}
