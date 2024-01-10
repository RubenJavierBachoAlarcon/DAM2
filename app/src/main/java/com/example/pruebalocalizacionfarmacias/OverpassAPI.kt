import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface OverpassAPI {
    @GET("/api/interpreter")
    fun getPharmacies(@Query("data") query: String): Call<OverpassResponse>
}
