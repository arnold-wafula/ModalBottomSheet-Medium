package com.lemonboy.modalbottomsheet.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.lemonboy.modalbottomsheet.databinding.ItemBottomsheetFullscreenBinding

class FullscreenModalBottomSheetDialog : BottomSheetDialogFragment() {
    private lateinit var binding : ItemBottomsheetFullscreenBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = ItemBottomsheetFullscreenBinding.inflate(inflater, container, false)

        val toolbar = binding.toolbar
        toolbar.setNavigationOnClickListener {
            dismiss()
        }

        return binding.root
    }

    /*override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        //dialog?.setOnShowListener {}

        return super.onCreateDialog(savedInstanceState)
    }*/

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bottomSheet : FrameLayout = dialog?.findViewById(com.google.android.material.R.id.design_bottom_sheet)!!

        // Height of the view
        bottomSheet.layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT

        // Behavior of the bottom sheet
        val behavior = BottomSheetBehavior.from(bottomSheet)
        behavior.apply {
            peekHeight = resources.displayMetrics.heightPixels // Pop-up height
            state = BottomSheetBehavior.STATE_EXPANDED // Expanded state

            addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
                override fun onStateChanged(bottomSheet: View, newState: Int) {
                }

                override fun onSlide(bottomSheet: View, slideOffset: Float) {}
            })
        }
    }
}