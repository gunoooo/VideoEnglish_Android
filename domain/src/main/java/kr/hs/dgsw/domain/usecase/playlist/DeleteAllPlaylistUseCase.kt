package kr.hs.dgsw.domain.usecase.playlist

import kr.hs.dgsw.domain.base.BaseUseCase
import kr.hs.dgsw.domain.repository.PlaylistRepository
import io.reactivex.Completable
import javax.inject.Inject

class DeleteAllPlaylistUseCase @Inject constructor(
    private val playlistRepository: PlaylistRepository
) : BaseUseCase<Completable>() {

    override fun buildUseCaseObservable(): Completable {
        return playlistRepository.deleteAllPlaylist()
    }
}