package adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.daviddam.projectecafeteriadavidgelmacorral2ndam.R
import entity.ComandaEntity

class ComandaAdapter(
    private val llistaComandes: List<ComandaEntity>,
    private val onEliminar: (ComandaEntity) -> Unit,
    private val onEditar: (ComandaEntity) -> Unit
) : RecyclerView.Adapter<ComandaAdapter.ComandaViewHolder>() {

    inner class ComandaViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val tvUsuari: TextView = v.findViewById(R.id.tvComandaUsuari)
        val tvData: TextView = v.findViewById(R.id.tvComandaData)
        val tvTotal: TextView = v.findViewById(R.id.tvComandaTotal)
        val btnEditar: android.widget.ImageButton = v.findViewById(R.id.btnEditarComanda)
        val btnEliminar: android.widget.ImageButton = v.findViewById(R.id.btnEliminarComanda)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComandaViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_comanda, parent, false)
        return ComandaViewHolder(v)
    }

    override fun onBindViewHolder(holder: ComandaViewHolder, position: Int) {
        val comanda = llistaComandes[position]
        holder.tvUsuari.text = comanda.usuari
        holder.tvData.text = java.text.DateFormat.getDateTimeInstance().format(java.util.Date(comanda.timestamp))
        holder.tvTotal.text = String.format("%.2f €", comanda.total)
        holder.btnEliminar.setOnClickListener { onEliminar(comanda) }
        holder.btnEditar.setOnClickListener { onEditar(comanda) }
        holder.itemView.setOnLongClickListener {
            onEliminar(comanda)
            true
        }
    }

    override fun getItemCount(): Int = llistaComandes.size
}