package rubenpla.develop.privtmdbendelesslist

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView
            .OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.popular_movies -> {
                message.setText(R.string.bottom_navigation_popular_movies_tab)
                return@OnNavigationItemSelectedListener true
            }
            R.id.search_movies -> {
                message.setText(R.string.bottom_navigation_search_movies_tab)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
