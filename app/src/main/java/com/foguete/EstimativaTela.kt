package com.foguete

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.foguete.databinding.EstimativaTelaBinding
import kotlin.math.sin

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class EstimativaTela : Fragment() {
    private var _binding: EstimativaTelaBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = EstimativaTelaBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.reagirButton.setOnClickListener {
            val inputPressao = binding.editTextNumberpressao.text.toString().toDoubleOrNull()
            val inputPeso = binding.editTextNumberPeso.text.toString().toDoubleOrNull()
            val inputAngulo = binding.editTextNumberAngulo.text.toString().toDoubleOrNull()

            if ( inputPressao == null || inputPeso == null || inputAngulo == null) {
                val calculopressaonull = 100
                val calculopesonull = 150
                val calculoangulonull = 45

                val anguloemradianos = Math.toRadians((calculoangulonull * 2).toDouble())
                val senoseno = sin(anguloemradianos)


                val pascalpressao = calculopressaonull * 6894.757
                val kilospeso = calculopesonull / 1000.0
                val resultado1 = ((((pascalpressao * 0.0005) * 0.3) / kilospeso) * 0.05)
                val resultado2 = ((resultado1 * resultado1) * senoseno) / 9.8
                val resultado3 = String.format("%.2f", resultado2)
                binding.textnumresult.text = resultado3 + "m"

           } else {
                val calculopressaonull = inputPressao
                val calculopesonull = inputPeso
                val calculoangulonull = inputAngulo

                val anguloemradianos = Math.toRadians((calculoangulonull * 2).toDouble())
                val senoseno = sin(anguloemradianos)


                val pascalpressao = calculopressaonull * 6894.757
                val kilospeso = calculopesonull / 1000.0
                val resultado1 = ((((pascalpressao * 0.0005) * 0.3) / kilospeso) * 0.05)
                val resultado2 = ((resultado1 * resultado1) * senoseno) / 9.8
                val resultado3 = String.format("%.2f", resultado2)
                binding.textnumresult.text = resultado3 + "m"
            }

        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}