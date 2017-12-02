package com.skripsi.dini.diniskripsi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;
import com.skripsi.dini.diniskripsi.model.Pesanan;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by wandy on 12/3/17.
 */

public class ConfirmOrderActivity extends AppCompatActivity {

    public final static String HENDRA_B_UTAMA = "Hendra B Utama";
    public final static String HENDRA_B_LIST_UTAMA = "Hendra B List Utama";
    private final static String TAG = ConfirmOrderActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final String rawRequest = getIntent().getStringExtra(HENDRA_B_UTAMA);
        //Log.d(TAG, rawRequest);



        Bundle b = getIntent().getBundleExtra("bundle");
        ArrayList<Pesanan.Order> orders = (ArrayList<Pesanan.Order>) b.getSerializable(HENDRA_B_LIST_UTAMA);
        for(Pesanan.Order order :orders) {
            Log.d(TAG, order.getQty());
        }

    }
}
