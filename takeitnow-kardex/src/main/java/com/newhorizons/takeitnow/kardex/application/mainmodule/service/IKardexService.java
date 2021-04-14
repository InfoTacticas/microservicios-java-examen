package com.newhorizons.takeitnow.kardex.application.mainmodule.service;

import com.newhorizons.takeitnow.kardex.application.mainmodule.dto.KardexDto;

import java.util.Date;
import java.util.List;

public interface IKardexService {
    List<KardexDto> getAll();
    KardexDto getKardex(long productId, long quantity, String transactionType, Date transactionDate);
}
