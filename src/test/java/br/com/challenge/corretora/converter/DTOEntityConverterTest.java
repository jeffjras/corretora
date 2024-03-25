package br.com.challenge.corretora.converter;

import br.com.challenge.corretora.config.ApplicationConfig;
import br.com.challenge.corretora.dto.ClienteDTO;
import br.com.challenge.corretora.model.Cliente;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DTOEntityConverterTest {

    @Test
    public void whenConvertAnyEntityToAnyDto_thenCorrect() {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(1L);
        cliente.setNome("teste nome");
        cliente.setCpfCnpj("123");
        cliente.setEmail("teste email");
        cliente.setEndereco("teste emd");
        cliente.setSexo("masc");
        cliente.setTipo("fisica");
        cliente.setTelefone("1234");
        cliente.setDtNasc("10/02/1990");
        cliente.setEstadoCivil("casado");

        ClienteDTO clienteDTO = ApplicationConfig.modelMapper().map(cliente, ClienteDTO.class);
        assertEquals(cliente.getIdCliente(), clienteDTO.getIdCliente());
        assertEquals(cliente.getNome(), clienteDTO.getNome());
        assertEquals(cliente.getCpfCnpj(), clienteDTO.getCpfCnpj());
        assertEquals(cliente.getEmail(), clienteDTO.getEmail());
        assertEquals(cliente.getEndereco(), clienteDTO.getEndereco());
        assertEquals(cliente.getSexo(), clienteDTO.getSexo());
        assertEquals(cliente.getTipo(), clienteDTO.getTipo());
        assertEquals(cliente.getTelefone(), clienteDTO.getTelefone());
        assertEquals(cliente.getDtNasc(), clienteDTO.getDtNasc());
        assertEquals(cliente.getEstadoCivil(), clienteDTO.getEstadoCivil());
    }

    @Test
    public void whenConvertAnyDtoToAnyEntity_thenCorrect() {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setIdCliente(1L);
        clienteDTO.setNome("teste nome");
        clienteDTO.setCpfCnpj("123");
        clienteDTO.setEmail("teste email");
        clienteDTO.setEndereco("teste emd");
        clienteDTO.setSexo("masc");
        clienteDTO.setTipo("fisica");
        clienteDTO.setTelefone("1234");
        clienteDTO.setDtNasc("10/02/1990");
        clienteDTO.setEstadoCivil("casado");

        Cliente cliente = ApplicationConfig.modelMapper().map(clienteDTO, Cliente.class);
        assertEquals(clienteDTO.getIdCliente(), cliente.getIdCliente());
        assertEquals(clienteDTO.getNome(), cliente.getNome());
        assertEquals(clienteDTO.getCpfCnpj(), cliente.getCpfCnpj());
        assertEquals(clienteDTO.getEmail(), cliente.getEmail());
        assertEquals(clienteDTO.getEndereco(), cliente.getEndereco());
        assertEquals(clienteDTO.getSexo(), cliente.getSexo());
        assertEquals(clienteDTO.getTipo(), cliente.getTipo());
        assertEquals(clienteDTO.getTelefone(), cliente.getTelefone());
        assertEquals(clienteDTO.getDtNasc(), cliente.getDtNasc());
        assertEquals(clienteDTO.getEstadoCivil(), cliente.getEstadoCivil());
    }

    @Test
    public void whenConvertClienteDtoToClienteEntity_thenCorrect() {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setIdCliente(1L);
        clienteDTO.setNome("teste nome");
        clienteDTO.setCpfCnpj("123");
        clienteDTO.setEmail("teste email");
        clienteDTO.setEndereco("teste emd");
        clienteDTO.setSexo("masc");
        clienteDTO.setTipo("fisica");
        clienteDTO.setTelefone("1234");
        clienteDTO.setDtNasc("10/02/1990");
        clienteDTO.setEstadoCivil("casado");

        Cliente cliente = DTOEntityConverter.convertClienteDtoToEntity(clienteDTO);

        assertEquals(clienteDTO.getIdCliente(), cliente.getIdCliente());
        assertEquals(clienteDTO.getNome(), cliente.getNome());
        assertEquals(clienteDTO.getCpfCnpj(), cliente.getCpfCnpj());
        assertEquals(clienteDTO.getEmail(), cliente.getEmail());
        assertEquals(clienteDTO.getEndereco(), cliente.getEndereco());
        assertEquals(clienteDTO.getSexo(), cliente.getSexo());
        assertEquals(clienteDTO.getTipo(), cliente.getTipo());
        assertEquals(clienteDTO.getTelefone(), cliente.getTelefone());
        assertEquals(clienteDTO.getDtNasc(), cliente.getDtNasc());
        assertEquals(clienteDTO.getEstadoCivil(), cliente.getEstadoCivil());
    }

    @Test
    public void whenConvertClienteEntityToClienteDto_thenCorrect() {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(1L);
        cliente.setNome("teste nome");
        cliente.setCpfCnpj("123");
        cliente.setEmail("teste email");
        cliente.setEndereco("teste emd");
        cliente.setSexo("masc");
        cliente.setTipo("fisica");
        cliente.setTelefone("1234");
        cliente.setDtNasc("10/02/1990");
        cliente.setEstadoCivil("casado");

        ClienteDTO clienteDTO = DTOEntityConverter.convertClienteToDto(cliente);

        assertEquals(clienteDTO.getIdCliente(), cliente.getIdCliente());
        assertEquals(clienteDTO.getNome(), cliente.getNome());
        assertEquals(clienteDTO.getCpfCnpj(), cliente.getCpfCnpj());
        assertEquals(clienteDTO.getEmail(), cliente.getEmail());
        assertEquals(clienteDTO.getEndereco(), cliente.getEndereco());
        assertEquals(clienteDTO.getSexo(), cliente.getSexo());
        assertEquals(clienteDTO.getTipo(), cliente.getTipo());
        assertEquals(clienteDTO.getTelefone(), cliente.getTelefone());
        assertEquals(clienteDTO.getDtNasc(), cliente.getDtNasc());
        assertEquals(clienteDTO.getEstadoCivil(), cliente.getEstadoCivil());
    }

}