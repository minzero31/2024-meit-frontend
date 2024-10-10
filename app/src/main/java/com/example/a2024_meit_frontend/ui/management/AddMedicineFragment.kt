package com.example.a2024_meit_frontend.ui.management

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.widget.EditText
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.a2024_meit_frontend.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*

class AddMedicineFragment : Fragment() {

    private lateinit var navView: BottomNavigationView
    private lateinit var inputDate: EditText
    private lateinit var inputTime: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_addmedi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // View 찾기
        inputDate = view.findViewById(R.id.input_date)
        inputTime = view.findViewById(R.id.input_time)
        navView = requireActivity().findViewById(R.id.nav_view)

        // DatePicker 설정
        inputDate.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(requireContext(), { _, selectedYear, selectedMonth, selectedDay ->
                inputDate.setText("$selectedYear-${selectedMonth + 1}-$selectedDay")
            }, year, month, day)
            datePickerDialog.show()
        }

        // TimePicker 설정
        inputTime.setOnClickListener {
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)

            val timePickerDialog = TimePickerDialog(requireContext(), { _, selectedHour, selectedMinute ->
                inputTime.setText("$selectedHour:$selectedMinute")
            }, hour, minute, true)
            timePickerDialog.show()
        }

        // BottomNavigationView 보이도록 설정
        navView.visibility = View.VISIBLE
    }
}
