import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.org.hackathon.R
import com.org.hackathon.model.SlotResponse
import com.org.hackathon.model.TimeSlot

class TimeSlotAdapter : RecyclerView.Adapter<TimeSlotAdapter.ViewHolder>() {

    private var slotsList: List<TimeSlot> = emptyList()

    fun setSlots(slots: List<TimeSlot>) {
        slotsList = slots
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.time_pic, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val slot = slotsList[position]
        holder.bind(slot)
    }

    override fun getItemCount(): Int {
        return slotsList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val timeTextView: TextView = itemView.findViewById(R.id.btnTimeSlot1)
        private val timeTextView1: TextView = itemView.findViewById(R.id.btnTimeSlot2)

        fun bind(slot: TimeSlot) {
            timeTextView.text = "${slot.slot_name} - ${slot.slot_id}"
            timeTextView1.text = "${slot.slot_name} - ${slot.slot_id}"


            // Set background color based on availability
            if (slot.slot_active) {
                itemView.setBackgroundColor(Color.GREEN) // Available slot color
            } else {
                itemView.setBackgroundColor(Color.RED) // Not available slot color
            }
        }
    }
}