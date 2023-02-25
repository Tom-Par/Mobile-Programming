package com.example.studentshardlife.fragments.update

import android.app.AlertDialog
import android.os.Bundle
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.studentshardlife.R
import com.example.studentshardlife.model.Task
import com.example.studentshardlife.viewmodel.TaskViewModel
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*


class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()

    private lateinit var mTaskViewModel:TaskViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_update, container, false)

        mTaskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)

        view.updateName.setText(args.currentTask.Name)
        view.updatePrzedmiot.setText(args.currentTask.Major)
        view.updateOpis.setText(args.currentTask.Description)

        view.update_button.setOnClickListener {
            updateItem()
        }

        return view
    }

    private fun updateItem() {
        val name = updateName.text.toString()
        val major = updatePrzedmiot.text.toString()
        val description = updateOpis.text.toString()

        if(inputCheck(name, major, description)) {
            val updatedTask = Task(args.currentTask.id, name, major, description)
            mTaskViewModel.updateTask(updatedTask)
            Toast.makeText(requireContext(),"Zaktualizowano Pomyślnie!!", Toast.LENGTH_LONG).show()

            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(),"Proszę wypełnić wszytkie pola.", Toast.LENGTH_LONG).show()
        }
    }
    private fun inputCheck(name:String, major:String,description:String): Boolean{
        return !(TextUtils.isEmpty(name) && TextUtils.isEmpty(major) && TextUtils.isEmpty(description))
    }



}