package dev.dslam.merekeapp.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import dev.dslam.merekeapp.models.*

@Dao
interface MerekeDao {

//    private val newVenueList: MutableLiveData<List<Venue>>
//        get() = MutableLiveData<List<Venue>>()

    fun getNewVenues(): LiveData<List<Venue>> {
        val newVenueList = MutableLiveData<List<Venue>>()

        newVenueList.value =
            listOf(
                Venue(
                    1,
                    "Royal Tulip",
                    "Банкетный зал вместимостью 400 человек",
                    4.5f,
                    "Макатаева 42",
                    listOf(
                        Image("https://cf.bstatic.com/xdata/images/hotel/max1024x768/37841494.jpg?k=4dba455b83c267f00babee749851e06cc836aeb069fc10428855bc5b6a9ba3fa&o=&hp=1"),
                        Image("https://realkz.com/images_resize/main/64759.jpg")
                    ),
                    VenueInformation("Корейская, японская, казахская", "9000–12000 тенге на человека", 120, "13:00–00:00, без выходных"),
                    VenueExtraFeature("Есть", "Есть", "Неохраняемая, бесплатная")
                ),
                Venue(
                    2,
                    "Assem Toikhana",
                    "Банкетный зал вместимостью 200 человек",
                    4.8f,
                    "Толе Би 74",
                    listOf(
                        Image("https://cf.bstatic.com/xdata/images/hotel/max1024x768/37841494.jpg?k=4dba455b83c267f00babee749851e06cc836aeb069fc10428855bc5b6a9ba3fa&o=&hp=1"),
                        Image("https://realkz.com/images_resize/main/64759.jpg")
                    ),
                    VenueInformation("Корейская, японская, казахская", "9000–12000 тенге на человека", 120, "13:00–00:00, без выходных"),
                    VenueExtraFeature("Есть", "Есть", "Неохраняемая, бесплатная")
                ),
                Venue(
                    3,
                    "Assem Toikhana",
                    "Банкетный зал вместимостью 200 человек",
                    4.8f,
                    "Толе Би 74",
                    listOf(
                        Image("https://cf.bstatic.com/xdata/images/hotel/max1024x768/37841494.jpg?k=4dba455b83c267f00babee749851e06cc836aeb069fc10428855bc5b6a9ba3fa&o=&hp=1"),
                        Image("https://realkz.com/images_resize/main/64759.jpg")
                    ),
                    VenueInformation("Корейская, японская, казахская", "9000–12000 тенге на человека", 120, "13:00–00:00, без выходных"),
                    VenueExtraFeature("Есть", "Есть", "Неохраняемая, бесплатная")
                ),
                Venue(
                    4,
                    "Assem Toikhana",
                    "Банкетный зал вместимостью 200 человек",
                    4.8f,
                    "Толе Би 74",
                    listOf(
                        Image("https://cf.bstatic.com/xdata/images/hotel/max1024x768/37841494.jpg?k=4dba455b83c267f00babee749851e06cc836aeb069fc10428855bc5b6a9ba3fa&o=&hp=1"),
                        Image("https://realkz.com/images_resize/main/64759.jpg")
                    ),
                    VenueInformation("Корейская, японская, казахская", "9000–12000 тенге на человека", 120, "13:00–00:00, без выходных"),
                    VenueExtraFeature("Есть", "Есть", "Неохраняемая, бесплатная")
                )
            )
        return newVenueList
    }

    fun getNewSingers(): LiveData<List<Singer>> {
        val newSingerList = MutableLiveData<List<Singer>>()

        newSingerList.value =
            listOf(
                Singer(
                    1,
                    "Кайрат Нуртас",
                    "Народный любимец казахской публики Кайрат Нартас исполняет композиции в жанре поп. Если вам по душе такой стиль, наше агентство готово организовать выступление артиста на вашем празднике. Музыкант поет только на казахском языке и является обладателем премии «Дарын».",
                    4.5f,
                    listOf(Image("https://images.satu.kz/83879044_w640_h640_kajrat-nurtas.jpg"))
                ),
                Singer(
                    2,
                    "Роза Рымбаева",
                    "Опытная певица Роза Рымбаева, которую по праву считают примадонной казахстанского шоу-бизнеса, исполняет композиции в жанре поп. Ее имя увековечено в виде звезд на специальных Площадях как в Караганде, так и в Москве, а также в Витебске. Если вы хотите пригласить исполнительницу на свой праздник, доверьте организацию торжества с ее участием менеджерам нашего агентства!",
                    4.8f,
                    listOf(Image("https://bnmusic.kz/wp-content/uploads/2020/04/Rosa-Rymbaeva.jpg"))
                ),
                Singer(
                    3,
                    "Али Окапов",
                    "Очень профессиональный артист во многих смыслах этого статуса. У Али прекрасная хореография, причем как сольная, так и с танцевальным коллективом. Он не просто отлично смотрится на сцене, он даже в некотором роде придает ей определённый вид! Али замечательно работает с залом, всегда очень тактично и даже скромно поприветствовав публику он знакомит ее с своей следующей композицией и так далее. Али Окапов остается профессионалом на любой площадке, будь то сцена частного мероприятия или большая площадка уличного шоу Али всегда выступает с запоминающейся энергетикой.",
                    4.8f,
                    listOf(Image("https://baigenews.kz/upload/iblock/0fe/Ali-Okapov-ne-soglasilsya-s-mneniem-materi-ob-Imanbeke-_-BaigeNews.kz.jpg"))
                )
            )
        return newSingerList
    }
}
