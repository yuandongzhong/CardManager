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


public class SettingActivity extends AppCompatActivity {

    String activityTitle;
    TextView barTitle;
    private List<SettingItem> settingItemList_S1  = new ArrayList<>();                  // Items for list view session 1
    private List<SettingItem> settingItemList_S2  = new ArrayList<>();                  // Items for list view session 2

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        activityTitle = "设置";
        barTitle = (TextView) findViewById(R.id.title_text);
        barTitle.setText(activityTitle);

         /*
            Setup the list view here
         */
        initListItem();                 // Initialize the setting item list

        SettingAdapter adapter_S1 = new SettingAdapter(SettingActivity.this, R.layout.table_cell_3, settingItemList_S1);
        SettingAdapter adapter_S2 = new SettingAdapter(SettingActivity.this, R.layout.table_cell_3, settingItemList_S2);

        ListView listView_S1 = (ListView) findViewById(R.id.setting_list_view_s1);
        listView_S1.setAdapter(adapter_S1);

        ListView listView_S2 = (ListView) findViewById(R.id.setting_list_view_s2);
        listView_S2.setAdapter(adapter_S2);

    }

    private void initListItem() {

        SettingItem versionCheck = new SettingItem("检查版本");
        versionCheck.setSubtitle("1.0.0");                       // Show current version
        settingItemList_S1.add(versionCheck);

        SettingItem passChange = new SettingItem("修改密码");
        settingItemList_S1.add(passChange);

        SettingItem feedback = new SettingItem("意见反馈");
        settingItemList_S1.add(feedback);

        SettingItem contact = new SettingItem("联系客服");
        contact.setSubtitle("400-0000-000");                     // Show the phone number
        settingItemList_S2.add(contact);

        SettingItem aboutUs = new SettingItem("关于我们");
        settingItemList_S2.add(aboutUs);

    }
}


/*
    Items on the setting page
 */
class SettingItem {
    private String title;               // title of the activity
    private String subtitle;

    SettingItem(String title) {
        this.title = title;
        this.subtitle = "";             // Subtitle is null by default
    }

    String getTitle() {
        return title;
    }

    String getSubtitle() {
        return subtitle;
    }

    void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
}

/*
    Custom ArrayAdapter for settingItemList
 */

class SettingAdapter extends ArrayAdapter<SettingItem> {
    private int resourceId;

    public SettingAdapter(Context context, int textViewResourceId, List<SettingItem> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SettingItem settingItem = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        TextView title = (TextView) view.findViewById(R.id.table_cell_3_title);
        TextView subtitle = (TextView) view.findViewById(R.id.table_cell_3_subtitle);
        title.setText(settingItem.getTitle());
        subtitle.setText(settingItem.getSubtitle());

        if(title.getText().equals("联系客服")) {
            subtitle.setTextColor(Color.parseColor("#FEB33B"));
        }
        return view;
    }
}
