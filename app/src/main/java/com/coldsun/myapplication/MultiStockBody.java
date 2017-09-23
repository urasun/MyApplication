package com.coldsun.myapplication;
import java.util.ArrayList;
import java.util.List;

public class MultiStockBody {
    int ret_code;
    List<StockContent> list = new ArrayList<StockContent>();

    public MultiStockBody() {
        // TODO Auto-generated constructor stub
    }

    public int getRet_code() {
        return ret_code;
    }

    public void setRet_code(int ret_code) {
        this.ret_code = ret_code;
    }

    public List<StockContent> getList() {
        return list;
    }

    public void setListStockContent(List<StockContent> list) {
        this.list = list;
    }



}
