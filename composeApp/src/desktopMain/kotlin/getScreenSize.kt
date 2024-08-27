import java.awt.Toolkit

actual fun getScreenSize(): ScreenSize {
    val screenSize = Toolkit.getDefaultToolkit().screenSize
    val width = screenSize.getWidth().toFloat()
    val height = screenSize.getHeight().toFloat()
    return ScreenSize(width, height)
}