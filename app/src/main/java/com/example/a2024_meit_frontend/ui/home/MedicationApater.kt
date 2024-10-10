package com.example.a2024_meit_frontend.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a2024_meit_frontend.R

data class Medication(val time: String, val medicines: List<String>)

class MedicationAdapter(private val medicationList: List<Medication>) :
    RecyclerView.Adapter<MedicationAdapter.MedicationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicationViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.medication_card, parent, false)
        return MedicationViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MedicationViewHolder, position: Int) {
        val medication = medicationList[position]
        holder.timeText.text = medication.time
        holder.medicine1.text = medication.medicines[0]
        holder.medicine2.text = medication.medicines[1]
        holder.medicine3.text = medication.medicines[2]
    }

    override fun getItemCount(): Int {
        return medicationList.size
    }

    class MedicationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val timeText: TextView = itemView.findViewById(R.id.time_text)
        val medicine1: TextView = itemView.findViewById(R.id.medicine_1)
        val medicine2: TextView = itemView.findViewById(R.id.medicine_2)
        val medicine3: TextView = itemView.findViewById(R.id.medicine_3)
    }
}
