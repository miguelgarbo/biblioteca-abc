package com.uni.biblioteca_abc.controller;

import com.uni.biblioteca_abc.model.Editora;
import com.uni.biblioteca_abc.service.EditoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class EditoraController {

    @Autowired
    private EditoraService editoraService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Editora>> findAll(){
        try{
            var lista = this.editoraService.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Editora> findById(@PathVariable Long id){
        try{
            var editora = this.editoraService.findById(id);
            return new ResponseEntity<>(editora, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update (@RequestBody Editora editora, @PathVariable Long id){

        try{
            String mensagem = this.editoraService.update(id, editora);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Não foi Possivel Alterar", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete (@PathVariable Long id){

        try{
            String mensagem = this.editoraService.deleteById(id);
            return new ResponseEntity<>(mensagem,HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao Deletar Editora",HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Editora> save (@RequestBody Editora editora){
        try {
            Editora editoraCriado = this.editoraService.save(editora);
            return new ResponseEntity<>(editoraCriado,HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
    
    
}
