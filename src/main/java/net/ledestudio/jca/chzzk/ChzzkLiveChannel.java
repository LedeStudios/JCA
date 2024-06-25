package net.ledestudio.jca.chzzk;

import net.ledestudio.jca.api.LiveChannel;
import org.jetbrains.annotations.NotNull;

public class ChzzkLiveChannel implements LiveChannel {

    private String channelId;
    private String channelName;
    private String channelImageUrl;
    private boolean verifiedMark;

    @Override
    public @NotNull String getId() {
        return channelId;
    }

    @Override
    public @NotNull String getName() {
        return channelName;
    }

    @Override
    public @NotNull String getImageUrl() {
        return channelImageUrl;
    }

    @Override
    public boolean hasVerifiedMark() {
        return verifiedMark;
    }

    @Override
    public String toString() {
        return "ChzzkLiveChannel{" +
                "channelId='" + channelId + '\'' +
                ", channelName='" + channelName + '\'' +
                ", channelImageUrl='" + channelImageUrl + '\'' +
                ", verifiedMark=" + verifiedMark +
                '}';
    }

}
