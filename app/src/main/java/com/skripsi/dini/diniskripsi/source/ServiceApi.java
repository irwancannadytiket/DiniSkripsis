package com.skripsi.dini.diniskripsi.source;

import com.skripsi.dini.diniskripsi.model.DaftarMenuList;
import com.skripsi.dini.diniskripsi.model.DaftarMenuListResponse;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by irwancannady on 11/10/17.
 */

public interface ServiceApi {

    @GET("questions")
    Observable<List<DaftarMenuList>> getDaftarMenuList();
}
