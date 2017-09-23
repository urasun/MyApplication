package com.coldsun.myapplication;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;


public class MultiStock {
    int showapi_res_code;		//": 0,
    String showapi_res_error;	//": "",
    MultiStockBody showapi_res_body;	//":

    static List <MyStock> myStockList = new LinkedList<MyStock>();

    public MultiStock() {

    }

    public int getShowapi_res_code() {
        return showapi_res_code;
    }

    public void setShowapi_res_code(int showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public MultiStockBody getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(MultiStockBody showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }



//    public  List <MyStock> getMultiStock() {
//        String host = "https://ali-stock.showapi.com";
//        String path = "/batch-real-stockinfo";
//        String method = "GET";
//        String appcode = "2b6dc224e43c40c6a01ee7028ff617ca";
//        Map<String, String> headers = new HashMap<String, String>();
//        // 最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
//        headers.put("Authorization", "APPCODE " + appcode);
//        Map<String, String> querys = new HashMap<String, String>();
//        querys.put("needIndex", "0");
//        //   querys.put("stocks", "sh601006%2Csh601007%2Csh601008%2Csh601009%2Csz000018%2Chk00941");
//
//
//        initMyStockList();
//
//
//        double total = 0;
//        double total_gain = 0;
//        String str = new String();
//        Iterator<MyStock> it = myStockList.iterator();
//        while (it.hasNext()) {
//            str += it.next().getId() + ",";
//        }
//        querys.put("stocks", str);
//
////			System.out.println(str);
//
//
//        try {
//
//            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
//            HttpEntity entity = response.getEntity();
//            if (entity != null) {
//
//                String out = EntityUtils.toString(entity);
//
//                MultiStock restInfo = JSON.parseObject(out, MultiStock.class);
//                List<StockContent> stockContentList = restInfo.getShowapi_res_body().getList();
//                printStockContentList(stockContentList);
//
//                return myStockList;
//
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }

    private void buildStockContentList(List<StockContent> stockContentList ) {
        Iterator<StockContent> itStockContent = stockContentList.iterator();
        System.out.println("ID      NAME      SHARES  PRICE  COST      VALUE       GAIN      PERCENT");

        while (itStockContent.hasNext()) {
            //System.out.println("code "+itStockContent.next().getCode());
            StockContent stockContent = itStockContent.next();
            for(int i = 0; i < myStockList.size(); i++) {
                if(myStockList.get(i).id.equals(stockContent.getCode())) {
                    MyStock myStock = new MyStock();
                    myStock = myStockList.get(i);
                    myStock.setPrice(stockContent.nowPrice);
                    myStock.setName( stockContent.name);
                    myStockList.set(i, myStock);
             //       break;
                }
            }
        }
//        float total  = 0;
//        float total_gain = 0;
//
//        for(int i = 0; i < myStockList.size(); i++) {
//            System.out.println(myStockList.get(i).toString());
//            total += myStockList.get(i).getPrice() * myStockList.get(i).getShares();
//            total_gain += myStockList.get(i).gain;
//        }
//
//        System.out.println(String.format("TOTAL VAL = %,10.2f   TOTAL GAIN =  %,10.2f", total,  total_gain));

    }

    private static void initMyStockList() {
//        myStockList.clear();
//        myStockList.add(new MyStock("00327", 500000, 4.86f));
//        myStockList.add(new MyStock("00001", 10000, 102.4f));
//        myStockList.add(new MyStock("00700", 2500, 190.5f));
//        myStockList.add(new MyStock("03396", 10000, 43.2f));
//        myStockList.add(new MyStock("06030", 50000, 18.6f));
//        myStockList.add(new MyStock("01211", 500, 45.0f));
//        myStockList.add(new MyStock("01114", 20000, 12.5f));
//        myStockList.add(new MyStock("02318", 4000, 61.5f));
    }

    public  void addStock(MyStock myStock) {
        myStockList.add(myStock);
    }

    public void emtpy() {
        myStockList.clear();
    }


    public  List<MyStock> getMultiStockList() {
        String host = "https://ali-stock.showapi.com";
        String path = "/batch-real-stockinfo";
        String method = "GET";
        String appcode = "2b6dc224e43c40c6a01ee7028ff617ca";
        Map<String, String> headers = new HashMap<String, String>();
        // 最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("needIndex", "0");
        //   querys.put("stocks", "sh601006%2Csh601007%2Csh601008%2Csh601009%2Csz000018%2Chk00941");


      //  initMyStockList();


        double total = 0;
        double total_gain = 0;
        String str = new String();
        Iterator<MyStock> it = myStockList.iterator();
        while (it.hasNext()) {
            str += it.next().getId() + ",";
        }
        querys.put("stocks", str);

//			System.out.println(str);


        try {

            String out = HttpUtils.retrieveResponseFromServer(host, path, method, headers, querys);


            MultiStock restInfo = JSON.parseObject(out, MultiStock.class);
            List<StockContent> stockContentList = restInfo.getShowapi_res_body().getList();
            buildStockContentList(stockContentList);

            return myStockList;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

}
