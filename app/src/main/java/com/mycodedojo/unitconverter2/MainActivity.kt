package com.mycodedojo.unitconverter2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mycodedojo.unitconverter2.ui.theme.UnitConverter2Theme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnitConverter2Theme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = { Text("Unit Converter") },
                            colors = TopAppBarDefaults.smallTopAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primary
                            )
                        )
                    }
                ) { innerPadding ->
                    // Call UnitConverter here, inside the Scaffold's content lambda
                    UnitConverter(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun UnitConverter(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Unit Converter", modifier = Modifier.padding(100.dp))
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField("", onValueChange = {

        })
        Spacer(modifier = Modifier.height(16.dp))

        Row {
            Box {
                Button(onClick = {}){
                    Text("Select")
                    Icon(Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow")
                }
                DropdownMenu(expanded = true, onDismissRequest = {}){
                    DropdownMenuItem(text= { Text("Centimeters") }, onClick = {})
                    DropdownMenuItem(text= { Text("Feet") }, onClick = {})
                    DropdownMenuItem(text= { Text("Meters") }, onClick = {})

                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Box {
                Button(onClick = {}){
                    Text("Select")
                    Icon(Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow")
                }
                DropdownMenu(expanded = true, onDismissRequest = {}){
                    DropdownMenuItem(text= { Text("Centimeters") }, onClick = {})
                    DropdownMenuItem(text= { Text("Feet") }, onClick = {})
                    DropdownMenuItem(text= { Text("Meters") }, onClick = {})

                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        Text("Result: ")
    }
}

@Preview
@Composable
fun UnitConverterPreview() {
        UnitConverter()
    }