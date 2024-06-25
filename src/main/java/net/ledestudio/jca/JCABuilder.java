package net.ledestudio.jca;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.jetbrains.annotations.NotNull;


public class JCABuilder {

    private String auth;
    private String session;
    private boolean isLoggedIn;

    public JCABuilder() {}

    public @NotNull JCABuilder login(@NotNull String NID_AUT, @NotNull String NID_SES) {
        this.auth = NID_AUT;
        this.session = NID_SES;
        this.isLoggedIn = true;
        return this;
    }

    public @NotNull JCA build() {
        final OkHttpClient.Builder builder = new OkHttpClient.Builder();

        if (isLoggedIn) {
            builder.addInterceptor(chain ->{
                final Request original = chain.request();
                final Request authorized = original.newBuilder()
                        .addHeader("Cookie", String.format("NID_AUT=%s; NID_SES=%s", auth, session))
                        .build();
                return chain.proceed(authorized);
            });
        }

        builder.addInterceptor(chain -> {
            final Request original = chain.request();
            final Request authorized = original.newBuilder()
                   .addHeader("User-Agent",
                           "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36 Edg/122.0.0.0")
                   .build();
            return chain.proceed(authorized);
        });

        if (isLoggedIn) {
            return new ChzzkIdentifiedJCA(builder.build(), auth, session);
        }

        return new ChzzkAnonymousJCA(builder.build());
    }

}
