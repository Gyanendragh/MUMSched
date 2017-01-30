package org.mumsched.service;

import java.util.List;

import org.mumsched.domain.Entry;

public interface EntryService {
	public void save(Entry entry);

	public List<Entry> getAllEntry();

	public Entry getEntryById(Long id); 

	public void delete(Long id);

}
