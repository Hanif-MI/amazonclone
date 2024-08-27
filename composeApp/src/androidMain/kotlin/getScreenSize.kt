import android.content.res.Resources



actual fun getScreenSize(): ScreenSize {
    val metrics = Resources.getSystem().displayMetrics
    val width = metrics.widthPixels / metrics.density
    val height = metrics.heightPixels / metrics.density
    return ScreenSize(width, height)
}