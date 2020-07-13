package kr.hs.dgsw.videoenglish_android.ui.favorites

import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kr.hs.dgsw.videoenglish_android.R
import kr.hs.dgsw.videoenglish_android.base.dialog.BaseDialog
import kr.hs.dgsw.videoenglish_android.databinding.DialogFavoritesAddBinding
import kr.hs.dgsw.videoenglish_android.widget.SingleLiveEvent
import javax.inject.Inject

class FavoritesAddDialog : BaseDialog<DialogFavoritesAddBinding, FavoritesAddViewModel>() {

    @Inject
    lateinit var viewModelFactory: FavoritesAddViewModelFactory

    override val viewModel: FavoritesAddViewModel
        get() = ViewModelProvider(this, viewModelFactory)[FavoritesAddViewModel::class.java]

    val onSuccessInsertEvent = SingleLiveEvent<Unit>()

    override fun observerViewModel() {
        with(mViewModel) {
            onSuccessInsertEvent.observe(this@FavoritesAddDialog, Observer {
                this@FavoritesAddDialog.onSuccessInsertEvent.call()
                dismiss()
            })

            onEmptyEvent.observe(this@FavoritesAddDialog, Observer {
                Toast.makeText(context, R.string.error_empty, Toast.LENGTH_SHORT).show()
            })

            onBackEvent.observe(this@FavoritesAddDialog, Observer {
                dismiss()
            })
        }
    }
}