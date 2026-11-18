package com.example.recyclerview

import android.app.Activity
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val _arWayang = ArrayList<DcWayang>()

    private var _nama :Array<String> = arrayOf()
    private var _karakter : Array<String> = arrayOf()
    private var _deskripsi : Array<String> = arrayOf()
    private var _gambar : Array<String> = arrayOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        siapkanData()
        tambahData()
        tampilkanData()

        binding.btnToggleLayout.setOnCheckedChangeListener { _, isChecked ->
            tampilkanData()
        }
    }

    private fun siapkanData(){
        _nama = resources.getStringArray(R.array.namaWayang)
        _karakter = resources.getStringArray(R.array.karakterUtamaWayang)
        _deskripsi = resources.getStringArray(R.array.deskripsiWayang)
        _gambar = resources.getStringArray(R.array.gambarWayang)
    }

    private fun tambahData() {
        _arWayang.clear()
        for (i in _nama.indices) {
            val wayang = DcWayang(
                foto = _gambar[i],
                nama = _nama[i],
                karakter = _karakter[i],
                deskripsi = _deskripsi[i]
            )
            _arWayang.add(wayang)
        }
    }

    private fun tampilkanData() {
        if (binding.btnToggleLayout.isChecked) {
            binding.rvWayang.layoutManager = GridLayoutManager(this, 2)
        } else {
            binding.rvWayang.layoutManager = LinearLayoutManager(this)
        }

        binding.rvWayang.adapter = AdapterRecView(_arWayang)
    }
}
