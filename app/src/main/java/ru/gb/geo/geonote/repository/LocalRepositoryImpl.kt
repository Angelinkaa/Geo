package ru.gb.geo.geonote.repository

import ru.gb.geo.geonote.utils.Mappers
import ru.gb.geo.geonote.App
import ru.gb.geo.geonote.data.room.MarkersDAO
import ru.gb.geo.geonote.domain.UserMarker

class LocalRepositoryImpl : LocalRepository {
    private val dataSource: MarkersDAO = App.getMarkersDAO()
    private val mappers = Mappers()
    override fun getAllMarkers(): List<UserMarker> {
        return mappers.mapEntityList(dataSource.getAll())
    }

    override fun saveMarker(userMarker: UserMarker) {
        dataSource.insert(mappers.map(userMarker))
    }

    override fun updateMarker(userMarker: UserMarker) {
        dataSource.updateById(userMarker.id, userMarker.title, userMarker.description)
    }

    override fun removeMarkerByID(id: Long) {
        dataSource.deleteById(id)
    }
}