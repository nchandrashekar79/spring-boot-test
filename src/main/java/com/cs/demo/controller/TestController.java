package com.cs.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cs.demo.dto.AddressDto;
import com.cs.demo.dto.CategoryDto;
import com.cs.demo.dto.CityDto;
import com.cs.demo.dto.CountryDto;
import com.cs.demo.dto.CustomerDto;
import com.cs.demo.dto.FilmActorDto;
import com.cs.demo.dto.FilmCategoryDto;
import com.cs.demo.dto.FilmDto;
import com.cs.demo.dto.InventoryDto;
import com.cs.demo.dto.LanguageDto;
import com.cs.demo.dto.PaymentDto;
import com.cs.demo.dto.RentalDto;
import com.cs.demo.dto.StaffDto;
import com.cs.demo.dto.StoreDto;
import com.cs.demo.repo.AddressRepo;
import com.cs.demo.repo.CategoryRepo;
import com.cs.demo.repo.CityRepo;
import com.cs.demo.repo.CountryRepo;
import com.cs.demo.repo.CustomerRepo;
import com.cs.demo.repo.FilmActorRepo;
import com.cs.demo.repo.FilmCategoryRepo;
import com.cs.demo.repo.FilmRepo;
import com.cs.demo.repo.InventoryRepo;
import com.cs.demo.repo.LanguageRepo;
import com.cs.demo.repo.PaymentRepo;
import com.cs.demo.repo.RentalRepo;
import com.cs.demo.repo.StaffRepo;
import com.cs.demo.repo.StoreRepo;

@RestController
@RequestMapping("v1/test")
public class TestController {

	@Autowired
	private CountryRepo countryRepo;

	@Autowired
	private StoreRepo storeRepo;

	@Autowired
	private CityRepo cityRepo;

	@Autowired
	private AddressRepo addressRepo;

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private StaffRepo staffRepo;

	@Autowired
	private PaymentRepo paymentRepo;

	@Autowired
	private RentalRepo rentalRepo;
	
	@Autowired
	private LanguageRepo LanguageRepo; 

	@Autowired
	private InventoryRepo inventoryRepo;
	

	@Autowired
	private FilmRepo filmRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private FilmCategoryRepo filmCategoryRepo;
	
	
	@Autowired
	private FilmActorRepo filmActorRepo;
	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@GetMapping("/filmactor")
	public List<FilmActorDto> filmActorFindAll() {
		return filmActorRepo.findAll();
	}
	
	@GetMapping("/filmcat")
	public List<FilmCategoryDto> filmCategoryFindAll() {
		return filmCategoryRepo.findAll();
	}
	
	@GetMapping("/cat")
	public List<CategoryDto> categoryFindAll() {
		return categoryRepo.findAll();
	}
	
	
	@GetMapping("film")
	public List<FilmDto> filmFindAll() {
		return filmRepo.findAll();
	} 
	
	@GetMapping("/lang")
	public List<LanguageDto> languageFindAll() {
		return LanguageRepo.findAll();
	} 

	
	@GetMapping("/inv")
	public List<InventoryDto> inventoryFindAll() {
		return inventoryRepo.findAll();
	} 

	@GetMapping("/rental")
	public List<RentalDto> rentalFindAll() {
		return rentalRepo.findAll();
	}

	@GetMapping("/payment")
	public List<PaymentDto> paymentFindAll() {
		return paymentRepo.findAll();
	}

	@GetMapping("/staff")
	public List<StaffDto> staffFindAll() {
		return staffRepo.findAll();
	}

	@GetMapping("/customer")
	public List<CustomerDto> customerFindAll() {
		return customerRepo.findAll();
	}

	@GetMapping("/address")
	public List<AddressDto> addressFindAll() {
		return addressRepo.findAll();
	}

	@GetMapping
	public String test() {
		return "test ";
	}

	@GetMapping("/city")
	public List<CityDto> cityFindAll() {
		return cityRepo.findAll();
	}

	@GetMapping("/country")
	public List<CountryDto> countryFindAll() {
		return countryRepo.findAll();
	}

	@GetMapping("/store")
	public List<StoreDto> storeFindAll() {
		 logger.debug("Performing an storeFindAll...");
		return storeRepo.findAll();
	}

}
