package br.com.bandtec.nivelentretenimento.controller;

import br.com.bandtec.nivelentretenimento.ControleEntretenimento;
import br.com.bandtec.nivelentretenimento.Entretenimento;
import br.com.bandtec.nivelentretenimento.entidades.Filme;
import br.com.bandtec.nivelentretenimento.entidades.Jogo;
import br.com.bandtec.nivelentretenimento.entidades.Serie;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entretenimentos")
public class EntretenimentoController {

  ControleEntretenimento controle = new ControleEntretenimento();

  @GetMapping
  public List<Entretenimento> todos() {
    return controle.todos();
  }

  @GetMapping("/qualidade/{qualidade}")
  public List<Entretenimento> qualidadeAcima(@PathVariable Double qualidade) {
    return controle.filtrarQualidadeAcima(qualidade);
  }

  @GetMapping("/qualidade/media")
  public Double mediaQualidade() {
    return controle.mediaQualidade();
  }

  @GetMapping("/total/horas")
  public Double totalHoras() {
    return controle.totalHoras();
  }

  @GetMapping("/filmes")
  public List<Entretenimento> filmes() {
    return controle.todosFilmes();
  }

  @GetMapping("/series")
  public List<Entretenimento> series() {
    return controle.todosSeries();
  }

  @GetMapping("/jogos")
  public List<Entretenimento> jogos() {
    return controle.todosJogos();
  }

  @PostMapping("/filmes")
  public void cadastrarFilme(@RequestBody Filme filme) {
    controle.adicionaEntretenimento(filme);
  }

  @PostMapping("/series")
  public void cadastrarSerie(@RequestBody Serie serie) {
    controle.adicionaEntretenimento(serie);
  }

  @PostMapping("/jogos")
  public void cadastrarJogos(@RequestBody Jogo jogo) {
    controle.adicionaEntretenimento(jogo);
  }

  @DeleteMapping("/{id}")
  public void removeFilmes(@PathVariable Integer id) {
    controle.removeEntretenimento(id - 1);
  }
}