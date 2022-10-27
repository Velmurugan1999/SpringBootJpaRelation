package com.relation.manytomany.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.relation.models.Student;


@Repository
public interface StudentDao extends JpaRepository<Student, Integer>{

}
