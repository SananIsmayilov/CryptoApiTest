package com.myapplication.myapi;

import com.google.gson.annotations.SerializedName;

public class Money {
    @SerializedName("currency")
    String currency;
    @SerializedName("price")
    String price;
}
