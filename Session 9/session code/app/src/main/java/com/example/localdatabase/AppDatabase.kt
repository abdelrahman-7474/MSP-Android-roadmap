package com.example.localdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun getUserDao():UserDAO

    companion object{
        @Volatile
        private var dp:AppDatabase? = null
        fun getDatabase(context: Context):AppDatabase=
            dp ?:
        synchronized(this){
            dp ?: Room.databaseBuilder(
                context.applicationContext,
                name = "userDatabase",
                klass = AppDatabase::class.java
            ).fallbackToDestructiveMigration(true)
                .build().also {
                    dp=it
                }

        }
    }
}