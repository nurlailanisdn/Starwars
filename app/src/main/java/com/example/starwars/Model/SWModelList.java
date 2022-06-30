package com.example.starwars.Model;

import android.text.TextUtils;

import java.io.Serializable;
import java.util.ArrayList;

public class SWModelList<T> implements Serializable {
    int count;
    String next, previous;
    ArrayList<T> results;

    public boolean hasMore(){
        return !TextUtils.isEmpty(next);
    }
}
