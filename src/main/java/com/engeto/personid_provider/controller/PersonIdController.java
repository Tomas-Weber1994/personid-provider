package com.engeto.personid_provider.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Simulated certification authority API.
 * In reality, valid person IDs would come from an external service.
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/person-id")
public class PersonIdController {

    private final List<String> validIds = List.of(
            "jXa4g3H7oPq2",
            "yB9fR6tK0wLm",
            "cN1vZ8pE5sYx",
            "tQdG2kP3mJfB",
            "iM5sO6tXcW7v",
            "rU8nA9eT2bYh",
            "wV6eH1fK7qZj",
            "sL4gN9dC3bXz",
            "kR0aZ7vW2nDl",
            "eI1oY6tQ9dKj",
            "gT4cR7wS0lVx",
            "xF9hD2yJ3sWv",
            "hM5bZ8nK4aVf",
            "qE3lY6uT0vKd",
            "bG2zC7jR9xVp",
            "vB1fX4rH7iNt",
            "aO8kP3mZ6dIw",
            "dW9pL2eU1yNc",
            "nS7tJ0qR5wGh",
            "mY6sT1jA3cLz"
    );

    @GetMapping
    public Map<String, List<String>> getValidIds() {
        Map<String, List<String>> response = Map.of("validPersonIds", validIds);
        log.info("PersonId API returned {} IDs", validIds.size());
        return response;
    }
}
