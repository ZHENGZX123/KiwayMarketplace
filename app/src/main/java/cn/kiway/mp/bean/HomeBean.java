package cn.kiway.mp.bean;

import java.util.List;


public class HomeBean {
    private static final String TAG = "HomeBean";


    private List<String> picture;


    private List<AppListItem> list;

    public List<String> getPicture() {
        return picture;
    }

    public void setPicture(List<String> picture) {
        this.picture = picture;
    }

    public List<AppListItem> getList() {
        return list;
    }

    public void setList(List<AppListItem> list) {
        this.list = list;
    }

}
