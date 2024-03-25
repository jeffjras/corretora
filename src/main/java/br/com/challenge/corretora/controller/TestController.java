package br.com.challenge.corretora.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;

@RestController
@RequestMapping("/api/test")
public class TestController {

    private static final SimpleDateFormat dateFormat
            = new SimpleDateFormat("dd-MM-yyyy HH:mm");
    private static final Logger LOG = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/corretora/{name}")
    public ResponseEntity<?> dogTest(@PathVariable String name) {
        LOG.info("Test controller info - name: {}", name);

        return ResponseEntity.ok("Name: " + name);
    }
}

