package br.com.bruno.gs3.clientes.brunogs3backend.mapper;

import br.com.bruno.gs3.clientes.brunogs3backend.dao.entity.Telefone;
import br.com.bruno.gs3.clientes.brunogs3backend.dto.TelefoneDTO;
import br.com.bruno.gs3.clientes.brunogs3backend.forms.TelefoneForm;

import java.util.List;
import java.util.stream.Collectors;

public class TelefoneMapper implements MapperGlobal<Telefone, TelefoneDTO, TelefoneForm> {

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
                .id(entity.getId())
                .ddd(entity.getDdd())
                .numero(entity.getNumero())
                .build();
    }

    @Override
    public TelefoneForm dtoToForm(TelefoneDTO dto) {
        return TelefoneForm.builder()
                .id(dto.getId())
                .ddd(dto.getDdd())
                .numero(dto.getNumero())
                .build();
    }

}
