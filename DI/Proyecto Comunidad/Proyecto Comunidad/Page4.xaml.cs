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

        private void Button_Click(object sender, RoutedEventArgs e)
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


            MainWindow mainWindow = (MainWindow)Application.Current.MainWindow;
            Page2 page2 = new Page2();
            mainWindow.MainFrame.Navigate(page2);





        }
    }
}
