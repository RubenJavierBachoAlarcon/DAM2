using Proyecto_Comunidad.Domain;
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
using System.Windows.Media.Animation;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace Proyecto_Comunidad
{
    /// <summary>
    /// Interaction logic for Page1.xaml
    /// </summary>
    public partial class Page1 : Page
    {
        /// <summary>
        /// List of entrances.
        /// </summary>
        List<EntranceInfo> entrances = new List<EntranceInfo>();

        /// <summary>
        /// Auxiliary id.
        /// </summary>
        private int idAux = 1;

        /// <summary>
        /// Initializes a new instance of the Page1 class.
        /// </summary>
        public Page1()
        {
            InitializeComponent();
            GlobalVariable.numEntrances--;
        }

        /// <summary>
        /// Event handler for the Click event of the NEXT button.
        /// </summary>
        private void NEXT_Click(object sender, RoutedEventArgs e1)
        {
            // If there are no more entrances to process
            if (GlobalVariable.numEntrances == 0)
            {
                // Calculate total number of owners
                int totalOwners = entrances.Count * entrances[0].numStairs * entrances[0].numFloors * entrances[0].numLetters;

                // Generate lists of parking and storage numbers
                List<int> numsParking = Enumerable.Range(1, totalOwners).ToList();
                List<int> numsStorage = Enumerable.Range(1, totalOwners).ToList();

                // Shuffle the lists
                Random rand = new Random();
                numsParking = numsParking.OrderBy(x => rand.Next()).ToList();
                numsStorage = numsStorage.OrderBy(x => rand.Next()).ToList();

                // Create and insert entrances
                int index = 0;
                foreach (var entranceInfo in entrances)
                {
                    for (int j = 1; j <= entranceInfo.numStairs; j++)
                    {
                        for (int k = 1; k <= entranceInfo.numFloors; k++)
                        {
                            for (int l = 0; l < entranceInfo.numLetters; l++)
                            {
                                Entrance e = new Entrance
                                {
                                    stair = j,
                                    floor = k,
                                    letter = (char)(l + 'A'),
                                    parking = numsParking[index],
                                    storage = numsStorage[index]
                                };
                                index++;
                                e.insert();
                            }
                        }
                    }
                }

                // Navigate to Page4
                MainWindow mainWindow = (MainWindow)Application.Current.MainWindow;
                Page4 page4 = new Page4();
                mainWindow.MainFrame.Navigate(page4);
<<<<<<< HEAD
            }
            if (GlobalVariable.numEntrances == 1)
            {
                GlobalVariable.numEntrances--;
                entrances.Add(new EntranceInfo(int.Parse(NUMSTAIRS.Text), int.Parse(NUMFLOORS.Text), int.Parse(NUMLETTERS.Text)));
                idAux++;
                NUMENTRANCES.Text = "Entrance " + idAux;

                NUMSTAIRS.Text = "";
                NUMFLOORS.Text = "";
                NUMLETTERS.Text = "";
                NEXT.Content = "SAVE";
=======
>>>>>>> Interfaz
            }
            else
            {
                // If there is one more entrance to process
                if (GlobalVariable.numEntrances == 1)
                {
                    GlobalVariable.numEntrances--;
                    entrances.Add(new EntranceInfo(int.Parse(NUMSTAIRS.Text), int.Parse(NUMFLOORS.Text), int.Parse(NUMLETTERS.Text)));
                    idAux++;
                    NUMENTRANCES.Text = "Entrance " + idAux;

                    // Clear the input fields
                    NUMSTAIRS.Text = "";
                    NUMFLOORS.Text = "";
                    NUMLETTERS.Text = "";
                    NEXT.Content = "SAVE";
                }
                else
                {
                    // If there are more than one entrances to process
                    GlobalVariable.numEntrances--;
                    entrances.Add(new EntranceInfo(int.Parse(NUMSTAIRS.Text), int.Parse(NUMFLOORS.Text), char.Parse(NUMLETTERS.Text)));
                    idAux++;
                    NUMENTRANCES.Text = "Entrance " + idAux;

                    // Clear the input fields
                    NUMSTAIRS.Text = "";
                    NUMFLOORS.Text = "";
                    NUMLETTERS.Text = "";
                }
            }
        }
    }
}
