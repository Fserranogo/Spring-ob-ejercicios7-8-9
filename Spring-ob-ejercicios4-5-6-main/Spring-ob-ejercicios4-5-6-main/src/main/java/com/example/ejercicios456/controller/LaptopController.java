package com.example.ejercicios456.controller;

import com.example.ejercicios456.entities.Laptop;
import com.example.ejercicios456.repository.LaptopRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@RestController
public class LaptopController {

    //atributo

    private LaptopRepository laptopRepository;
    private final Logger log = LoggerFactory.getLogger(LaptopController.class);

    //constructor

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    // CRUD sobre la entidad Laptop

    // Buscar todos los laptops (lista de laptops)

    @GetMapping("api/laptop")
    public List<Laptop> findAll() {
        return laptopRepository.findAll();


    }


    /**
     * Request
     * Response
     *
     * @param id
     * @return
     */
    // buscar un solo laptop en base de datos según su id
    @GetMapping("/api/laptop/{id}")
    public ResponseEntity<Laptop> findOneById(@PathVariable Long id) {

        Optional<Laptop> laptopOpt = laptopRepository.findById(id);

        if (laptopOpt.isPresent())
            return ResponseEntity.ok(laptopOpt.get());
        else
            return ResponseEntity.notFound().build();


    }


    // crear un nuevo laptop en base de datos
    @PostMapping("api/laptop")
    public Laptop create(@RequestBody Laptop laptop) {

        // guardar el laptop recibido por parámetro en la base de datos
        return laptopRepository.save(laptop);
    }

    /**
     * actualizar un laptop existente en base de datos
     */
    @PutMapping("/api/laptop")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop) {
        if (laptop.getId() == null) { // si no tiene id quiere decir que sí es una creación
            log.warn("Trying to update a non existent book");
            return ResponseEntity.badRequest().build();
        }
        if (!laptopRepository.existsById(laptop.getId())) {
            log.warn("Trying to update a non existent laptop");
            return ResponseEntity.notFound().build();
        }

        // El proceso de actualización
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result); // el laptop devuelto tiene una clave primaria
    }

    /**
     * Borrar un laptop existente en base de datos
     */

    @DeleteMapping("/api/laptop/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id){

        if(!laptopRepository.existsById(id)){
            log.warn("Trying to delete a non existent laptop");
            return ResponseEntity.notFound().build();
        }

        laptopRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
    /**
     * Borrar todos los laptops existentes en base de datos
     */

    @DeleteMapping("/api/laptop")
    public ResponseEntity<Laptop> deleteAll(){
        log.info("REST Request for delete all laptops");
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }

}