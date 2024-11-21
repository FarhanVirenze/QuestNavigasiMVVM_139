package com.pam.questnavigasimvvm_139.ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun FormulirView(
    modifier: Modifier = Modifier,
    listJK: List<String> = listOf("Laki-laki", "Perempuan"),
    onSubmitClicked: (List<String>) -> Unit = {}
) {
    var nama by remember { mutableStateOf("") }
    var nim by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var notelepon by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Name Input
        TextField(
            value = nama,
            onValueChange = { nama = it },
            label = { Text("Nama") },
            placeholder = { Text("Isi Nama Anda") },
            modifier = modifier.fillMaxWidth().padding(5.dp)
        )

        TextField(
            value = nim,
            onValueChange = { nim = it },
            label = { Text("Nim") },
            placeholder = { Text("Isi Nim Anda") },
            modifier = modifier.fillMaxWidth().padding(5.dp)
        )

        // Gender Selection
        Text(
            text = "Jenis Kelamin:",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .align(Alignment.Start)
        )

        Row(modifier = Modifier.fillMaxWidth()) {
            listJK.forEach { selectedGender ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = gender == selectedGender,
                        onClick = { gender = selectedGender }
                    )
                    Text(text = selectedGender)
                }
            }
        }

        // Email Input
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            placeholder = { Text("Isi Email Anda") },
            modifier = modifier.fillMaxWidth().padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        // Address Input
        TextField(
            value = alamat,
            onValueChange = { alamat = it },
            label = { Text("Alamat") },
            placeholder = { Text("Isi Alamat Anda") },
            modifier = modifier.fillMaxWidth().padding(5.dp)
        )

        // Phone Number Input
        TextField(
            value = notelepon,
            onValueChange = { notelepon = it },
            label = { Text("Nomor Telepon") },
            placeholder = { Text("Isi No Telepon Anda") },
            modifier = modifier.fillMaxWidth().padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        // Submit Button
        Button(onClick = {
            val listData = listOf(nama, nim, gender, alamat, email, notelepon)
            onSubmitClicked(listData)
        }) {
            Text("Simpan")
        }
    }
}
