package com.pam.questnavigasimvvm_139

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pam.questnavigasimvvm_139.model.JenisKelamin.JenisK
import com.pam.questnavigasimvvm_139.ui.view.FormulirView
import com.pam.questnavigasimvvm_139.ui.view.TampilDataView
import com.pam.questnavigasimvvm_139.viewmodel.SiswaViewModel

enum class Halaman {
    FORMULIR,
    TAMPILDATA
}

@Preview(showBackground = true)
@Composable
fun NavigationControl(
    modifier: Modifier = Modifier,
    viewModel: SiswaViewModel = viewModel(),
    navHost: NavHostController = rememberNavController()
) {
    // Collecting uiState from ViewModel
    val uiState by viewModel.statusUI.collectAsState()

    NavHost(
        modifier = modifier, // Correct usage of modifier
        navController = navHost,
        startDestination = Halaman.FORMULIR.name
    ) {
        composable(
            route = Halaman.FORMULIR.name
        ) {
            val context = LocalContext.current
            FormulirView(
                listJK = JenisK.map { id -> context.getString(id) },
                onSubmitClicked = {
                    // Convert List<String> to MutableList<String>
                    val mutableList = it.toMutableList()
                    viewModel.saveDataSiswa(mutableList)
                    navHost.navigate(Halaman.TAMPILDATA.name)
                }
            )
        }

        composable(
            route = Halaman.TAMPILDATA.name
        ) {
            // Pass uiState to TampilDataView for displaying the data
            TampilDataView(
                uiState = uiState, // Pass the UI state to display data
                onBackButton = {
                    // Handling the back button action
                    navHost.popBackStack()
                }
            )
        }
    }
}
