package com.example.dao;

import com.example.entity.TeacherEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherCrudDao extends CrudRepository<TeacherEntity, String> {

    public Page<TeacherEntity> findByTeacherName(String teacherName, Pageable page);

    @Query("From TeacherEntity e where e.teacherName = :teacherName" )
    public Page<TeacherEntity> findByTeacherNameCase02(@Param("teacherName") String teacherName, Pageable page);
}
