package com.raghul.rnews.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.raghul.rnews.models.Article


@Database(
        entities = [Article::class],
        version = 1
)
@TypeConverters(Convertors::class)
abstract class ArticleDatbase  : RoomDatabase() {

    abstract fun getArticleDao():ArticleDao

    companion object {

        @Volatile
        private var instance : ArticleDatbase? = null

        private val LOCK = Any()

        operator  fun invoke(context:Context)= instance?: synchronized(LOCK){
            instance?:createDatabase(context).also{ instance= it }
        }

        private fun createDatabase(context: Context)= Room
                .databaseBuilder(
                        context.applicationContext,
                ArticleDatbase::class.java,
                "article_db.db")
                .build()
    }
}