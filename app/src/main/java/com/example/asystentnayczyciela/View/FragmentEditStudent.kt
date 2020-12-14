package com.example.asystentnayczyciela.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.asystentnayczyciela.Model.DataSource
import com.example.asystentnayczyciela.R
import com.example.asystentnayczyciela.ViewModel.StudentViewModel
import kotlinx.android.synthetic.main.fragment_add_student.*
import kotlinx.android.synthetic.main.fragment_choosen_student.*
import kotlinx.android.synthetic.main.fragment_edit_student.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentEditStudent.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentEditStudent : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var viewModel: StudentViewModel

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

        viewModel = ViewModelProvider(requireActivity()).get(StudentViewModel::class.java)

        return inflater.inflate(R.layout.fragment_edit_student, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newStudentName2.setText(viewModel.students.value?.get(DataSource.choosenStudentIndex)?.name)
        newStudentLastName2.setText(viewModel.students.value?.get(DataSource.choosenStudentIndex)?.lastName)

        editStudentButton.setOnClickListener{
            var newName: String = newStudentName.getText().toString()
            var newLastName: String = newStudentLastName2.getText().toString()

            if(!newName.equals(viewModel.students.value?.get(DataSource.choosenStudentIndex)?.name) && !"".equals(newName)
                &&
                !newLastName.equals(viewModel.students.value?.get(DataSource.choosenStudentIndex)?.lastName) && !"".equals(newLastName)
            ){
                viewModel.students.value?.get(DataSource.choosenStudentIndex)?.id?.let { it1 ->
                    viewModel.editStudent(newName, newLastName,
                        it1
                    )
                }
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentEditStudent.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentEditStudent().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}