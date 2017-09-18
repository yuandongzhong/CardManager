package co.bankoo.patrick.cardmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import co.bankoo.patrick.cardmanager.Controllers.BaseActivity;
import co.bankoo.patrick.cardmanager.Models.RecordItem;


/*
    This activity is for showing user info for both of 补卡 or 换卡
 */


public class UserInfoActivity extends BaseActivity {

    String activityTitle;
    TextView barTitle;
    private List<RecordItem> recordItemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        activityTitle = "用户信息";
        barTitle = (TextView) findViewById(R.id.title_text);
        barTitle.setText(activityTitle);

        /*
         *  Get data from intent (from previous activity)
         */
        Intent intent = getIntent();
        String taskName = intent.getStringExtra("task_name");
        Log.d("TaskName", taskName);

        /*
         *  Create and show info items
         */
        initListItem();
        showInfo(taskName);         // Show info depend on "换卡" or "补卡"
    }

    private void initListItem() {
        recordItemList.add(new RecordItem("姓名", "张先生"));
        recordItemList.add(new RecordItem("性别", "男"));
        recordItemList.add(new RecordItem("手机号码", "15112001453"));
        recordItemList.add(new RecordItem("证件号码", "512315121251312XX"));
        recordItemList.add(new RecordItem("卡等级", "高级卡"));
        recordItemList.add(new RecordItem("卡号", "3241234124123"));
    }

    void showInfo(String taskName) {
        HandleResultAdapter adapter = new HandleResultAdapter(UserInfoActivity.this, R.layout.list_view_2, recordItemList);
        ListView listView = (ListView) findViewById(R.id.user_info_list_view);
        listView.setAdapter(adapter);

        Button confirmButton = (Button) findViewById(R.id.user_info_button_confirm);

        switch (taskName) {
            case "补卡":
                confirmButton.setText("补卡");
                break;
            case "换卡":
                confirmButton.setText("换卡");
                break;
            default:
                Log.d("UserInfoActivity", "showRecord: Missing task name data from getIntent()");
                break;
        }
    }

}

