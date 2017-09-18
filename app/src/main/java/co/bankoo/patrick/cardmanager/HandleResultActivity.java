package co.bankoo.patrick.cardmanager;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import co.bankoo.patrick.cardmanager.Controllers.BaseActivity;
import co.bankoo.patrick.cardmanager.Models.RecordItem;

import static android.view.View.GONE;

/*
 *  This activity is to show the result from "办理卡片"
 */

public class HandleResultActivity extends BaseActivity {

    String activityTitle;
    TextView barTitle;

    private List<RecordItem> recordItemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handle_result);

        activityTitle = "办理卡片";
        barTitle = (TextView) findViewById(R.id.title_text);
        barTitle.setText(activityTitle);

        /*
         *  Show handling result
         */
        initRecordItem();
        showResult();
    }

    void showResult() {
        HandleResultAdapter adapter = new HandleResultAdapter(HandleResultActivity.this, R.layout.handle_result_list, recordItemList);
        ListView listView = (ListView) findViewById(R.id.handle_result_list_view);
        listView.setAdapter(adapter);
    }

    /*
     *  TODO: parse data from the cloud directly
     */
    private void initRecordItem() {
        recordItemList.add(new RecordItem("卡等级", "普通卡"));
        recordItemList.add(new RecordItem("卡号", "3241234124123"));
        recordItemList.add(new RecordItem("余额", "¥0.00"));
        recordItemList.add(new RecordItem("完成时间", "2017-07-25 14:25"));
    }
}


/*
 *  Custom ArrayAdapter
 */

class HandleResultAdapter extends ArrayAdapter<RecordItem> {
    private int resourceId;

    public HandleResultAdapter(Context context, int textViewResourcedId, List<RecordItem> objects) {
        super(context, textViewResourcedId, objects);
        resourceId = textViewResourcedId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RecordItem recordItem = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);

        TextView title = (TextView) view.findViewById(R.id.handle_result_list_item_title);
        TextView detail = (TextView) view.findViewById(R.id.handle_result_list_item_detail);
        title.setText(recordItem.getTitle());
        detail.setText(recordItem.getDetail());

        return view;
    }
}

