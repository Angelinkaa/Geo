package ru.gb.geo.geonote.domain

import com.google.android.gms.maps.model.MarkerOptions
import ru.gb.geo.geonote.utils.EMPTY
import ru.gb.geo.geonote.utils.ZERO

data class UserMarker(
    var id: Long = Long.ZERO,
    val markerOptions: MarkerOptions,
    var title: String = String.EMPTY,
    var description: String = String.EMPTY
)