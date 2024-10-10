package com.example.a2024_meit_frontend.ui.management

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a2024_meit_frontend.R

class MyAdapter(private val medicationList: List<MedicationItem>) : RecyclerView.Adapter<MyAdapter.MedicationViewHolder>() {

    // ViewHolder 클래스 정의
    class MedicationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val medicationName: TextView = itemView.findViewById(R.id.medication_name)
        val medicationNumber: TextView = itemView.findViewById(R.id.medication_number)
        val medicationImage: ImageView = itemView.findViewById(R.id.medication_image)
        val remainingAmount: TextView = itemView.findViewById(R.id.remaining_amount)
    }

    // onCreateViewHolder: 뷰 홀더 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicationViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_medication, parent, false)
        return MedicationViewHolder(view)
    }

    // onBindViewHolder: 데이터 바인딩
    override fun onBindViewHolder(holder: MedicationViewHolder, position: Int) {
        val medicationItem = medicationList[position]
        holder.medicationName.text = medicationItem.name
        holder.medicationNumber.text = medicationItem.number.toString()
        holder.medicationImage.setImageResource(medicationItem.imageResId) // drawable 리소스 설정
        holder.remainingAmount.text = "잔량: ${medicationItem.remainingAmount}"
    }

    // 아이템 개수 반환
    override fun getItemCount(): Int {
        return medicationList.size
    }
}

// MedicationItem 데이터 클래스 정의
data class MedicationItem(
    val name: String,
    val number: Int,
    val imageResId: Int,
    val remainingAmount: Int
)
