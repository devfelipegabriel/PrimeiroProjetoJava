package com.felipegabriel.primeiro_projeto.controllers;

import com.felipegabriel.primeiro_projeto.dominio.Aluno;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;

@RestController
public class AlunoController {
    private ArrayList<Aluno> alunos = new ArrayList<>();

    @PostMapping("/aluno")
    public String cadastrarAluno(@RequestBody Aluno aluno) {
        alunos.add(aluno);
        return "Aluno cadastrado com sucesso!\n" +
                "dados do aluno:\n" + aluno.getNome() + "\n" +
                aluno.getIdade() + "\n" + aluno.getCurso();
    }

    @GetMapping("/aluno/{i}")
    public String aluno(@PathVariable int i) {
        if (i >= 0 && i < alunos .size()) {
            return "O nome do aluno é: " + alunos.get(i).getNome();
        } else {
            return "Erro, indice invalido";
        }
    }

    @GetMapping("/curso/{i}")
    public String curso(@PathVariable int i) {
        if (i >= 0 && i < alunos.size()) {
            return "O curso do aluno é: " + alunos.get(i).getCurso();
        } else {
            return "Erro, indice invalido";
        }
    }
}