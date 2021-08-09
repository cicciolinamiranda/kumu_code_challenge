package com.example.kumu.util;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import retrofit2.Call;

public class RetrofitClassDeSerializer implements JsonDeserializer<Call> {
    @Override
    public Call deserialize(JsonElement src, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return null;
    }
}
