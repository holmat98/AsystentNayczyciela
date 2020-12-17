package com.example.asystentnayczyciela.View

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModelProvider
import com.example.asystentnayczyciela.Model.DataSource
import com.example.asystentnayczyciela.R
import com.example.asystentnayczyciela.ViewModel.GradeViewModel
import kotlinx.android.synthetic.main.fragment_add_grade.*
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentAddGrade.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentAddGrade : Fragment(), AdapterView.OnItemSelectedListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var marks: List<String> = listOf("1", "1+", "2", "2+", "3", "3+", "4", "4+", "5", "5+", "6")
    private var selectedMark: String = ""
    private val calendar = java.util.Calendar.getInstance()

    private lateinit var viewModel: GradeViewModel
    lateinit var adapter: ArrayAdapter<String>

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

        adapter = context?.let {
            ArrayAdapter(
                it,
                android.R.layout.simple_spinner_item,
                marks
            )
        }!!
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)


        return inflater.inflate(R.layout.fragment_add_grade, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        gradesSpinner.adapter = adapter
        gradesSpinner.onItemSelectedListener = this

        addGradeBtn.setOnClickListener {
            var description: String = gradeDescription.getText().toString()
            Log.d("OCENA", Date().toString() + " " + selectedMark + " " + description + " " + DataSource.chosenCourseId.toString() + " " + DataSource.chosenParticipantId)
            if(!"".equals(description) && !"".equals(selectedMark))
            {
                viewModel.addGrade(DataSource.chosenParticipantId, description, DataSource.chosenCourseId, selectedMark, Date())
            }
        }
    }

    override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
        selectedMark = parent.getItemAtPosition(pos).toString()
    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        selectedMark = ""
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentAddGrade.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentAddGrade().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}