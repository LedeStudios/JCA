package net.ledestudio.jca.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Optional;

public class Utils {

    public static @NotNull Request.Builder httpGetRequest(String url) {
        return new Request.Builder()
                .url(url)
                .get();
    }

    public static @NotNull Optional<JsonObject> getRawJson(
            @NotNull OkHttpClient httpClient,
            @NotNull Request request
    ) throws IOException {
        try {
            final Response response = httpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                final ResponseBody body = response.body();
                final JsonObject json = JsonParser.parseString(body.string()).getAsJsonObject();
                return Optional.ofNullable(json);
            }
        } catch (Exception e) {
            throw new IOException("Response was not successful!", e);
        }

        return Optional.empty();
    }

    public static @NotNull Optional<JsonElement> getContentJson(
            @NotNull OkHttpClient httpClient,
            @NotNull Request request
    ) throws IOException {
        return getRawJson(httpClient, request).map(jsonObject -> jsonObject.get("content"));
    }

}
