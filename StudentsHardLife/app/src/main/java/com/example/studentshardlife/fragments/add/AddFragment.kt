package com.example.studentshardlife.fragments.add

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.studentshardlife.R
import com.example.studentshardlife.model.Task
import com.example.studentshardlife.viewmodel.TaskViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*


class AddFragment : Fragment() {

    private lateinit var mTaskViewModel: TaskViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        mTaskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)

        view.add_button.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {
        val name = addName.text.toString()
        val major = addPrzedmiot.text.toString()
        val description = addOpis.text.toString()

        if(inputCheck(name, major, description)) {
            val task = Task(0, name, major, description)
            mTaskViewModel.addTask(task)
            Toast.makeText(requireContext(), "Dodano pomyślnie!!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }
    }

    private fun inputCheck(name:String, major:String,description:String): Boolean{
        return !(TextUtils.isEmpty(name) && TextUtils.isEmpty(major) && TextUtils.isEmpty(description))
    }


}