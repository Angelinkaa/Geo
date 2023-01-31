package ru.gb.geo.geonote.repository

import ru.gb.geo.geonote.domain.UserMarker

interface LocalRepository {
    fun getAllMarkers(): List<UserMarker>
    fun saveMarker(userMarker: UserMarker)
    fun updateMarker(userMarker: UserMarker)
    fun removeMarkerByID(id: Long)
}