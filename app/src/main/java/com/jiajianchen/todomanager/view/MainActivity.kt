package com.jiajianchen.todomanager.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.jiajianchen.todomanager.R
import com.jiajianchen.todomanager.viewmodel.MatterViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var matterViewModel: MatterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewModel()
    }

    private fun initViewModel() {
        matterViewModel = ViewModelProviders.of(this).get(MatterViewModel::class.java)
        // viewModel data to UI

    }
}
