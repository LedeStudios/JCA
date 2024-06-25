package net.ledestudio.jca.chzzk;

import net.ledestudio.jca.api.LiveChannel;
import net.ledestudio.jca.api.LiveDetail;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.util.Optional;

public class ChzzkLiveDetail extends ChzzkLiveStatus implements LiveDetail {

    private int liveId;
    private String liveImageUrl;
    private String defaultThumbnailImageUrl;
    private String openDate;
    private String closeDate;
    private ChzzkLiveChannel channel;

    @Override
    public int getLiveId() {
        return liveId;
    }

    @Override
    public @NotNull String getLiveImageUrl() {
        return liveImageUrl;
    }

    @Override
    public @NotNull String getDefaultThumbnailImageUrl() {
        return defaultThumbnailImageUrl;
    }

    @Override
    public @NotNull Optional<LocalDateTime> getOpenDate() {
        if (openDate == null) {
            return Optional.empty();
        }
        return Optional.of(LocalDateTime.parse(openDate));
    }

    @Override
    public @NotNull Optional<LocalDateTime> getCloseDate() {
        if (closeDate == null) {
            return Optional.empty();
        }
        return Optional.of(LocalDateTime.parse(closeDate));
    }

    @Override
    public @NotNull LiveChannel getChannel() {
        return channel;
    }

    @Override
    public String toString() {
        return "ChzzkLiveDetail{" +
                "liveId=" + liveId +
                ", liveImageUrl='" + liveImageUrl + '\'' +
                ", defaultThumbnailImageUrl='" + defaultThumbnailImageUrl + '\'' +
                ", openDate='" + openDate + '\'' +
                ", closeDate='" + closeDate + '\'' +
                ", channel=" + channel +
                '}';
    }

}
