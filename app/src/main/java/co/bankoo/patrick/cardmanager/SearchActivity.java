package co.bankoo.patrick.cardmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import co.bankoo.patrick.cardmanager.Controllers.ActivityAdapter;
import co.bankoo.patrick.cardmanager.Models.ActivityItem;

public class SearchActivity extends AppCompatActivity {

    private List<ActivityItem> activityItemList = new ArrayList<>();
    String activityTitle;
    TextView barTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        activityTitle = "查询";
        barTitle = (TextView) findViewById(R.id.title_text);
        barTitle.setText(activityTitle);

        /*
            Setup the list view here
         */
        initActivities();           // Initialize the activity data
        ActivityAdapter adapter = new ActivityAdapter(SearchActivity.this, R.layout.table_cell_2, activityItemList);
        ListView listView = (ListView) findViewById(R.id.search_list_view);
        listView.setAdapter(adapter);
    }

    private void initActivities() {

        ActivityItem searchCustomer = new ActivityItem("商户查询");
        activityItemList.add(searchCustomer);

        ActivityItem searchCard = new ActivityItem("卡片查询");
        activityItemList.add(searchCard);

    }
}
