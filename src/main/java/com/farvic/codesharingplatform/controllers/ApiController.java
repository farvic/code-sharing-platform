package com.farvic.codesharingplatform.controllers;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.farvic.codesharingplatform.entities.Code;
import com.farvic.codesharingplatform.repositories.CodeRepository;
import com.farvic.codesharingplatform.services.CodeServiceImpl;

@RestController
@RequestMapping("/api/code")
public class ApiController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CodeRepository.class);
    private final CodeServiceImpl codeService;

    public ApiController(CodeServiceImpl codeService) {
        this.codeService = codeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Code> findById(@PathVariable("id") String id) {
        Code code = codeService.findById(id);
        LOGGER.info(code.getCode());
        return ResponseEntity.ok(code);
    }

    @PostMapping(value = "/new", consumes = "application/json")
    public ResponseEntity<Map<String, String>> postTextCode(@RequestBody Code codeSnippet) {
        codeService.saveCode(codeSnippet);
        return ResponseEntity.ok(Map.of("id", codeSnippet.getId()));
    }

    @GetMapping("/latest")
    public ResponseEntity<List<Code>> getLatestCodes() {
        List<Code> codes = codeService.getLastTenCodes();
        LOGGER.info(codes.toString());
        return ResponseEntity.ok(codes);
    }

}
