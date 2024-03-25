package br.com.challenge.corretora.controller;

import br.com.challenge.corretora.dto.VendaDTO;
import br.com.challenge.corretora.exception.VendaNotFoundException;
import br.com.challenge.corretora.model.Venda;
import br.com.challenge.corretora.service.VendaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/venda")
@RequiredArgsConstructor
public class VendaController {

    @Autowired
    VendaService vendaService;

    @GetMapping
    public List<VendaDTO> getVendas(){
        return vendaService.getAll();
    }

    @GetMapping(path = "/cotacao/{idCotacao}")
    public List<VendaDTO> getVendaByCotacao(@PathVariable Long idCotacao) {
        return vendaService.getVendaByCotacao(idCotacao);
    }

    @GetMapping(path = "/{idVenda}")
    public ResponseEntity<Venda> findById(@PathVariable long idVenda) {
        Optional<Venda> optVenda = vendaService.findById(idVenda);
        return optVenda.map(venda -> new ResponseEntity<>(venda, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.OK));
    }

    @GetMapping(path = "/{vendaIdentifier}")
    public VendaDTO findById(@PathVariable String vendaIdentifier) throws VendaNotFoundException {

        return vendaService.findByVendaIdentifier(vendaIdentifier);
    }

    @PostMapping
    public VendaDTO newVenda(@Valid @RequestBody VendaDTO vendaDTO) throws VendaNotFoundException {
        return vendaService.save(vendaDTO);
    }

    @DeleteMapping(path = "/{id}")
    public VendaDTO delete(@PathVariable Long id) throws VendaNotFoundException {
        return vendaService.delete(id);
    }

    @GetMapping(path = "/pageable")
    public Page<VendaDTO> getVendasPage(Pageable pageable) {
        return vendaService.getAllPage(pageable);
    }

    @PostMapping(path = "/{id}")
    public VendaDTO editVenda(@PathVariable Long id,
                                  @RequestBody VendaDTO vendaDTO) {
        return vendaService.editVenda(id, vendaDTO);
    }
}
