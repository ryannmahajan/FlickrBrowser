package com.example.photogallery

import com.example.photogallery.api.detail_screen.FlickrDetailResponse
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun flickr_photo_detail_isParsedCorrectly() {
        val json = "{ \"sizes\": { \"canblog\": 0, \"canprint\": 0, \"candownload\": 1, \n" +
                "    \"size\": [\n" +
                "      { \"label\": \"Square\", \"width\": 75, \"height\": 75, \"source\": \"https:\\/\\/live.staticflickr.com\\/65535\\/52626927212_9b9b4507ec_s.jpg\", \"url\": \"https:\\/\\/www.flickr.com\\/photos\\/185738890@N04\\/52626927212\\/sizes\\/sq\\/\", \"media\": \"photo\" },\n" +
                "      { \"label\": \"Large Square\", \"width\": \"150\", \"height\": \"150\", \"source\": \"https:\\/\\/live.staticflickr.com\\/65535\\/52626927212_9b9b4507ec_q.jpg\", \"url\": \"https:\\/\\/www.flickr.com\\/photos\\/185738890@N04\\/52626927212\\/sizes\\/q\\/\", \"media\": \"photo\" },\n" +
                "      { \"label\": \"Thumbnail\", \"width\": 100, \"height\": 67, \"source\": \"https:\\/\\/live.staticflickr.com\\/65535\\/52626927212_9b9b4507ec_t.jpg\", \"url\": \"https:\\/\\/www.flickr.com\\/photos\\/185738890@N04\\/52626927212\\/sizes\\/t\\/\", \"media\": \"photo\" },\n" +
                "      { \"label\": \"Small\", \"width\": \"240\", \"height\": \"161\", \"source\": \"https:\\/\\/live.staticflickr.com\\/65535\\/52626927212_9b9b4507ec_m.jpg\", \"url\": \"https:\\/\\/www.flickr.com\\/photos\\/185738890@N04\\/52626927212\\/sizes\\/s\\/\", \"media\": \"photo\" },\n" +
                "      { \"label\": \"Small 320\", \"width\": \"320\", \"height\": \"215\", \"source\": \"https:\\/\\/live.staticflickr.com\\/65535\\/52626927212_9b9b4507ec_n.jpg\", \"url\": \"https:\\/\\/www.flickr.com\\/photos\\/185738890@N04\\/52626927212\\/sizes\\/n\\/\", \"media\": \"photo\" },\n" +
                "      { \"label\": \"Small 400\", \"width\": \"400\", \"height\": \"269\", \"source\": \"https:\\/\\/live.staticflickr.com\\/65535\\/52626927212_9b9b4507ec_w.jpg\", \"url\": \"https:\\/\\/www.flickr.com\\/photos\\/185738890@N04\\/52626927212\\/sizes\\/w\\/\", \"media\": \"photo\" },\n" +
                "      { \"label\": \"Medium\", \"width\": \"500\", \"height\": \"336\", \"source\": \"https:\\/\\/live.staticflickr.com\\/65535\\/52626927212_9b9b4507ec.jpg\", \"url\": \"https:\\/\\/www.flickr.com\\/photos\\/185738890@N04\\/52626927212\\/sizes\\/m\\/\", \"media\": \"photo\" },\n" +
                "      { \"label\": \"Medium 640\", \"width\": \"640\", \"height\": \"430\", \"source\": \"https:\\/\\/live.staticflickr.com\\/65535\\/52626927212_9b9b4507ec_z.jpg\", \"url\": \"https:\\/\\/www.flickr.com\\/photos\\/185738890@N04\\/52626927212\\/sizes\\/z\\/\", \"media\": \"photo\" },\n" +
                "      { \"label\": \"Medium 800\", \"width\": \"800\", \"height\": \"537\", \"source\": \"https:\\/\\/live.staticflickr.com\\/65535\\/52626927212_9b9b4507ec_c.jpg\", \"url\": \"https:\\/\\/www.flickr.com\\/photos\\/185738890@N04\\/52626927212\\/sizes\\/c\\/\", \"media\": \"photo\" },\n" +
                "      { \"label\": \"Large\", \"width\": \"1024\", \"height\": \"687\", \"source\": \"https:\\/\\/live.staticflickr.com\\/65535\\/52626927212_9b9b4507ec_b.jpg\", \"url\": \"https:\\/\\/www.flickr.com\\/photos\\/185738890@N04\\/52626927212\\/sizes\\/l\\/\", \"media\": \"photo\" },\n" +
                "      { \"label\": \"Large 1600\", \"width\": \"1600\", \"height\": \"1074\", \"source\": \"https:\\/\\/live.staticflickr.com\\/65535\\/52626927212_8bf6dfbff9_h.jpg\", \"url\": \"https:\\/\\/www.flickr.com\\/photos\\/185738890@N04\\/52626927212\\/sizes\\/h\\/\", \"media\": \"photo\" },\n" +
                "      { \"label\": \"Large 2048\", \"width\": \"2048\", \"height\": \"1375\", \"source\": \"https:\\/\\/live.staticflickr.com\\/65535\\/52626927212_a8f02bb74c_k.jpg\", \"url\": \"https:\\/\\/www.flickr.com\\/photos\\/185738890@N04\\/52626927212\\/sizes\\/k\\/\", \"media\": \"photo\" },\n" +
                "      { \"label\": \"X-Large 3K\", \"width\": \"2896\", \"height\": \"1944\", \"source\": \"https:\\/\\/live.staticflickr.com\\/65535\\/52626927212_c2844eaa70_3k.jpg\", \"url\": \"https:\\/\\/www.flickr.com\\/photos\\/185738890@N04\\/52626927212\\/sizes\\/3k\\/\", \"media\": \"photo\" },\n" +
                "      { \"label\": \"Original\", \"width\": \"2896\", \"height\": \"1944\", \"source\": \"https:\\/\\/live.staticflickr.com\\/65535\\/52626927212_d69e5bf5b9_o.jpg\", \"url\": \"https:\\/\\/www.flickr.com\\/photos\\/185738890@N04\\/52626927212\\/sizes\\/o\\/\", \"media\": \"photo\" }\n" +
                "    ] }, \"stat\": \"ok\" }"

        val moshi = Moshi.Builder().build()
        val jsonAdapter: JsonAdapter<FlickrDetailResponse> = moshi.adapter(FlickrDetailResponse::class.java)

        val photoDetails = jsonAdapter.fromJson(json)
        println(photoDetails)

        assert(photoDetails!!.sizes.size.let { list ->
            list.any { (it.label == "Square" ) && (it.height==75)} }
            )
    }

    @Test
    fun flickr_photo_is_retrieved_correctly () {
        assert (runBlocking {
            PhotoRepository().getSizes("52626927212").any {
                (it.label == "Square" ) && (it.height==75)
            }
        })
    }
}