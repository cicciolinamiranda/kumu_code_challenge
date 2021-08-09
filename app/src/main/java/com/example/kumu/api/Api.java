package com.example.kumu.api;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.os.Build;
import android.util.Base64;
import android.util.Log;

import com.example.kumu.MainApplication;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.kumu.util.Constants.FORMAT_JSON_DATE_TIME;

public class Api {

    private static Retrofit retrofit = null;

    private static OkHttpClient okHttpClient = null;

    private static Gson gson = new GsonBuilder()
            .setDateFormat(FORMAT_JSON_DATE_TIME)
            .setLenient()
            .registerTypeHierarchyAdapter(byte[].class,
                    new ByteArrayToBase64TypeAdapter())
            .create();

    private static class ByteArrayToBase64TypeAdapter implements JsonSerializer<byte[]>, JsonDeserializer<byte[]> {
        public byte[] deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return Base64.decode(json.getAsString(), Base64.DEFAULT);
        }

        public JsonElement serialize(byte[] src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(Base64.encodeToString(src, Base64.DEFAULT));
        }
    }

    public static Retrofit getClient(Context context) {

        if (retrofit==null) {

            if(retrofit != null) retrofit = null;
            try {

                retrofit = new Retrofit.Builder()
                        .baseUrl("https://itunes.apple.com/")
                        .client(getOkHttpClient(4))
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();
            } catch (IllegalArgumentException e) {
                throw e;
            }
        }

        return retrofit;
    }


    private static OkHttpClient getOkHttpClient(int timeout) {

        if(okHttpClient != null) okHttpClient = null;


        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) {
                        String url = chain.request().url() != null ? chain.request().url()+"" : "";
                        url = url.replace("\\","%5C");
                        Request request = chain.request().newBuilder()
                                .url(url)
                                .build();

                        Log.d(Api.class.getName(), "Url**"+request.url());
                        String method = request != null && request.method() != null ? request.method() : "";



                        try {
                            return chain.proceed(request);
                        } catch (IOException e) {
                        }

                        return new Response.Builder()
                                .request(request)
                                .protocol(Protocol.HTTP_1_1)
                                .code(999)
                                .message("")
                                .body(ResponseBody.create(null, "The request timed out.")).build();
                    }
                })
                .build();
        return okHttpClient;
    }

}
