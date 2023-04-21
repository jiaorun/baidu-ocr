package baiduOCR.utils;

import okhttp3.*;

import java.io.IOException;

/**
 * 百度OCR-获取Access_token
 *
 * @author Run Jiao
 * @date 2023-03-30 10:35
 **/
public class AccessTokenUtils {

    /**
     * API_KEY
     */
    private static String API_KEY = "ILFGr0FQNPwTycWbTYC27IMo";

    /**
     * SECRET_KEY
     */
    private static String SECRET_KEY = "ftgkmGpKM3gafMA2spIDFNiGScahPN7A";

    /**
     * Access_token通用请求地址
     */
    private static String PATH = "https://aip.baidubce.com/oauth/2.0/token?";

    private static final OkHttpClient HTTP_CLIENT = new OkHttpClient().newBuilder().build();

    public static void main(String[] args) throws IOException {
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create("", mediaType);

        Request request = new Request.Builder()
                .url(PATH + "client_id=" + API_KEY + "&client_secret=" + SECRET_KEY + "&grant_type=client_credentials")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();
        Response response = HTTP_CLIENT.newCall(request).execute();
        System.out.println(response.body().string());
    }

}
