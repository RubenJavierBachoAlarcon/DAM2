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

namespace DI_Ejercicio_4_Squid_Game
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();

            Domain.Employee e = new Domain.Employee();
            e.readE();

            dgEmployee.ItemsSource = e.getListTask();
        }

        private void dgTask_SelectionChanged(object sender, SelectionChangedEventArgs e1)
        {
            if (dgEmployee.SelectedItems.Count == 1)
            {
                Domain.Employee e = (Domain.Employee)dgEmployee.SelectedItems[0];

                NIF.Text = e.nif;
                SURNAME.Text = e.surname;
                NAME.Text = e.name;
                AGE.Text = e.age.ToString();
            }
        }

        private void SAVE_Click(object sender, RoutedEventArgs e1)
        {
            Domain.Employee e = (Domain.Employee)dgEmployee.SelectedItem;
            e.nif = NIF.Text;
            e.name = NAME.Text;
            e.surname = SURNAME.Text;
            e.age = Int32.Parse(e.age.ToString());
            e.update();

            dgEmployee.Items.Refresh();
        }

        private void NEW_Click(object sender, RoutedEventArgs e1)
        {
            Domain.Employee e = new Domain.Employee();
            e.insert();

            ((List<Domain.Employee>)dgEmployee.ItemsSource).Add(e);
            dgEmployee.Items.Refresh();
        }

        private void DELETE_Click(object sender, RoutedEventArgs e1)
        {
            Domain.Employee e = (Domain.Employee)dgEmployee.SelectedItem;
            e.delete();

            ((List<Domain.Employee>)dgEmployee.ItemsSource).Remove(e);
            dgEmployee.Items.Refresh();
        }
    }
}
