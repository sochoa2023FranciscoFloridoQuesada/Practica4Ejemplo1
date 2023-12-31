package net.iesochoa.pacofloridoquesada.practica4ejemplo1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import net.iesochoa.pacofloridoquesada.practica4ejemplo1.databinding.FragmentSaludoBinding

class SaludoFragment : Fragment() {
    private var _binding: FragmentSaludoBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    val args:SaludoFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        _binding = FragmentSaludoBinding.inflate(inflater, container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        // Busco el nombre en los argumentos recibidos y lo asigno al TextView
        binding.tvSaludo.text= getString(R.string.saludo, args.nombre)

        // Creo la accion del boton btCambiaNombre
        binding.btCambiaNombre.setOnClickListener{
            // Pasamos el nombre como argumento a CambiaNombreFragment
            val action = SaludoFragmentDirections.actionSaludoFragmentToCambiaNombreFragment(args.nombre)
            // Ejecutamos la acción
            findNavController().navigate(action)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}