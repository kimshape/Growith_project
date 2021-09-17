package com.bit.growith.repository;

import com.bit.growith.entity.Comunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComunityRepository extends JpaRepository<Comunity, Long>{

}
