package utils

fun calculateDiscountedPrice(originalPrice: Int): Double {
    val discountRate = 0.1  // 10% discount
    return originalPrice * (1 - discountRate)
}