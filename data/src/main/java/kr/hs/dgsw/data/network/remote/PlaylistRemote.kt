package kr.hs.dgsw.data.network.remote

import kr.hs.dgsw.data.base.BaseRemote
import kr.hs.dgsw.data.network.service.PlaylistService
import io.reactivex.Single
import kr.hs.dgsw.domain.model.PlaylistItem

class PlaylistRemote(override val service: PlaylistService) : BaseRemote<PlaylistService>() {

    fun getPlaylistsList(id: String): Single<List<PlaylistItem>> =
        service.getPlaylistsList(id).map(getResponse())
}