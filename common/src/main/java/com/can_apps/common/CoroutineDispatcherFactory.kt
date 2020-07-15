package com.can_apps.common

import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Unconfined
import kotlinx.coroutines.ExperimentalCoroutinesApi

interface CoroutineDispatcherFactory {

    val IO: CoroutineContext

    val UI: CoroutineContext
}

class CoroutineDispatcherFactoryDefault : CoroutineDispatcherFactory {
    override val IO: CoroutineContext
        get() = Dispatchers.IO

    override val UI: CoroutineContext
        get() = Dispatchers.Main
}

@ExperimentalCoroutinesApi
class CoroutineDispatcherFactoryUnconfined : CoroutineDispatcherFactory {

    override val IO: CoroutineContext
        get() = Unconfined

    override val UI: CoroutineContext
        get() = Unconfined
}
