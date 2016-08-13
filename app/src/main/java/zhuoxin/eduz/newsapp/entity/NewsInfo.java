package zhuoxin.eduz.newsapp.entity;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/7/27.
 */
public class NewsInfo {
    private String message;
    private int status;

    public NewsInfo() {
    }

    public String getMessage() {

        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ArrayList<News> getData() {
        return data;
    }

    public void setData(ArrayList<News> data) {
        this.data = data;
    }

    public NewsInfo(String message, int status, ArrayList<News> data) {

        this.message = message;
        this.status = status;
        this.data = data;
    }

    private ArrayList<News> data;

}
