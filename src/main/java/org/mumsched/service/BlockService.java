package org.mumsched.service;

import java.util.List;

import org.mumsched.domain.Block;

public interface BlockService {

	public void save(Block blockObj);

	public Object getBlockById(long id);

	public void delete(Long id);

	public List<Block> getAllBlock();

}
