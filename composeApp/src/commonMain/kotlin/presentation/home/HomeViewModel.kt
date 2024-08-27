package presentation.home

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import data.HomeRepoImpl
import data.dto.toProduct
import data.dto.toProductList
import database.ProductDao
import domain.models.Product
import kotlinx.coroutines.launch

/* Created by Hanif on 18/04/24 */

class HomeViewModel(private val impl: HomeRepoImpl) : ViewModel() {

    val list = mutableStateListOf<Product>()

    init {
        getProducts()
    }

    private fun getProducts() {
        viewModelScope.launch {
            impl.getProducts().let {
                print("!@#3")

                list.clear()
                list.addAll(it)
                //list.removeRange(0,4)
            }
        }
    }

    fun getProductByIndex(index: Int): Product = list[index]

}