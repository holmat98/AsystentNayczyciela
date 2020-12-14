package com.example.asystentnayczyciela.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.asystentnayczyciela.Model.DataSource.Companion.chosenTeacherIndex
import com.example.asystentnayczyciela.R
import com.example.asystentnayczyciela.ViewModel.TeacherViewModel
import kotlinx.android.synthetic.main.fragment_choosen_teacher.*
import javax.sql.DataSource

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ChoosenTeacher.newInstance] factory method to
 * create an instance of this fragment.
 */
class ChoosenTeacher : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var viewModel: TeacherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        viewModel = ViewModelProvider(requireActivity()).get(TeacherViewModel::class.java)
        
        return inflater.inflate(R.layout.fragment_choosen_teacher, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        witajTTV.text = "Witaj " + viewModel.teachers.value?.get(com.example.asystentnayczyciela.Model.DataSource.chosenTeacherIndex)?.name + " " + viewModel.teachers.value?.get(com.example.asystentnayczyciela.Model.DataSource.chosenTeacherIndex)?.lastName

        deleteTeacher.setOnClickListener{
            view -> view.findNavController().navigate(R.id.action_choosenTeacher_to_fragmentChooseTeacher)
            viewModel.teachers.value?.get(com.example.asystentnayczyciela.Model.DataSource.chosenTeacherIndex)
                ?.let { viewModel.deleteTeacher(it) }
        }
        
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ChoosenTeacher.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ChoosenTeacher().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}