package com.project.Library.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Library.model.User;

@Repository
public interface  UserRepository extends JpaRepository<User,Long>{

}
