package net.ledestudio.jca.chzzk;

import net.ledestudio.jca.api.LiveStatus;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ChzzkLiveStatus implements LiveStatus {

    private String liveTitle;
    private String status;
    private int concurrentUserCount;
    private int accumulateCount;
    private boolean paidPromotion;
    private boolean adult;
    private boolean clipActive;
    private String chatChannelId;
    private List<String> tags;
    private String categoryType;
    private String liveCategory;
    private String liveCategoryValue;
    private String livePollingStatusJson;
    private Object faultStatus;
    private Object userAdultStatus;
    private boolean chatActive;
    private String chatAvailableGroup;
    private String chatAvailableCondition;
    private int minFollowerMinute;
    private boolean chatDonationRankingExposure;

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
