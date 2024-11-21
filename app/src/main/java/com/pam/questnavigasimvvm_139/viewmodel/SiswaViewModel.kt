package com.pam.questnavigasimvvm_139.viewmodel

import androidx.lifecycle.ViewModel
import com.pam.questnavigasimvvm_139.model.Datasiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SiswaViewModel : ViewModel() {

    //Request
    private val _statusUI = MutableStateFlow(Datasiswa())

    //Response
    val statusUI: StateFlow<Datasiswa> = _statusUI.asStateFlow()

    fun saveDataSiswa(ls: MutableList<String>) {
        _statusUI.update { statusSaatIni ->
            statusSaatIni.copy(
                nama = ls[0],
                gender = ls[1],
                email = ls[2],
                alamat = ls[3],
                notelp = ls[4]
            )
        }
    }
}