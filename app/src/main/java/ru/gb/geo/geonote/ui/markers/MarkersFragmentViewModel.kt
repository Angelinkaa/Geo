package ru.gb.geo.geonote.ui.markers

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import ru.gb.geo.data.contracts.MarkersFragmentViewModelContract
import ru.gb.geo.geonote.data.SingleLiveEvent
import ru.gb.geo.geonote.domain.UserMarker
import ru.gb.geo.geonote.domain.messages.MarkerMessage
import ru.gb.geo.geonote.repository.LocalRepository

class MarkersFragmentViewModel(private val repository: LocalRepository) : ViewModel(),
    MarkersFragmentViewModelContract {
    private val _messagesLiveData = SingleLiveEvent<MarkerMessage>()
    val messagesLiveData: LiveData<MarkerMessage> by this::_messagesLiveData

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, error ->
        error.printStackTrace()
    }
    private var dbJob: Job? = null
    private val mainScope =
        CoroutineScope(Dispatchers.IO + SupervisorJob() + coroutineExceptionHandler)

    override fun requestMarkers() {
        dbJob?.cancel()
        dbJob = mainScope.launch {
            val userMarkers = repository.getAllMarkers()
            if (userMarkers.isNotEmpty()) {
                _messagesLiveData.postValue(MarkerMessage.UserMarkers(userMarkers))
            }
        }
    }

    override fun removeMarker(id: Long) {
        dbJob?.cancel()
        dbJob = mainScope.launch {
            repository.removeMarkerByID(id)
        }
    }

    override fun updateMarker(userMarker: UserMarker) {
        dbJob?.cancel()
        dbJob = mainScope.launch {
            repository.updateMarker(userMarker)
        }
    }

    override fun requestSnackbar(text: String) {
        _messagesLiveData.value = MarkerMessage.InfoSnackBar(text)
    }
}