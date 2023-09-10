package com.meal.game.ui.container

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ContainerViewModel: ViewModel() {
    private val _page = MutableLiveData(1)
    val page: LiveData<Int> = _page

    var changePageCallback: ((Int) -> Unit)? = null

    fun setPage(page: Int) {
        _page.postValue(page)
    }

    fun changePage(page: Int) {
        _page.postValue(page)
        changePageCallback?.invoke(page)
    }
}