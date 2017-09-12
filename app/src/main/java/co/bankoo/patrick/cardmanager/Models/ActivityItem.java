package co.bankoo.patrick.cardmanager.Models;


/**
 * Created by patrick on 12/09/2017.
 */

public class ActivityItem {
    private String title;               // title of the activity
    private String subtitle;

    public ActivityItem(String title) {
        this.title = title;
        this.subtitle = "";             // Subtitle is null by default
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

}
