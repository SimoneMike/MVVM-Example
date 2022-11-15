package com.example.myapplication.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.DummyListAdapter
import com.example.myapplication.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var binding : FragmentMainBinding? = null
    private lateinit var viewModel: MainViewModel
    private lateinit var dummyDataAdapter: DummyListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater)

        dummyDataAdapter = DummyListAdapter()

        val gridLayoutManager = GridLayoutManager(context,2)
        gridLayoutManager.orientation = LinearLayoutManager.VERTICAL
        binding!!.dummyData.layoutManager = gridLayoutManager

        binding!!.dummyData.adapter = dummyDataAdapter

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getDummyData()

        viewModel.observeDummyLiveData().observe(viewLifecycleOwner, Observer {
                dataList->dummyDataAdapter.setDataList(dataList)
        })

        return binding!!.root
    }
}