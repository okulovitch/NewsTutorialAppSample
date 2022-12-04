import android.app.Application
import androidx.room.Room
import com.akul.news_data.BuildConfig
import com.akul.news_data.local.NewsDatabase
import com.akul.news_data.remote.OpenNewsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NewsDataModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
            ).addInterceptor { chain ->
                val authorizedRequest = chain.request().newBuilder()
                    .addHeader(
                        "X-Api-Key",
                        "9ce1ee9910d34bd8b25d7cb376c0d45e"
                    )//todo send api key as dependency
                    .build()

                chain.proceed(authorizedRequest)
            }.build()
    }

    @Provides
    @Singleton
    fun provideNewsOpenApi(client: OkHttpClient): OpenNewsApi {
        return Retrofit.Builder()
            .baseUrl(OpenNewsApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideNewsDatabase(app: Application): NewsDatabase {
        return Room.databaseBuilder(
            app,
            NewsDatabase::class.java,
            "news.db"
        ).build()
    }
}