package com.example.asystentnayczyciela.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.asystentnayczyciela.Model.DataSource
import com.example.asystentnayczyciela.R
import com.example.asystentnayczyciela.ViewModel.AdapterGrades
import com.example.asystentnayczyciela.ViewModel.GradeViewModel
import kotlinx.android.synthetic.main.fragment_report.*
import kotlinx.android.synthetic.main.fragment_students_grades.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentStudentsGrades.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentStudentsGrades : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var viewModel: GradeViewModel
    lateinit var myLaoyoutManager: LinearLayoutManager
    lateinit var myAdapter: AdapterGrades
    lateinit var recyclerView: RecyclerView

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

        viewModel = ViewModelProvider(requireActivity()).get(GradeViewModel::class.java)
        viewModel.studentsGrades = viewModel.gradeRepository.getStudentsGrades(DataSource.chosenStudentId, DataSource.chosenStudentsCourseId)
        myLaoyoutManager = LinearLayoutManager(context)
        myAdapter = AdapterGrades(viewModel.studentsGrades)

        viewModel.studentsGrades.observe(viewLifecycleOwner, Observer { myAdapter.notifyDataSetChanged() })

        return inflater.inflate(R.layout.fragment_students_grades, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = sgRecyclerView.apply {
            this.layoutManager = myLaoyoutManager
            this.adapter = myAdapter
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentStudentsGrades.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentStudentsGrades().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}