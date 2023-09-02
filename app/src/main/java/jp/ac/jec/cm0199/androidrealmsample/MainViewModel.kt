package jp.ac.jec.cm0199.androidrealmsample

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.query.RealmResults
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default
) : ViewModel() {
    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Log.e("TAG", "error!!", throwable)
    }

    fun addItem() {
        viewModelScope.launch(dispatcher + coroutineExceptionHandler) {
            val config = RealmConfiguration.create(schema = setOf(Item::class))
            val realm: Realm = Realm.open(config)
            realm.write {
                copyToRealm(Item().apply {
                    summary = "Do the laundry"
                    isComplete = false
                })
            }
            realm.close()
        }
    }

    fun query() {
        viewModelScope.launch(dispatcher + coroutineExceptionHandler) {
            val config = RealmConfiguration.create(schema = setOf(Item::class))
            val realm: Realm = Realm.open(config)
            val items: RealmResults<Item> = realm.query(Item::class).find()
            items.forEach { Log.d(TAG, "item: $it") }
            realm.close()
        }
    }

    companion object {
        private const val TAG = "realmDemo"
    }
}