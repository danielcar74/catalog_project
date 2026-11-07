package model;

public class ItemMidia {
	private int id;
	private String titulo;
	private String autor_diretor;
	private int ano_lancamento;
	private String genero;
	private String sinopse;
	private String tipo_midia;
	
	public ItemMidia() {}
	
	public ItemMidia(String titulo, String autor_diretor, int ano_lancamento, String genero, String sinopse, String tipo_media) {
		this.titulo = titulo;
		this.autor_diretor = autor_diretor;
		this.ano_lancamento = ano_lancamento;
		this.genero = genero;
		this.sinopse = sinopse;
		this.tipo_midia = tipo_media;
	}
	
public int getId() { return id;}
public void setId(int id) {this.id = id; }

public String getTitulo() { return titulo; }
public void setTitulo(String titulo) { this.titulo = titulo; }

public String getAutorDiretor() { return autor_diretor; }
public void setAutorDiretor(String autor_diretor) { this.autor_diretor = autor_diretor; }

public int getAnoLancamento() { return ano_lancamento; }
public void setAnoLancamento(int ano_lancamento) { this.ano_lancamento = ano_lancamento; }

public String getGenero() { return genero; }
public void setGenero(String genero) { this.genero = genero; }

public String getSinopse() { return sinopse; }
public void setSinopse(String sinopse) { this.sinopse = sinopse; }

public String getTipoMidia() { return tipo_midia; }
public void setTipoMidia(String tipo_midia) { this.tipo_midia = tipo_midia; }
	
	
	
}