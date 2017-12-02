package com.skripsi.dini.diniskripsi.source;

import com.skripsi.dini.diniskripsi.model.DaftarMenuList;
import com.skripsi.dini.diniskripsi.model.DaftarMenuListResponse;

import java.util.List;

import rx.Observable;

/**
 * Created by irwancannady on 11/10/17.
 */

public interface DaftarMenuListDataSource {

    Observable<List<DaftarMenuList>> getDaftarMenuList();
}
