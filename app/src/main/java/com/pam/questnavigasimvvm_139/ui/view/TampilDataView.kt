package com.pam.questnavigasimvvm_139.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pam.questnavigasimvvm_139.model.Datasiswa

// Mocking a sample Datasiswa object for preview
fun getMockData(): Datasiswa {
    return Datasiswa(
        nama = "Muhamad Farhan",
        gender = "Laki-laki",
        email = "farhanvirenze18@gmail.com",
        alamat = "Jalan Bunga",
        notelp = "085820215321"
    )
}

@Preview(showBackground = true)
@Composable
fun TampilDataViewPreview() {
    TampilDataView(
        uiState = getMockData(),
        onBackButton = {}
    )
}

@Composable
fun TampilDataView(
    uiState: Datasiswa,
    onBackButton: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TampilData(label = "Nama", value = uiState.nama)
        TampilData(label = "Jenis Kelamin", value = uiState.gender)
        TampilData(label = "Email", value = uiState.email)
        TampilData(label = "Alamat", value = uiState.alamat)
        TampilData(label = "Nomor Telepon", value = uiState.notelp)

        Button(onClick = onBackButton) {
            Text(text = "Kembali")
        }
    }
}

@Composable
fun TampilData(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            modifier = Modifier.weight(0.4f)
        )
        Text(
            text = ":",
            modifier = Modifier.weight(0.1f)
        )
        Text(
            text = value,
            modifier = Modifier.weight(1.5f)
        )
    }
}