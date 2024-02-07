using DI_Ejercicio_4_Squid_Game.Persistance.DataBaseFolder;
using SAPBusinessObjects.WPF.Viewer;
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
using System.Windows.Shapes;

namespace Proyecto_Comunidad
{
    /// <summary>
    /// Interaction logic for CommunityInfo.xaml
    /// </summary>
    public partial class CommunityInfo : Window
    {
        public CommunityInfo()
        {
            InitializeComponent();
        }

        private void CrystalReportsViewer_Loaded(object sender, RoutedEventArgs e)
        {
            List<List<Object>> owners = DataBase.obtainDataBase().read("SELECT id, name FROM owners");

            DataSet1 ds = new DataSet1();

            // Llena la tabla owners de tu DataSet con los datos que obtuviste
            foreach (List<Object> row in owners)
            {
                ds.owners.Rows.Add(row.ToArray());
            }

            CrystalReport1 report = new CrystalReport1();

            // Asigna el DataSet al informe
            report.SetDataSource(ds);

            // Asigna el informe al visor de informes de Crystal
            crystalReportsViewer.ViewerCore.ReportSource = report;

        }
    }
}
