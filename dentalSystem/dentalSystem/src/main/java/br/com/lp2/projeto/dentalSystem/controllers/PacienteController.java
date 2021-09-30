package br.com.lp2.projeto.dentalSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import br.com.lp2.projeto.dentalSystem.dto.LoginDTO;
import br.com.lp2.projeto.dentalSystem.dto.PacienteDTO;
import br.com.lp2.projeto.dentalSystem.service.paciente.DentalSystemServicePaciente;

@RestController // Define que a classe é um controller. Tinha antes o  restController que retornava o objeto gravados diretamente na resposta http como Json
@RequestMapping("/paciente") // Define que qualquer ação desse controler deve preceder da url paciente
public class PacienteController {

    @Autowired // Permite que o Spring injete as dependências na classe do DentalSystemServicePaciente
    private DentalSystemServicePaciente service;
    
    @GetMapping(value = "/list")
    public ResponseEntity list(){
        return new ResponseEntity(service.list(), HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity add(@RequestBody PacienteDTO usuario){
        return new ResponseEntity(service.add(usuario), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}/updateLogin")
    public ResponseEntity edit(@PathVariable(value = "id") String id, @RequestBody PacienteDTO usuario){
        return new ResponseEntity(service.edit(id,usuario), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}/delete")
    public ResponseEntity delete(@PathVariable(value = "id") String id){
        return  new ResponseEntity(service.delete(id), HttpStatus.OK);
    }
}