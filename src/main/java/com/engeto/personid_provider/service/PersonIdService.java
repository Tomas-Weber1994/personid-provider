package com.engeto.personid_provider.service;

import com.engeto.personid_provider.exception.ParsePersonIdException;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PersonIdService {

    @Getter
    private List<String> validIds;

    @Value("${personid.file}")
    private String filename;

    @PostConstruct
    public void loadIdsFromFile() {
        ClassPathResource resource = new ClassPathResource(filename);

        if (!resource.exists()) {
            log.error("Person ID file '{}' not found.", filename);
            throw new ParsePersonIdException("Person ID file not found: " + filename);
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
            AtomicInteger lineNumber = new AtomicInteger(0);

            validIds = reader.lines()
                    .map(String::trim)
                    .filter(line -> !line.isEmpty())
                    .map(line -> validatePersonId(line, lineNumber.incrementAndGet()))
                    .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));

        } catch (IOException e) {
            log.error("Error reading Person ID file '{}'", filename, e);
            throw new ParsePersonIdException("Failed to parse Person ID file", e);
        }

        log.info("PersonIdService loaded {} IDs from file '{}'", validIds.size(), filename);
    }

    private String validatePersonId(String id, int lineNumber) {
        if (id.length() != 12) {
            throw new ParsePersonIdException(
                    "Invalid person ID format at line " + lineNumber + ": '" + id + "'"
            );
        }
        return id;
    }
}
