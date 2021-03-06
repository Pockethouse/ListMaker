package com.markbowen.listmaker.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelStore
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.markbowen.listmaker.MainViewModelFactory
import com.markbowen.listmaker.R
import com.markbowen.listmaker.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    private lateinit var binding : MainFragmentBinding

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = MainFragmentBinding.inflate(inflater, container,false)

        binding.listsRecyclerview.layoutManager =
            LinearLayoutManager(requireContext())

        binding.listsRecyclerview.adapter = ListSelectionRecyclerViewAdapter()

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(requiredActivity(),
            MainViewModelFactory(PreferenceManager.getDefaultSharedPreferences(requireActivity())))[MainViewModel::class.java]


    }

    private fun requiredActivity(): ViewModelStore {
        TODO("Not yet implemented")
    }

}