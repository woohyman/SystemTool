import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
    override suspend fun shutDown(hour: Int, minute: Int, is24hour: Boolean): Boolean {
        return true
    }
}

actual fun getPlatform(): Platform = IOSPlatform()