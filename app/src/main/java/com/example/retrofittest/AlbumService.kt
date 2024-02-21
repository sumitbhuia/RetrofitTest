package com.example.retrofittest

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

// 2 - API/Service Interface - Here , defined all different methods that will be used for network transition
interface AlbumService {

    //Specifying endpoints of URL
    @GET("/albums")
    suspend fun getAlbum() : Response<Album>

    @GET("/albums")
    suspend fun getSpecificAlbums(@Query("userId") userId:Int) : Response<Album>


}