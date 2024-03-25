package br.com.challenge.corretora.service;

import br.com.challenge.corretora.config.ApplicationConfig;
import br.com.challenge.corretora.converter.DTOEntityConverter;
import br.com.challenge.corretora.dto.CotacaoDTO;
import br.com.challenge.corretora.exception.CorretoraNotFoundException;
import br.com.challenge.corretora.exception.CotacaoNotFoundException;
import br.com.challenge.corretora.model.Cotacao;
import br.com.challenge.corretora.respository.CorretoraRepository;
import br.com.challenge.corretora.respository.CotacaoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CotacaoService {

    private final CotacaoRepository cotacaoRepository;

    private final CorretoraRepository corretoraRepository;

    public CotacaoService(CotacaoRepository cotacaoRepository, CorretoraRepository corretoraRepository) {
        this.cotacaoRepository = cotacaoRepository;
        this.corretoraRepository = corretoraRepository;
    }

    public List<CotacaoDTO> getAll() {
        List<Cotacao> products = cotacaoRepository.findAll();
        return products.stream().map(DTOEntityConverter::convertCotacaoToDto).collect(Collectors.toList());
    }

    public List<CotacaoDTO> getCotacaoByCorretora(Long idCorretora) {
        List<Cotacao> products = cotacaoRepository.getCotacaoByCorretora(idCorretora);
        return products.stream().map(DTOEntityConverter::convertCotacaoToDto).collect(Collectors.toList());
    }

    public CotacaoDTO findByCotacaoIdentifier(String cotacaoIdentifier) throws CotacaoNotFoundException {
        Cotacao cotacao = cotacaoRepository.findByCotacaoIdentifier(cotacaoIdentifier);
        if (cotacao != null) {
            return DTOEntityConverter.convertCotacaoToDto(cotacao);
        }
        throw new CotacaoNotFoundException();
    }

    public CotacaoDTO save(CotacaoDTO cotacaoDTO) throws CotacaoNotFoundException {
        boolean existsCategory = corretoraRepository.existsById(cotacaoDTO.getCorretora().getIdCorretora());
        if (!existsCategory) {
            throw new CotacaoNotFoundException();
        }
        Cotacao cotacao = cotacaoRepository.save(DTOEntityConverter.convertCotacaoDtoToEntity(cotacaoDTO));
        return DTOEntityConverter.convertCotacaoToDto(cotacao);
    }

    public CotacaoDTO delete(long id) throws CotacaoNotFoundException {
        Optional<Cotacao> cotacao = cotacaoRepository.findById(id);
        cotacao.ifPresent(cotacaoRepository::delete);
        throw new CotacaoNotFoundException();
    }

    public CotacaoDTO editCotacao(long id, CotacaoDTO dto) {
        Cotacao cotacao = cotacaoRepository.findById(id).orElseThrow(() -> new RuntimeException("Cotacao not found"));

        if (dto.getNumProposta() != null || !dto.getNumProposta().isEmpty()) {
            cotacao.setNumProposta(dto.getNumProposta());
        }
        if (dto.getNumApolice() != null) {
            cotacao.setNumProposta(dto.getNumProposta());
        }
        return ApplicationConfig.objectMapper().convertValue(cotacaoRepository.save(cotacao), CotacaoDTO.class);
    }

    public Page<CotacaoDTO> getAllPage(Pageable page) {
        Page<Cotacao> cotacoes = cotacaoRepository.findAll(page);
        return cotacoes
                .map(DTOEntityConverter::convertCotacaoToDto);
    }
}
