package com.skripsi.dini.diniskripsi.menus;

import com.skripsi.dini.diniskripsi.commons.BaseSchedulerProvider;
import com.skripsi.dini.diniskripsi.model.DaftarMenuList;
import com.skripsi.dini.diniskripsi.model.DaftarMenuListResponse;
import com.skripsi.dini.diniskripsi.source.CoreAppRepository;

import java.util.List;

import rx.Subscriber;

/**
 * Created by irwancannady on 11/10/17.
 */

public class MenusPresenter implements MenusContract.Presenter {

    private MenusContract.View mview;
    private BaseSchedulerProvider mScheduler;
    private CoreAppRepository mRepository;

    public MenusPresenter(CoreAppRepository mRepository, BaseSchedulerProvider mScheduler) {
        this.mScheduler = mScheduler;
        this.mRepository = mRepository;
    }

    @Override
    public void bind(MenusContract.View view) {
        mview = view;
    }

    @Override
    public void unbind() {
        mview = null;
    }

    @Override
    public void getDataMakanan() {
        mRepository.getDaftarMenuList()
                .subscribeOn(mScheduler.io())
                .observeOn(mScheduler.ui())
                .subscribe(new Subscriber<List<DaftarMenuList>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<DaftarMenuList> daftarMenuListResponse) {
                        if (mview != null){
                            mview.showDataMakanan(daftarMenuListResponse);
                        }
                    }
                });
    }
}
