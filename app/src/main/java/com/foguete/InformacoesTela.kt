package com.foguete

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.foguete.databinding.InformacoesTelaBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class InformacoesTela : Fragment() {
    private var _binding: InformacoesTelaBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = InformacoesTelaBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.reagirButton.setOnClickListener {
//            findNavController().navigate(R.id.action_Estimativa_to_FirstFragment)
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}