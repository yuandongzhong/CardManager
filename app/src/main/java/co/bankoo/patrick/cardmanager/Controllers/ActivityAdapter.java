package co.bankoo.patrick.cardmanager.Controllers;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;
import co.bankoo.patrick.cardmanager.Models.ActivityItem;
import co.bankoo.patrick.cardmanager.R;

/**
 * Created by patrick on 12/09/2017.
 */

public class ActivityAdapter extends ArrayAdapter<ActivityItem> {

    private int resourceId;

    public ActivityAdapter(Context context, int textViewResourceId, List<ActivityItem> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ActivityItem activity = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        TextView title = (TextView) view.findViewById(R.id.table_cell_title);
        TextView subtitle = (TextView) view.findViewById(R.id.table_cell_subtitle);
        title.setText(activity.getTitle());
        subtitle.setText(activity.getSubtitle());
        return view;
    }
}
