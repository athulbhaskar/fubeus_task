package com.athulsapp.demoapplocation.Network;

import com.athulsapp.demoapplocation.Model.CoffieModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface getData {

    @GET("/coffee/iced")
    Call<List<CoffieModel>>GetData();
}
