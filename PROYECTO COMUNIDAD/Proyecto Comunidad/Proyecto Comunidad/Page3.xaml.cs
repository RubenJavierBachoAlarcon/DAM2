using ProyectoComunidad.Domain;
using ProyectoComunidad.Persistance.Manages;
using System;
using System.Linq;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Navigation;

namespace Proyecto_Comunidad
{
    /// <summary>
    /// Interaction logic for Page3.xaml
    /// </summary>
    public partial class Page3 : Page
    {
        /// <summary>
        /// Initializes a new instance of the Page3 class.
        /// </summary>
        public Page3()
        {
            InitializeComponent();

            // Default values for all labels
            NAME.Text = "Nombre";
            ADDRESS.Text = "Direccion";
            FOUNDING_DATE.SelectedDate = DateTime.Today;
            SIZE.Text = "23";
            NUM_ENTRANCES.Text = "2";
        }

        /// <summary>
        /// Event handler for the Click event of the NEXT button.
        /// </summary>
        private void NEXT_Click(object sender, RoutedEventArgs e)
        {
<<<<<<< HEAD
            
=======
            // Create a new CommunityManage instance and load the database
>>>>>>> Interfaz
            CommunityManage cm = new CommunityManage();
            cm.loadDataBase();

            // Insert a new community into the database
            cm.insertCommunity(new Community(NAME.Text, ADDRESS.Text, FOUNDING_DATE.Text, int.Parse(SIZE.Text), HAVE_POOL.IsChecked.Value, cm));

            // Update global variables
            GlobalVariable.numEntrancesFinal = int.Parse(NUM_ENTRANCES.Text);
            GlobalVariable.numEntrances = GlobalVariable.numEntrancesFinal;
            GlobalVariable.nameCommunity = NAME.Text;
<<<<<<< HEAD
            
=======

            // Navigate to Page1
>>>>>>> Interfaz
            MainWindow mainWindow = (MainWindow)Application.Current.MainWindow;
            Page1 page1 = new Page1();
            mainWindow.MainFrame.Navigate(page1);
        }
    }
}
