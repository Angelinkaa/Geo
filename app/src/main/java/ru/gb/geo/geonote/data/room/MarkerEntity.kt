package ru.gb.geo.geonote.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.gb.geo.geonote.utils.EMPTY
import ru.gb.geo.geonote.utils.ZERO

@Entity
data class MarkerEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = Long.ZERO,
    val title: String = String.EMPTY,
    val description: String = String.EMPTY,
    val latitude: Double = Double.ZERO,
    val longitude: Double = Double.ZERO
)