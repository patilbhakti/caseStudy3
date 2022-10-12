package com.gl.companyShareApp.service;

import java.util.List;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.companyShareApp.bean.CompanyShare;
import com.gl.companyShareApp.repository.ShareRepository;

@Service
public class ShareService {
	@Autowired
	private ShareRepository repository;
	public void save(CompanyShare companyShare) {
		repository.save(companyShare);	
	}
	
	public List<CompanyShare> findAll(){
		return repository.findAll();
	}
	
	public CompanyShare findById(Long id){
		return repository.getById(id);
	}
	
	public Long generateCompanyId() {
		Long val=repository.findMaxCompanyId();
		if(val==null)
			val=1000001L;
		else
			val=val+1;
		return val;
			
	}
	public void delete(long id) {
		repository.deleteById(id);
	}

}
