package ru.gb.geo.geonote.data.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MarkerEntity::class], version = 1, exportSchema = false)
abstract class MarkersDataBase : RoomDatabase() {
    abstract fun markersDAO(): MarkersDAO
}