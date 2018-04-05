package rubenpla.develop.privtmdbendlesslist.mvp.base

interface BaseView<in T> {
    fun setPresenter(presenter : T)
    fun showMessage(message : String)
}