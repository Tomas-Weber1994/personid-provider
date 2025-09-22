package com.engeto.personid_provider.controller;

import com.engeto.personid_provider.service.PersonIdService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/v1/person-id")
@RequiredArgsConstructor
public class PersonIdController {

    @Autowired
    private PersonIdService personIdService;

    @GetMapping
    public Map<String, List<String>> getValidIds() {
        List<String> ids = personIdService.getValidIds();
        log.info("PersonId API returned {} IDs", ids.size());
        return Map.of("validPersonIds", ids);
    }
}
