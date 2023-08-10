package com.ashehata.madarsoft_task.modules.user.domain.model

import com.ashehata.madarsoft_task.common.enums.Gender
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.io.IOException

data class UserDomainModel(
    val name: String,
    val jobTitle: String,
    val age: Int,
    val gender: Gender,
) {

    companion object {
        fun create(json: String): UserDomainModel {
            return try {
                val moshi = Moshi.Builder()
                    .add(KotlinJsonAdapterFactory())
                    .build()
                val adapter = moshi.adapter(UserDomainModel::class.java)
                adapter.fromJson(json)!!
            } catch (e: Exception) {
                throw IOException()
            }
        }
    }

    override fun toString(): String {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val adapter = moshi.adapter(UserDomainModel::class.java)
        return adapter.toJson(this)
    }

}
