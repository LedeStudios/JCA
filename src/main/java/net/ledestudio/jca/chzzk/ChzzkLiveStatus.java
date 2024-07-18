package net.ledestudio.jca.chzzk;

import net.ledestudio.jca.api.LiveStatus;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ChzzkLiveStatus implements LiveStatus {

    protected String liveTitle;
    protected String status;
    protected int concurrentUserCount;
    protected int accumulateCount;
    protected boolean paidPromotion;
    protected boolean adult;
    protected boolean clipActive;
    protected String chatChannelId;
    protected List<String> tags;
    protected String categoryType;
    protected String liveCategory;
    protected String liveCategoryValue;
    protected String livePollingStatusJson;
    protected Object faultStatus;
    protected Object userAdultStatus;
    protected boolean chatActive;
    protected String chatAvailableGroup;
    protected String chatAvailableCondition;
    protected int minFollowerMinute;
    protected boolean chatDonationRankingExposure;

    @Override
    public @NotNull String getTitle() {
        return liveTitle;
    }

    @Override
    public boolean isOnline() {
        return status.equals("OPEN");
    }

    @Override
    public int getUserCount() {
        return concurrentUserCount;
    }

    @Override
    public int getAccumulateCount() {
        return accumulateCount;
    }

    @Override
    public boolean hasPaidPromotion() {
        return paidPromotion;
    }

    @Override
    public boolean isNSFW() {
        return adult;
    }

    @Override
    public boolean isClipActive() {
        return clipActive;
    }

    @Override
    public @NotNull String getChatChannelId() {
        return chatChannelId;
    }

    @Override
    public @NotNull List<String> getTags() {
        return tags;
    }

    @Override
    public @NotNull String getCategoryType() {
        return categoryType;
    }

    @Override
    public @NotNull String getLiveCategory() {
        return liveCategory;
    }

    @Override
    public @NotNull String getLiveCategoryValue() {
        return liveCategoryValue;
    }

    @Override
    public boolean isChatActive() {
        return chatActive;
    }

    @Override
    public @NotNull String getChatAvailableGroup() {
        return chatAvailableGroup;
    }

    @Override
    public @NotNull String getChatAvailableCondition() {
        return chatAvailableCondition;
    }

    @Override
    public int getMinFollowerMinute() {
        return minFollowerMinute;
    }

    @Override
    public boolean isChatDonationRankingExposure() {
        return chatDonationRankingExposure;
    }

    @Override
    public String toString() {
        return "ChzzkLiveStatus{" +
                "liveTitle='" + liveTitle + '\'' +
                ", status='" + status + '\'' +
                ", concurrentUserCount=" + concurrentUserCount +
                ", accumulateCount=" + accumulateCount +
                ", paidPromotion=" + paidPromotion +
                ", adult=" + adult +
                ", clipActive=" + clipActive +
                ", chatChannelId='" + chatChannelId + '\'' +
                ", tags=" + tags +
                ", categoryType='" + categoryType + '\'' +
                ", liveCategory='" + liveCategory + '\'' +
                ", liveCategoryValue='" + liveCategoryValue + '\'' +
                ", livePollingStatusJson='" + livePollingStatusJson + '\'' +
                ", faultStatus=" + faultStatus +
                ", userAdultStatus=" + userAdultStatus +
                ", chatActive=" + chatActive +
                ", chatAvailableGroup='" + chatAvailableGroup + '\'' +
                ", chatAvailableCondition='" + chatAvailableCondition + '\'' +
                ", minFollowerMinute=" + minFollowerMinute +
                ", chatDonationRankingExposure=" + chatDonationRankingExposure +
                '}';
    }

}
