using System;
using System.Reflection.Metadata.Ecma335;
using System.Runtime.CompilerServices;
namespace Matrix
{
    public class Character
    {
        private static Random rand = new Random();

        public string name;
        public string city;

        public double latitude;
        public double longitude;
        public double probDeath;

        public int x { get; set; }
        public int y { get; set; }

        public int age;

        public Character(double probDeath)
        {
            this.name = generateName();
            this.generateCity();
            this.age = rand.Next(18, 100);
            this.probDeath = probDeath;
        }

        public Character() : this(rand.NextDouble() * 0.7)
        {

        }

        public Character(Character original)
        {
            this.probDeath = original.probDeath;
            this.name = original.name;
            this.city = original.city;
            this.latitude = original.latitude;
            this.longitude = original.longitude;
            this.x = original.x;
            this.y = original.y;
            this.age = original.age;
        }


        private string generateName()
        {
            string[] names = { "Michelle", "Alexander", "James", "Caroline", "Claire", "Jessica", "Erik", "Mike" };
            return names[rand.Next(names.Length)];
        }

        private string generateCity()
        {
            latitude = rand.NextDouble() * 180 - 90;
            longitude = rand.NextDouble() * 360 - 180;
            double minDistance = double.MaxValue;
            string nearestCity = "";

            Dictionary<string, (double latitude, double longitude)> cityCords = new Dictionary<string, (double, double)>()
        {
            { "Nueva York", (40.7128, -74.0060) },
            { "Boston", (42.3601, -71.0589) },
            { "Baltimore", (39.2904, -76.6122) },
            { "Atlanta", (33.7490, -84.3880) },
            { "Detroit", (42.3314, -83.0458) },
            { "Dallas", (32.7767, -96.7970) },
            { "Denver", (39.7392, -104.9903) }
        };

            foreach (var city in cityCords)
            {
                double cityLat = city.Value.latitude;
                double cityLon = city.Value.longitude;
                double distance = CalculateDistance(cityLat, cityLon, latitude, longitude);

                if (distance < minDistance)
                {
                    minDistance = distance;
                    nearestCity = city.Key;
                }
            }

            return nearestCity;

            double CalculateDistance(double lat1, double lon1, double lat2, double lon2)
            {
                // Implementa aquí la fórmula de cálculo de distancia entre dos puntos dados sus latitudes y longitudes
                // Puedes usar la fórmula de la "fórmula del haversine" para calcular la distancia en kilómetros o millas.
                // Aquí se muestra una implementación simplificada:

                const double EarthRadiusKm = 6371.0;
                double dLat = ToRadians(lat2 - lat1);
                double dLon = ToRadians(lon2 - lon1);

                double a = Math.Sin(dLat / 2) * Math.Sin(dLat / 2) +
                           Math.Cos(ToRadians(lat1)) * Math.Cos(ToRadians(lat2)) *
                           Math.Sin(dLon / 2) * Math.Sin(dLon / 2);

                double c = 2 * Math.Atan2(Math.Sqrt(a), Math.Sqrt(1 - a));

                double distance = EarthRadiusKm * c;

                return distance;
            }

            double ToRadians(double degrees)
            {
                return degrees * (Math.PI / 180.0);
            }
        }

    }
}