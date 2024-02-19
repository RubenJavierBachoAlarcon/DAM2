using DI_Ejercicio_4_Squid_Game.Persistance.DataBaseFolder;
using Proyecto_Comunidad.Domain;
using Proyecto_Comunidad.Persistance.Manages;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Navigation;

namespace Proyecto_Comunidad
{
    /// <summary>
    /// Interaction logic for Page4.xaml
    /// </summary>
    public partial class Page4 : Page
    {
        /// <summary>
        /// Variables to store the state of the checkboxes.
        /// </summary>
        bool isGateKeeper = false;
        int isShowers = 0;
        int isPlayground = 0;
        int isGym = 0;
        int isMeetingRoom = 0;
        int isTennisCourt = 0;
        int isPadelCourt = 0;

        /// <summary>
        /// Initializes a new instance of the Page4 class.
        /// </summary>
        public Page4()
        {
            InitializeComponent();
        }

        /// <summary>
        /// Event handler for the Click event of the NEXT button.
        /// </summary>
        private void NEXT_Click(object sender, RoutedEventArgs e)
        {
            // Update the state of the checkboxes
            isGateKeeper = GATE.IsChecked.Value;
            isShowers = SHOWERS.IsChecked == true ? 1 : 0;
            isPlayground = PLAYAREA.IsChecked == true ? 1 : 0;
            isGym = GYM.IsChecked == true ? 1 : 0;
            isMeetingRoom = MEETING.IsChecked == true ? 1 : 0;
            isTennisCourt = TENNIS.IsChecked == true ? 1 : 0;
            isPadelCourt = PADEL.IsChecked == true ? 1 : 0;

            // Insert the community info into the database
            DataBase.obtainDataBase().modify("INSERT INTO community_info VALUES " +
                $"('{GlobalVariable.nameCommunity}', {isShowers}, {isPlayground}, {isGym}, {isMeetingRoom}, {isTennisCourt}, {isPadelCourt})");

            // If the gatekeeper checkbox is checked
            if (isGateKeeper)
            {
                // Check if a gatekeeper already exists
                List<List<Object>> gateKeeper = DataBase.obtainDataBase().read("SELECT * FROM owners WHERE id = -1");

                // If a gatekeeper does not exist
                if (gateKeeper[0].Count == 0)
                {
                    // Insert the gatekeeper into the database
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
                    // If a gatekeeper already exists, show an error message
                    MessageBox.Show("Already exist a gatekeeper", "Error", MessageBoxButton.OK, MessageBoxImage.Error);
                }
            }

            // Insert the owners into the database
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

            // Insert the entrances_owners into the database
            DataBase.obtainDataBase().modify("INSERT INTO entrances_owners (idEntrance, idOwner)\r\nSELECT entrances.id, owners.id\r\nFROM entrances\r\nCROSS JOIN owners\r\nORDER BY RAND()\r\nLIMIT 200;\r\n");

            // Show the CommunityInfo window
            CommunityInfo communityInfoWindow = new CommunityInfo();
            communityInfoWindow.Show();

            // Close the current window
            Window currentWindow = Window.GetWindow(this);
            if (currentWindow != null)
            {
                currentWindow.Close();
            }
        }
    }
}
