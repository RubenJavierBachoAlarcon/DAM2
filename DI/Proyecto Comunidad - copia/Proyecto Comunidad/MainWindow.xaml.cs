using ProyectoComunidad.Domain;
using ProyectoComunidad.Persistance.Manages;
using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading;
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
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            //Valores por defecto a todos los label
            NAME.Text = "Nombre";
            ADDRESS.Text = "Direccion";
            FOUNDING_DATE.SelectedDate = DateTime.Today;
            SIZE.Text = "23";
            NUM_ENTRANCES.Text = "2";
            
        }

        private void NEXT_Click(object sender, RoutedEventArgs e)
        {
            CommunityManage cm = new CommunityManage();
            cm.loadDataBase();
            cm.insertCommunity(new Community(NAME.Text, ADDRESS.Text, FOUNDING_DATE.Text, int.Parse(SIZE.Text), HAVE_POOL.IsChecked.Value, cm));
            GlobalVariable.numEntrancesFinal = int.Parse(NUM_ENTRANCES.Text);
            GlobalVariable.numEntrances = GlobalVariable.numEntrancesFinal;
            GlobalVariable.nameCommunity = NAME.Text;

            mainFrame.NavigationService.Navigate(new Page1());
            
        }

    }
}
