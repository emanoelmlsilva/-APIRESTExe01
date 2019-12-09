package br.ufpb.dcx.disciplina.model.Model;

public class Disciplina implements Comparable<Disciplina>{
	
	private int id;
	private String nome;
	private double nota; 	
	
	public Disciplina(String nome, double nota) {
		super();		
		this.nome = nome;
		this.nota = nota;
	}
		
	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int compareTo(Disciplina disciplinaComp) {
		if(this.nota > disciplinaComp.getNota()) {
			return -1;
		}else if(this.nota < disciplinaComp.getNota()) {
			return 1;
		}
		return 0;
	}
	
	
	
}



