package co.bankoo.patrick.cardmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import co.bankoo.patrick.cardmanager.Controllers.ActivityAdapter;
import co.bankoo.patrick.cardmanager.Models.ActivityItem;

public class HandleActivity extends AppCompatActivity {

    private List<ActivityItem> activityItemList = new ArrayList<>();
    String activityTitle;
    TextView barTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handle);

        activityTitle = "办理";
        barTitle = (TextView) findViewById(R.id.title_text);
        barTitle.setText(activityTitle);

        /*
            Setup the list view here
         */
        initActivities();           // Initialize the activity data
        ActivityAdapter adapter = new ActivityAdapter(HandleActivity.this, R.layout.table_view_action, activityItemList);
        ListView listView = (ListView) findViewById(R.id.handle_list_view);
        listView.setAdapter(adapter);


        /*
            Setup onClick events for list view
         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ActivityItem activityItem = activityItemList.get(i);
                switch (activityItem.getTitle()) {
                    case "开卡":
                        Intent intent = new Intent(HandleActivity.this, NewCardActivity.class);
                        startActivity(intent);
                        break;
                    case "补卡":
                        Intent intent2 = new Intent(HandleActivity.this, NewCardActivity.class);
                        startActivity(intent2);
                        break;
                    case "换卡":
                        Intent intent3 = new Intent(HandleActivity.this, NewCardActivity.class);
                        startActivity(intent3);
                        break;
                    default:
                        Log.d("HandleActivity", "onItemClick: Invalid activityItem Title");
                        break;
                }
            }
        });

    }
    private void initActivities() {

        ActivityItem cardCreation = new ActivityItem("开卡");
        cardCreation.setSubtitle("办理新卡片");
        activityItemList.add(cardCreation);

        ActivityItem cardReplacement = new ActivityItem("补卡");
        cardReplacement.setSubtitle("卡片丢失、损坏");
        activityItemList.add(cardReplacement);

        ActivityItem cardChange = new ActivityItem("换卡");
        cardChange.setSubtitle("外观损坏");
        activityItemList.add(cardChange);
    }
}
