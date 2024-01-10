import com.example.osmdroid.OverpassResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface OverpassApi {
    @GET("api/interpreter")
    fun getHospitals(@Query("data") query: String): Call<OverpassResponse>
}
