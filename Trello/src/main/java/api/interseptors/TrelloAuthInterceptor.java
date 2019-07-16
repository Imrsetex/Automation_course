package api.interseptors;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class TrelloAuthInterceptor implements Interceptor {

    public static final String KEY = "b41f8cc25fa3a0ac46b2905f28a0e7ef";
    public static final String TOKEN = "b270614a7075cc655262d3c9b10951dbbaa06a89609b55db3d14204a290bf65a";


    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        HttpUrl originalHttpUrl = original.url();

        HttpUrl url = originalHttpUrl.newBuilder()
                .addQueryParameter("key", KEY)
                .addQueryParameter("token", TOKEN)
                .build();

        Request.Builder requestBuilder = original.newBuilder()
                .url(url);

        Request request = requestBuilder.build();
        return chain.proceed(request);
    }
}