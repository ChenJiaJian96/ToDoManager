package com.jiajianchen.todomanager.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.jiajianchen.todomanager.R
import com.jiajianchen.todomanager.viewmodel.MatterViewModel

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var matterViewModel: MatterViewModel

    private lateinit var addMatterBtn: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        initView()

        initViewModel()


    }

    private fun initViewModel() {
        matterViewModel = ViewModelProviders.of(this).get(MatterViewModel::class.java)
        // viewModel data to UI
    }

    private fun initView() {
        addMatterBtn = findViewById(R.id.add_matter_btn)
        addMatterBtn.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.add_matter_btn -> {
                val intent = Intent(this, NewMatterActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
