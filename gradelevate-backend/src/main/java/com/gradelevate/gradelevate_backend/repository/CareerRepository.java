package com.gradelevate.gradelevate_backend.repository;

import com.gradelevate.gradelevate_backend.entity.Career;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CareerRepository extends JpaRepository<Career, Long> {
    List<Career> findByTitleContainingIgnoreCase(String keyword);
    List<Career> findByDemandLevel(Career.DemandLevel demandLevel);
}