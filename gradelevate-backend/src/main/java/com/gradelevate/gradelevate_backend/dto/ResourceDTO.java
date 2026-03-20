package com.gradelevate.gradelevate_backend.dto;

import com.gradelevate.gradelevate_backend.entity.Resource;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ResourceDTO {

    private Long id;

    @NotBlank(message = "Title is required")
    private String title;

    @NotNull(message = "Resource type is required")
    private Resource.ResourceType type;

    @NotBlank(message = "URL is required")
    private String url;

    private String thumbnailUrl;

    private Long skillId;
    private Long careerId;
}