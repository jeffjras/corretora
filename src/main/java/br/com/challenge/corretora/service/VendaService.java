package br.com.challenge.corretora.service;

import br.com.challenge.corretora.config.ApplicationConfig;
import br.com.challenge.corretora.converter.DTOEntityConverter;
import br.com.challenge.corretora.dto.VendaDTO;
import br.com.challenge.corretora.exception.CotacaoNotFoundException;
import br.com.challenge.corretora.exception.VendaNotFoundException;
import br.com.challenge.corretora.model.Venda;
import br.com.challenge.corretora.respository.CotacaoRepository;
import br.com.challenge.corretora.respository.VendaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VendaService {

    private final VendaRepository vendaRepository;

    private final CotacaoRepository cotacaoRepository;

    private VendaStatus status;
    private enum VendaStatus {
        READY,
        DELIVERED;
    }

    public VendaService(VendaRepository VendaRepository, CotacaoRepository cotacaoRepository) {
        this.vendaRepository = VendaRepository;
        this.cotacaoRepository = cotacaoRepository;
    }

    public List<VendaDTO> getAll() {
        List<Venda> products = vendaRepository.findAll();
        return products.stream().map(DTOEntityConverter::convertVendaToDto).collect(Collectors.toList());
    }

    public List<VendaDTO> getVendaByCotacao(Long idCotacao) {
        List<Venda> products = vendaRepository.getVendaByCotacao(idCotacao);
        return products.stream().map(DTOEntityConverter::convertVendaToDto).collect(Collectors.toList());
    }

    public VendaDTO findByVendaIdentifier(String vendaIdentifier) throws VendaNotFoundException {
        Venda Venda = vendaRepository.findByVendaIdentifier(vendaIdentifier);
        if (Venda != null) {
            return DTOEntityConverter.convertVendaToDto(Venda);
        }
        throw new VendaNotFoundException();
    }

    public VendaDTO save(VendaDTO vendaDTO) throws VendaNotFoundException {
        boolean existsVenda = cotacaoRepository.existsById(vendaDTO.getCotacao().getIdCotacao());
        if (!existsVenda) {
            throw new VendaNotFoundException();
        }
        Venda venda = vendaRepository.save(DTOEntityConverter.convertVendaDtoToEntity(vendaDTO));
        return DTOEntityConverter.convertVendaToDto(venda);
    }

    public VendaDTO delete(long id) throws VendaNotFoundException {
        Optional<Venda> venda = vendaRepository.findById(id);
        venda.ifPresent(vendaRepository::delete);
        throw new VendaNotFoundException();
    }

    private int getDeliveryVenda() {
        switch (status) {
            case READY: return 0;
            case DELIVERED: return 1;
        }
        return -1;
    }
    public VendaDTO editVenda(long id, VendaDTO dto) {
        Venda venda = vendaRepository.findById(id).orElseThrow(() -> new RuntimeException("Venda not found"));

        if (dto.getValor() != null) {
            venda.setValor(dto.getValor());
        }
        if (dto.getTransmitida() != getDeliveryVenda()) {
            venda.setTransmitida(dto.getTransmitida());
        }
        return ApplicationConfig.objectMapper().convertValue(vendaRepository.save(venda), VendaDTO.class);
    }

    public Page<VendaDTO> getAllPage(Pageable page) {
        Page<Venda> vendas = vendaRepository.findAll(page);
        return vendas
                .map(DTOEntityConverter::convertVendaToDto);
    }

    public Optional<Venda> findById(long id) {
        return vendaRepository.findById(id);
    }

    Optional<Venda> findByCode(String code) {
        return null;
    }
}
