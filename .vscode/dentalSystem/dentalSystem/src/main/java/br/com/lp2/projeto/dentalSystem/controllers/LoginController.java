package br.com.lp2.projeto.dentalSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.lp2.projeto.dentalSystem.dto.LoginDTO;
import br.com.lp2.projeto.dentalSystem.service.login.DentalSystemServiceLogin;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
    private DentalSystemServiceLogin service;

	@GetMapping(value = "/greet/{name}")
    public String greet(@PathVariable(value = "name") String name){
        return  "Olá, "+name;
    }

    @GetMapping(value = "/list")
    public ResponseEntity list(){
        return new ResponseEntity(service.list(), HttpStatus.OK);
    }
    

    @PostMapping(value = "/add")
    public ResponseEntity add(@RequestBody LoginDTO usuario){
        return new ResponseEntity(service.add(usuario), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}/updateLogin")
    public ResponseEntity edit(@PathVariable(value = "id") String id, @RequestBody LoginDTO usuario){
        return new ResponseEntity(service.edit(id,usuario), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}/delete")
    public ResponseEntity delete(@PathVariable(value = "id") String id){
        return  new ResponseEntity(service.delete(id), HttpStatus.OK);
    }
}