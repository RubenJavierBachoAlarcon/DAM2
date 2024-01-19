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
    /// Lógica de interacción para Page1.xaml
    /// </summary>
    public partial class Page1 : Page
    {
        List<EntranceInfo> entrances = new List<EntranceInfo>();
        private int idAux = 1;
        public Page1()
        {
            InitializeComponent();
            GlobalVariable.numEntrances--;

        }

        private void NEXT_Click(object sender, RoutedEventArgs e1)
        {
            if (GlobalVariable.numEntrances == 0)
            {
                int totalOwners = entrances.Count * entrances[0].numStairs * entrances[0].numFloors * entrances[0].numLetters;
                List<int> numsParking = Enumerable.Range(1, totalOwners).ToList();
                List<int> numsStorage = Enumerable.Range(1, totalOwners).ToList();
                Random rand = new Random();

                int n = numsParking.Count;
                while (n > 1)
                {
                    n--;
                    int k = rand.Next(n + 1);
                    int value = numsParking[k];
                    numsParking[k] = numsParking[n];
                    numsParking[n] = value;
                }

                int m = numsParking.Count;
                while (m > 1)
                {
                    m--;
                    int p = rand.Next(m + 1);
                    int value2 = numsParking[p];
                    numsParking[p] = numsParking[m];
                    numsParking[m] = value2;
                }

                int index = 0;
                for (int i = 0; i < entrances.Count; i++)
                {
                    for (int j = 1; j <= entrances[i].numStairs; j++)
                    {
                        for (int k = 1; k <= entrances[i].numFloors; k++)
                        {
                            for (int l = 0; l < entrances[i].numLetters; l++)
                            {
                                Entrance e = new Entrance();
                                
                                e.stair = j;
                                e.floor = k;
                                e.letter = (char)(l + 'A');
                                e.parking = numsParking[index];
                                e.storage = numsStorage[index];
                                index++;
                                e.insert();
                            }
                        }
                    }
                }
                NavigationWindow window = new NavigationWindow();
                window.Content = new Page2(); // Tu página inicial
                window.Show();


            }
            if (GlobalVariable.numEntrances == 1)
            {
                GlobalVariable.numEntrances--;
                entrances.Add(new EntranceInfo(int.Parse(NUMSTAIRS.Text), int.Parse(NUMFLOORS.Text), int.Parse(NUMLETTERS.Text)));
                idAux++;
                NUMENTRANCES.Content = "Entrance " + idAux;

                NUMSTAIRS.Text = "";
                NUMFLOORS.Text = "";
                NUMLETTERS.Text = "";
                NEXT.Content = "SAVE";
            }
            else
            {
                GlobalVariable.numEntrances--;
                entrances.Add(new EntranceInfo(int.Parse(NUMSTAIRS.Text), int.Parse(NUMFLOORS.Text), char.Parse(NUMLETTERS.Text)));
                idAux++;
                NUMENTRANCES.Content = "Entrance " + idAux;

                NUMSTAIRS.Text = "";
                NUMFLOORS.Text = "";
                NUMLETTERS.Text = "";
            }
            

            

        }
    }
}
