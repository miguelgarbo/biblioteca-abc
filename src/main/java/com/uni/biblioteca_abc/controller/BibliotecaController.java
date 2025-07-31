package com.uni.biblioteca_abc.controller;

import com.uni.biblioteca_abc.model.Biblioteca;
import com.uni.biblioteca_abc.service.BibliotecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class BibliotecaController {

    @Autowired
    private BibliotecaService bibliotecaService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Biblioteca>> findAll(){
        try{
            var lista = this.bibliotecaService.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Biblioteca> findById(@PathVariable Long id){
        try{
            var biblioteca = this.bibliotecaService.findById(id);
            return new ResponseEntity<>(biblioteca, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update (@RequestBody Biblioteca biblioteca, @PathVariable Long id){

        try{
            String mensagem = this.bibliotecaService.update(id, biblioteca);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Não foi Possivel Alterar", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete (@PathVariable Long id){

        try{
            String mensagem = this.bibliotecaService.deleteById(id);
            return new ResponseEntity<>(mensagem,HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao Deletar Biblioteca",HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Biblioteca> save (@RequestBody Biblioteca biblioteca){
        try {
            Biblioteca bibliotecaCriado = this.bibliotecaService.save(biblioteca);
            return new ResponseEntity<>(bibliotecaCriado,HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
    
}
