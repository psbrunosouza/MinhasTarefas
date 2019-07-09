package com.dev.minhastarefas.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dev.minhastarefas.Model.Tarefa;
import com.dev.minhastarefas.R;

import java.util.List;

public class AdapterTarefas extends RecyclerView.Adapter<AdapterTarefas.mViewHolder> {

    private List<Tarefa> listaTarefa;

    public AdapterTarefas(List<Tarefa> listaTarefa) {
        this.listaTarefa = listaTarefa;
    }

    @NonNull
    @Override
    public mViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.tarefa, viewGroup, false);
        return new mViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull mViewHolder mViewHolder, int i) {
        Tarefa tarefa = listaTarefa.get(i);
        mViewHolder.txt_tarefa.setText(tarefa.getTarefaNome());
    }

    @Override
    public int getItemCount() {
        return listaTarefa.size();
    }

    public class mViewHolder extends RecyclerView.ViewHolder{

        TextView txt_tarefa;

        public mViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_tarefa = itemView.findViewById(R.id.txt_tarefa);
        }
    }

}
