import com.google.gson.annotations.SerializedName

data class OverpassResponse(
    @SerializedName("elements") val elements: List<OverpassElement>
)

data class OverpassElement(
    @SerializedName("lat") val lat: Double,
    @SerializedName("lon") val lon: Double
)
