using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Prueba.Persistence.DataBase
{
    internal class DataBase
    {
        private static DataBase instance;
        private static MySql.Data.MySqlClient.MySqlConnection conection;
        private const String stringConection = "server=localhost;database=mydb;uid=root;pwd=1234";

        private DataBase()
        {
            DataBase.conection = new MySql.Data.MySqlClient.MySqlConnection(DataBase.stringConection);
        }

        private void connect()
        {
            if (DataBase.conection.State == System.Data.ConnectionState.Closed)
            {
                DataBase.conection.Open();
            }
        }
        private void disconnect()
        {
            if (DataBase.conection.State == System.Data.ConnectionState.Open)
            {
                DataBase.conection.Close();
            }
        }

        public static DataBase obtainDataBase()
        {
            if (DataBase.instance == null)
            {
                DataBase.instance = new DataBase();
            }
            return DataBase.instance;
        }

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

        public void modify(String sql)
        {
            MySql.Data.MySqlClient.MySqlCommand com = new MySql.Data.MySqlClient.MySqlCommand(sql, DataBase.conection);

            connect();
            com.ExecuteNonQuery();
            disconnect();
        }
    }
}
