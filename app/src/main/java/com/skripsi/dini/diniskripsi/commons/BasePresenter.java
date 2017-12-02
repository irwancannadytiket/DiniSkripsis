package com.skripsi.dini.diniskripsi.commons;

/**
 * Created by irwancannady on 21/10/2016.
 */

public interface BasePresenter<V>{

    void bind(V view);
    void unbind();
}
