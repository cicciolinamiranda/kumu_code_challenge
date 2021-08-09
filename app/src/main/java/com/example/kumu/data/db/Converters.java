package com.example.kumu.data.db;

import androidx.room.TypeConverter;

import com.example.kumu.data.exception.AndroidPhoneException;
import com.example.kumu.util.JsonUtil;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.util.Date;

public class Converters {

    @TypeConverter
    public static Date stringToDate(String data) {


        try {
            Gson gson = new Gson();
            return gson.fromJson(data, Date.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }

        return null;
    }

    @TypeConverter
    public static String dateToString(Date date) {

        try {
            return JsonUtil.serialize(date);
        } catch (AndroidPhoneException e) {
            e.printStackTrace();
        }
        return "";
    }
}
