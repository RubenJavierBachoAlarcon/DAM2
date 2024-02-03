using MVCPruebaBBDD.Domain;
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
using System.Xml.Linq;

namespace MVCPruebaBBDD
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();

            Person p = new Domain.Person();
            p.readT();

            dgPerson.ItemsSource = p.getListPerson();
        }

        private void dgPerson_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            if (dgPerson.SelectedItems.Count == 1)
            {
                Person p = (Person) dgPerson.SelectedItems[0];

                FIRSTNAME.Text = p.firstName;
                LASTNAME.Text = p.lastName;
                BIRTHDATE.Text = p.birthDate;
                ISSTUDENT.IsChecked = p.isStudent;
            }
        }

        private void NEW_Click(object sender, RoutedEventArgs e)
        {
            if (ShowConfirmation("Are you sure you want to add a new person?"))
            {
                Person p = new Person();
                p.insert();

                ((List<Person>)dgPerson.ItemsSource).Add(p);
                dgPerson.Items.Refresh();
            }
        }

        private void DELETE_Click(object sender, RoutedEventArgs e)
        {
            Person t = (Person)dgPerson.SelectedItem;

            if (t != null && ShowConfirmation("Are you sure you want to delete this person?"))
            {
                t.delete();

                ((List<Person>)dgPerson.ItemsSource).Remove(t);
                dgPerson.Items.Refresh();
            }
        }

        private void SAVE_Click(object sender, RoutedEventArgs e)
        {
            Person t = (Person)dgPerson.SelectedItem;

            if (t != null && ShowConfirmation("Are you sure you want to save changes?"))
            {
                t.firstName = FIRSTNAME.Text;
                t.lastName = LASTNAME.Text;
                t.birthDate = BIRTHDATE.Text; // Note: You may want to convert this to DateTime
                t.isStudent = ISSTUDENT.IsChecked ?? false;
                t.update();

                dgPerson.Items.Refresh();
            }
        }

        private bool ShowConfirmation(string message)
        {
            MessageBoxResult result = MessageBox.Show(message, "Confirmation", MessageBoxButton.YesNo, MessageBoxImage.Question);
            return result == MessageBoxResult.Yes;
        }


    }
}
