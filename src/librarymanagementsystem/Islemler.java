
package librarymanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Islemler {
    
        public static final String  kullanici_adi = "root";
        public static final String parola = "";
        public static final String db_isim = "library_management_system";
        public static final String host = "localhost";
        public static final int port = 3306;
        
         private Connection con = null;
         private Statement statement = null;
         private PreparedStatement preparedStatement = null;
        
    public Islemler(){
         String url = "jdbc:mysql://" + host + ":" + port + "/" + db_isim + "?useUnicode=true&characterEncoding=utf8";
            try{
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println("Driver bulunamadı");
            }
            
            try{
                con = DriverManager.getConnection(url, kullanici_adi, parola);
                System.out.println("Baglantı başarılı");
            } catch (SQLException ex) {
                System.out.println("Baglantı başarısız");
              //  ex.printStackTrace();
            }   
    }
    public boolean loginControl(String username, String password){
        String sorgu = "Select * From admin where username = ? and password = ?";
            try {
                preparedStatement = con.prepareStatement(sorgu);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                ResultSet rs = preparedStatement.executeQuery();
                if (rs.next() == true) {
                    return true;
                }else{
                    return false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
    }
     public boolean userloginControl(int id, String username, String user_password){
        String sorgu = "Select * From user_informations where id = ? and username = ? and user_password = ?";
            try {
                preparedStatement = con.prepareStatement(sorgu);
                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, username);
                preparedStatement.setString(3, user_password);
                ResultSet rs = preparedStatement.executeQuery();
                if (rs.next() == true) {
                    return true;
                }else{
                    return false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
    }
    public ArrayList<Users> getUsers(){
            ArrayList<Users> show = new ArrayList<Users>();
            try {
                statement = con.createStatement();
                String sorgu = "Select * From user_informations";
                ResultSet rs = statement.executeQuery(sorgu);
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String surname = rs.getString("surname");
                    String username = rs.getString("username");
                    String email = rs.getString("email");
                    String date_of_membership = rs.getString("date_of_membership");
                    String phone = rs.getString("phone");
                    String address = rs.getString("address");
                    
                    
                    show.add(new Users(name,surname,username,email,date_of_membership,phone,address,id));
                }
                return show;
            } catch (SQLException ex) {
                Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
    }
    public void addUser(String name, String surname, String username, String email, String date_of_membership, String phone, String address){
               
            String sorgu = "Insert Into user_informations (name,surname,username,email,date_of_membership,phone,address) Values (?,?,?,?,?,?,?)";
            try {
                preparedStatement = con.prepareStatement(sorgu);
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, surname);
                preparedStatement.setString(3, username);
                preparedStatement.setString(4, email);
                preparedStatement.setString(5, date_of_membership);
                preparedStatement.setString(6, phone);
                preparedStatement.setString(7, address);
                preparedStatement.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            }  
    }
    public void updateUser(int id, String name, String surname, String username, String email, String date_of_membership, String phone, String address){
            String sorgu = "Update user_informations Set name=? , surname=?, username=?, email=?, date_of_membership=?, phone=?, address=? where id = ?";
            try {
                preparedStatement = con.prepareStatement(sorgu);  
                
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, surname);
                preparedStatement.setString(3, username);
                preparedStatement.setString(4, email);
                preparedStatement.setString(5, date_of_membership);
                preparedStatement.setString(6, phone);
                preparedStatement.setString(7, address);
                preparedStatement.setInt(8, id); 
                preparedStatement.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            }  
    }
     public void deleteUser(int id){
            String sorgu = "Delete From user_informations where id = ?";
            try {
                preparedStatement = con.prepareStatement(sorgu);  
                 preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            }  
    }
     public ArrayList<Books> getBooks(){
            ArrayList<Books> show = new ArrayList<Books>();
            try {
                statement = con.createStatement();
                String sorgu = "Select * From books";
                ResultSet rs = statement.executeQuery(sorgu);
                while (rs.next()) {
                    int book_id = rs.getInt("book_id");
                    String book_name = rs.getString("book_name");
                    String book_author = rs.getString("book_author");
                    show.add(new Books(book_id,book_name,book_author));
                }
                return show;
            } catch (SQLException ex) {
                Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
    }
    public void addBook(String book_name, String book_author){
               
            String sorgu = "Insert Into books (book_name, book_author) Values (?,?)";
            try {
                preparedStatement = con.prepareStatement(sorgu);
                preparedStatement.setString(1, book_name);
                preparedStatement.setString(2, book_author);
                preparedStatement.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            }  
    }
     public void updateBook(int book_id, String book_name, String book_author){
            String sorgu = "Update books Set book_name=? , book_author=? where book_id = ?";
            try {
                preparedStatement = con.prepareStatement(sorgu);  
                preparedStatement.setInt(3, book_id); 
                preparedStatement.setString(1, book_name);
                preparedStatement.setString(2, book_author);
                
                preparedStatement.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            }  
    } 
      public void deleteBook(int book_id){
            String sorgu = "Delete From books where book_id = ?";
            try {
                preparedStatement = con.prepareStatement(sorgu);  
                 preparedStatement.setInt(1, book_id);
                preparedStatement.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            }  
    }
    public static void main(String[] args) {
        Islemler islemler = new Islemler();
        
    }
}
