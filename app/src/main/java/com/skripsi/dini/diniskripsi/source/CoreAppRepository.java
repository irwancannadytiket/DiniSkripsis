package com.skripsi.dini.diniskripsi.source;

import android.support.annotation.NonNull;

import com.skripsi.dini.diniskripsi.model.DaftarMenuList;
import com.skripsi.dini.diniskripsi.model.DaftarMenuListResponse;

import java.util.List;

import rx.Observable;

/**
 * Created by irwancannady on 8/27/17.
 */

public class CoreAppRepository implements DaftarMenuListDataSource{

    private static CoreAppRepository sInstance = null;

    private final RemoteDataSource mRemoteDataSource;

    public CoreAppRepository(@NonNull RemoteDataSource mRemoteDataSource) {
        this.mRemoteDataSource = mRemoteDataSource;
    }

    public static CoreAppRepository getInstance(@NonNull RemoteDataSource remoteDataSource){
        if (sInstance == null){
            sInstance = new CoreAppRepository(remoteDataSource);
        }
        return sInstance;
    }

    public void destroyInstance(){
        sInstance = null;
    }

    @Override
    public Observable<List<DaftarMenuList>> getDaftarMenuList() {
        return mRemoteDataSource.getDaftarMenuList();
    }
}
