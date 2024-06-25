package net.ledestudio.jca.api;

import org.jetbrains.annotations.NotNull;

import java.time.ZonedDateTime;

public interface User {

    @NotNull String getId();

    @NotNull String getName();

    @NotNull String getProfileImageUrl();

    boolean isOfficialNotifyAgree();

    @NotNull ZonedDateTime getOfficialNotifyAgreeUpdatedDate();

    boolean hasProfile();

    boolean hasVerifiedMark();

    boolean isLoggedIn();

}
