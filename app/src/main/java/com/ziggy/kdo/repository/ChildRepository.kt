package com.ziggy.kdo.repository

import com.ziggy.kdo.model.Child
import com.ziggy.kdo.network.configuration.Result
import com.ziggy.kdo.network.store.ChildApi
import okhttp3.ResponseBody
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * The class description here.
 *
 * @author thomas
 * @since 2019.03.22
 */
class ChildRepository @Inject constructor(retrofit: Retrofit) : BaseRepository() {

    private var childApi: ChildApi = retrofit.create(ChildApi::class.java)

    suspend fun getChildren(id:String): Result<List<Child>> {
        val request = childApi.getChildren(id)
        return getResponse(request)
    }

    suspend fun createChild(child: Child): Result<Child> {
        val request = childApi.createChild(child)
        return getResponse(request)
    }

    suspend fun updateChild(child: Child): Result<Child> {
        val request = childApi.updateChild(child.id!!, child)
        return getResponse(request)
    }

    suspend fun deleteChild(child: Child): Result<ResponseBody> {
        val request = childApi.deleteChild(child.id!!)
        return getResponse(request)
    }
}