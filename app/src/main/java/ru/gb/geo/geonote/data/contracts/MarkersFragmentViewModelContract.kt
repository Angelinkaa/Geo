package ru.gb.geo.data.contracts

import ru.gb.geo.geonote.domain.UserMarker

interface MarkersFragmentViewModelContract {
    fun requestMarkers()
    fun removeMarker(id: Long)
    fun updateMarker(userMarker: UserMarker)
    fun requestSnackbar(text: String)
}