package com.example.photogallery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuItemCompat
import com.example.photogallery.ui.DetailScreen
import com.example.photogallery.ui.GalleryScreen
import com.example.photogallery.ui.NavHost

class MainActivity : AppCompatActivity() {
    private val viewModel:PhotoGalleryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavHost()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)

        val searchViewItem = menu.findItem(R.id.search_bar)
        val searchView = MenuItemCompat.getActionView(searchViewItem) as SearchView

        searchView.setQuery(viewModel.searchQuery.value, false)
        //todo: add viewModel storing the focused and collapsed info as well

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.submitQuery(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })
        return super.onCreateOptionsMenu(menu)
    }


}