interface Platform {
    val name: String
    suspend fun shutDown(): Boolean
}

expect fun getPlatform(): Platform