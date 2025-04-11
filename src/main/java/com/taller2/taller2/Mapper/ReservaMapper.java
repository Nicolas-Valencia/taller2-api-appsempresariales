package com.taller2.taller2.Mapper;

import com.taller2.taller2.DTO.ResevaDTO;
import com.taller2.taller2.Entity.Reserva;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ReservaMapper {

    ReservaMapper INSTANCE = Mappers.getMapper(ReservaMapper.class);

    ResevaDTO toDTO(Reserva reserva);

    Reserva toEntity(ResevaDTO reservaDTO);
}