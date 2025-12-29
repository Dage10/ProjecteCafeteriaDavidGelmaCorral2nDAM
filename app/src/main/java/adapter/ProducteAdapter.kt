package adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.daviddam.projectecafeteriadavidgelmacorral2ndam.databinding.ItemProducteBinding
import entity.ProducteEntity

class ProducteAdapter(
    private val llistaProductes: List<ProducteEntity>,
    private val alClicar: (ProducteEntity) -> Unit,
    private val mostrarToast: Boolean = true
) : RecyclerView.Adapter<ProducteAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(val binding: ItemProducteBinding) : RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemProducteBinding.inflate(inflater, parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val producte = llistaProductes[position]
        holder.binding.tvProducteNom.text = producte.nom
        holder.binding.tvProductePreu.text = "${producte.preu} €"
        holder.binding.root.setOnClickListener {
            holder.binding.root.animate().alpha(0.6f).setDuration(80).withEndAction {
                holder.binding.root.animate().alpha(1f).setDuration(150).start()
            }.start()
            if (mostrarToast) {
                android.widget.Toast.makeText(holder.binding.root.context, "Producte afegit", android.widget.Toast.LENGTH_SHORT).show()
            }
            alClicar(producte)
        }
    }

    override fun getItemCount(): Int = llistaProductes.size
}
