package com.example.jetpackone.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.jetpackone.R
import com.example.jetpackone.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_list.*

/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment() {

    private lateinit var viewModel: ListViewModel
    private val dogAdapter = DogAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        viewModel.refresh()

        dogsList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = dogAdapter
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.dogs.observe(this, Observer { list ->
            list?.let {
                dogsList.visibility = VISIBLE
                dogAdapter.updateDogList(list)
            }
        })

        viewModel.dogsLoadError.observe(this, Observer {
            it?.let {
                errorMessage.visibility = if (it) VISIBLE else GONE
            }
        })

        viewModel.loading.observe(this, Observer {
            it?.let {
                progressBar.visibility = if (it) VISIBLE else GONE
                if (it) {
                    errorMessage.visibility = GONE
                    dogsList.visibility = GONE
                }
            }
        })
    }
}
