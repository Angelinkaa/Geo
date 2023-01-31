package ru.gb.geo.geonote.di

import ru.gb.geo.geonote.repository.LocalRepository
import ru.gb.geo.geonote.repository.LocalRepositoryImpl
import ru.gb.geo.geonote.ui.maps.MapsFragmentViewModel
import ru.gb.geo.geonote.ui.markers.MarkersFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainKoinModule = module {
    single<LocalRepository> { LocalRepositoryImpl() }
    viewModel { MapsFragmentViewModel(get(), get()) }
    viewModel { MarkersFragmentViewModel(get()) }
}