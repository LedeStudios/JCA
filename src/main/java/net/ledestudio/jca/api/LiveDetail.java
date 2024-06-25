package net.ledestudio.jca.api;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.util.Optional;

public interface LiveDetail extends LiveStatus {

    int getLiveId();

    @NotNull String getLiveImageUrl();

    @NotNull String getDefaultThumbnailImageUrl();

    @NotNull Optional<LocalDateTime> getOpenDate();

    @NotNull Optional<LocalDateTime> getCloseDate();

    @NotNull LiveChannel getChannel();

}
