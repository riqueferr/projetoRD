package br.com.pi.projeto_RD.controller;


import br.com.pi.projeto_RD.repository.DocumentoFiscalRepository;
import br.com.pi.projeto_RD.repository.FilialRepository;
import br.com.pi.projeto_RD.service.DocumentoFiscalService;
import br.com.pi.projeto_RD.service.FilialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocumentoFiscalController {

    @Autowired
    DocumentoFiscalRepository repository;


    @Autowired
    private DocumentoFiscalService service;

    @GetMapping("/documentofiscal")
    public ResponseEntity<Object> listarTodas(){
        return ResponseEntity.ok().body(service.buscarTodos());
    }

    //LISTAR POR ID
    @GetMapping("/documentofiscal/{codigo}")
    public ResponseEntity buscarPorId(@PathVariable("codigo") Long codigo) {
        return ResponseEntity.ok().body(service.buscarPorId(codigo));
    }



}