class WasmPlatform: Platform {
    override val name: String = "Web with Kotlin/Wasm"
    override suspend fun shutDown(): Boolean {
        return true
    }
}

actual fun getPlatform(): Platform = WasmPlatform()