using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DI_Ejercicio_4_Squid_Game.Persistance.DataBaseFolder
{
    /// <summary>
    /// Represents a database connection and operations.
    /// </summary>
    class DataBase
    {
        /// <summary>
        /// Singleton instance of the DataBase class.
        /// </summary>
        private static DataBase instance;

        /// <summary>
        /// MySQL connection object.
        /// </summary>
        private static MySql.Data.MySqlClient.MySqlConnection conection;

        /// <summary>
        /// Connection string to the MySQL database.
        /// </summary>
        private const String stringConection = "server=localhost;database=mydb;uid=root;pwd=1234";

        /// <summary>
        /// Private constructor that initializes the MySQL connection.
        /// </summary>
        private DataBase()
        {
            DataBase.conection = new MySql.Data.MySqlClient.MySqlConnection(DataBase.stringConection);
        }

        /// <summary>
        /// Opens the database connection if it is closed.
        /// </summary>
        private void connect()
        {
            if (DataBase.conection.State == System.Data.ConnectionState.Closed)
            {
                DataBase.conection.Open();
            }
        }

        /// <summary>
        /// Closes the database connection if it is open.
        /// </summary>
        private void disconnect()
        {
            if (DataBase.conection.State == System.Data.ConnectionState.Open)
            {
                DataBase.conection.Close();
            }
        }

        /// <summary>
        /// Returns the singleton instance of the DataBase class, creating it if it doesn't exist.
        /// </summary>
        public static DataBase obtainDataBase()
        {
            if (DataBase.instance == null)
            {
                DataBase.instance = new DataBase();
            }
            return DataBase.instance;
        }

        /// <summary>
        /// Executes a SQL SELECT command and returns the result as a list of rows.
        /// </summary>
        public List<List<Object>> read(String sql)
        {
            List<List<Object>> allRows = new List<List<Object>>();
            List<Object> row;

            MySql.Data.MySqlClient.MySqlDataReader reader;
            MySql.Data.MySqlClient.MySqlCommand com = new MySql.Data.MySqlClient.MySqlCommand(sql, DataBase.conection);

            connect();
            reader = com.ExecuteReader();

            while (reader.Read())
            {
                row = new List<Object>();
                for (int i = 0; i < reader.FieldCount; i++)
                {
                    row.Add(reader[i].ToString());
                }
                allRows.Add(row);
            }
            disconnect();

            return allRows;
        }

        /// <summary>
        /// Executes a SQL INSERT, UPDATE, or DELETE command.
        /// </summary>
        public void modify(String sql)
        {
            MySql.Data.MySqlClient.MySqlCommand com = new MySql.Data.MySqlClient.MySqlCommand(sql, DataBase.conection);

            connect();
            com.ExecuteNonQuery();
            disconnect();
        }
    }
}
