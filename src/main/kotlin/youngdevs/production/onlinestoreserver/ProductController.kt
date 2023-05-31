package youngdevs.production.onlinestoreserver

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/products")
class ProductController(private val productService: ProductService) {

    @GetMapping
    suspend fun getProducts(): List<Product> {
        return try {
            productService.getProducts()
        } catch (e: Exception) {
            // Обработка ошибки
            emptyList()
        }
    }
}