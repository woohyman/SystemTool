class WasmPlatform : Platform {
    override val name: String = "Web with Kotlin/Wasm"
    override suspend fun shutDown(hour: Int, minute: Int, is24hour: Boolean): Boolean {
        return true
    }
}

actual fun getPlatform(): Platform = WasmPlatform()