package net.ledestudio.jca;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.ledestudio.jca.api.LiveDetail;
import net.ledestudio.jca.api.LiveStatus;
import net.ledestudio.jca.api.User;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public abstract class JCA {

    protected final @NotNull Gson gson = new GsonBuilder().create();
    protected final @NotNull OkHttpClient httpClient;

    protected JCA(@NotNull OkHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public final @NotNull OkHttpClient getHttpClient() {
        return httpClient;
    }

    public abstract @NotNull Optional<LiveDetail> getLiveDetail(@NotNull String id);

    public abstract @NotNull Optional<LiveStatus> getLiveStatus(@NotNull String id);

    public abstract boolean isLoggedIn();

    /**
     * Fetching and returning the logged-in user's information.
     * @return Populating and returning values if the user's information exists.
     */
    public abstract @NotNull Optional<User> getCurrentUser();

}
