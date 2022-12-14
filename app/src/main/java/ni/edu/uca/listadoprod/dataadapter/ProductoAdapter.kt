package ni.edu.uca.listadoprod.dataadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ni.edu.uca.listadoprod.dataclass.Producto
import ni.edu.uca.listadoprod.databinding.ItemlistaBinding
import android.view.View

class ProductoAdapter(val listaProd: List<Producto>,
                      val onClickListener:(Producto) -> Unit,
                      val onClickDelete: (Int) -> Unit,
                      val onClickUpdate: (Int) -> Unit
) :
    RecyclerView.Adapter<ProductoAdapter.ProductoHolder>() {
    inner class ProductoHolder(val binding: ItemlistaBinding, val view: View?) : RecyclerView.ViewHolder(binding.root) {
        fun cargar(producto: Producto) {
            with(binding) {
                tvCodProd.text = producto.id.toString()
                tvNombreProd.text = producto.nombre
                tvPrecioProd.text = producto.precio.toString()
                itemView.setOnClickListener{onClickListener(producto)}
                binding.btnDelete.setOnClickListener { onClickDelete(adapterPosition)}
                binding.btnEditar.setOnClickListener { onClickUpdate (adapterPosition) }

            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoHolder {
        val binding = ItemlistaBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ProductoHolder(binding, null)
    }

    override fun onBindViewHolder(holder: ProductoHolder, position: Int) {
        holder.cargar(listaProd[position])

    }

    override fun getItemCount(): Int = listaProd.size

}