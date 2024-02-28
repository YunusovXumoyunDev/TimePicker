package uz.yxdev.timepicker.data.repository

import android.content.Context
import uz.yxdev.timepicker.data.storage.local.LocalStorage

class Repository(private val context: Context) {
    private val storage = LocalStorage(context)
    fun create(
        date: String,
        time: String,
        name: String,
    ) {
        storage.saveString("date", date)
        storage.saveString("time", time)
        storage.saveString("name", name)

    }

    fun getDate(): String = storage.getString("date")
    fun getTime(): String = storage.getString("time")
    fun getName(): String = storage.getString("name")
    fun hasUser(): Boolean = storage.getBoolean("isUserExist")
    fun createUser() {
        storage.saveBoolean("isUserExist", true)
    }
}