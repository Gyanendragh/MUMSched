package org.mumsched.repositories;

import org.mumsched.domain.Block;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockRepository extends CrudRepository<Block, Long> {
	Block findByBlockName(String name);
}
