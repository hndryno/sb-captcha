package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Supplier;

public interface SupplierService {
	List<Supplier> getAllSuppliers();
	void saveSupplier(Supplier supplier);
	Supplier getSupplierById(long id);
	void deleteSupplierById(long id);
}
