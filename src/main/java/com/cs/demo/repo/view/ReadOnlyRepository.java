package com.cs.demo.repo.view;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface ReadOnlyRepository<SalesByStoreDto, Long> extends Repository<SalesByStoreDto, Long> {

   
}