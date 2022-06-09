package com.example.wyklad10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wyklad10.adapters.DaoAdapter
import com.example.wyklad10.room.Sklep
import com.example.wyklad10.viewmodel.SklepyViewModel


class ShowListActivity : AppCompatActivity() {
    private lateinit var viewModel: SklepyViewModel
    private lateinit var daoAdapter: DaoAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var listofSklepy: LiveData<List<Sklep>>

    override fun onCreate(savedInstanceState: Bundle?)  {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_list_sklepy)



        viewModel = ViewModelProvider.AndroidViewModelFactory
            .getInstance(application)
            .create(SklepyViewModel::class.java)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)

             listofSklepy = viewModel.getAllSklepy()
        listofSklepy.observe(this, Observer {
            if (it.isNotEmpty()) {
                daoAdapter = DaoAdapter(it)
                recyclerView.adapter = daoAdapter
            }
        })
    }}




