class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}

class Operate {
    private val platform = getPlatform()

    suspend fun operate(): Boolean {
        return platform.shutDown()
    }
}