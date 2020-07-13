package kr.hs.dgsw.domain.usecase.playlist

import io.reactivex.Single
import kr.hs.dgsw.domain.base.BaseUseCase
import kr.hs.dgsw.domain.model.YoutubeData
import kr.hs.dgsw.domain.repository.PlaylistRepository
import javax.inject.Inject

class GetDefaultPlaylistListUseCase @Inject constructor(
    private val playlistRepository: PlaylistRepository
) : BaseUseCase<Single<List<YoutubeData>>>() {

    override fun buildUseCaseObservable(): Single<List<YoutubeData>> {
        return playlistRepository.getDefaultPlaylistsList()
    }
}