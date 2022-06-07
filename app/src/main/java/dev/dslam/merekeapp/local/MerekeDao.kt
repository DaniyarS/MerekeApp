package dev.dslam.merekeapp.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import dev.dslam.merekeapp.models.*

@Dao
interface MerekeDao {

//    private val newVenueList: MutableLiveData<List<Venue>>
//        get() = MutableLiveData<List<Venue>>()

//    @Query("SELECT * FROM persons")
//    fun getAllPerson(): LiveData<List<Person>>
//
//    @Query("SELECT * FROM venues")
//    fun getAllVenues(): LiveData<List<Venue>>

//    @Query("SELECT * FROM persons WHERE categoryId =:categoryId")
//    fun getPersonByCategory(categoryId: String): LiveData<List<Person>>
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun addPersonList(personList: List<Person>)
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun addVenues(venues: List<Venue>)

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
                    VenueInformation(
                        "Корейская, японская, казахская",
                        "9000–12000 тенге на человека",
                        120,
                        "13:00–00:00, без выходных"
                    ),
                    VenueExtraFeature("Есть", "Есть", "Неохраняемая, бесплатная")
                ),
                Venue(
                    2,
                    "Assem Toikhana",
                    "Банкетный зал вместимостью 200 человек",
                    4.8f,
                    "Толе Би 74",
                    listOf(
                        Image("https://strg1.restoran.kz/neofiles/serve-image/60ab817e16e6d9000665c72a/1280x720/c1/q70"),
                        Image("https://realkz.com/images_resize/main/64759.jpg")
                    ),
                    VenueInformation(
                        "Корейская, японская, казахская",
                        "9000–12000 тенге на человека",
                        120,
                        "13:00–00:00, без выходных"
                    ),
                    VenueExtraFeature("Есть", "Есть", "Неохраняемая, бесплатная")
                ),
                Venue(
                    3,
                    "Khan Sarai",
                    "Банкетный зал вместимостью 200 человек",
                    4.8f,
                    "Толе Би 74",
                    listOf(
                        Image("https://strg2.restoran.kz/neofiles/serve-image/5c7cfcb7d062917b98186d70/720x405/c1/q40"),
                        Image("https://realkz.com/images_resize/main/64759.jpg")
                    ),
                    VenueInformation(
                        "Корейская, японская, казахская",
                        "9000–12000 тенге на человека",
                        120,
                        "13:00–00:00, без выходных"
                    ),
                    VenueExtraFeature("Есть", "Есть", "Неохраняемая, бесплатная")
                ),
                Venue(
                    4,
                    "Bekbol Toikhana",
                    "Банкетный зал вместимостью 200 человек",
                    4.8f,
                    "Толе Би 74",
                    listOf(
                        Image("https://cf.bstatic.com/xdata/images/hotel/max1024x768/37841494.jpg?k=4dba455b83c267f00babee749851e06cc836aeb069fc10428855bc5b6a9ba3fa&o=&hp=1"),
                        Image("https://realkz.com/images_resize/main/64759.jpg")
                    ),
                    VenueInformation(
                        "Корейская, японская, казахская",
                        "9000–12000 тенге на человека",
                        120,
                        "13:00–00:00, без выходных"
                    ),
                    VenueExtraFeature("Есть", "Есть", "Неохраняемая, бесплатная")
                )
            )
        return newVenueList
    }

    fun getAllVenues(): LiveData<List<Venue>> {
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
                    VenueInformation(
                        "Корейская, японская, казахская",
                        "9000–12000 тенге на человека",
                        120,
                        "13:00–00:00, без выходных"
                    ),
                    VenueExtraFeature("Есть", "Есть", "Неохраняемая, бесплатная")
                ),
                Venue(
                    2,
                    "Assem Toikhana",
                    "Банкетный зал вместимостью 200 человек",
                    4.8f,
                    "Толе Би 74",
                    listOf(
                        Image("https://strg1.restoran.kz/neofiles/serve-image/60af7e2016e6d9000665c95f/1280x720/c1/q70"),
                        Image("https://realkz.com/images_resize/main/64759.jpg")
                    ),
                    VenueInformation(
                        "Корейская, японская, казахская",
                        "9000–12000 тенге на человека",
                        120,
                        "13:00–00:00, без выходных"
                    ),
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
                    VenueInformation(
                        "Корейская, японская, казахская",
                        "9000–12000 тенге на человека",
                        120,
                        "13:00–00:00, без выходных"
                    ),
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
                    VenueInformation(
                        "Корейская, японская, казахская",
                        "9000–12000 тенге на человека",
                        120,
                        "13:00–00:00, без выходных"
                    ),
                    VenueExtraFeature("Есть", "Есть", "Неохраняемая, бесплатная")
                ),
                Venue(
                    5,
                    "Дом Приемов на Мира",
                    "Банкетный зал вместимостью 200 человек",
                    4.8f,
                    "пр. Желтоксан, 167",
                    listOf(
                        Image("https://strg1.restoran.kz/neofiles/serve-image/60af7e2416e6d9000665c969/1280x720/c1/q70"),
                        Image("https://realkz.com/images_resize/main/64759.jpg")
                    ),
                    VenueInformation(
                        "Корейская, японская, казахская",
                        "9000–12000 тенге на человека",
                        120,
                        "13:00–00:00, без выходных"
                    ),
                    VenueExtraFeature("Есть", "Есть", "Неохраняемая, бесплатная")
                ),
                Venue(
                    6,
                    "Мирас — Жасминовый зал",
                    "Банкетный зал вместимостью 200 человек",
                    4.8f,
                    "пр. Аль-Фараби, 216",
                    listOf(
                        Image("https://strg2.restoran.kz/neofiles/serve-image/5a9f683fd06291017ac0e37b/720x405/c1/q40"),
                        Image("https://realkz.com/images_resize/main/64759.jpg")
                    ),
                    VenueInformation(
                        "Корейская, японская, казахская",
                        "9000–12000 тенге на человека",
                        120,
                        "13:00–00:00, без выходных"
                    ),
                    VenueExtraFeature("Есть", "Есть", "Неохраняемая, бесплатная")
                )
            )
        return newVenueList
    }

    fun getAllDancers(): LiveData<List<Dancers>> {
        val allDancersList = MutableLiveData<List<Dancers>>()

        allDancersList.value =
            listOf(
                Dancers(
                    0,
                    "Shine - Шоу-Балет",
                    "Шоу балет «SHINE» - это танцевальный коллектив, который может подарить бурю восторга на вашем праздничном мероприятии, ведь репертуар коллектива разнообразен.\n" +
                            "Шоу-балет «SHINE» предлагает разнообразную танцевальную программу для любого праздничного события.\n" +
                            "Бразилия, Казахский, Русский, Латина, таинственный Восток - все это создаст неповторимую атмосферу торжества.\n" +
                            "Яркие костюмы, запоминающаяся музыка и очаровательные танцоры сделают Ваш праздник веселым и незабываемым.",
                    4.5f,
                    listOf(
                        Image("https://art-dance.kz/up/dancers/img/almaty/shine_almaty.png")
                    ),
                ),
                Dancers(
                    1,
                    "Eurasia - Школа танца Ксении Пахомовой",
                    "Эстрадные танцы, Спортивные бальные танцы, Народные танцы, Танцы для детей, Черлидинг. Zumbatomic®, Hip-hop, Восточные танцы, Zumba, Jazz-funk, High heels, Go-Go, Модерн, Аэробика, Стрип-пластика.\n" +
                            "Участие на Республиканских и Международных конкурсах по хореографии, выступление на городских и областных мероприятиях.\n" +
                            "Организовываем выступление.\n" +
                            "Украсьте Ваш праздник яркими и запоминающимися танцами!",
                    4.5f,
                    listOf(
                        Image("https://art-dance.kz/up/dancers/img/almaty/sb_pahomovoi.gif")
                    )
                ),
                Dancers(
                    2,
                    "Vivat - Шоу-балет",
                    "Участие:\n" +
                            "- в крупных концертах во многих городах Казахстана;\n" +
                            "- в фестивалях, в презентациях и юбилеях крупных компаний;\n" +
                            "- подтанцовка для звёзд казахстанской и зарубежной эстрады.\n" +
                            "\n" +
                            "Массовость, техничность, универсальность, эмоциональное исполнение - это стиль Vivat!",
                    4.5f,
                    listOf(
                        Image("https://art-dance.kz/up/dancers/img/almaty/ds_vivat.jpg")
                    )
                ),
                Dancers(
                    3,
                    "BLOCKBUSTER - шоу-балет Константина Дихнова",
                    "В репертуаре шоу-балета - танцы разных стилей и направлений хореографии - от стилизации испанских, кавказских и до хореографических постановок на основе джаз-модерн танца.\n" +
                            "В нашей биографии - участие в десятках разнообразнейших шоу-проектах, а также работа с известными исполнителями современной казахстанской эстрады.\n" +
                            "У нас есть свой неповторимый стиль, свое оригинальное творческое лицо.",
                    4.5f,
                    listOf(
                        Image("https://art-dance.kz/up/dancers/img/almaty/blockbuster.jpg")
                    )
                ),
                Dancers(
                    4,
                    "Di-Lali - Ансамбль народного танца",
                    "Участники многих Фестивалей-конкурсов.\n" +
                            "В репертуаре различные народные танцы: казахские, испанские, цыганские, армянские, грузинские, чеченские и многие другие танцы народов мира!",
                    4.5f,
                    listOf(
                        Image("https://art-dance.kz/up/dancers/img/almaty/di_lali.png")
                    )
                ),
                Dancers(
                    5,
                    "ARAKS - Ансамбль народного танца",
                    "Ансамбль народного танца \"ARAKS\" при Республиканской Ассоциации Армян Казахстана \"Масис\", под руководством талантливого и высококвалифицированного хореографа со стажем работы более 20-ти лет, Оганнисяна Артура Размиковича",
                    4.5f,
                    listOf(
                        Image("https://strg1.restoran.kz/neofiles/serve-image/60af7e2416e6d9000665c969/1280x720/c1/q70")
                    )
                )
            )
        return allDancersList
    }

    fun getAllMusicians(): LiveData<List<Musicians>> {
        val allMusiciansList = MutableLiveData<List<Musicians>>()

        allMusiciansList.value =
            listOf(
                Musicians(
                    0,
                    "Phoenix Live Band",
                    "Победители «Wedding Awards 2018» в номинации «Лучший Cover Band 2018»\n" +
                            "Phoenix – это буйное сочетание стиля и харизмы в одном флаконе, по-настоящему пьянящий коктейль из драйва, позитива и взрывного репертуара, который всегда сведет с ума окружающих! ",
                    4.5f,
                    listOf(
                        Image("https://strg2.restoran.kz/neofiles/serve-image/619391c185d534421934ade8/1280x720/c1/q70")
                    )
                ),
                Musicians(
                    1,
                    "MAGICAL",
                    "Участие на Республиканских и Международных конкурсах по хореографии, выступление на городских и областных мероприятиях.\n" +
                            "Организовываем выступление.\n" +
                            "Украсьте Ваш праздник яркими и запоминающимися танцами!",
                    4.5f,
                    listOf(
                        Image("https://strg2.restoran.kz/neofiles/serve-image/56ab2939579f2403260000c5/1280x720/c1/q70")
                    )
                ),
                Musicians(
                    2,
                    "Action музыкальная группа",
                    "Команда просто супер!!! Несколько раз работали с ними. Всегда вызывают лишь море позитива. Обладают необыкновенной харизмой. Зажигали разновозрастную аудиторию. Танцевали все, от юношей до людей солидного возраста. Ребята, спасибо вам за творчество и всегда качественную музыку!!!",
                    4.5f,
                    listOf(
                        Image("https://strg2.restoran.kz/neofiles/serve-image/56ab26ff579f245fb50001c8/1280x720/c1/q70")
                    )
                ),
                Musicians(
                    3,
                    "Кавер группа Glance Live Band",
                    "В репертуаре шоу-балета - танцы разных стилей и направлений хореографии - от стилизации испанских, кавказских и до хореографических постановок на основе джаз-модерн танца.\n" +
                            "В нашей биографии - участие в десятках разнообразнейших шоу-проектах, а также работа с известными исполнителями современной казахстанской эстрады.\n" +
                            "У нас есть свой неповторимый стиль, свое оригинальное творческое лицо.",
                    4.5f,
                    listOf(
                        Image("https://strg1.restoran.kz/neofiles/serve-image/57072840579f242a580005f4/1280x720/c1/q70")
                    )
                ),
                Musicians(
                    4,
                    "Турар Рахимберлин",
                    "Участник многих Фестивалей-конкурсов." +
                            "В репертуаре различные народные танцы: казахские, испанские, цыганские, армянские, грузинские, чеченские и многие другие танцы народов мира!",
                    4.5f,
                    listOf(
                        Image("https://strg1.restoran.kz/neofiles/serve-image/560526de7265737a293d0000/1280x720/c1/q70")
                    )
                ),
                Musicians(
                    5,
                    "ARAKS - Ансамбль народного танца",
                    "Ансамбль народного танца \"ARAKS\" при Республиканской Ассоциации Армян Казахстана \"Масис\", под руководством талантливого и высококвалифицированного хореографа со стажем работы более 20-ти лет, Оганнисяна Артура Размиковича",
                    4.5f,
                    listOf(
                        Image("https://strg1.restoran.kz/neofiles/serve-image/60af7e2416e6d9000665c969/1280x720/c1/q70")
                    )
                )
            )
        return allMusiciansList
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
                    4.5f,
                    listOf(Image("https://bnmusic.kz/wp-content/uploads/2020/04/Rosa-Rymbaeva.jpg"))
                ),
                Singer(
                    3,
                    "Али Окапов",
                    "Очень профессиональный артист во многих смыслах этого статуса. У Али прекрасная хореография, причем как сольная, так и с танцевальным коллективом. Он не просто отлично смотрится на сцене, он даже в некотором роде придает ей определённый вид! Али замечательно работает с залом, всегда очень тактично и даже скромно поприветствовав публику он знакомит ее с своей следующей композицией и так далее. Али Окапов остается профессионалом на любой площадке, будь то сцена частного мероприятия или большая площадка уличного шоу Али всегда выступает с запоминающейся энергетикой.",
                    4.5f,
                    listOf(Image("https://baigenews.kz/upload/iblock/0fe/Ali-Okapov-ne-soglasilsya-s-mneniem-materi-ob-Imanbeke-_-BaigeNews.kz.jpg")),
                )
            )
        return newSingerList
    }

    fun getAllSingers(): LiveData<List<Singer>> {
        val allSingerList = MutableLiveData<List<Singer>>()

        allSingerList.value =
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
                    4.5f,
                    listOf(Image("https://bnmusic.kz/wp-content/uploads/2020/04/Rosa-Rymbaeva.jpg"))
                ),
                Singer(
                    3,
                    "Али Окапов",
                    "Очень профессиональный артист во многих смыслах этого статуса. У Али прекрасная хореография, причем как сольная, так и с танцевальным коллективом. Он не просто отлично смотрится на сцене, он даже в некотором роде придает ей определённый вид! Али замечательно работает с залом, всегда очень тактично и даже скромно поприветствовав публику он знакомит ее с своей следующей композицией и так далее. Али Окапов остается профессионалом на любой площадке, будь то сцена частного мероприятия или большая площадка уличного шоу Али всегда выступает с запоминающейся энергетикой.",
                    4.5f,
                    listOf(Image("https://baigenews.kz/upload/iblock/0fe/Ali-Okapov-ne-soglasilsya-s-mneniem-materi-ob-Imanbeke-_-BaigeNews.kz.jpg")),
                ),
                Singer(
                    4,
                    "Pharrel Williams",
                    "Народный любимец казахской публики Farrel Williams исполняет композиции в жанре поп. Если вам по душе такой стиль, наше агентство готово организовать выступление артиста на вашем празднике. Музыкант поет только на казахском языке и является обладателем премии «Дарын».",
                    4.5f,
                    listOf(Image("https://www.biography.com/.image/t_share/MTQ3NjM5NjAyMDAwMTc2MjAy/pharrell_williams_photo_by_brian_bowen_nbcuniversal_getty_462041114.jpg")),
                ),
                Singer(
                    5,
                    "Jay Z",
                    "Опытный певец Роза Рымбаева, которую по праву считают примадонной казахстанского шоу-бизнеса, исполняет композиции в жанре поп. Ее имя увековечено в виде звезд на специальных Площадях как в Караганде, так и в Москве, а также в Витебске. Если вы хотите пригласить исполнительницу на свой праздник, доверьте организацию торжества с ее участием менеджерам нашего агентства!",
                    4.5f,
                    listOf(Image("https://assets.vogue.com/photos/5fda78f840cd4235a6f54663/master/w_2560%2Cc_limit/00_story%2520(1).jpg")),
                ),
                Singer(
                    6,
                    "Ed Sheeran",
                    "Очень профессиональный артист во многих смыслах этого статуса. У Али прекрасная хореография, причем как сольная, так и с танцевальным коллективом. Он не просто отлично смотрится на сцене, он даже в некотором роде придает ей определённый вид! Али замечательно работает с залом, всегда очень тактично и даже скромно поприветствовав публику он знакомит ее с своей следующей композицией и так далее. Али Окапов остается профессионалом на любой площадке, будь то сцена частного мероприятия или большая площадка уличного шоу Али всегда выступает с запоминающейся энергетикой.",
                    4.5f,
                    listOf(Image("https://studiosol-a.akamaihd.net/uploadfile/letras/fotos/9/6/4/0/9640a9aa5c9fd17dd1a3015756725789.jpg")),
                )
            )
        return allSingerList
    }

    fun getAllShowmans(): LiveData<List<Showman>> {
        val allShowmansList = MutableLiveData<List<Showman>>()

        allShowmansList.value =
            listOf(
                Showman(
                    1,
                    "Руслан Акишев",
                    "Интеллигентный весельчак, неотъемлемой частью работы которого является юмор и хорошее настроение. Индивидуальный стиль ведения Руслана можно описать двумя словами: максимум юмора, ноль пошлости.",
                    4.5f,
                    listOf(Image("https://sun9-69.userapi.com/impf/c855216/v855216945/da209/8cEQwkFhXew.jpg?size=720x405&quality=96&sign=96afd59e80873fc14f8f4ff4a8b5fd95&type=album")),
                ),
                Showman(
                    2,
                    "Тимофей Пак",
                    "Team Vision - ивент агентство, проводит мероприятия \"под ключ\". Опыт работы наших ведущих более 10 лет. Тематические корпоративы, тимбилдинги, открытие, конференции.\n" +
                            "\n" +
                            "Также мы возьмем \"под контроль\" любое семейное торжество: годики, юбилеи, свадьбы.\n" +
                            "\n" +
                            "Выездная регистрация, фото и видео съемка, оформление, шоу программа.\n" +
                            "\n" +
                            "Мы работаем на долгосрочные отношения и для нас важно качество и результат от проведения.\n" +
                            "\n" +
                            "Проведение по всем городам Казахстана и за рубеж.",
                    4.5f,
                    listOf(
                        Image(
                            "data:image/jpeg;base64,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"
                        )
                    )
                ),
                Showman(
                    3,
                    "Тимур Жолдаспаев",
                    "Создавать праздники это не просто моя профессия - это мое призвание... это то, что я делаю с радостью и легко! Я с удовольствием перенесу Вас в мир красок и волшебства. Я не работаю по заезженным сценариям! Главное-это доверительные отношения и  дружеская обстановка…  создание такой атмосферы – моя задача!",
                    4.5f,
                    listOf(Image("https://incatalog.kz/uploads/posts/2019-04/1554912999_c2ee75af5fd1f91c0b297b4bf7ac6942.jpg")),
                ),
                Showman(
                    4,
                    "Александр Цой",
                    "Праздник на одном дыхании. Это – мечта каждого, у кого впереди – день рождения, юбилей (хангади), свадьба, корейская свадьба, корейский годик (толь/асянди). Одним словом, - праздничный банкет в Алматы. Эту мечту воплотит в жизнь Александр Цой.",
                    4.5f,
                    listOf(
                        Image(
                            "data:image/webp;base64,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"
                        )
                    )
                ),
                Showman(
                    5,
                    "Евгений Ожогин",
                    "Евгений уже  зарекомендовал себя, как ведущий высокого уровня, умеющий «дружить» с публикой на мероприятиях любого формата. За его плечами множество мероприятий на площадках страны, среди которых вечера с участием первых лиц государств!",
                    4.5f,
                    listOf(Image("https://incatalog.kz/uploads/posts/2019-04/1554915751_t4_1320366886a83602dc2205bde1aeaf58.jpg"))
                ),
                Showman(
                    6,
                    "Серик Нурбеков",
                    "Веселый, харизматичный, интеллигентный ведущий мероприятий для Вашего торжества!\n" +
                            "\n" +
                            "Большой опыт работы, индивидуальный подход, дипломатичность и гибкая стратегия по отношению к клиентам!\n" +
                            "\n" +
                            "Великолепная шоу-программа, интересные интерактивы, занимательные викторины и тонкий юмор сделают Ваш праздник незабываемым!",
                    4.5f,
                    listOf(Image("https://i.mycdn.me/i?r=AzEPZsRbOZEKgBhR0XGMT1RkcooxIU8ozj9jTEANcy0mSaaKTM5SRkZCeTgDn6uOyic&fn=sqr_288"))
                )
            )
        return allShowmansList
    }
}
