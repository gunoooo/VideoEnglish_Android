package kr.hs.dgsw.data.util

import android.os.Environment

object Constants {
    val DIRECTORY_RECORD = Environment.getExternalStorageDirectory().toString() + "/VideoEnglish"

    const val DEFAULT_HOST = "https://www.googleapis.com/youtube/v3/"
    const val TEST_HOST = "http://10.80.161.201:8080/"

    const val TIME_OUT_MESSAGE = "시간초과 다시 한번 시도해주세요"
    const val SERVER_ERROR_MESSAGE = "이용에 불편을 드려 대단히 죄송합니다\n추후에 다시 시도해주세요"

    const val ORANGE_CHANNEL_ID = "UCc3pyBqG4oNnUkSKR4JCIUw"
    const val PINE6_CHANNEL_ID = "UClOlvlqQciz887ffJ_hMAhg"
    const val KI_CHANNEL_ID = "UCPzjGcGQeC9BckS6a18sJMg"
    const val SKY_CHANNEL_ID = "UCzVWnWyqIoGA_BcaCNlQLdQ"

    const val HOME_PLAYLIST_ID = "PLXMR4OefiQXqSPc7QVwCf7fzRRWeqgkhw"
}