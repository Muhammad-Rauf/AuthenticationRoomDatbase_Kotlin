package com.example.authenticationroomdatbase_kotlin.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RegisterEntity::class], version = 1, exportSchema = false)
abstract class RegisterDatabase : RoomDatabase() {

    abstract fun userDao(): RegisterDao

    companion object {
        @Volatile
        private var INSTANCE: RegisterDatabase? = null

        fun getDatabase(context: Context): RegisterDatabase {
            if (INSTANCE == null) {
                synchronized(this)
                {
                    INSTANCE =
                        Room.databaseBuilder(
                            context.applicationContext,
                            RegisterDatabase::class.java,
                            "user_database"
                        ).build()
                }

            }
            return INSTANCE!!
        }
    }
}