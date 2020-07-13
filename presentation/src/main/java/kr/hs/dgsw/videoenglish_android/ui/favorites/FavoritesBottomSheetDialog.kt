package kr.hs.dgsw.videoenglish_android.ui.favorites

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kr.hs.dgsw.domain.model.YoutubeData
import kr.hs.dgsw.videoenglish_android.base.dialog.BaseBottomSheetDialog
import kr.hs.dgsw.videoenglish_android.databinding.DialogFavoritesBottomSheetBinding
import javax.inject.Inject

class FavoritesBottomSheetDialog(private val youtubeData: YoutubeData) : BaseBottomSheetDialog<DialogFavoritesBottomSheetBinding, FavoritesBottomSheetViewModel>() {

    @Inject
    lateinit var viewModelFactory: FavoritesBottomSheetViewModelFactory

    override val viewModel: FavoritesBottomSheetViewModel
        get() = ViewModelProvider(this, viewModelFactory)[FavoritesBottomSheetViewModel::class.java]

    override fun observerViewModel() {
        with(mViewModel) {
            with(favoritesCheckListAdapter) {
                onCheckFavoritesEvent.observe(this@FavoritesBottomSheetDialog, Observer {
                    insertFavoritesItem(it.id!!)
                })

                onUncheckFavoritesEvent.observe(this@FavoritesBottomSheetDialog, Observer {
                    deleteFavoritesItem(it.id!!)
                })
            }

            onOpenFavoritesAddViewEvent.observe(this@FavoritesBottomSheetDialog, Observer {
                val favoritesAddDialog = FavoritesAddDialog()
                favoritesAddDialog.show(requireFragmentManager())
                favoritesAddDialog.onSuccessInsertEvent.observe(this@FavoritesBottomSheetDialog, Observer {
                    setFavoritesList()
                })
            })

            onCloseEvent.observe(this@FavoritesBottomSheetDialog, Observer {
                dismiss()
            })
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel.youtubeData = youtubeData
        mViewModel.setFavoritesList()
    }
}