package com.skripsi.dini.diniskripsi.model;

import java.util.List;

/**
 * Created by irwancannady on 12/2/17.
 */

public class Pesanan {

    private List<Order> pesan;
    private String no_meja;

    public List<Order> getPesan() {
        return pesan;
    }

    public void setPesan(List<Order> pesan) {
        this.pesan = pesan;
    }

    public String getNo_meja() {
        return no_meja;
    }

    public void setNo_meja(String no_meja) {
        this.no_meja = no_meja;
    }

    public static class Order {
        private String qty;
        private String menu_id;

        public String getMenu_id() {
            return menu_id;
        }

        public String getQty() {
            return qty;
        }

        public void setQty(String qty) {
            this.qty = qty;
        }

        public void setMenu_id(String menu_id) {
            this.menu_id = menu_id;
        }
    }
}
