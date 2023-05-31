package youngdevs.production.onlinestoreserver

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class OnlineStoreServerApplication(private val productService: ProductService) : CommandLineRunner {

    override fun run(vararg args: String?) {
        productService.loadProductsFromFile("data/products.txt")
    }
}

fun main(args: Array<String>) {
    runApplication<OnlineStoreServerApplication>(*args)
}
