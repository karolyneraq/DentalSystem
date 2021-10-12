package br.com.lp2.projeto.dentalSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.lp2.projeto.dentalSystem.dto.AgendamentoDTO;
import br.com.lp2.projeto.dentalSystem.service.agendamento.DentalSystemServiceAgendamento;



@RestController
@RequestMapping("/Agendamento")
public class AgendamentoController {

	@Autowired
    private DentalSystemServiceAgendamento service;

    @GetMapping(value = "/list")
    public ResponseEntity list(){
        return new ResponseEntity(service.list(), HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity add(@RequestBody AgendamentoDTO agendamento){
        return new ResponseEntity(service.add(agendamento), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}/update")
    public ResponseEntity edit(@PathVariable(value = "id") String id, @RequestBody AgendamentoDTO agendamento){
        return new ResponseEntity(service.edit(id,agendamento), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}/delete")
    public ResponseEntity delete(@PathVariable(value = "id") String id){
        return  new ResponseEntity(service.delete(id), HttpStatus.OK);
    }
}