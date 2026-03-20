package com.gradelevate.gradelevate_backend.dto;

import com.gradelevate.gradelevate_backend.entity.Career;
import com.gradelevate.gradelevate_backend.entity.Skill;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SkillGapDTO {
    private String careerTitle;
    private List<Skill> missingSkills;
    private List<Skill> knownSkills;
    private List<String> learningOrder;

    public SkillGapDTO(Career career,
                       List<Skill> missingSkills,
                       List<Skill> knownSkills) {
        this.careerTitle   = career.getTitle();
        this.missingSkills = missingSkills;
        this.knownSkills   = knownSkills;
    }
}