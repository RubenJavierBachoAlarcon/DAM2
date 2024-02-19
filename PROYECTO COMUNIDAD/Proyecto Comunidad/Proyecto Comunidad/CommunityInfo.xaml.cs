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
        /// <summary>
        /// Initializes a new instance of the <see cref="CommunityInfo"/> class.
        /// </summary>
        public CommunityInfo()
        {
            InitializeComponent();
        }

        /// <summary>
        /// Event handler for the Loaded event of the CrystalReportsViewer.
        /// </summary>
        private void CrystalReportsViewer_Loaded(object sender, RoutedEventArgs e)
        {
            // Fetch owners data from the database
            List<List<Object>> owners = DataBase.obtainDataBase().read("SELECT id, name FROM owners");

            DataSet1 ds = new DataSet1();

            // Fill the owners table of your DataSet with the data you obtained
            foreach (List<Object> row in owners)
            {
                ds.owners.Rows.Add(row.ToArray());
            }

            CrystalReport1 report = new CrystalReport1();

            // Assign the DataSet to the report
            report.SetDataSource(ds);

            // Assign the report to the Crystal report viewer
            crystalReportsViewer.ViewerCore.ReportSource = report;
        }

        /// <summary>
        /// Event handler for the Click event of the Button.
        /// </summary>
        private void Button_Click(object sender, RoutedEventArgs e)
        {
            // Fetch entrance data from the database
            List<List<Object>> entrance = DataBase.obtainDataBase().read("SELECT entrances.stair,entrances.floor,entrances.letter, COUNT(owners.id)\r\nFROM entrances\r\nJOIN entrances_owners ON entrances.id = entrances_owners.idEntrance\r\nJOIN owners ON owners.id = entrances_owners.idOwner\r\ngroup by entrances.id");

            DataSet3 ds = new DataSet3();

            // Fill the entrances table of your DataSet with the data you obtained
            foreach (List<Object> row in entrance)
            {
                ds.entrances.Rows.Add(row.ToArray());
            }

            CrystalReport4 report = new CrystalReport4();

            // Assign the DataSet to the report
            report.SetDataSource(ds);

            // Assign the report to the Crystal report viewer
            crystalReportsViewer.ViewerCore.ReportSource = report;
        }

        /// <summary>
        /// Event handler for the Click event of the Button.
        /// </summary>
        private void Button_Click_1(object sender, RoutedEventArgs e)
        {
            // Fetch community_info data from the database
            List<List<Object>> community_info = DataBase.obtainDataBase().read("SELECT isShowersToilets, isPlayground, isGym, isMeetingRoom, isTennisCourt, isPadelCourt FROM community_info");

            DataSet4 ds = new DataSet4();

            // Fill the community_info table of your DataSet with the data you obtained
            foreach (List<Object> row in community_info)
            {
                ds.community_info.Rows.Add(row.ToArray());
            }

            CrystalReport5 report = new CrystalReport5();

            // Assign the DataSet to the report
            report.SetDataSource(ds);

            // Assign the report to the Crystal report viewer
            crystalReportsViewer.ViewerCore.ReportSource = report;
        }
    }
}
