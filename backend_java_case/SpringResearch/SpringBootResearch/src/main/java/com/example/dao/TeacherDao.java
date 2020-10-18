package com.example.dao;

import com.example.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TeacherDao extends JpaRepository<TeacherEntity, String> {

    @Query("From TeacherEntity a where a.teacherName = :name")
    public TeacherEntity findByName(@Param("name") String name);

    @Query(nativeQuery = true, value = "select * from teacher where teacher_name = :name")
    public TeacherEntity queryWithName(@Param("name") String name);

    @Modifying
    @Query("Update TeacherEntity a set a.teacherName = :name where a.opId = :opId")
    public void updateName(@Param("opId") String opId, @Param("name") String name);

    @Query(nativeQuery = true, value = "select * from teacher where teacher_name = :name")
    public List<Map<String, Object>> queryWithNameList(@Param("name") String name);
}
