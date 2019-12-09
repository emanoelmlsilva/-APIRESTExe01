package br.ufpb.dcx.disciplina.service.DisciplinaService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.ufpb.dcx.disciplina.model.Model.Disciplina;

@Service
public class DisciplinaService {

	private List<Disciplina> disciplinas = new ArrayList<>();	
	
	private final AtomicLong counter = new AtomicLong();
	
	public List<Disciplina> getOrderRanking(){		
		List<Disciplina> auxClone = new ArrayList<>();
		auxClone.addAll(disciplinas);
		Collections.sort(auxClone);  	
		return auxClone;
	}	
	
	public List<Disciplina> getAll(){		
		return disciplinas;
	}
	
	public Disciplina setNewDisciplina(Disciplina disciplina) {
		Long aux = counter.incrementAndGet();
		int id = Integer.valueOf(aux.toString());
		disciplina.setId(id);
		disciplinas.add(disciplina);
		return disciplina;
	}
	
	public Disciplina removeDiciplinaById(int id) {
		Disciplina disciplina = findId(id);
		if(disciplina != null) {
			disciplinas.remove(id);			
		}
		return disciplina;
	}
	
	public Disciplina findId(int id) {
		for(Disciplina disciplina : disciplinas) {
			if(disciplina.getId() == id)return disciplina;
		}
		return null;
	}
	
	public Disciplina upDateName(int id, String name) {
		Disciplina disciplina = findId(id);
		if(disciplina != null) {
			int index = disciplinas.indexOf(disciplina);		
			disciplina.setNome(name);
			disciplinas.set(index, disciplina);			
		}		
		return disciplina;
	}
	
	public Disciplina upDateNota(int id, double nota) {
		Disciplina disciplina = findId(id);
		if(disciplina != null) {
			int index = disciplinas.indexOf(disciplina);			
			disciplina.setNota(nota);
			disciplinas.set(index, disciplina);			
		}		
		return disciplina;
	}
}
