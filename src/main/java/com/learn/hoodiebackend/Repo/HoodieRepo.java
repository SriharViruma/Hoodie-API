package com.learn.hoodiebackend.Repo;

import com.learn.hoodiebackend.Model.Hoodie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface HoodieRepo extends JpaRepository<Hoodie,Long> {

    @Query("Select max(h.id) from Hoodie h")
    long findMaxId();
}
