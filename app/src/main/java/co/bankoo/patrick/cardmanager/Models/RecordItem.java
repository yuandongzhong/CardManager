package co.bankoo.patrick.cardmanager.Models;

/**
 * Created by patrick on 16/09/2017.
 */

public class RecordItem {

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
