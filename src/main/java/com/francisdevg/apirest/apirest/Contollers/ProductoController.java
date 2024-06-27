package com.francisdevg.apirest.apirest.Contollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.francisdevg.apirest.apirest.Repositories.ProductosRepository;
import com.francisdevg.apirest.apirest.Entities.Producto;

@RestController
@RequestMapping("/Productos")
public class ProductoController {

    @Autowired
    private ProductosRepository productosRepository;

    @GetMapping
    public List<Producto> getAllProductos(){
        return productosRepository.findAll();
    }

    @GetMapping("/{id}")
    public Producto obtenerProductoPorId(@PathVariable Long id){
        return productosRepository.findById(id)
        .orElseThrow(() -> new  RuntimeException("No se encontró el producto con el ID: " + id));
    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto){
        return productosRepository.save(producto);
    }

    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable Long id, @RequestBody Producto productoDetails) {
        Producto producto = productosRepository.findById(id)
        .orElseThrow(() -> new  RuntimeException("No se encontró el producto con el ID: " + id));

        producto.setNombre(productoDetails.getNombre());
        producto.setPrecio(productoDetails.getPrecio());

        return productosRepository.save(producto);
    }

    @DeleteMapping("/{id}")
    public String borrarProducto(@PathVariable Long id){
        Producto producto = productosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el producto con el ID: " + id));

        productosRepository.delete(producto);
        return "El producto con el ID: " + id + " fue eliminado correctamente";
    }



}
