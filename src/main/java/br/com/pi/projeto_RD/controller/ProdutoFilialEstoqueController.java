package br.com.pi.projeto_RD.controller;

import br.com.pi.projeto_RD.model.dto.ProdutoDto;
import br.com.pi.projeto_RD.model.dto.ProdutoFilialEstoqueDTO;
import br.com.pi.projeto_RD.model.entity.ProdutoEntity;
import br.com.pi.projeto_RD.repository.ProdutoFilialEstoqueRepository;
import br.com.pi.projeto_RD.service.FilialEstoqueService;
import br.com.pi.projeto_RD.service.bo.ProdutoFilialEstoqueBO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProdutoFilialEstoqueController {

    @Autowired
    ProdutoFilialEstoqueRepository produtoFilialEstoqueRepository;

    @Autowired
    FilialEstoqueService service;


    @GetMapping("/FilialEstoque")
    @ApiOperation(value = "Listar todas os Produtos e Filiais")
    public ResponseEntity buscarTodas() {
        return ResponseEntity.ok().body(service.buscarTodos());
    }

    @GetMapping("/FilialEstoque/{codigo}")
    @ApiOperation(value = "Listar filiais e produtos por ID produto")
    public ResponseEntity buscarPorId(@PathVariable("codigo") Integer codigo) {
        return ResponseEntity.ok().body(service.buscarPorId(codigo));
    }

    @PutMapping("/FilialEstoque")
    @ApiOperation(value = "Alterar filiais produtos")
    public ResponseEntity atualizar(@RequestBody ProdutoFilialEstoqueDTO dto) throws Exception {
        service.atualizar(dto);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping("/FilialEstoque")
    @ApiOperation(value = "Salvar idFilial e idProduto")
    public ResponseEntity<Object> salvarProdutos(@RequestBody ProdutoFilialEstoqueDTO dto) {
        ResultData resultData = null;
        if (dto.getCd_filial() == null)
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(), "Filial não informado!");
        else if (dto.getCodProduto() == null)
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(), "Produto não informado!");

        if (resultData != null)
            return ResponseEntity.badRequest().body(resultData);
        else {
            try {
                service.inserir(dto);
                resultData = new ResultData<ProdutoEntity>(HttpStatus.OK.value(), "Estoque registrada com sucesso!");
                return ResponseEntity.status(HttpStatus.CREATED).body(resultData);
            } catch (Exception e) {
                resultData = new ResultData(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Ocorreu um erro ao registrar Estoque", e.getMessage());
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resultData);
            }
        }
    }

}
