package org.chuix.training.universidad.backend.repository;

import org.chuix.training.universidad.backend.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
