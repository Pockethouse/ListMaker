package com.markbowen.listmaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.preference.PreferenceManager
import com.markbowen.listmaker.databinding.MainActivityBinding
import com.markbowen.listmaker.ui.main.MainFragment
import com.markbowen.listmaker.ui.main.MainViewModel




class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this, MainViewModelFactory(PreferenceManager.getDefaultSharedPreferences(this)))[MainViewModel::class.java]

        binding = MainActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        Log.i("MainActivity", viewModel.toString())

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
        binding.fabButton.setOnClickListener { showCreateListDialog() }

    }
    //New method for alert dialog to get the name of list
    //retrieved strings from xml

    private fun showCreateListDialog() {
        // 1
        val dialogTitle = getString(R.string.name_of_list)
        val positiveButtonTitle = getString(R.string.create_list)
        // 2
        val builder = AlertDialog.Builder(this)
        val listTitleEditText = EditText(this)
        listTitleEditText.inputType = InputType.TYPE_CLASS_TEXT
        builder.setTitle(dialogTitle)
        builder.setView(listTitleEditText)
        // 3
        builder.setPositiveButton(positiveButtonTitle) { dialog, _ ->
            dialog.dismiss()

        }
        // 4
        builder.create().show()
    }
}