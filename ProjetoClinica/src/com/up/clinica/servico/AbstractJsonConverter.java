package com.up.clinica.servico;


import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public abstract class AbstractJsonConverter<T> implements IJSonConverter<T>{
    
    private final Gson gson;
    
    public AbstractJsonConverter() {
        gson = new GsonBuilder().create();
    }

    public String convertToJson(List<T> lista) {
        JsonArray jarray = gson.toJsonTree(lista).getAsJsonArray();
        JsonObject jsonObject = new JsonObject();
        jsonObject.add(this.getNomeArray(), jarray);

        return jsonObject.toString();
    }
    
    public String convertToJson(T objeto) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add(this.getNomeObjeto(), gson.toJsonTree(objeto));

        return jsonObject.toString();
    }
    
    public abstract String getNomeObjeto();
    
    public abstract String getNomeArray();
}
