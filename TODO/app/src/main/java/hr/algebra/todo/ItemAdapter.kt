package hr.algebra.todo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hr.algebra.todo.model.Item

class ItemAdapter(private val items: MutableList<Item>)
    :RecyclerView.Adapter<ItemAdapter.ViewHolder>(){
    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        private val ivItem=itemView.findViewById<ImageView>(R.id.ivItem)
        private val tvItem=itemView.findViewById<TextView>(R.id.tvItem)

        fun bind(item: Item){
            ivItem.setOnClickListener{
                item.done=!item.done
                notifyDataSetChanged()
            }
            ivItem.setImageResource(
                if (item.done)R.drawable.done else R.drawable.notdone
            )
            tvItem.text=item.text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView=LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            items.removeAt(position)
            notifyDataSetChanged()
            true
        }
        holder.bind(items[position])
    }

    override fun getItemCount()=items.size

}