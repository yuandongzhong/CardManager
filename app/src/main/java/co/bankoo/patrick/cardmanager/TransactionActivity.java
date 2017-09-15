package co.bankoo.patrick.cardmanager;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.speech.RecognizerResultsIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.GONE;


/*
    This activity is for showing transaction result of 充值 or 付款
 */


public class TransactionActivity extends AppCompatActivity {

    TextView barTitle;
    String activityTitle;

    private List<RecordItem> recordItemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);

         /*
          * Set up action bar
          */
        activityTitle = "交易记录";
        barTitle = (TextView) findViewById(R.id.title_text);
        barTitle.setText(activityTitle);

        /*
         *  Get data from intent (from previous activity)
         */
        Intent intent = getIntent();
        String taskName = intent.getStringExtra("task_name");
        Log.d("TaskName", taskName);


        /*
         *  Create and show record items
         */
        initListItem();
        showRecord(taskName);           // Show record according to if the task is "充值" or "付款"
    }

    void showRecord(String taskName) {

        TextView resultText = (TextView) findViewById(R.id.transaction_result_text);
        RecordAdapter adapter = new RecordAdapter(TransactionActivity.this, R.layout.transaction_record_list, recordItemList);
        ListView listView = (ListView) findViewById(R.id.transaction_list_view);
        listView.setAdapter(adapter);

        switch (taskName) {
            case "充值":
                resultText.setText("充值成功");
                break;
            case "收款":
                resultText.setText("付款成功");
                break;
            default:
                Log.d("TransactionActivity", "createRecord: Missing task name data from getIntent()");
                break;
        }
    }

    /*
     *  TODO: parse data from the cloud directly
     */
    private void initListItem() {
//        RecordItem amount = new RecordItem("充值金额", "¥500.00");
        RecordItem amount = new RecordItem("收款金额", "¥500.00");
        amount.setSubDetailPair("¥700.00", "¥200.00");

        RecordItem accountBalance = new RecordItem("卡内余额", "¥1000.00");
        RecordItem beneficiary = new RecordItem("收款方", "广州某某科技有限公司");
        RecordItem cardClass = new RecordItem("卡等级", "高级卡");
        RecordItem cardNumber = new RecordItem("收款卡号", "50769394");
        RecordItem orderNumber = new RecordItem("订单号", "4213141532423424");
        RecordItem finishTime = new RecordItem("完成时间", "2017-07-25 14:25");

        recordItemList.add(amount);
        recordItemList.add(accountBalance);
        recordItemList.add(beneficiary);
        recordItemList.add(cardClass);
        recordItemList.add(cardNumber);
        recordItemList.add(orderNumber);
        recordItemList.add(finishTime);
    }
}



/*
 *  Data structure for transaction record items
 */

class RecordItem {

    private String title;
    private String detail;

    // The subTitle and subDetail are for "收款金额" only
    private String[] subTitle = { "原价", "优惠" };
    private String[] subDetail = { "", "" };


    public RecordItem(String title, String detail) {
        this.title = title;
        this.detail = detail;
    }

    public String getTitle() { return title; }

    public String getDetail() { return detail; }

    public void setSubDetailPair(String detail_1, String detail_2) {
        this.subDetail[0] = detail_1;
        this.subDetail[1] = detail_2;
    }
    public String[] getSubItemTitle() { return subTitle; }
    public String[] getSubItemDetail() { return subDetail; }
}

/*
 *  Custom ArrayAdapter for recordItemList
 */

class RecordAdapter extends ArrayAdapter<RecordItem> {
    private int resourceId;

    public RecordAdapter(Context context, int textViewResourcedId, List<RecordItem> objects) {
        super(context, textViewResourcedId, objects);
        resourceId = textViewResourcedId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RecordItem recordItem = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);

        TextView title = (TextView) view.findViewById(R.id.transaction_record_item_title);
        TextView detail = (TextView) view.findViewById(R.id.transaction_record_item_detail);
        title.setText(recordItem.getTitle());
        detail.setText(recordItem.getDetail());

        /*
         *  Logic for handling the sub items TextView
         */
        View subItemCell_1 = (View) view.findViewById(R.id.transaction_record_subItem_1);
        View subItemCell_2 = (View) view.findViewById(R.id.transaction_record_subItem_2);

        if(!title.getText().equals("收款金额")) {
            subItemCell_1.setVisibility(GONE);                    // Hide the subItem by default (only activate for 收款金额）
            subItemCell_2.setVisibility(GONE);
        } else {
            /*
             * Show sub item for "收款金额"
             */
            TextView subTitle_1 = (TextView) view.findViewById(R.id.transaction_record_subItem_title_1);
            TextView subDetail_1 = (TextView) view.findViewById(R.id.transaction_record_subItem_detail_1);
            TextView subTitle_2 = (TextView) view.findViewById(R.id.transaction_record_subItem_title_2);
            TextView subDetail_2 = (TextView) view.findViewById(R.id.transaction_record_subItem_detail_2);

            subTitle_1.setText(recordItem.getSubItemTitle()[0]);
            subTitle_2.setText(recordItem.getSubItemTitle()[1]);
            subDetail_1.setText(recordItem.getSubItemDetail()[0]);
            subDetail_2.setText(recordItem.getSubItemDetail()[1]);
        }

        // Set the charge / payment amount text in red
        if(title.getText().equals("充值金额") || title.getText().equals("收款金额")) {
            detail.setTextColor(Color.RED);
        }

        return view;
    }
}

