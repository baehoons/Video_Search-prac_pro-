package com.example.searchvideo.Model

import com.example.searchvideo.util.ConstantUtils
import java.io.Serializable

@Suppress(ConstantUtils.SuppressWarningAttributes.SPELL_CHECKING_INSPECTION)
data class VideoSearchResponse(
    var meta:Meta,
    var documents:ArrayList<Document>
) {
    data class Meta(
        var total_count:Int,
        var pageable_count:Int,
        var is_end:Boolean
    )
    @Suppress(ConstantUtils.SuppressWarningAttributes.SPELL_CHECKING_INSPECTION)
    data class Document(
        var title:String,
        var url:String,
        var datetime:String,
        var play_time:Int,
        var thumbnail:String,
        var author:String
    ) :Serializable

    @Suppress(ConstantUtils.SuppressWarningAttributes.SPELL_CHECKING_INSPECTION)
    data class KakaoVideoModelList(
        val isEnd : Boolean,
        val pageableCount : Int,
        val totalCount : Int,
        val documents : java.util.ArrayList<Document>
    )

}