package com.coldsun.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View.OnClickListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.app.AlertDialog;
import android.widget.EditText;
import android.view.LayoutInflater;
import android.content.DialogInterface;

import javax.crypto.Mac;

public class MainActivity extends Activity {
//                //定义显示数据
    private List<Map<String, String>> list = new ArrayList<Map<String, String>>();
    private List<MyStock> myStockList = new ArrayList<MyStock>();
    private ListView stockListView;
    private SimpleAdapter simpleAdapter = null;
    private Button refreshButton;
    private Button addStockButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);

        refreshButton = (Button) findViewById(R.id.refresh_button);
        refreshButton.setOnClickListener(new refreshButtonClickListener());

        addStockButton = (Button) findViewById(R.id.add_button);
        addStockButton.setOnClickListener(new addButtonClickListener());

        new Thread(runnable).start();

    }

    class addButtonClickListener implements OnClickListener{

        public void onClick(View v) {


            String strUsername = "";

            LayoutInflater factory = LayoutInflater.from(MainActivity.this);
            //得到自定义对话框
            final View DialogView = factory.inflate(R.layout.add_stock, null);
//创建对话框
            AlertDialog dlg = new AlertDialog.Builder(MainActivity.this)
                    .setTitle("登录框")
                    .setView(DialogView)//设置自定义对话框的样式
                    .setPositiveButton("确定", //设置"确定"按钮
                            new DialogInterface.OnClickListener() //设置事件监听
                            {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    //输入后点击“确定”，开始获取我们要的内容 DialogView就是AlertDialog弹出的Activity
                                    EditText editStockId = (EditText)DialogView.findViewById(R.id.edit_stock_id);
                                    String stockId = editStockId.getText().toString();
                                }
                            })
                    .setNegativeButton("取消", //设置“取消”按钮
                            new DialogInterface.OnClickListener()
                            {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    //点击"取消"按钮之后退出程序
                                 //   MainActivity.this.finish();
                                }
                            })
                    .create();//创建弹出框
            dlg.show();//显示


//            new AlertDialog.Builder(MainActivity.this)
//                    .setTitle("请输入")
//                    .setIcon(android.R.drawable.ic_dialog_info)
////                    .setView(new EditText(MainActivity.this))
//                    .setView(R.layout.add_stock)
//                    .setPositiveButton("确定", null)
//                    .setNegativeButton("取消", null)
//                    .show();

//            new Thread(runnable).start();
        }
    }
    //定义内部类，实现OnClickListene接口
    class refreshButtonClickListener implements OnClickListener{

        public void onClick(View v) {
            // TODO Auto-generated method stub
//            Log.i("定义内部类，实现OnClickListene接口", "点击事件");

            new Thread(runnable).start();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
//            Bundle data = msg.getData();
//            String val = data.getString("value");
//            Log.i("","请求结果:" + val);

            updateContent();


        }
    };

    private void updateContent() {
        this.stockListView =  MainActivity.super.findViewById(R.id.data_list);
        stockListView.removeAllViewsInLayout();
        this.simpleAdapter = new SimpleAdapter(this,        //实例化SimpleAdapter
                this.list, R.layout.data_list,                //要使用的显示模板
                new String[]{"id", "name", "price", "cost", "shares", "value", "gain"},                    //定义要显示的Map的Key
                new int[]{R.id.id, R.id.name, R.id.price, R.id.cost, R.id.shares, R.id.value, R.id.gain});            //与模板中的组建匹配
        this.stockListView.setAdapter(this.simpleAdapter);        //设置显示数据

    }
    Runnable runnable = new Runnable(){
        @Override
        public void run() {
            // TODO: http request.

            getPriceListFromHost();


            Message msg = new Message();
            Bundle data = new Bundle();
         //   data.putString("value","请求结果");
            msg.setData(data);
            handler.sendMessage(msg);
        }
    };

    private void getPriceListFromHost(){
        MultiStock multiStock = new MultiStock();
        myStockList = multiStock.getMultiStockList();

        if(myStockList != null) {
            System.out.println("ID      NAME      SHARES  PRICE  COST      VALUE       GAIN      PERCENT");

           // stockListView.removeAllViews();
            list.clear();
            Map<String, String> map1 = new HashMap<String, String>();

            map1.put("id", "ID");
            map1.put("name", "NAME");
            map1.put("price", "PRICE");
            map1.put("cost", "COST");
            map1.put("shares", "SHARES");
            map1.put("value", "VALUE");
            map1.put("gain", "GAIN");
            list.add(map1);

            float totalValue= 0;
            float totalGain = 0;
            Iterator<MyStock> itMystockList = myStockList.iterator();
            while (itMystockList.hasNext()) {
                MyStock myStock = itMystockList.next();
                Map<String, String> map = new HashMap<String, String>();

                map.clear();
                map.put("id", myStock.getId());
                map.put("name", ""+myStock.getName());
                map.put("price", String.format("%,.2f", myStock.getPrice()));
                map.put("cost", String.format("%,.2f", myStock.getCost()));
                map.put("shares", String.format("%,d", myStock.getShares()));
                map.put("value", String.format("%,.2f", myStock.price * myStock.shares));
                map.put("gain", String.format("%,.2f", (myStock.getShares() * (myStock.getPrice() - myStock.getCost()))));
                list.add(map);
                totalValue += myStock.price * myStock.shares;
                totalGain += myStock.getShares() * (myStock.getPrice() - myStock.getCost());
            }
            Map<String, String> map2 = new HashMap<String, String>();

            map2.clear();
            map2.put("id", "TOTAL");
            map2.put("value", String.format("%,.2f",totalValue));
            map2.put("gain", String.format("%,.2f",totalGain));
            list.add(map2);
        }
        else {

        }

    }
}