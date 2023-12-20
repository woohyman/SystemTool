interface Platform {
    val name: String
    suspend fun shutDown(hour:Int,minute:Int,is24hour: Boolean): Boolean
}

expect fun getPlatform(): Platform