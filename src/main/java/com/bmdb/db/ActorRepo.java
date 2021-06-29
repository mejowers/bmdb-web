package com.bmdb.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.bmdb.business.Actor;

public interface ActorRepo extends CrudRepository<Actor, Integer> {

}
