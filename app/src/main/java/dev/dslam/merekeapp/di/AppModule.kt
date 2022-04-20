package dev.dslam.merekeapp.di

import android.app.Application
import androidx.room.Room
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dev.dslam.merekeapp.local.AppDatabase
import dev.dslam.merekeapp.local.AppRepository
import dev.dslam.merekeapp.local.MerekeDao
import dev.dslam.merekeapp.network.MerekeApi
import dev.dslam.merekeapp.presentation.viewModels.*
import okhttp3.Cache
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://localhost:2000/"

val viewModelModule = module {
    viewModel{
        HomeFragmentViewModel(appRepository = get())
    }
    viewModel {
        VenuesFragmentViewModel(appRepository = get())
    }
    viewModel {
        SingersFragmentViewModel(appRepository = get())
    }
    viewModel {
        ShowmansFragmentViewModel(appRepository = get())
    }
    viewModel {
        DancersFragmentViewModel(appRepository = get())
    }
    viewModel {
        MusiciansFragmentViewModel(appRepository = get())
    }
}

val apiModule = module {
    fun provideMerekeApi(retrofit: Retrofit): MerekeApi {
        return retrofit.create(MerekeApi::class.java)
    }

    single { provideMerekeApi(get()) }
}

val netModule = module {
    fun provideCache(application: Application): Cache {
        val cacheSize = 10 * 1024 * 1024
        return Cache(application.cacheDir, cacheSize.toLong())
    }

    fun provideHttpClient(cache: Cache): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()
            .cache(cache)

        return okHttpClientBuilder.build()
    }

    fun provideGson(): Gson {
        return GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create()
    }

    fun provideRetrofit(factory: Gson, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(factory))
            .client(client)
            .build()
    }

    single { provideCache(androidApplication()) }
    single { provideHttpClient(get()) }
    single { provideGson() }
    single { provideRetrofit(get(), get()) }
}

val databaseModule = module {

    fun provideDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "mereke.database")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    fun provideDao(database: AppDatabase): MerekeDao {
        return database.merekeDao
    }

    single { provideDatabase(androidApplication()) }
    single { provideDao(get()) }
}

val repositoryModule = module {
    fun provideAppRepository(api: MerekeApi, dao: MerekeDao): AppRepository {
        return AppRepository(api, dao)
    }

    single { provideAppRepository(get(), get()) }
}
