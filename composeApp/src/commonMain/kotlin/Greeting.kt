import androidx.compose.material3.TimePickerState

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}

class Operate {
    private val platform = getPlatform()

    suspend fun operate(hour: Int, minute: Int, is24hour: Boolean): Boolean {
        return platform.shutDown(hour, minute, is24hour)
    }
}