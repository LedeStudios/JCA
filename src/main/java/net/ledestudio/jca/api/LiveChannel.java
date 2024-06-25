package net.ledestudio.jca.api;

import org.jetbrains.annotations.NotNull;

public interface LiveChannel {

    @NotNull String getId();

    @NotNull String getName();

    @NotNull String getImageUrl();

    boolean hasVerifiedMark();

}
