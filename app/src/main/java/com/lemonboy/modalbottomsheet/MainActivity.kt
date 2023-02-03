package com.lemonboy.modalbottomsheet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.lemonboy.modalbottomsheet.databinding.ActivityMainBinding
import com.lemonboy.modalbottomsheet.dialog.FullscreenModalBottomSheetDialog
import com.lemonboy.modalbottomsheet.dialog.ModalBottomSheetDialog

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupModalButtons()
    }

    private fun setupModalButtons() {
        binding.apply {
            btnModal.setOnClickListener {
                val modal = ModalBottomSheetDialog()
                supportFragmentManager.let { modal.show(it, ModalBottomSheetDialog.TAG) }
            }

            btnFullscreenModal.setOnClickListener {
                Snackbar.make(it, "Implementing on part 2", Snackbar.LENGTH_LONG).show()
            }
        }
    }
}