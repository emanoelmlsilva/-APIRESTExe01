package br.ufpb.dcx.disciplina.controller.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufpb.dcx.disciplina.model.Model.Disciplina;
import br.ufpb.dcx.disciplina.service.DisciplinaService.*;

@RestController
@RequestMapping("/v1/api/disciplinas")
public class ControllerDisciplina {
	
	
	@Autowired
	private DisciplinaService disciplinaService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Disciplina> getDisciplinasId(@PathVariable(value="id") int id) {
		Disciplina disciplina = disciplinaService.findId(id);
		if(disciplina != null) {
			return new ResponseEntity<Disciplina>(disciplina, HttpStatus.OK);	
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping("/ranking")
	public ResponseEntity<List<Disciplina>> getRanking(){
		List<Disciplina> disciplinas = disciplinaService.getOrderRanking();
		if(disciplinas.size() != 0) {
			return new ResponseEntity<List<Disciplina>>(disciplinas, HttpStatus.OK);	
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("")
	public ResponseEntity<List<Disciplina>> getAllDisciplinas(){
		List<Disciplina> disciplinas = disciplinaService.getAll();
		if(disciplinas.size() != 0) {
			return new ResponseEntity<List<Disciplina>>(disciplinas, HttpStatus.OK);	
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);		
	}
	
	@PostMapping("")
	public ResponseEntity<Disciplina> setDisciplina(@RequestBody Disciplina newDisciplina){
		return new ResponseEntity<Disciplina>(disciplinaService.setNewDisciplina(newDisciplina), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Disciplina> delDisciplina(@PathVariable(value = "id") int id){
		Disciplina disciplina = disciplinaService.removeDiciplinaById(id);
		if(disciplina != null) {
			return new ResponseEntity<Disciplina>(disciplina, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/{id}/name")
	public ResponseEntity<Disciplina> putDisciplinaName(@PathVariable(value = "id") int id, @RequestBody String name){
		Disciplina disciplina = disciplinaService.upDateName(id,name);		
		if(disciplina != null) {			
			return new ResponseEntity<Disciplina>(disciplina, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/{id}/nota")
	public ResponseEntity<Disciplina> putDisciplinaNota(@PathVariable(value = "id") int id, @RequestBody double nota){
		Disciplina disciplina = disciplinaService.upDateNota(id,nota);		
		if(disciplina != null) {			
			return new ResponseEntity<Disciplina>(disciplina, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
