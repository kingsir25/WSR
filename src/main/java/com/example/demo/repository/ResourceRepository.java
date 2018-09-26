package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.domain.Resource;

public interface ResourceRepository extends JpaRepository<Resource, Integer> {

	public List<Resource> findByComeDate(Integer comeDate);
}
