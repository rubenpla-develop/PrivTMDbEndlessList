package rubenpla.develop.privtmdbendlesslist.ui.activity

import android.os.Bundle
import android.support.design.widget.BottomNavigationView.OnNavigationItemSelectedListener
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import rubenpla.develop.privtmdbendlesslist.R
import rubenpla.develop.privtmdbendlesslist.ui.fragment.PopularMoviesFragment
import rubenpla.develop.privtmdbendlesslist.ui.fragment.SearchMovieFragment

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = OnNavigationItemSelectedListener { item ->
                        when (item.itemId) {
                            R.id.popular_movies -> {
                                setFragment(PopularMoviesFragment())
                                return@OnNavigationItemSelectedListener true
                            }
                            R.id.search_movies -> {
                                setFragment(SearchMovieFragment())
                                return@OnNavigationItemSelectedListener true
                            }
                        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setFragment(PopularMoviesFragment())
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_activity_container, fragment)
                .commit()
    }
}
