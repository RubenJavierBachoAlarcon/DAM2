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

        People peopleMain;
        public MainWindow()
        {
            InitializeComponent();

            New.IsEnabled = false;
            Save.IsEnabled = false;

            peopleMain = new People();
            peopleMain.readP();
            dgvPeople.ItemsSource = peopleMain.getListPeople();

            Delete.IsEnabled = false;
            Save.IsEnabled = false;
        }

        private void dgvPeople_SelectionChangedGridPosition(object sender, SelectionChangedEventArgs e)
        {
            if (dgvPeople.SelectedIndex != -1)
            {
                Save.IsEnabled = true;
                Delete.IsEnabled = true;
                People people = (People)dgvPeople.SelectedItem;
                Name.Text = people.name;
                Age.Text = people.age.ToString();
            }
            else
            {
                Delete.IsEnabled = false;
                Save.IsEnabled = false;
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
            try
            {
                if (MessageBox.Show("Are you sure you want to add this person?",
                "Confirmation",
                MessageBoxButton.YesNo,
                MessageBoxImage.Warning) == MessageBoxResult.Yes)
                {
                    List<People> listPeople = (List<People>)dgvPeople.ItemsSource;
                    listPeople.Add(new People(Name.Text, int.Parse(Age.Text)));
                    for (int i = 0; i < listPeople.Count; i++)
                    {

                        Traza.Text += listPeople[i].name + " " + listPeople[i].age + "\n";
                    }
                    dgvPeople.Items.Refresh();

                    Name.Text = "";
                    Age.Text = "";

                    //Create a row with empty parametres (name, age) in the table grid
                    dgvPeople.SelectedIndex = -1;
                }
            } catch (FormatException ex)
            {
                MessageBox.Show("The age must be a integer", "Error");
            }
        }

        private void ClickDeleteButton(object sender, RoutedEventArgs e)
        {
            
            if (MessageBox.Show("Are you sure you want to delete this person?",
                "Confirmation", 
                MessageBoxButton.YesNo, 
                MessageBoxImage.Warning) == MessageBoxResult.Yes)
            {
                // El usuario confirmó la eliminación

                // Remove row from table grid
                String selectedIndex = dgvPeople.SelectedIndex.ToString();

                List<People> listPeople = (List<People>)dgvPeople.ItemsSource;
                listPeople.RemoveAt(dgvPeople.SelectedIndex);

                dgvPeople.Items.Refresh();

                // Remove the complete content of the selected row from the table grid
                // dgvPeople.Items.RemoveAt(dgvPeople.SelectedIndex);
            }

        }

        private void ClickSaveButton(object sender, RoutedEventArgs e)
        {
            try
            {
                if (MessageBox.Show("Are you sure you want to save this person?",
                "Confirmation",
                MessageBoxButton.YesNo,
                MessageBoxImage.Warning) == MessageBoxResult.Yes)
                {
                    String selectedIndex = dgvPeople.SelectedIndex.ToString();

                    List<People> listPeople = (List<People>)dgvPeople.ItemsSource;
                    listPeople[dgvPeople.SelectedIndex].name = Name.Text;
                    listPeople[dgvPeople.SelectedIndex].age = int.Parse(Age.Text);

                    dgvPeople.Items.Refresh();
                }
            }
            catch (FormatException ex)
            {
                MessageBox.Show("La edad debe ser un número entero.", "Error");
            }
        }

        private void TextBox_TextChanged(object sender, TextChangedEventArgs e)
        {

        }

        private void Name_TextChanged(object sender, TextChangedEventArgs e)
        {
            
            if (Name.Text == "" || Age.Text == "")
            {
                New.IsEnabled = false;
                Save.IsEnabled = false;
            }
            else
            {
                New.IsEnabled = true;
                Save.IsEnabled = true;
            }
            
            
        }

        private void Age_TextChanged(object sender, TextChangedEventArgs e)
        {
            if (Name.Text == "" || Age.Text == "")
            {
                New.IsEnabled = false;
                Save.IsEnabled = false;
            }
            else
            {
                New.IsEnabled = true;
                Save.IsEnabled = true;
            }
        }
    }
}
