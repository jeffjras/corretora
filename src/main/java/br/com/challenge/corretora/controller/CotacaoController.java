package br.com.challenge.corretora.controller;

import br.com.challenge.corretora.dto.CotacaoDTO;
import br.com.challenge.corretora.exception.CotacaoNotFoundException;
import br.com.challenge.corretora.service.CotacaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cotacao")
@RequiredArgsConstructor
public class CotacaoController {

    @Autowired
    CotacaoService cotacaoService;

    @GetMapping
    public List<CotacaoDTO> getCotacoes(){
        return cotacaoService.getAll();
    }

    @GetMapping("/corretora/{idCorretora}")
    public List<CotacaoDTO> getCotacaoByCarretora(@PathVariable Long idCorretora) {
        return cotacaoService.getCotacaoByCorretora(idCorretora);
    }

    @GetMapping("/{cotacaoIdentifier}")
    public CotacaoDTO findById(@PathVariable String cotacaoIdentifier) throws CotacaoNotFoundException {
        return cotacaoService.findByCotacaoIdentifier(cotacaoIdentifier);
    }

    @PostMapping
    public CotacaoDTO newCotacao(@Valid @RequestBody CotacaoDTO cotacaoDTO) throws CotacaoNotFoundException {
        return cotacaoService.save(cotacaoDTO);
    }

    @DeleteMapping("/{id}")
    public CotacaoDTO delete(@PathVariable Long id) throws CotacaoNotFoundException {
        return cotacaoService.delete(id);
    }

    @GetMapping("/pageable")
    public Page<CotacaoDTO> getCotacoesPage(Pageable pageable) {
        return cotacaoService.getAllPage(pageable);
    }

    @PostMapping("/{id}")
    public CotacaoDTO editProduct(@PathVariable Long id,
                                  @RequestBody CotacaoDTO cotacaoDTO) {
        return cotacaoService.editCotacao(id, cotacaoDTO);
    }
}
