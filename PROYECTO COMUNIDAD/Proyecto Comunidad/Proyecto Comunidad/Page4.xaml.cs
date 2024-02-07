using DI_Ejercicio_4_Squid_Game.Persistance.DataBaseFolder;
using Proyecto_Comunidad.Domain;
using Proyecto_Comunidad.Persistance.Manages;
using System;
using System.Collections.Generic;
using System.Linq;
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


    public partial class Page4 : Page
    {
        bool isGateKeeper = false;
        int isShowers = 0;
        int isPlayground = 0;
        int isGym = 0;
        int isMeetingRoom = 0;
        int isTennisCourt = 0;
        int isPadelCourt = 0;

        public Page4()
        {
            InitializeComponent();



        }

        private void NEXT_Click(object sender, RoutedEventArgs e)
        {
            isGateKeeper = GATE.IsChecked.Value;

            if (SHOWERS.IsChecked == true)
            {
                isShowers = 1;
            }
            if (PLAYAREA.IsChecked == true)
            {
                isPlayground = 1;
            }
            if (GYM.IsChecked == true)
            {
                isGym = 1;
            }
            if (MEETING.IsChecked == true)
            {
                isMeetingRoom = 1;
            }
            if (TENNIS.IsChecked == true)
            {
                isTennisCourt = 1;
            }
            if (PADEL.IsChecked == true)
            {
                isPadelCourt = 1;
            }


            DataBase.obtainDataBase().modify("INSERT INTO community_info VALUES " +
                $"('{GlobalVariable.nameCommunity}', {isShowers}, {isPlayground}, {isGym}, {isMeetingRoom}, {isTennisCourt}, {isPadelCourt})");




            if (isGateKeeper)
            {



                List<List<Object>> gateKeeper = DataBase.obtainDataBase().read("SELECT * FROM owners WHERE id = -1");

                if (gateKeeper[0].Count == 0)
                {
                    DataBase.obtainDataBase()
                    .modify("INSERT INTO entrances (id, nameCommunity, stair, floor, letter, parking, storage) " +
                     $"values (-1, '{GlobalVariable.nameCommunity}', 1, -1, 'A', 0, 0)");

                    DataBase.obtainDataBase().modify("INSERT INTO owners (id, DNI, Name, Surname, Address, Locality, zipCode, province) " +
                        $"VALUES (-1, 1234231, 'gateKeeper1', 'Martinez', 'C/Ejemplo', 'Ciudad Real', '13421', 'Ciudad Real')");

                    DataBase.obtainDataBase().modify("INSERT INTO entrances_owners (idEntrance, idOwner) " +
                                               $"VALUES (-1, -1)");
                }
                else
                {
                    MessageBox.Show("Already exist a gatekeeper", "Error", MessageBoxButton.OK, MessageBoxImage.Error);
                }

            }


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

            DataBase.obtainDataBase().modify("INSERT INTO entrances_owners (idEntrance, idOwner)\r\nSELECT entrances.id, owners.id\r\nFROM entrances\r\nCROSS JOIN owners\r\nORDER BY RAND()\r\nLIMIT 200;\r\n");


            CommunityInfo communityInfoWindow = new CommunityInfo();

            communityInfoWindow.Show();


            Window currentWindow = Window.GetWindow(this);

            // Cierra la ventana actual
            if (currentWindow != null)
            {
                currentWindow.Close();
            }

        }
    }
}
