package com.gradelevate.gradelevate_backend.dto;

import com.gradelevate.gradelevate_backend.entity.UserSkillProgress;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SkillProgressDTO {
    private Long skillId;
    private String skillName;
    private Long careerId;
    private String careerTitle;
    private UserSkillProgress.ProgressStatus status;
}