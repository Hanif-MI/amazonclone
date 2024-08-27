
import platform.UIKit.UIScreen
import utils.ScreenSize

actual fun getScreenSize(): ScreenSize {
    val screen = UIScreen.mainScreen.bounds
    val width = screen.size.width
    val height = screen.size.height
    return ScreenSize(width.toFloat(), height.toFloat())
}