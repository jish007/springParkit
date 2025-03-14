package com.carparking.project;

import com.carparking.project.service.RatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RatesController {

    @Autowired
    RatesService ratesService;


}
