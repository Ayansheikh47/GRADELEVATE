package com.gradelevate.gradelevate_backend.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SkillDTO {

    private Long id;

    @NotBlank(message = "Skill name is required")
    private String name;

    private String category;
    private String description;
}