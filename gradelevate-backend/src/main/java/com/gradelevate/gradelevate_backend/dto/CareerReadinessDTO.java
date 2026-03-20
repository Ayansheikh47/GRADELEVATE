package com.gradelevate.gradelevate_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CareerReadinessDTO {
    private Long careerId;
    private String careerTitle;
    private int totalSkills;
    private int completedSkills;
    private int learningSkills;
    private int readinessPercent;
    private List<SkillProgressDTO> skillProgresses;
}