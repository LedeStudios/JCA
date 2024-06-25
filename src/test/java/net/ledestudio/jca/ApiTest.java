package net.ledestudio.jca;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.ledestudio.jca.chzzk.ChzzkLiveDetail;
import net.ledestudio.jca.chzzk.ChzzkLiveStatus;
import net.ledestudio.jca.chzzk.ChzzkUser;
import net.ledestudio.jca.utils.Constants;
import net.ledestudio.jca.utils.Utils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ApiTest {

    final String auth = "HYZBeZuQ2BfEUqMSXGBiI4a2PCJqDE0xacHoN28BfAvTZP1l0rwKRnnNDl5ZaRwi";
    final String session = " AAABkriO/GS3w5VefQKvtxiyusVoTZoPWEIhBPmf4zIWc5w4x88Y29vTyKpwV40SiJq6OSD7z2/IoiOzhMwCx/ky/Ck5JeM+2txMQOsgHn2+SDubKDhSb1NIlKt7mUlQwKnz5lyfDPfyrFyfmeMeBfHs+8DFgAN9730s5V8cEuyeWalwUC1Z/4+Y2wNm5jRiJuaJEwEbYbLjZq44kaGufF5obxcvPIPG0ScuG0O1ctVFk6PsX8N9E3lnKwcOnkDo589oWGNo+ZpgXS5RlEUdnyK5YENNqsS1gCRWy0bm0YtIv68QpJTxIj5oF2zJ81CZmOMz62g8qayjQOxTmfo3mV9nWY7HRF/rHFjd66TtHdg4Hh5wifjTx4jSyNT99yIIJkKHXkSGhqtbByditAaPBIGdicZmstNaQDctJAAoVfrnAq0n5J+MQneacvB9iA1ZXQ5tJEYg5M9FMq0E+ZaURsRoeDidQsDwk3lfipGf8DD1BPnHaCXXfky8x4nQVzFWyekSiWYYbH8g94QTkzY6YWlawh+mOk4BBkQcRdwN9g1Ubeaq";


    @Test
    public void initTest() {
        JCA jca = new JCABuilder().login(auth, session).build();
        jca.getCurrentUser().ifPresent(user -> {
            ZonedDateTime time = user.getOfficialNotifyAgreeUpdatedDate();
            System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        });
    }

    @Test
    public void getLiveStatus() throws IOException {
        final Gson gson = new GsonBuilder().create();
        final JCA jca = new JCABuilder().login(auth, session).build();

        Utils.getContentJson(
                jca.getHttpClient(),
                Utils.httpGetRequest(Constants.CHZZK_URL + "/polling/v1/channels/458f6ec20b034f49e0fc6d03921646d2/live-status").build()
        ).ifPresent(json -> {
            System.out.println(gson.fromJson(json, ChzzkLiveStatus.class));
        });
    }

    @Test
    public void getLiveDetail() throws IOException {
        final Gson gson = new GsonBuilder().create();
        final JCA jca = new JCABuilder().login(auth, session).build();

        Utils.getContentJson(
                jca.getHttpClient(),
                Utils.httpGetRequest(Constants.CHZZK_URL + "/service/v1/channels/458f6ec20b034f49e0fc6d03921646d2/live-detail").build()
        ).ifPresent(json -> System.out.println(gson.fromJson(json, ChzzkLiveDetail.class)));
    }

}
