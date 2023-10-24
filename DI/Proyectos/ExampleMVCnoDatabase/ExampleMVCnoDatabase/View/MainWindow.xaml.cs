using ExampleMVCnoDatabase.Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Sockets;
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

namespace ExampleMVCnoDatabase
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            People people = new People();
            people.readP();
            dgvPeople.ItemsSource = people.getListPeople();
        }

        private void dgvPeople_SelectionChangedGridPosition(object sender, SelectionChangedEventArgs e)
        {
            if (dgvPeople.SelectedIndex != -1)
            {
                People people = (People)dgvPeople.SelectedItem;
                Name.Text = people.name;
                Age.Text = people.age.ToString();
                
            }
        }

        private void btnExample_Click(object sender, RoutedEventArgs e)
        {
            MessageBox.Show("Perfect I love C#");
        }

        private void ClickButton(object sender, RoutedEventArgs e)
        {

        }

        private void ClickNewButton(object sender, RoutedEventArgs e)
        {

        }

        private void ClickDeleteButton(object sender, RoutedEventArgs e)
        {

        }

        private void ClickSaveButton(object sender, RoutedEventArgs e)
        {

        }

        private void TextBox_TextChanged(object sender, TextChangedEventArgs e)
        {

        }
    }
}
