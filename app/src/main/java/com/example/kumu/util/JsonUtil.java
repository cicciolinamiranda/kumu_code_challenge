package com.example.kumu.util;

import android.net.Uri;

import com.example.kumu.data.exception.AndroidPhoneException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import retrofit2.Call;

public class JsonUtil {
    public static GsonBuilder gsonBuilder;

    static {
        gsonBuilder = new GsonBuilder();
        gsonBuilder.serializeNulls();
        gsonBuilder.registerTypeAdapter(Uri.class, new UriSerializer());
        gsonBuilder.registerTypeAdapter(Uri.class, new UriDeserializer());
        gsonBuilder.registerTypeAdapter(Call.class, new RetrofitClassSerializer());
        gsonBuilder.registerTypeAdapter(Call.class, new RetrofitClassDeSerializer());
        gsonBuilder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        gsonBuilder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
                try {
                    return simpleDateFormat.parse(json.getAsJsonPrimitive().getAsString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return null;
            }
        });
    }

    public static Gson getGson() {
        return gsonBuilder.create();
    }

    public static <T> T deserializeToList(String jsonString, Class cls){
        return getGson().fromJson(jsonString, getListTypeForDeserialization(cls));
    }

    public static <T> T deserializeToObject(String jsonString, Class cls){
        return getGson().fromJson(jsonString, getTypeForDeserialization(cls));
    }

    public static Type getListTypeForDeserialization(Class cls) {
        String className = cls.getSimpleName();

        if ("Long".equalsIgnoreCase(className)) {
            return new TypeToken<List<Long>>(){}.getType();
        }


        if ("Call".equalsIgnoreCase(className)) {
            return new TypeToken<List<Call<?>>>(){}.getType();
        }

        if ("Date".equalsIgnoreCase(className)) {
            return new TypeToken<List<Date>>(){}.getType();
        }

        return new TypeToken<Object>(){}.getType();
    }

    public static Type getTypeForDeserialization(Class cls) {
        String className = cls.getSimpleName();

        if ("Long".equalsIgnoreCase(className)) {
            return new TypeToken<List<Long>>(){}.getType();
        }

        if ("Date".equalsIgnoreCase(className)) {
            return new TypeToken<List<Date>>(){}.getType();
        }

        return new TypeToken<Object>(){}.getType();
    }

    public static Object deserialize(String json, String containerType, Class cls) throws AndroidPhoneException {
        try {
            if ("list".equalsIgnoreCase(containerType) || "array".equalsIgnoreCase(containerType)) {
                return JsonUtil.deserializeToList(json, cls);
            } else if (String.class.equals(cls)) {
                if (json != null && json.startsWith("\"") && json.endsWith("\"") && json.length() > 1)
                    return json.substring(1, json.length() - 1);
                else
                    return json;
            } else {
                return JsonUtil.deserializeToObject(json, cls);
            }
        } catch (JsonParseException e) {
            throw new AndroidPhoneException(500, e.getMessage());
        }
    }

    public static String serializeJSonStringToGSon(Object obj){
        return getGson().toJson(obj);
    }

    public static String serialize(Object obj) throws AndroidPhoneException {
        try {
            if (obj != null)
                return JsonUtil.serializeJSonStringToGSon(obj);
            else
                return null;
        } catch (Exception e) {
            throw new AndroidPhoneException(500, e.getMessage());
        }
    }

}
