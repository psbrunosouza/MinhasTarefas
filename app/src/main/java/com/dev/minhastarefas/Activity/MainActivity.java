package com.dev.minhastarefas.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.dev.minhastarefas.Adapter.AdapterTarefas;
import com.dev.minhastarefas.Helper.RecyclerItemClickListener;
import com.dev.minhastarefas.Model.Tarefa;
import com.dev.minhastarefas.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewListaTarefa;
    private List<Tarefa> listaTarefa = new ArrayList<>();
    private AdapterTarefas adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Binding
        FloatingActionButton fab = findViewById(R.id.fab);
        recyclerViewListaTarefa = findViewById(R.id.recyclerViewListaTarefa);

        recyclerViewListaTarefa.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerViewListaTarefa,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Toast.makeText(MainActivity.this, "EDITAR", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Toast.makeText(MainActivity.this, "DELETAR", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );

        //Lista de itens
        configurarListaTarefas();

        //FloatingActionButton
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });
    }

    public void configurarListaTarefas(){

        Tarefa tarefa1 = new Tarefa();
        tarefa1.setTarefaNome("Ir ao banco");
        listaTarefa.add(tarefa1);

        Tarefa tarefa2 = new Tarefa();
        tarefa2.setTarefaNome("Ir a praia");
        listaTarefa.add(tarefa2);

        //Adapter
        adapter = new AdapterTarefas(listaTarefa);

        //layoutManager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());

        //Configurações
        recyclerViewListaTarefa.setAdapter(adapter);
        recyclerViewListaTarefa.setLayoutManager(layoutManager);
        recyclerViewListaTarefa.setHasFixedSize(true);
        recyclerViewListaTarefa.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
    }

    @Override
    protected void onStart() {
        super.onStart();
        listaTarefa.clear();
        adapter.notifyDataSetChanged();
        configurarListaTarefas();
    }
}
