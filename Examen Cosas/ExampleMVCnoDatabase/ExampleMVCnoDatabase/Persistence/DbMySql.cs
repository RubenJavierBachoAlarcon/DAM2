using System;
using System.CodeDom;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Media;
using System.Xml;

namespace ExampleMVCnoDatabase.Persistence
{
    public class DbMySql
    {
        private static DbMySql instance;
        private static MySql.Data.MySqlClient.MySqlConnection conection;
        private const String conectionString = "server=localhost;database=mydb;uid=root;pwd=1234";

        private DbMySql()
        {
            conection = new MySql.Data.MySqlClient.MySqlConnection(DbMySql.conectionString);
        }
        private void connect()
        {
            if (conection.State == System.Data.ConnectionState.Closed)
            {
                conection.Open();
            }
        }
        private void disconnect()
        {
            if (conection.State == System.Data.ConnectionState.Open)
            {
                conection.Close();
            }
        }

        public static DbMySql obtainDB()
        {
            if (instance == null)
            {
                instance = new DbMySql();
            }
            return instance;
        }

        public List<List<Object>> read(String sql)
        {
            List<List<Object>> allRows = new List<List<Object>>();
            List<Object> row;

            MySql.Data.MySqlClient.MySqlDataReader reader;
            MySql.Data.MySqlClient.MySqlCommand cmd = new MySql.Data.MySqlClient.MySqlCommand(sql, conection);

            connect();
            reader = cmd.ExecuteReader();

            while (reader.Read())
            {
                row = new List<Object>();

                for (int i = 0; i < reader.FieldCount; i++)
                {
                    row.Add(reader.GetValue(i));
                }

                allRows.Add(row);
            }

            disconnect();
            return allRows;
        }

        public void modify(String sql)
        {
            MySql.Data.MySqlClient.MySqlCommand cmd = new MySql.Data.MySqlClient.MySqlCommand(sql, conection);

            connect();
            cmd.ExecuteNonQuery();
            disconnect();
        }
    }
}



