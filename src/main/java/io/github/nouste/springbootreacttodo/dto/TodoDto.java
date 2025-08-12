package io.github.nouste.springbootreacttodo.dto;

public record TodoDto (Long id, String title, String description, boolean completed) {
}
