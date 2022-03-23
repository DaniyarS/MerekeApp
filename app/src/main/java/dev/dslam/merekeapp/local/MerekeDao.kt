package dev.dslam.merekeapp.local

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import dev.dslam.merekeapp.models.Venue

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
                    "https://cf.bstatic.com/xdata/images/hotel/max1024x768/37841494.jpg?k=4dba455b83c267f00babee749851e06cc836aeb069fc10428855bc5b6a9ba3fa&o=&hp=1"
                ),
                Venue(
                    2,
                    "Assem Toikhana",
                    "Банкетный зал вместимостью 200 человек",
                    4.8f,
                    "Толе Би 74",
                    "https://realkz.com/images_resize/main/64759.jpg"
                )
            )
        Log.d("TAG", newVenueList.value.toString())
        return newVenueList
    }
}
