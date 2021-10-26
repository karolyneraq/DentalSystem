package br.com.lp2.projeto.dentalSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.lp2.projeto.dentalSystem.dto.MedicamentoDTO;
import br.com.lp2.projeto.dentalSystem.service.medicamento.DentalSystemServiceMedicamento;


@RestController
@RequestMapping("/medicamentos")
public class MedicamentoController {

	@Autowired
    private DentalSystemServiceMedicamento service;

    @GetMapping(value = "/list")
    public ResponseEntity list(){
        return new ResponseEntity(service.list(), HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity add(@RequestBody MedicamentoDTO post){
        return new ResponseEntity(service.add(post), HttpStatus.OK);
    }

    @PostMapping(value = "/{id}/update")
    public ResponseEntity edit(@PathVariable(value = "id") String id, @RequestBody MedicamentoDTO post){
        return new ResponseEntity(service.edit(id,post), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}/delete")
    public ResponseEntity delete(@PathVariable(value = "id") String id){
        return  new ResponseEntity(service.delete(id), HttpStatus.OK);
    }
}