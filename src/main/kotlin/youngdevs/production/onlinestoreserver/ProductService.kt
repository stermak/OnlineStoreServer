package youngdevs.production.onlinestoreserver

import org.springframework.stereotype.Service
import java.io.File
import java.io.FileNotFoundException

@Service
class ProductService(private val productRepository: ProductRepository) {

    suspend fun getProducts(): List<Product> {
        return productRepository.findAll()
    }

    fun loadProductsFromFile(filePath: String) {
        try {
            val file = File(filePath)
            val lines = file.readLines()
            for (line in lines) {
                val parts = line.split('|')
                if (parts.size == 5) {
                    val id = parts[0].toLongOrNull()
                    val name = parts[1]
                    val description = parts[2]
                    val availability = parts[3]
                    val image = parts[4]

                    if (id != null) {
                        val product = Product(id, name, description, availability, image)
                        productRepository.save(product)
                    }
                }
            }
        } catch (e: FileNotFoundException) {
            println("File not found: $filePath")
        }
    }
}
