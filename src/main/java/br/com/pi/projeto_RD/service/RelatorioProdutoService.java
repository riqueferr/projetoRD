package br.com.pi.projeto_RD.service;

import br.com.pi.projeto_RD.model.dto.ProdutoDto;
import br.com.pi.projeto_RD.model.dto.RelatorioProdutoDTO;
import br.com.pi.projeto_RD.model.entity.ProdutoEntity;
import br.com.pi.projeto_RD.repository.ProdutoRepository;
import br.com.pi.projeto_RD.service.bo.RelatorioProdutoBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Component
public class RelatorioProdutoService {

    @Autowired
    private RelatorioProdutoBO bo;

    @Autowired
    private ProdutoRepository repository;

    @PersistenceContext
    private EntityManager manager;

    public List<RelatorioProdutoDTO> listarTodas() {
        List<ProdutoEntity> listEntity = repository.findAll();
        List<RelatorioProdutoDTO> listDTO = new ArrayList<>();

        for (ProdutoEntity entity : repository.findAll()) {
            RelatorioProdutoDTO dto = bo.parseToDTO(entity);
            listDTO.add(dto);
        }

        return listDTO;
    }

    public RelatorioProdutoDTO buscarPorId(Integer codigo) {
        return bo.parseToDTO(repository.getOne(codigo));
    }

    public List<ProdutoEntity> buscarNfPorDsStatus(Long DS_STATUS_PRODUTO) {
        return manager.createNamedQuery("buscarNfPorDsStatus", ProdutoEntity.class).setParameter("DS_STATUS_PRODUTO", DS_STATUS_PRODUTO).getResultList();
    }

}