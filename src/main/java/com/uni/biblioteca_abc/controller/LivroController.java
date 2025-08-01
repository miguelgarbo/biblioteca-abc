package com.uni.biblioteca_abc.controller;
import com.uni.biblioteca_abc.model.Livro;
import com.uni.biblioteca_abc.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/biblioteca")
public class LivroController {

    //findAll, findById, update, delete, save

    @Autowired
    private LivroService livroService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Livro>> findAll(){
        try{
            var lista = this.livroService.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Long id){
        try{
            var livro = this.livroService.findById(id);
            return new ResponseEntity<>(livro, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update (@RequestBody Livro livro, @PathVariable Long id){

        try{
            String mensagem = this.livroService.update(id, livro);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Não foi Possivel Alterar", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete (@PathVariable Long id){

        try{
            String mensagem = this.livroService.deleteById(id);
            return new ResponseEntity<>(mensagem,HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao Deletar Livro",HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Livro> save (@RequestBody Livro livro){
        try {
            Livro livroCriado = this.livroService.save(livro);
            return new ResponseEntity<>(livroCriado,HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }


}
