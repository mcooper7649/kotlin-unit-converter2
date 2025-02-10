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
import androidx.compose.foundation.layout.width
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
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mycodedojo.unitconverter2.ui.theme.UnitConverter2Theme
import kotlin.math.roundToInt

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

    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }
    var inputUnit by remember { mutableStateOf("Centimeters") }
    var outputUnit by remember { mutableStateOf("Meters") }
    var iExpanded by remember { mutableStateOf(false) }
    var oExpanded by remember { mutableStateOf(false) }
    val conversionFactor = remember { mutableStateOf(0.01) }

    fun convertUnits() {
        val inputValueDouble = inputValue.toDoubleOrNull() ?: 0.0
        val result = (inputValueDouble * conversionFactor.value * 100.0).roundToInt() /100.0
        outputValue = result.toString()
    }

    Column(modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Unit Converter", modifier = Modifier.padding(10.dp))
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = inputValue,
            onValueChange = {
            inputValue = it
        },
            label = { Text("Input Value") },
            modifier = Modifier.padding(10.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

        Row {
            Box {
                Button(onClick = { iExpanded = true}){
                    Text("Select")
                    Icon(Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow")
                }
                DropdownMenu(expanded = iExpanded, onDismissRequest = { iExpanded = false}){
                    DropdownMenuItem(text= { Text("Centimeters") }, onClick = {
                        iExpanded = false
                        inputUnit = "Centimeters"
                        conversionFactor.value = 0.01
                        outputValue = (inputValue.toDouble() * conversionFactor.value).toString()
                        outputUnit = "Meters"
                        convertUnits()
                    })
                    DropdownMenuItem(text= { Text("Feet") }, onClick = {
                        iExpanded = false
                        inputUnit = "Feet"
                        conversionFactor.value = 0.3048
                        outputValue = (inputValue.toDouble() * conversionFactor.value).toString()
                        outputUnit = "Meters"
                        convertUnits()
                    })
                    DropdownMenuItem(text= { Text("Meters") }, onClick = {
                        iExpanded = false
                        inputUnit = "Meters"
                        conversionFactor.value = 1.0
                        outputValue = (inputValue.toDouble() * conversionFactor.value).toString()
                        outputUnit = "Meters"
                        convertUnits()
                    })

                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Spacer(modifier = Modifier.width(16.dp))
            Box {
                Button(onClick = { oExpanded = true}){
                    Text("Select")
                    Icon(Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow")
                }
                DropdownMenu(expanded = oExpanded, onDismissRequest = { oExpanded = false}){
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