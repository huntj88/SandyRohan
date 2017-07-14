package hunt.james.sandyrohan.data.di.scope.app.network

import dagger.Module
import dagger.Provides
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import javax.inject.Singleton



/**
 * Created by James on 7/14/2017.
 */

@Module
class NetworkClientModule {

    val BASE_URL = "http://www.gw2spidy.com/"


    @Singleton
    @Provides
    fun getRetrofitClient(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    @Singleton
    @Provides
    fun getGuildWarsService(retrofit: Retrofit): UnofficialGWService {
        return retrofit.create(UnofficialGWService::class.java)
    }


}