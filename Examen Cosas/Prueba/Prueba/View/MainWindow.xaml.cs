using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
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
using System.Xml.Linq;

namespace Prueba
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();

            Domain.Task t = new Domain.Task();
            t.readT();

            dgTask.ItemsSource = t.getListTask();

        }

        private void dgTask_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            if (dgTask.SelectedItems.Count == 1)
            {
                Domain.Task t = (Domain.Task)dgTask.SelectedItems[0];

                NAME.Text = t.name;
                DESCRIPTION.Text = t.description;
                COMPLETED.IsChecked = t.isCompleted;
            }
        }

        private void SAVE_Click(object sender, RoutedEventArgs e)
        {
            Domain.Task t = (Domain.Task)dgTask.SelectedItem;
            t.name = NAME.Text;
            t.description = DESCRIPTION.Text;
            t.isCompleted = COMPLETED.IsChecked ?? false;
            t.update();

            dgTask.Items.Refresh();
        }

        private void NEW_Click(object sender, RoutedEventArgs e)
        {
            Domain.Task t = new Domain.Task();
            t.last();
            t.insert();

            ((List<Domain.Task>)dgTask.ItemsSource).Add(t);
            dgTask.Items.Refresh();
        }

        private void DELETE_Click(object sender, RoutedEventArgs e)
        {
            Domain.Task t = (Domain.Task)dgTask.SelectedItem;
            t.delete();

            ((List<Domain.Task>)dgTask.ItemsSource).Remove(t);
            dgTask.Items.Refresh();
        }
    }
}
