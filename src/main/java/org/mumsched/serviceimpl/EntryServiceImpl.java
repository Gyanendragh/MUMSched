package org.mumsched.serviceimpl;

import java.util.List;

import org.mumsched.domain.Entry;
import org.mumsched.repositories.EntryRepository;
import org.mumsched.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntryServiceImpl implements EntryService {
	@Autowired
	EntryRepository entryrepository;


	@Override
	public void save(Entry entry) {
		entryrepository.save(entry);
	}

	@Override
	public List<Entry> getAllEntry() {

		return (List<Entry>) entryrepository.findAll();
	}

	@Override
	public Entry getEntryById(Long id) {

		return entryrepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		entryrepository.delete(id);

	}

}
