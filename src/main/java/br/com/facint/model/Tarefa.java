package br.com.facint.model;

import java.security.PrivateKey;
import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tarefas")
@NamedQuery(name = "Tarefa.tarefasPorCategoria", query = "select t from Tarefa t inner join t.categoria c where c.nome = ?1")
public class Tarefa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @NotBlank(message = "{tarefa.descricao.not-blank}")//validação por campo
    @Size(min = 5, max = 150, message = "{tarefa.descricao.size}") //quantidade permitida do campo
	@Column(name = "ds_tarefa", nullable = false, length = 150)
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	private TarefaStatus status;

    @FutureOrPresent(message = "{tarefa.descricao.future-or-present}")// data precisa ser presente ou futura
	private LocalDate dataEntrega;
	
	private boolean visivel;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private TarefaCategoria categoria;
	
	@ManyToOne
	private Usuario usuario;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TarefaStatus getStatus() {
		return status;
	}

	public void setStatus(TarefaStatus status) {
		this.status = status;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public boolean isVisivel() {
		return visivel;
	}

	public void setVisivel(boolean visivel) {
		this.visivel = visivel;
	}

	public TarefaCategoria getCategoria() {
		return categoria;
	}

	public void setCategoria(TarefaCategoria categoria) {
		this.categoria = categoria;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
