package br.com.bruno.gs3.clientes.brunogs3backend.mapper;

import br.com.bruno.gs3.clientes.brunogs3backend.dao.entity.Endereco;
import br.com.bruno.gs3.clientes.brunogs3backend.dao.entity.Telefone;
import br.com.bruno.gs3.clientes.brunogs3backend.dto.EnderecoDTO;
import br.com.bruno.gs3.clientes.brunogs3backend.dto.TelefoneDTO;

public class TelefoneMapper implements MapperGlobal<Telefone, TelefoneDTO> {

    @Override
    public Telefone dtoToEntity(TelefoneDTO dto) {
        return Telefone.builder()
                .ddd(dto.getDdd())
                .numero(dto.getNumero())
                .build();
    }

    @Override
    public TelefoneDTO entityToDTO(Telefone entity) {
        return TelefoneDTO.builder()
                .ddd(entity.getDdd())
                .numero(entity.getNumero())
                .build();
    }
}
