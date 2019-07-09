package com.dev.minhastarefas.Model;

import java.io.Serializable;

public class Tarefa implements Serializable {

    private long id;
    private String tarefaNome;

    public Tarefa() {

    }

    public Tarefa(long id, String tarefaNome) {
        this.id = id;
        this.tarefaNome = tarefaNome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTarefaNome() {
        return tarefaNome;
    }

    public void setTarefaNome(String tarefaNome) {
        this.tarefaNome = tarefaNome;
    }
}
