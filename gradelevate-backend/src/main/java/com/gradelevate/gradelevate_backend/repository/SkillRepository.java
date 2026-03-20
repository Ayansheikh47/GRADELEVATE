package com.gradelevate.gradelevate_backend.repository;

import com.gradelevate.gradelevate_backend.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
    List<Skill> findByCategory(String category);
    List<Skill> findByNameContainingIgnoreCase(String keyword);
}