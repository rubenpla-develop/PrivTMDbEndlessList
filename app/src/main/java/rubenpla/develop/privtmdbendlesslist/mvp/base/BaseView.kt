package rubenpla.develop.privtmdbendlesslist.mvp.base

/**
 * Created by alten on 13/2/18.
 */
interface BaseView<in T> {
    fun setPresenter(presenter : T)
    fun showMessage(message : String)
}