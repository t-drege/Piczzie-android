package com.ziggy.kdo.network.store

import com.ziggy.kdo.model.Child
import com.ziggy.kdo.model.Gift
import kotlinx.coroutines.Deferred
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

/**
 * The class description here.
 *
 * @author thomas
 * @since 2019.03.21
 */
interface ChildApi {

    @GET("api/child/children/{id}")
    fun getChildren(@Path("id") id: String): Deferred<Response<List<Child>?>>

    @POST("api/child")
    fun createChild(@Body child: Child): Deferred<Response<Child?>>

    @PUT("api/child/{id}")
    fun updateChild(@Path("id") id: String, @Body child: Child): Deferred<Response<Child?>>

    @DELETE("api/child/{id}")
    fun deleteChild(@Path("id") id: String): Deferred<Response<ResponseBody?>>
}