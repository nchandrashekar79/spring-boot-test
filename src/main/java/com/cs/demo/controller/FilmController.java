package com.cs.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cs.demo.dto.FilmDto;
import com.cs.demo.exception.ResourceNotFoundException;
import com.cs.demo.repo.FilmRepo;

@RestController
@RequestMapping("v1/film")
public class FilmController {

	private FilmRepo filmRepo;

	@Autowired
	public FilmController(FilmRepo filmRepo) {
		this.filmRepo = filmRepo;
	}

	@GetMapping
	public List<FilmDto> FilmFindAll() {
		return filmRepo.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getFilmById(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {

		FilmDto film = findById(id);

		System.out.println(film.getFilmId());

		return ResponseEntity.ok().body(film);

	}

	private FilmDto findById(Integer id) throws ResourceNotFoundException {
		return filmRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Film not found for this id :: " + id));
	}

	@PostMapping
	public FilmDto createFilm(@RequestBody FilmDto Film) {
		return filmRepo.save(Film);
	}

	@PutMapping("{id}")
	public ResponseEntity<FilmDto> updateFilm(@PathVariable(value = "id") Integer id,
			@RequestBody FilmDto filmReq) throws ResourceNotFoundException {

		FilmDto film = findById(id);

		 film = mappingFilmData(filmReq, film);

		FilmDto updatedFilm = filmRepo.save(film);
		return ResponseEntity.ok(updatedFilm);
	}

	private FilmDto mappingFilmData(FilmDto filmReq, FilmDto film) {
		film.setTitle(filmReq.getTitle());
		return film;
	}

	@DeleteMapping("{id}")
	public Map<String, Boolean> deleteFilm(@PathVariable(value = "id") Integer id)
			throws ResourceNotFoundException {
		FilmDto film = findById(id);

		filmRepo.delete(film);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Film deleted", Boolean.TRUE);
		return response;
	}

}
