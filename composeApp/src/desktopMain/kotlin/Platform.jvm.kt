import java.awt.Robot
import java.awt.event.KeyEvent

class JVMPlatform: Platform {
    override val name: String = "Java ${System.getProperty("java.version")}"
    override suspend fun shutDown(): Boolean {
        println("===============================>111")
        try {
            val robot = Robot()

            robot.delay(5_000)

            println("===============================>222")

            //首先切换到桌面，快捷键windows+D
            robot.keyPress(KeyEvent.VK_WINDOWS);
            robot.keyPress(KeyEvent.VK_D);
            robot.delay(20);
            robot.keyRelease(KeyEvent.VK_WINDOWS);
            robot.keyRelease(KeyEvent.VK_D);
            robot.delay(20);

        } catch (e: Exception) {
            e.printStackTrace()
        }
        return true
    }
}

actual fun getPlatform(): Platform = JVMPlatform()