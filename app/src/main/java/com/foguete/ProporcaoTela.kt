package com.foguete

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.foguete.databinding.ProporcaoTelaBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ProporcaoTela : Fragment() {
    private var _binding: ProporcaoTelaBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = ProporcaoTelaBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.reagirButton.setOnClickListener {
            val inputPsi = binding.editTextNumber.text.toString().toDoubleOrNull()

            if (inputPsi == null) {
                val calculobicarnull = (39.1 * 100) / 100
                val resultadobicarnull = String.format("%.2f", calculobicarnull)
                binding.resultadotextbicar.text = "Bicarbonato: " + resultadobicarnull + "g"
                val calculovinanull = (((27.9 * 100) / 100) * 100) / 4
                val resultadovinanull = String.format("%.2f", calculovinanull)
                binding.resultadotextvinagre.text = "Vinagre: " + resultadovinanull + "mL"

            } else {
                val calculobicar = (39.1 * inputPsi) / 100
                val calculovina = (((27.9 * inputPsi) / 100) * 100) / 4
                val resultadobicar = String.format("%.2f", calculobicar)
                val resultadovina = String.format("%.2f", calculovina)
                binding.resultadotextbicar.text = "Bicarbonato: " + resultadobicar + "g"
                binding.resultadotextvinagre.text = "Vinagre: " + resultadovina + "mL"
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}