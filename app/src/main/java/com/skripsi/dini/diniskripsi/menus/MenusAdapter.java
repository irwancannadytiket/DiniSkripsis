package com.skripsi.dini.diniskripsi.menus;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.skripsi.dini.diniskripsi.R;
import com.skripsi.dini.diniskripsi.commons.BaseBindingAdapter;
import com.skripsi.dini.diniskripsi.commons.BaseBindingViewHolder;
import com.skripsi.dini.diniskripsi.databinding.RowMenusListBinding;
import com.skripsi.dini.diniskripsi.model.DaftarMenuList;
import com.skripsi.dini.diniskripsi.model.Pesanan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by irwancannady on 11/10/17.
 */

public class MenusAdapter extends BaseBindingAdapter {

    private List<DaftarMenuList> mDaftarMenu;
    List<Pesanan.Order> pesananList = new ArrayList<>();
    private Context context;
    private boolean isOpen;
    private int value;

    public MenusAdapter(List<DaftarMenuList> mDaftarMenu, Context context) {
        this.mDaftarMenu = mDaftarMenu;
        this.context = context;
    }

    DaftarMenuList getDaftarMenu(int position){
        return mDaftarMenu.get(position);
    }

    @Override
    protected void updateBinding(ViewDataBinding binding, final int position) {
        final RowMenusListBinding item = (RowMenusListBinding) binding;
        final DaftarMenuList daftarMenuList = mDaftarMenu.get(position);
        item.tvNameMakanan.setText(daftarMenuList.getNama_menu());
        item.tvHargaMakanan.setText("Rp." + daftarMenuList.getHarga());

        if (daftarMenuList.getNumber() == 0 || daftarMenuList.getNumber() <= 0) {
            item.btnMinus.setEnabled(false);
        }

        item.btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //set value for textView Value
                value = daftarMenuList.setNumber(daftarMenuList.getNumber() + 1);
                item.tvValue.setText(String.valueOf(value));
                item.btnMinus.setEnabled(true);
                item.rlTotalHarga.setVisibility(View.VISIBLE);

                //set to model bentuk List
                Pesanan pesanan = new Pesanan();

                Pesanan.Order menuList = new Pesanan.Order();
                menuList.setQty(String.valueOf(value));
                menuList.setMenu_id(daftarMenuList.getId());
                pesananList.add(menuList);
                pesanan.setPesan(pesananList);

                //bawa no meja
                pesanan.setNo_meja("4");

                String response = new Gson().toJson(pesanan, Pesanan.class);
                Log.d("hasilnya", response);

                //set to totalHarga
                int totalHarga = value * Integer.parseInt(daftarMenuList.getHarga());
                item.tvTotalHargaPerMenu.setText(String.valueOf(totalHarga));


            }
        });

        item.btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //set value for textView Value
                value = daftarMenuList.setNumber(daftarMenuList.getNumber() - 1);
                daftarMenuList.setNumber(value);
                mDaftarMenu.get(position).setNumber(daftarMenuList.getNumber()); // optional bisa pake ini
                item.tvValue.setText(String.valueOf(value));

                Pesanan pesanan = new Pesanan();

                Pesanan.Order menuList = new Pesanan.Order();
                List<Pesanan.Order> pesananList = new ArrayList<>();

                menuList.setQty(String.valueOf(value));
                menuList.setMenu_id(daftarMenuList.getId());
                pesananList.add(menuList);
                pesanan.setPesan(pesananList);

                //bawa no meja
                pesanan.setNo_meja("4");

                String response = new Gson().toJson(pesanan, Pesanan.class);
                Log.d("hasilnya", response);
                Toast.makeText(context, response, Toast.LENGTH_SHORT).show();

                if (value == 0) {
                    item.btnMinus.setEnabled(false);
                    item.rlTotalHarga.setVisibility(View.GONE);
                }

                //set to totalHarga
                int totalHarga = value * Integer.parseInt(daftarMenuList.getHarga());
                item.tvTotalHargaPerMenu.setText(String.valueOf(totalHarga));
            }
        });
    }

    public void listenForOrder(boolean open) {
        isOpen = open;
    }

    public List<DaftarMenuList> getEmployeeList() {
        return mDaftarMenu;
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
