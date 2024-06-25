package net.ledestudio.jca;

import net.ledestudio.jca.api.User;
import net.ledestudio.jca.chzzk.ChzzkUser;
import net.ledestudio.jca.utils.Constants;
import net.ledestudio.jca.utils.JCALogger;
import net.ledestudio.jca.utils.Utils;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Optional;

public class ChzzkIdentifiedJCA extends ChzzkAnonymousJCA {

    private final @NotNull String auth;
    private final @NotNull String session;

    ChzzkIdentifiedJCA(
            @NotNull OkHttpClient httpClient,
            @NotNull String auth,
            @NotNull String session
    ) {
        super(httpClient);
        this.auth = auth;
        this.session = session;
    }

    @Override
    public boolean isLoggedIn() {
        return this.getCurrentUser().map(User::isLoggedIn).orElse(false);
    }

    @Override
    public @NotNull Optional<User> getCurrentUser() {
        try {
            return Utils.getContentJson(
                    httpClient,
                    Utils.httpGetRequest(Constants.GAME_URL + "/v1/user/getUserStatus").build()
            ).map(json -> gson.fromJson(json, ChzzkUser.class));
        } catch (IOException e) {
            JCALogger.warning("Unable to retrieve user information.", e);
            return Optional.empty();
        }
    }
}
