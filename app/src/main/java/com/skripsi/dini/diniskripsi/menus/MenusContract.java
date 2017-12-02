package com.skripsi.dini.diniskripsi.menus;

import com.skripsi.dini.diniskripsi.commons.BasePresenter;
import com.skripsi.dini.diniskripsi.commons.BaseView;
import com.skripsi.dini.diniskripsi.model.DaftarMenuList;
import com.skripsi.dini.diniskripsi.model.DaftarMenuListResponse;

import java.util.List;

/**
 * Created by irwancannady on 11/10/17.
 */

public interface MenusContract {

    interface View extends BaseView<Presenter>{
        void showDataMakanan(List<DaftarMenuList> daftarMenuLists);
    }

    interface Presenter extends BasePresenter<View>{

        void getDataMakanan();
    }
}
