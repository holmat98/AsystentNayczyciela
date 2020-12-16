package com.example.asystentnayczyciela.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.asystentnayczyciela.Model.DataSource
import com.example.asystentnayczyciela.R
import com.example.asystentnayczyciela.ViewModel.AdapterNotParticipants
import com.example.asystentnayczyciela.ViewModel.AdapterParticipants
import com.example.asystentnayczyciela.ViewModel.ParticipantViewModel
import kotlinx.android.synthetic.main.fragment_participants.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentParticipants.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentParticipants : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var viewModel: ParticipantViewModel
    private lateinit var myAdapter: AdapterParticipants
    private lateinit var myLayoutManager: LinearLayoutManager
    private lateinit var recyclerView: RecyclerView

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

        viewModel = ViewModelProvider(requireActivity()).get(ParticipantViewModel::class.java)
        viewModel.participants = viewModel.studentRepository.getParticipants(DataSource.chosenCourseId)
        myLayoutManager = LinearLayoutManager(context)
        myAdapter = AdapterParticipants(viewModel.participants)

        viewModel.participants.observe(viewLifecycleOwner, androidx.lifecycle.Observer { myAdapter.notifyDataSetChanged() })

        return inflater.inflate(R.layout.fragment_participants, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = participantsRecyclerView.apply {
            this.layoutManager = myLayoutManager
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
         * @return A new instance of fragment FragmentParticipants.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentParticipants().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}