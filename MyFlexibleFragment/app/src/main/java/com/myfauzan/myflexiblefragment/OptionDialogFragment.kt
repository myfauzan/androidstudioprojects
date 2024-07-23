package com.myfauzan.myflexiblefragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.DialogFragment

class OptionDialogFragment : DialogFragment() {

    private lateinit var btnChoose: Button
    private lateinit var btnClose: Button
    private lateinit var rgOptions: RadioGroup
    private lateinit var rbSirAlexFerguson: RadioButton
    private lateinit var rbJoseMorinho: RadioButton
    private lateinit var rbLouisVanGaal: RadioButton
    private lateinit var rbDavidMoyes: RadioButton
    private var optionDialogListener: OnOptionDialogListener? = null



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnChoose = view.findViewById(R.id.btn_choose)
        btnClose = view.findViewById(R.id.btn_close)
        rgOptions = view.findViewById(R.id.rg_options)
        rbSirAlexFerguson = view.findViewById(R.id.rb_sir_alex_ferguson)
        rbJoseMorinho = view.findViewById(R.id.rb_jose_mourinho)
        rbLouisVanGaal = view.findViewById(R.id.rb_louis_van_gaal)
        rbDavidMoyes = view.findViewById(R.id.rb_david_moyes)

        btnChoose.setOnClickListener{
            val checkedRadioButtonId = rgOptions.checkedRadioButtonId
            if (checkedRadioButtonId != -1){
                var coach: String? = when (checkedRadioButtonId){
                    R.id.rb_sir_alex_ferguson -> rbSirAlexFerguson.text.toString().trim()
                    R.id.rb_jose_mourinho -> rbJoseMorinho.text.toString().trim()
                    R.id.rb_louis_van_gaal -> rbLouisVanGaal.text.toString().trim()
                    R.id.rb_david_moyes -> rbDavidMoyes.text.toString().trim()
                    else -> null
                }
                optionDialogListener?.onOptionChosen(coach)
                dialog?.dismiss()
            }
        }
        btnClose.setOnClickListener{
            dialog?.cancel()
        }
    }

    interface OnOptionDialogListener {
        fun onOptionChosen(text: String?)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_option_dialog, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val fragment = parentFragment

        if (fragment is DetailCategoryFragment){
            this.optionDialogListener = fragment.optionDialogListener
        }
    }

    override fun onDetach() {
        super.onDetach()
        this.optionDialogListener = null
    }
}