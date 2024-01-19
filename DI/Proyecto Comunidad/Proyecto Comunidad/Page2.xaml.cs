using DI_Ejercicio_4_Squid_Game.Persistance.DataBaseFolder;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace Proyecto_Comunidad
{
    /// <summary>
    /// Lógica de interacción para Page2.xaml
    /// </summary>
    public partial class Page2 : Page
    {
        public Page2()
        {
            InitializeComponent();
        }

        private void generarVecinos_Click(object sender, RoutedEventArgs e)
        {
            
            StringBuilder sb = new StringBuilder();
            sb.Append("INSERT INTO owners (id, DNI, Name, Surname, Address, Locality, zipCode, province) VALUES ");

            string[] names = { "John", "Jane", "Bob", "Alice", "Mike", "Emily", "David", "Samantha", "Tom", "Linda" };
            string[] surnames = { "Smith", "Johnson", "Williams", "Jones", "Brown", "Garcia", "Miller", "Davis", "Rodriguez", "Martinez" };
            Random rnd = new Random();

            for (int i = 1; i < 200; i++)
            {
                sb.Append($"({i},'{i + 123}', '{names[rnd.Next(names.Length)]}', '{surnames[rnd.Next(surnames.Length)]}', 'Address{i}', 'Locality{i}', '{i}', 'Province{i}')");

                if (i != 199)
                {
                    sb.Append(",");
                }
            }

            DataBase.obtainDataBase().modify(sb.ToString());

           
        }

        private void distribuirVecinos_Click(object sender, RoutedEventArgs e)
        {
            DataBase.obtainDataBase().modify("INSERT INTO entrances_owners (idEntrance, idOwner)\r\nSELECT entrances.id, owners.id\r\nFROM entrances\r\nCROSS JOIN owners\r\nORDER BY RAND()\r\nLIMIT 200;\r\n");
            distribuirVecinos.IsEnabled = false;
        }
    }
}
