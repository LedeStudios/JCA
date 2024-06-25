package net.ledestudio.jca.chzzk;

import net.ledestudio.jca.api.User;
import org.jetbrains.annotations.NotNull;

import java.time.ZonedDateTime;
import java.util.Arrays;

public class ChzzkUser implements User {

    private boolean hasProfile;
    private String userIdHash;
    private String nickname;
    private String profileImageUrl;
    private Object[] penalties; // unknown
    private boolean officialNotiAgree;
    private String officialNotiAgreeUpdatedDate;
    private boolean verifiedMark;
    private boolean loggedIn;

    @Override
    public boolean hasProfile() {
        return hasProfile;
    }

    @Override
    public boolean hasVerifiedMark() {
        return verifiedMark;
    }

    @Override
    public @NotNull String getId() {
        return userIdHash;
    }

    @Override
    public @NotNull String getName() {
        return nickname;
    }

    @Override
    public @NotNull String getProfileImageUrl() {
        return profileImageUrl;
    }

    @Override
    public boolean isOfficialNotifyAgree() {
        return officialNotiAgree;
    }

    @Override
    public @NotNull ZonedDateTime getOfficialNotifyAgreeUpdatedDate() {
        return ZonedDateTime.parse(officialNotiAgreeUpdatedDate);
    }

    @Override
    public boolean isLoggedIn() {
        return loggedIn;
    }

    @Override
    public String toString() {
        return "ChzzkUser{" +
                "hasProfile=" + hasProfile +
                ", userIdHash='" + userIdHash + '\'' +
                ", nickname='" + nickname + '\'' +
                ", profileImageUrl='" + profileImageUrl + '\'' +
                ", penalties=" + Arrays.toString(penalties) +
                ", officialNotiAgree=" + officialNotiAgree +
                ", officialNotiAgreeUpdatedDate='" + officialNotiAgreeUpdatedDate + '\'' +
                ", verifiedMark=" + verifiedMark +
                ", loggedIn=" + loggedIn +
                '}';
    }

}
