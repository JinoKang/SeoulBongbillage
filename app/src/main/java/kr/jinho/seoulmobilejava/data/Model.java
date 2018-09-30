package kr.jinho.seoulmobilejava.data;

import com.google.gson.Gson;

import java.io.Serializable;

public class Model implements Serializable {
    @Override

    public String toString() {
        return new Gson().toJson(this);
    }

}
