import java.io.IOException
import java.util.Calendar
import java.util.Timer
import java.util.TimerTask


class JVMPlatform : Platform {
    override val name: String = "Java ${System.getProperty("java.version")}"
    override suspend fun shutDown(hour: Int, minute: Int, is24hour: Boolean): Boolean {
        timer(hour, minute, is24hour) {
            try {
                // 执行休眠命令（Windows）
                val process = Runtime.getRuntime().exec("shutdown -h")
                process.waitFor()
            } catch (e: IOException) {
                e.printStackTrace()
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
        return true
    }
}

/**
 * 方法四：安排指定的任务task在指定的时间firstTime开始进行重复的固定速率period执行．
 * Timer.scheduleAtFixedRate(TimerTask task,Date firstTime,long period)
 */
fun timer(hour: Int, minute: Int, is24hour: Boolean, task: () -> Unit) {
    println("hour ==> " + hour + ", minute ==> " + minute + ", is24hour ==> " + is24hour)
    val calendar = Calendar.getInstance()
    // 控制小时
    if (is24hour) {
        calendar[Calendar.HOUR_OF_DAY] = hour
    } else {
        calendar[Calendar.HOUR] = hour
    }
    calendar[Calendar.MINUTE] = minute // 控制分钟
    val time = calendar.time //获取当前系统时间
    val timer = Timer()
    timer.scheduleAtFixedRate(object : TimerTask() {
        override fun run() {
            task()
        }
    }, time, 1000 * 60 * 60 * 24) // 这里设定将延时每天固定执行
}

actual fun getPlatform(): Platform = JVMPlatform()