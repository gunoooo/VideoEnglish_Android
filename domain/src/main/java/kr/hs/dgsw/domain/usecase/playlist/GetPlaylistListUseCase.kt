package kr.hs.dgsw.domain.usecase.playlist

import kr.hs.dgsw.domain.base.ParamsUseCase
import kr.hs.dgsw.domain.model.YoutubeData
import kr.hs.dgsw.domain.repository.PlaylistRepository
import io.reactivex.Single
import javax.inject.Inject

class GetPlaylistListUseCase @Inject constructor(
    private val playlistRepository: PlaylistRepository
) : ParamsUseCase<GetPlaylistListUseCase.Params, Single<List<YoutubeData>>>() {

    override fun buildUseCaseObservable(params: Params): Single<List<YoutubeData>> {
        return playlistRepository.getPlaylistsList(params.id)
    }

    data class Params(val id: String)
}