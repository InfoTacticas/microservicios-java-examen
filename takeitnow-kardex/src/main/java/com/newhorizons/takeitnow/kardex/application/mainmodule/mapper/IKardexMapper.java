package com.newhorizons.takeitnow.kardex.application.mainmodule.mapper;

import com.newhorizons.takeitnow.kardex.application.mainmodule.dto.KardexDto;
import com.newhorizons.takeitnow.kardex.domain.entity.Kardex;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = { IProductMapper.class })
public interface IKardexMapper {
    @Mappings({
            @Mapping(source = "product", target = "product"),
            @Mapping(source = "quantity", target = "quantity"),
            @Mapping(source = "transactionType", target = "transactionType"),
            @Mapping(source = "transactionDate", target = "transactionDate"),
    })
    KardexDto toItemDto(Kardex item);

    List<KardexDto> toKardexDto(List<Kardex> kardex);

    @InheritInverseConfiguration
    Kardex toKardex(KardexDto kardexDto);
}
