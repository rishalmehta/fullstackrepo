namespace MYPRACTICE.webapi1.DAL;

using MYPRACTICE.webapi1.POCO;
using System.Data;
using MySql.Data.MySqlClient;

public class dataaccess{
    
    public static List<user> userlist=new List<user>();

    public static string constring = @"server=localhost; port=3306; user=root; password=root123; database=userinfo";

    //reading all data from database
    public static List<user> GetAllUser(){
         MySqlConnection con = new MySqlConnection(constring);
         //List<user> userlist=new List<user>();

         try{
            string query="select * from users";
            DataSet ds=new DataSet();
            MySqlCommand cmd=new MySqlCommand(query,con);
            MySqlDataAdapter dat=new MySqlDataAdapter(cmd);
            dat.Fill(ds);

            DataTable dtable=ds.Tables[0];
            DataRowCollection rows=dtable.Rows;

            foreach(DataRow row in rows){
                user user=new user{
                    userid=int.Parse(row["userid"].ToString()),
                    username=row["username"].ToString(),
                    course=row["course"].ToString(),
                    purchasedate=(row["purchasedate"].ToString())
                };

                userlist.Add(user);
            }
         }catch(Exception err){
            Console.WriteLine(err.Message);
         }
         return userlist;
    }

    //finding and providing 1 data from database
    public static user GetUserById(int id){

        user userobj=null;
        MySqlConnection conn=new MySqlConnection(constring);
        try{
            conn.Open();
            string idquery="select * from users where userid="+id;
            MySqlCommand cmmd=new MySqlCommand(idquery,conn);
            MySqlDataReader reader = cmmd.ExecuteReader();

            if(reader.Read())
            {
                userobj =new user{
                    userid=int.Parse(reader["userid"].ToString()),
                    username=(reader["username"].ToString()),
                    course=(reader["course"].ToString()),
                    purchasedate=(reader["purchasedate"].ToString())
                };
            }
        }catch(Exception err){
            Console.WriteLine(err.Message);
        }
        finally{
            conn.Close();
        }
        return userobj;
    }


    //to save new user
    public static void AddNewUser(user newusr){
        MySqlConnection conn=new MySqlConnection(constring);

        try{
            conn.Open();
            string newquery=$"insert into users( username,course,purchasedate) values('{newusr.username}','{newusr.course}','{newusr.purchasedate}')";
            MySqlCommand cmd=new MySqlCommand(newquery,conn);
            cmd.ExecuteNonQuery();
            conn.Close();


        }catch(Exception err){
            Console.WriteLine(err.Message);
        }
        finally{
            conn.Close();
        }
    }

    //delete user
    public static void DeleteUser(int id){
        MySqlConnection conn=new MySqlConnection(constring);
        try{
            conn.Open();
            string newquery="delete from users where userid ="+id;
            MySqlCommand cmd=new MySqlCommand(newquery,conn);
            cmd.ExecuteNonQuery();
            conn.Close();
            
        }catch(Exception err){
            Console.WriteLine(err.Message);
        }
        finally{
            conn.Close();
        }
    }

}

