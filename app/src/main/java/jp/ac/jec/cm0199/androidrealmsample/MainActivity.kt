package jp.ac.jec.cm0199.androidrealmsample

import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import io.realm.kotlin.RealmConfiguration

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val config = RealmConfiguration.Builder(schema = setOf(Item::class))
//            .schemaVersion(1)
//            .build()

        findViewById<Button>(R.id.btn_create).setOnClickListener { viewModel.addItem() }
        findViewById<Button>(R.id.btn_read).setOnClickListener { viewModel.query()}
    }
    companion object {
        private const val TAG = "MainActivity"
    }
}