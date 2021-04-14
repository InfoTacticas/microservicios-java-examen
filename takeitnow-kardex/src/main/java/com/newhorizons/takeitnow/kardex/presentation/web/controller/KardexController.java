package com.newhorizons.takeitnow.kardex.presentation.web.controller;


import com.newhorizons.takeitnow.kardex.application.mainmodule.dto.KardexDto;
import com.newhorizons.takeitnow.kardex.application.mainmodule.service.IKardexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RefreshScope
@RestController
@RequestMapping("/kardex")
public class KardexController {
    @Value("${configuracion.usuario}")
    private String userName;

    @Autowired
    private Environment environment;

    @Autowired
    private IKardexService kardexService;

    @GetMapping("/getAll")
    public List<KardexDto> getAll(){
        return kardexService.getAll();
    }

    @GetMapping("/getKardex/{productId}/{quantity}/{transactionType}/{transactionDate}")
    public KardexDto getKardex(@PathVariable("productId") long productId, @PathVariable("quantity") long quantity,
                             @PathVariable("transactionType") String transactionType, @PathVariable("transactionDate") Date transactionDate
                             ){
        return kardexService.getKardex(productId, quantity, transactionType, transactionDate);
    }

    @GetMapping("/getConfigProperties")
    public ResponseEntity<?> getConfigProperties(){
        Map<String, String> jsonObject = new HashMap<>();
        jsonObject.put("userName", userName);

        if(environment.getActiveProfiles().length > 0 && environment.getActiveProfiles()[0].equals("dev")){
            jsonObject.put("port", environment.getProperty("server.port"));
        }

        return new ResponseEntity<Map<String, String>>(jsonObject, HttpStatus.OK);
    }
}
