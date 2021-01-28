package com.raghul.rnews.db

import androidx.room.TypeConverter
import com.raghul.rnews.models.Source

class Convertors {

    @TypeConverter
    fun fromSource(source: Source):String{
return source.name
    }

    @TypeConverter
    fun toSource(name:String): Source {
return Source(name,name)
    }


}