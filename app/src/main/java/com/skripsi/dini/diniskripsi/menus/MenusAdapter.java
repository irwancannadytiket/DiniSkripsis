package com.skripsi.dini.diniskripsi.menus;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.view.View;
import android.widget.LinearLayout;

import com.skripsi.dini.diniskripsi.R;
import com.skripsi.dini.diniskripsi.commons.BaseBindingAdapter;
import com.skripsi.dini.diniskripsi.databinding.RowMenusListBinding;
import com.skripsi.dini.diniskripsi.model.DaftarMenuList;

import java.util.List;

/**
 * Created by irwancannady on 11/10/17.
 */

public class MenusAdapter extends BaseBindingAdapter{

    private List<DaftarMenuList> mDaftarMenu;
    private Context context;
    private onclickItem mOnclickItem;

    public MenusAdapter(List<DaftarMenuList> mDaftarMenu, Context context) {
        this.mDaftarMenu = mDaftarMenu;
        this.context = context;
    }

    public interface onclickItem {
        void countTotalItem(int total);
    }

    public void setOnClickCount(onclickItem onClickCount){
        this.mOnclickItem = onClickCount;
    }

    @Override
    protected void updateBinding(ViewDataBinding binding, int position) {
        final RowMenusListBinding item = (RowMenusListBinding) binding;
        final DaftarMenuList daftarMenuList = mDaftarMenu.get(position);
        item.tvNameMakanan.setText(daftarMenuList.getNama_menu());
        item.tvHargaMakanan.setText("Rp." + daftarMenuList.getHarga());

        item.llContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = item.etJumlah.getText().toString();
                int b = Integer.parseInt(a);
                mOnclickItem.countTotalItem(Integer.parseInt(daftarMenuList.getHarga()) * b);
            }
        });
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.row_menus_list;
    }

    @Override
    protected View.OnClickListener getOnClickListener() {
        return null;
    }

    @Override
    public int getItemCount() {
        return mDaftarMenu.size();
    }
}
