package com.taller2.taller2.Mapper;

import com.taller2.taller2.DTO.PagoDTO;
import com.taller2.taller2.Entity.Pago;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PagoMapper {

    PagoMapper INSTANCE = Mappers.getMapper(PagoMapper.class);

    PagoDTO toDTO(Pago pago);

    Pago toEntity(PagoDTO pagoDTO);
}