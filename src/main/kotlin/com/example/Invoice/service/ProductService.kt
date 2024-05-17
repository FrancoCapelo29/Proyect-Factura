package com.example.Invoice.service

import com.example.Invoice.entity.Product
import com.example.Invoice.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class ProductService {
    @Autowired
    lateinit var prodductRepository: ProductRepository

    fun list ():List<Product>{
        return prodductRepository.findAll()
    }

    fun save(product: Product): Product{
        try{
            return prodductRepository.save(product)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun update(product: Product): Product{
        try {
            prodductRepository.findById(product.id)
                ?: throw Exception("ID no existe")

            return prodductRepository.save(product)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun updateName(product: Product): Product{
        try{
            val response = prodductRepository.findById(product.id)
                ?: throw Exception("ID no existe")
            response.apply {
                brand=product.brand //un atributo del modelo
            }
            return prodductRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun listById (id:Long?):Product?{
        return prodductRepository.findById(id)
    }
    fun delete (id: Long?):Boolean?{
        try{
            val response = prodductRepository.findById(id)
                ?: throw Exception("ID no existe")
            prodductRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
}