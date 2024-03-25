package br.com.challenge.corretora.converter;

import br.com.challenge.corretora.config.ApplicationConfig;
import br.com.challenge.corretora.dto.*;
import br.com.challenge.corretora.model.*;
import org.springframework.expression.ParseException;

public class DTOEntityConverter {

    public static ClienteDTO convertClienteToDto(Cliente cliente) {
        ClienteDTO clienteDto = ApplicationConfig.modelMapper().map(cliente, ClienteDTO.class);
        clienteDto.setIdCliente(cliente.getIdCliente());
        clienteDto.setNome(cliente.getNome());
        clienteDto.setCpfCnpj(cliente.getCpfCnpj());
        clienteDto.setEmail(cliente.getEmail());
        clienteDto.setEndereco(cliente.getEndereco());
        clienteDto.setSexo(cliente.getSexo());
        clienteDto.setTipo(cliente.getTipo());
        clienteDto.setTelefone(cliente.getTelefone());
        clienteDto.setDtNasc(cliente.getDtNasc());
        clienteDto.setEstadoCivil(cliente.getEstadoCivil());
        return clienteDto;
    }

    public static Cliente convertClienteDtoToEntity(ClienteDTO clienteDto) throws ParseException {
        Cliente cliente = ApplicationConfig.modelMapper().map(clienteDto, Cliente.class);
        cliente.setIdCliente(clienteDto.getIdCliente());
        cliente.setNome(clienteDto.getNome());
        cliente.setCpfCnpj(clienteDto.getCpfCnpj());
        cliente.setEmail(clienteDto.getEmail());
        cliente.setEndereco(clienteDto.getEndereco());
        cliente.setSexo(clienteDto.getSexo());
        cliente.setTipo(clienteDto.getTipo());
        cliente.setTelefone(clienteDto.getTelefone());
        cliente.setDtNasc(clienteDto.getDtNasc());
        cliente.setEstadoCivil(clienteDto.getEstadoCivil());
        return cliente;
    }

    public static CorretoraDTO convertCorretoraToDto(Corretora corretora) {
        CorretoraDTO corretoraDto = ApplicationConfig.modelMapper().map(corretora, CorretoraDTO.class);
        corretoraDto.setIdCorretora(corretora.getIdCorretora());
        corretoraDto.setCodsusep(corretora.getCodsusep());
        corretoraDto.setCpfCnpj(corretora.getCpfcnpj());
        corretoraDto.setEndereco(corretoraDto.getEndereco());
        corretoraDto.setTelefone(corretora.getTelefone());
        corretoraDto.setNome(corretora.getNome());

        return corretoraDto;
    }

    public static Corretora convertClienteDtoToEntity(CorretoraDTO corretoraDto) throws ParseException {
        Corretora corretora = ApplicationConfig.modelMapper().map(corretoraDto, Corretora.class);
        corretora.setIdCorretora(corretoraDto.getIdCorretora());
        corretora.setCodsusep(corretoraDto.getCodsusep());
        corretora.setCpfcnpj(corretoraDto.getCpfCnpj());
        corretora.setEndereco(corretoraDto.getEndereco());
        corretora.setTelefone(corretoraDto.getTelefone());
        corretora.setNome(corretoraDto.getNome());

        return corretora;
    }

    public static CotacaoDTO convertCotacaoToDto(Cotacao cotacao) {
        CotacaoDTO cotacaoDto = ApplicationConfig.modelMapper().map(cotacao, CotacaoDTO.class);
        cotacaoDto.setIdCotacao(cotacao.getIdCotacao());
        cotacaoDto.setCorretora(ApplicationConfig.modelMapper().map(cotacao.getCorretora(), CorretoraDTO.class));
        cotacaoDto.setVeiculo(ApplicationConfig.modelMapper().map(cotacao.getVeiculo(), VeiculoDTO.class));
        cotacaoDto.setSeguradora(ApplicationConfig.modelMapper().map(cotacao.getSeguradora(), SeguradoraDTO.class));
        cotacaoDto.setCliente(ApplicationConfig.modelMapper().map(cotacao.getCliente(), ClienteDTO.class));
        cotacaoDto.setProduto(cotacao.getProduto());
        cotacaoDto.setNumProposta(cotacao.getNumProposta());
        cotacaoDto.setNumApolice(cotacao.getNumApolice());
        cotacaoDto.setDtTermino(cotacao.getDtTermino());
        cotacaoDto.setDtProposta(cotacao.getDtProposta());
        cotacaoDto.setDtInicioVigencia(cotacao.getDtProposta());
        cotacaoDto.setDtEmissaoApolice(cotacao.getDtEmissaoApolice());
        cotacaoDto.setAprovada(cotacao.getAprovada());

        return cotacaoDto;
    }

    public static Cotacao convertCotacaoDtoToEntity(CotacaoDTO cotacaoDto) throws ParseException {
        Cotacao cotacao = ApplicationConfig.modelMapper().map(cotacaoDto, Cotacao.class);
        cotacao.setIdCotacao(cotacaoDto.getIdCotacao());
        cotacao.setCorretora(ApplicationConfig.modelMapper().map(cotacaoDto.getCorretora(), Corretora.class));
        cotacao.setVeiculo(ApplicationConfig.modelMapper().map(cotacaoDto.getVeiculo(), Veiculo.class));
        cotacao.setSeguradora(ApplicationConfig.modelMapper().map(cotacaoDto.getSeguradora(), Seguradora.class));
        cotacao.setCliente(ApplicationConfig.modelMapper().map(cotacaoDto.getCliente(), Cliente.class));
        cotacao.setProduto(cotacaoDto.getProduto());
        cotacao.setNumProposta(cotacaoDto.getNumProposta());
        cotacao.setNumApolice(cotacaoDto.getNumApolice());
        cotacao.setDtTermino(cotacaoDto.getDtTermino());
        cotacao.setDtProposta(cotacaoDto.getDtProposta());
        cotacao.setDtInicioVigencia(cotacaoDto.getDtProposta());
        cotacao.setDtEmissaoApolice(cotacaoDto.getDtEmissaoApolice());
        cotacao.setAprovada(cotacaoDto.getAprovada());
        return cotacao;
    }

    public static VendaDTO convertVendaToDto(Venda venda) {
        VendaDTO vendaDto = ApplicationConfig.modelMapper().map(venda, VendaDTO.class);
        vendaDto.setIdVenda(venda.getIdVenda());
        vendaDto.setCotacao(ApplicationConfig.modelMapper().map(venda.getCotacao(), CotacaoDTO.class));
        vendaDto.setVeiculo(ApplicationConfig.modelMapper().map(venda.getVeiculo(), VeiculoDTO.class));
        vendaDto.setFranquia(ApplicationConfig.modelMapper().map(venda.getFranquia(), FranquiaDTO.class));
        vendaDto.setPagamento(ApplicationConfig.modelMapper().map(venda.getPagamento(), PagamentoDTO.class));
        vendaDto.setPremiacao(ApplicationConfig.modelMapper().map(venda.getPremiacao(), PremiacaoDTO.class));
        vendaDto.setDtEmissao(venda.getDtEmissao());
        vendaDto.setValor(venda.getValor());
        vendaDto.setTransmitida(venda.getTransmitida());
        return vendaDto;
    }

    public static Venda convertVendaDtoToEntity(VendaDTO vendaDto) throws ParseException {
        Venda venda = ApplicationConfig.modelMapper().map(vendaDto, Venda.class);
        venda.setIdVenda(vendaDto.getIdVenda());
        venda.setCotacao(ApplicationConfig.modelMapper().map(vendaDto.getCotacao(), Cotacao.class));
        venda.setVeiculo(ApplicationConfig.modelMapper().map(vendaDto.getVeiculo(), Veiculo.class));
        venda.setFranquia(ApplicationConfig.modelMapper().map(vendaDto.getFranquia(), Franquia.class));
        venda.setPagamento(ApplicationConfig.modelMapper().map(vendaDto.getPagamento(), Pagamento.class));
        venda.setPremiacao(ApplicationConfig.modelMapper().map(vendaDto.getPremiacao(), Premiacao.class));
        venda.setDtEmissao(vendaDto.getDtEmissao());
        venda.setValor(vendaDto.getValor());
        return venda;
    }

}
