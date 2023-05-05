package com.example.covoituragebackend.dao;

import com.example.covoituragebackend.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RoleRepository extends MongoRepository<Role,String> {
   Role findByRoleName(String roleName);
}
