package com.newhorizons.takeitnow.kardex.domain.service;

import com.newhorizons.takeitnow.kardex.application.mainmodule.dto.KardexDto;
import com.newhorizons.takeitnow.kardex.domain.repository.IKardexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class KardexService {
    @Autowired
    @Qualifier("repositoryRest")
    private IKardexRepository kardexRepository;

    public List<KardexDto> getAll() {
        return kardexRepository.getAll();
    }


    public KardexDto getKardex(long productId, long quantity, String transactionType, Date transactionDate) {
        return kardexRepository.getKardex(productId, quantity, transactionType, transactionDate);
    }
}
