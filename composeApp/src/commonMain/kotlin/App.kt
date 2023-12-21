import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class, ExperimentalMaterial3Api::class)
@Composable
fun App() {
    MaterialTheme {
        var greetingText by remember { mutableStateOf("确定") }
        var showImage by remember { mutableStateOf(false) }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {

            val scope = rememberCoroutineScope()
            val state = rememberTimePickerState(
                is24Hour = true
            )
            TimePicker(state = state)

            Button(onClick = {
//                greetingText = "设置成功"
                showImage = !showImage
                scope.launch(Dispatchers.Default) {
                    Operate().operate(state.hour, state.minute, state.is24hour)
                }

                Toast
            }) {
                Text(greetingText)
            }
//            val showTime = "${state.hour}:${state.minute}"
//            Text(showTime)
//            AnimatedVisibility(showImage) {
//                Image(
//                    painterResource("compose-multiplatform.xml"),
//                    null
//                )
//            }
        }
    }
}