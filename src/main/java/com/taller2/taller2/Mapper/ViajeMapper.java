package com.taller2.taller2.Mapper;

import com.taller2.taller2.DTO.ViajeDTO;
import com.taller2.taller2.Entity.Viaje;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ViajeMapper {

    ViajeMapper INSTANCE = Mappers.getMapper(ViajeMapper.class);

    ViajeDTO toDTO(Viaje viaje);

    Viaje toEntity(ViajeDTO viajeDTO);
}
