 package com.example.retrofittest.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofittest.adapter.MyDataAdapter
import com.example.retrofittest.R
import com.example.retrofittest.viewmodel.MyViewModel
import com.example.retrofittest.viewmodel.MyViewModelFactory
import com.example.retrofittest.common.MyApi
import com.example.retrofittest.databinding.ActivityMainBinding
import com.example.retrofittest.repository.MyRepository

 class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
//    private val viewModel : MyViewModel by viewModels()
    private lateinit var viewModel: MyViewModel
    private lateinit var adapter :  MyDataAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this, MyViewModelFactory(MyRepository(MyApi.create())))[MyViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MyDataAdapter()
        binding.recyclerView.adapter = adapter

        viewModel.myData.observe(this, Observer {
            adapter.setData(it)
        })

        binding.btnFetchData.setOnClickListener {
            viewModel.fetchData()
        }
    }
}