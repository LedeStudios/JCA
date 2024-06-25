package net.ledestudio.jca;

import net.ledestudio.jca.api.LiveDetail;
import net.ledestudio.jca.api.LiveStatus;
import net.ledestudio.jca.api.User;
import net.ledestudio.jca.chzzk.ChzzkLiveDetail;
import net.ledestudio.jca.chzzk.ChzzkLiveStatus;
import net.ledestudio.jca.utils.Constants;
import net.ledestudio.jca.utils.JCALogger;
import net.ledestudio.jca.utils.Utils;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Optional;

public class ChzzkAnonymousJCA extends JCA {

    ChzzkAnonymousJCA(@NotNull OkHttpClient httpClient) {
        super(httpClient);
    }

    @Override
    public @NotNull Optional<LiveDetail> getLiveDetail(@NotNull String id) {
        try {
            return Utils.getContentJson(
                    httpClient,
                    Utils.httpGetRequest(String.format(
                            "%s/service/v1/channels/%s/live-detail", Constants.CHZZK_URL, id)).build()
            ).map(json -> gson.fromJson(json, ChzzkLiveDetail.class));
        } catch (IOException e) {
            JCALogger.warning("Unable to retrieve live broadcast information.", e);
            return Optional.empty();
        }
    }

    @Override
    public @NotNull Optional<LiveStatus> getLiveStatus(@NotNull String id) {
        try {
            return Utils.getContentJson(
                    httpClient,
                    Utils.httpGetRequest(String.format(
                            "%s/polling/v1/channels/%s/live-status", Constants.CHZZK_URL, id)).build()
            ).map(json -> gson.fromJson(json, ChzzkLiveStatus.class));
        } catch (IOException e) {
            JCALogger.warning("Unable to retrieve live broadcast information.", e);
            return Optional.empty();
        }
    }

    @Override
    public boolean isLoggedIn() {
        return false;
    }

    @Override
    public @NotNull Optional<User> getCurrentUser() {
        return Optional.empty();
    }

}
