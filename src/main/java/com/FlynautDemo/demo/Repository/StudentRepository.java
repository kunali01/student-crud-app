package com.FlynautDemo.demo.Repository;

import com.FlynautDemo.demo.entity.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Students, Integer> {


}
