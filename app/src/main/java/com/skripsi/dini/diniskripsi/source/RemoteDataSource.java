package com.skripsi.dini.diniskripsi.source;

import android.content.Context;
import android.support.annotation.NonNull;

import com.skripsi.dini.diniskripsi.model.DaftarMenuList;
import com.skripsi.dini.diniskripsi.model.DaftarMenuListResponse;

import java.util.List;

import rx.Observable;

/**
 * Created by irwancannady on 8/27/17.
 */

public class RemoteDataSource implements DaftarMenuListDataSource {

    private ServiceApi mServiceApi;
    private Context mContext;
    private static RemoteDataSource sInstance = null;

    public static RemoteDataSource getInstance(@NonNull Context context){
        if (sInstance == null){
            sInstance = new RemoteDataSource(context.getApplicationContext());
        }
        return sInstance;
    }

    private RemoteDataSource(Context context){
        mContext = context;
        mServiceApi = RetrofitHelper.getInstance(context).provideRetrofit().create(ServiceApi.class);
    }

    @Override
    public Observable<List<DaftarMenuList>> getDaftarMenuList() {
        return mServiceApi.getDaftarMenuList();
    }
}
