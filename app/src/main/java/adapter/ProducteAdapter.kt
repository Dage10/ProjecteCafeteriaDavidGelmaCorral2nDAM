package adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.daviddam.projectecafeteriadavidgelmacorral2ndam.R
import entity.ProducteEntity

class ProducteAdapter(
    private val llistaProductes: List<ProducteEntity>,
    private val alClicar: (ProducteEntity) -> Unit
) : RecyclerView.Adapter<ProducteAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val tvNom: TextView = view.findViewById(R.id.tvProducteNom)
        val tvPreu: TextView = view.findViewById(R.id.tvProductePreu)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_producte, parent, false)
        return ProductViewHolder(v)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val producte = llistaProductes[position]
        holder.tvNom.text = producte.nom
        holder.tvPreu.text = "${producte.preu} €"
        holder.itemView.setOnClickListener {
            holder.itemView.animate().alpha(0.6f).setDuration(80).withEndAction {
                holder.itemView.animate().alpha(1f).setDuration(150).start()
            }.start()
            android.widget.Toast.makeText(holder.itemView.context, "Producte afegit", android.widget.Toast.LENGTH_SHORT).show()
            alClicar(producte)
        }
    }

    override fun getItemCount(): Int = llistaProductes.size
}
