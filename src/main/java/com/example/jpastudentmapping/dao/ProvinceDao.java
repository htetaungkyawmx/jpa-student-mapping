package com.example.jpastudentmapping.dao;

import com.example.jpastudentmapping.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceDao extends JpaRepository<Province, Integer> {

}
