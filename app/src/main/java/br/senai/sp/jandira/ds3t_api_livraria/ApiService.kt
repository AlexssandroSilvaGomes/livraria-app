package br.senai.sp.jandira.ds3t_api_livraria

import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {

//    @GET("api/users/{id}")
//    suspend fun getUserById(@Path("id") id:String): Response<BaseResponse<CategoryResponse>>
//
//    @PUT("api/users/{id}")
//    suspend fun updateUserById(@Path("id") id:String, @Body body: JsonObject): Response<JsonObject>
//
//    @DELETE("api/users/{id}")
//    suspend fun deleteUserById(@Path("id") id:String): Response<JsonObject>

    @POST("/categoria/cadastrarCategoria")
    suspend fun createCategory(@Body body: JsonObject): Response<JsonObject>

}