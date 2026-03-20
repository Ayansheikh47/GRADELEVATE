package com.gradelevate.gradelevate_backend.dto;

import com.gradelevate.gradelevate_backend.entity.Career;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CareerRecommendationDTO {
    private Long id;
    private String title;
    private String description;
    private String avgSalary;
    private Career.DemandLevel demandLevel;
    private int score;

    public CareerRecommendationDTO(Career career, int score) {
        this.id          = career.getId();
        this.title       = career.getTitle();
        this.description = career.getDescription();
        this.avgSalary   = career.getAvgSalary();
        this.demandLevel = career.getDemandLevel();
        this.score       = score;
    }
}