package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Supplier;
import com.example.demo.repository.SupplierRepository;

@Service
public class SupplierServiceImpl implements SupplierService{
	
	@Autowired
	private SupplierRepository supplierRepository;

	@Override
	public List<Supplier> getAllSuppliers() {
		return supplierRepository.findAll();
	}

	@Override
	public void saveSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Supplier getSupplierById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteSupplierById(long id) {
		// TODO Auto-generated method stub
		
	}

}
