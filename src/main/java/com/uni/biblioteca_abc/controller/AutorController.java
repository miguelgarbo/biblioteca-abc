package com.uni.biblioteca_abc.controller;

import com.uni.biblioteca_abc.model.Autor;
import com.uni.biblioteca_abc.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Autor>> findAll(){
        try{
            var lista = this.autorService.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Autor> findById(@PathVariable Long id){
        try{
            var autor = this.autorService.findById(id);
            return new ResponseEntity<>(autor, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update (@RequestBody Autor autor, @PathVariable Long id){
        try{
            String mensagem = this.autorService.update(id, autor);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Não foi Possivel Alterar", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete (@PathVariable Long id){
        try{
            String mensagem = this.autorService.deleteById(id);
            return new ResponseEntity<>(mensagem,HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao Deletar Autor",HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Autor> save (@RequestBody Autor autor){
        try {
            Autor autorCriado = this.autorService.save(autor);
            return new ResponseEntity<>(autorCriado,HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
    
}
