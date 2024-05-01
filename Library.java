/*    LIBRARY MANAGEMENT SYSTEM   */
import java.awt.*;
import java.awt.event.*;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat; 
import java.util.Date; 
import java.sql.*;

public class Library 
{
  static Label uname;
  static TextField uname1,add1,cname1,Mno1;
  static Font font;
    Library()
    {
      Frame fr=new Frame();
      fr.setLayout(null);
      fr.setVisible(true);
      fr.setTitle("LIBRARY");
      fr.setSize(700,700);
      Color formColor = new Color(53, 59, 72);
      fr.setBackground(formColor);

      Label title =new Label("LIBRARY MANAGEMENT SYSTEM");
      title.setForeground(Color.YELLOW);
      font= new Font("Courier", Font.BOLD, 20);
      title.setFont(font);
      title.setBounds(130,70, 330, 40);
      fr.add(title);
        
      Label uname=new Label("Enter your name: ");
      font= new Font("Courier", Font.TRUETYPE_FONT, 18);
      uname.setFont(font);
      uname.setForeground(Color.WHITE);
      uname.setBounds(130,150,300,40);
      fr.add(uname);

      uname1=new TextField();
      font= new Font("Courier", Font.PLAIN, 15);
      uname1.setFont(font);
      uname1.setBounds(450,150,150,40);
      fr.add(uname1);

      Label cname=new Label("Enter your college name: ");
      font= new Font("Courier", Font.TRUETYPE_FONT, 18);
      cname.setFont(font);
      cname.setForeground(Color.WHITE);
      cname.setBounds(130,210,300,40);
      fr.add(cname);

      cname1=new TextField();
      font= new Font("Courier", Font.PLAIN, 15);
      cname1.setFont(font);
      cname1.setBounds(450,210,150,40);
      fr.add(cname1);

      Label Mno=new Label("Enter Registration number:");
      font= new Font("Courier", Font.TRUETYPE_FONT, 18);
      Mno.setFont(font);
      Mno.setForeground(Color.WHITE);
      Mno.setBounds(130,280,300,40);
      fr.add(Mno);

      Mno1=new TextField();
      font= new Font("Courier", Font.PLAIN, 15);
      Mno1.setFont(font);
      Mno1.setBounds(450,280,150,40);
      fr.add(Mno1);

      Button faculty=new Button(" Faculty ");
      font= new Font("Courier", Font.TRUETYPE_FONT, 20);
      faculty.setFont(font);
      faculty.setBounds(180,430,90,50);
      faculty.setBackground(Color.BLUE);
      faculty.setForeground(Color.WHITE);
      fr.add(faculty);
      faculty.addActionListener(
          new ActionListener() {
              public void actionPerformed(ActionEvent e) {  
                fr.dispose();
				String c=Library.cname1.getText();
                String s=Library.uname1.getText();
                String a=Library.Mno1.getText();
                JOptionPane.showMessageDialog(fr,"hello "+ s +" Roll Number : "+a);
                choice obj=new choice(a);  
				String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/Library";
        String username ="21331A0592";
		String password ="Ktanooj_592";

        // JDBC variables for managing the connection and executing queries
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // 1. Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish the connection
            connection = DriverManager.getConnection(jdbcUrl, username, password);

            // 3. Define the SQL insert statement
            String insertSQL = "INSERT INTO Logbook (Name, College, RegdNo, Role, Time) VALUES (?, ?, ?, ?, Now())";

            // 4. Create a prepared statement
            preparedStatement = connection.prepareStatement(insertSQL);

            // 5. Set the values for the placeholders in the SQL statement
            preparedStatement.setString(1, s);
			preparedStatement.setString(2, c);
			preparedStatement.setString(3, a);
			preparedStatement.setString(4, "Faculty");
            // 6. Execute the insert statement
            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("A new row has been inserted successfully.");
            }

        } catch (SQLException | ClassNotFoundException e1) {
            e1.printStackTrace();
        } finally {
            // 7. Close the connection and resources
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
              }
            }
         );

      Button student=new Button(" Student ");
      font= new Font("Courier", Font.TRUETYPE_FONT, 20);
      student.setFont(font);
      student.setBounds(380,430,90,50);
      student.setBackground(Color.BLUE);
      student.setForeground(Color.WHITE);
      fr.add(student);
      student.addActionListener(
          new ActionListener() {
              public void actionPerformed(ActionEvent e) {  
                fr.dispose();
                String c=Library.cname1.getText();
                String s=Library.uname1.getText();
                String a=Library.Mno1.getText();
                JOptionPane.showMessageDialog(fr,"hello "+ s +" Roll Number : "+a);
               choice obj2=new choice(a); 
String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/Library";
        String username ="21331A0592";
		String password ="Ktanooj_592";

        // JDBC variables for managing the connection and executing queries
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // 1. Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish the connection
            connection = DriverManager.getConnection(jdbcUrl, username, password);

            // 3. Define the SQL insert statement
            String insertSQL = "INSERT INTO Logbook (Name, College, RegdNo, Role, Time) VALUES (?, ?, ?, ?, Now())";

            // 4. Create a prepared statement
            preparedStatement = connection.prepareStatement(insertSQL);

            // 5. Set the values for the placeholders in the SQL statement
            preparedStatement.setString(1, s);
			preparedStatement.setString(2, c);
			preparedStatement.setString(3, a);
			preparedStatement.setString(4, "Student");
            // 6. Execute the insert statement
            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("A new row has been inserted successfully.");
            }

        } catch (SQLException | ClassNotFoundException e4) {
            e4.printStackTrace();
        } finally {
            // 7. Close the connection and resources
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e5) {
                e5.printStackTrace();
            }
        }			   
              }
           }
         );

       
      fr.addWindowListener(
          new WindowAdapter() {
            public void windowClosing(WindowEvent e)
            {
              fr.dispose();
            }
          }
        );
    }

  public static void main(String[] args) throws ClassNotFoundException
  {
	Connection conn = null;
Statement stmt = null;
ResultSet rs = null;
String TableName;
try {
    String username = "21331A0592";
    String password = "Ktanooj_592";
    String url = "jdbc:mysql://127.0.0.1:3306/Library";
    Class.forName("com.mysql.cj.jdbc.Driver");
    conn = DriverManager.getConnection(url, username, password);
    stmt = conn.createStatement();

    // Create Logbook table
    stmt.execute("CREATE TABLE IF NOT EXISTS Logbook (" +
                 "ID INT AUTO_INCREMENT PRIMARY KEY, " +
                 "Name VARCHAR(30), " +
                 "College VARCHAR(30), " +
                 "RegdNo VARCHAR(30), " +
                 "Role VARCHAR(30), " +
                 "Time DATETIME)");

    // Print a message indicating that the Logbook table creation is done
    System.out.println("Logbook table created successfully.");

    // Create BookStatus table
    stmt.execute("CREATE TABLE IF NOT EXISTS BookStatus (" +
                 "ID INT AUTO_INCREMENT PRIMARY KEY, " +
                 "RegdNo VARCHAR(30), " +
                 "Book VARCHAR(30), " +
                 "Taken DATETIME DEFAULT NULL, " +
                 "Submit DATETIME DEFAULT NULL)");

    // Print a message indicating that the BookStatus table creation is done
    System.out.println("BookStatus table created successfully.");

} catch (SQLException ex) {
    System.out.println("SQLException: " + ex.getMessage());
    System.out.println("SQLState: " + ex.getSQLState());
    System.out.println("VendorError: " + ex.getErrorCode());
} catch (ClassNotFoundException ex) {
    ex.printStackTrace(); // Handle ClassNotFoundException separately
} finally {
    try {
        if (rs != null) rs.close();
        if (stmt != null) stmt.close();
        if (conn != null) conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    Library obj1=new Library();
  }
}

//Click the chioce that you want.

class choice 
{
  Label msg;
  Font font;
  choice(String name) 
  {

    Frame f=new Frame();

    Label choice1=new Label("Click your Choice");
    font= new Font("Courier", Font.CENTER_BASELINE, 20);
    choice1.setFont(font);
    choice1.setBounds(120,80,220,40);
    choice1.setBackground(Color.WHITE);
    f.add(choice1);

    Button b1=new Button("Request Book");
    font= new Font("Courier", Font.CENTER_BASELINE, 20);
    b1.setFont(font);
    b1.setBackground(Color.ORANGE);
    b1.setBounds(40,180,185,50);
    f.add(b1);
    
    b1.addActionListener(
      new ActionListener() {
       public void actionPerformed(ActionEvent e)
       {
          f.dispose();
          Request R=new Request(name);
        }
      }
    );

    Button b2=new Button("Book Return");
    font= new Font("Courier", Font.CENTER_BASELINE, 18);
    b2.setFont(font);
    b2.setBackground(Color.CYAN);
    b2.setBounds(260,180,165,50);
    f.add(b2);
    b2.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e)
        {
          f.dispose();
          Return R=new Return(name);
        }
      }
    );

    Button b3=new Button("View Books");
    font= new Font("Courier", Font.CENTER_BASELINE, 18);
    b3.setFont(font);
    b3.setBackground(Color.PINK);
    b3.setBounds(40,280,185,50);
    f.add(b3);

    b3.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e)
        {
          f.dispose();
          viewBooks vb=new viewBooks(name);
        }
      }
    );

    Button b4=new Button(" EXIT ");
    font= new Font("Courier", Font.CENTER_BASELINE, 18);
    b4.setFont(font);
    b4.setBackground(Color.GREEN);
    b4.setBounds(260,280,165,50);
    f.add(b4);

    b4.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e)
        {
          System.exit(0);
        }
      }
    );

    f.setBackground(new Color(0xfff0f0f0));
    f.setTitle("CHOICES");
    f.setSize(500,500);
    f.setLayout(null);
    f.setVisible(true);

    f.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent we) {
          f.dispose();
      }
      });
  }
}

// Request for book

class Request{
  Font font;
  Request(String name)
  {
    Frame f1=new Frame();
    f1.setTitle("Request for book");
    String[] BookList={"C++","Java","Python","C","DataStructure"};
    Label bookname=new Label("Enter Book Name");
    font= new Font("Courier", Font.PLAIN, 17);
    bookname.setFont(font);
    bookname.setForeground(Color.BLUE);
    bookname.setBounds(30, 60, 160,40);
    f1.add(bookname);

    TextField bookname1=new TextField();
    font= new Font("Courier", Font.PLAIN, 15);
    bookname1.setFont(font);
    bookname1.setBounds(200, 60, 130,40);
    f1.add(bookname1);
	
    Button submit=new Button("Submit");
    font= new Font("Courier", Font.CENTER_BASELINE, 20);
    submit.setFont(font);
    submit.setBounds(150, 150, 100, 30);
    f1.add(submit);
    
    submit.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e)
        {
          int i;
          for(i=0;i<BookList.length;i++){
          if(bookname1.getText().equals(BookList[i]))
          {	String b = bookname1.getText();
            JOptionPane.showMessageDialog(f1,"Book Available");
            SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date=new Date();
	          String dt=formatter.format(date);
              JOptionPane.showMessageDialog(f1,"Date and Time of Book issue "+dt);
			
		String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/Library";
        String username ="21331A0592";
		String password ="Ktanooj_592";

        // JDBC variables for managing the connection and executing queries
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // 1. Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish the connection
            connection = DriverManager.getConnection(jdbcUrl, username, password);

            // 3. Define the SQL update statement
            String updateSQL ="INSERT INTO BookStatus (RegdNo, Book, Taken) VALUES (?, ?, Now())";


            // 4. Create a prepared statement
            preparedStatement = connection.prepareStatement(updateSQL);

            // 5. Set the values for the placeholders in the SQL statement
            preparedStatement.setString(1, name); // Replace with the new age
            preparedStatement.setString(2, b); // Replace with the name to update

            // 6. Execute the update statement
            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Existing data has been updated successfully.");
            } else {
                System.out.println("No data found to update.");
            }

        } catch (SQLException | ClassNotFoundException e6) {
            e6.printStackTrace();
        } finally {
            // 7. Close the connection and resources
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e7) {
                e7.printStackTrace();
            }
        }
          
            break;
          }
          
        }
        if(i==BookList.length){
          JOptionPane.showMessageDialog(f1,"Book is not Available","Check",JOptionPane.ERROR_MESSAGE);
        }
        Label msg2=new Label(" Do You Want To Continue ");
        font= new Font("Courier", Font.CENTER_BASELINE, 19);
         msg2.setFont(font);
         msg2.setForeground(Color.BLUE);
            msg2.setBounds(80,230,250,30);
            f1.add(msg2);
           CheckboxGroup cbg=new CheckboxGroup();
           Checkbox yes=new Checkbox("YES",cbg,false);
           font= new Font("Courier", Font.BOLD, 18);
           yes.setFont(font);
           yes.setForeground(Color.BLUE);
           yes.setBounds(140, 280, 50, 30);
           f1.add(yes);
           yes.addItemListener(new ItemListener() {    
            public void itemStateChanged(ItemEvent e) {   
                new choice(name);   
                f1.dispose();
             }
          }
          
          );
           Checkbox no1=new Checkbox("NO",cbg,false);
           no1.setBounds(220, 280, 50, 30);
           font= new Font("Courier", Font.BOLD, 18);
           no1.setFont(font);
           no1.setForeground(Color.BLUE);
           f1.add(no1);
           no1.addItemListener(new ItemListener() {    
            public void itemStateChanged(ItemEvent e) {   
                f1.dispose();           
             }
          }
         );

        }
      }
    );
    

    f1.setSize(400,400);
    f1.setLayout(null);
    f1.setBackground(new Color(0xfff0f0f0));
    f1.setVisible(true);
    f1.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent we) {
          f1.dispose();
      }
      });
  }
}

//Book Returned

class Return 
{
  Font font;
  Return(String name)
  {
    Frame f2=new Frame();
    String[] BookList={"C++","Java","Python","C","DataStructure"};

    Label rebookname=new Label("Enter Book Name");
    font= new Font("Courier", Font.PLAIN, 16);
    rebookname.setFont(font);
    rebookname.setBounds(30, 60, 220,40);
    f2.add(rebookname);

    TextField rebookname1=new TextField();
    font= new Font("Courier", Font.PLAIN, 15);
    rebookname1.setFont(font);
    rebookname1.setBounds(270, 60, 130,40);
    f2.add(rebookname1);

    Button return1=new Button("Return");
    font= new Font("Courier", Font.CENTER_BASELINE, 20);
    return1.setFont(font);
    return1.setBounds(150, 150, 110, 30);
    f2.add(return1);

    return1.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e)
        {
          int i;
          for(i=0;i<BookList.length;i++){
          if(rebookname1.getText().equals(BookList[i]))
          {
            SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date=new Date();
	          String dt=formatter.format(date);
			  String b = rebookname1.getText();
			String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/Library";
        String username ="21331A0592";
		String password ="Ktanooj_592";

        // JDBC variables for managing the connection and executing queries
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // 1. Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish the connection
            connection = DriverManager.getConnection(jdbcUrl, username, password);

            // 3. Define the SQL update statement
            String updateSQL = "UPDATE BookStatus SET Submit = NOW() WHERE RegdNo = ? AND Book = ? AND Submit IS NULL AND Taken IS NOT NULL";

            // 4. Create a prepared statement
            preparedStatement = connection.prepareStatement(updateSQL);

            // 5. Set the values for the placeholders in the SQL statement
            preparedStatement.setString(1, name); // Replace with the new age
            preparedStatement.setString(2, b); // Replace with the name to update

            // 6. Execute the update statement
            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated > 0) {
				JOptionPane.showMessageDialog(f2,"Book Returned");
                System.out.println("Existing data has been updated successfully.");
				JOptionPane.showMessageDialog(f2,"Date and Time of Book Return "+dt);
            } else {
                System.out.println("No data found to update.");
				JOptionPane.showMessageDialog(f2,"Book is not taken ");
            }

        } catch (SQLException | ClassNotFoundException e8) {
            e8.printStackTrace();
        } finally {
            // 7. Close the connection and resources
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e9) {
                e9.printStackTrace();
            }
        }
            break;
          }
          }
         if(i==BookList.length){
          JOptionPane.showMessageDialog(f2," This Book is not in Library ","Check",JOptionPane.ERROR_MESSAGE);
         }

          Label remsg2=new Label("Do you want to continue");
          font= new Font("Courier", Font.CENTER_BASELINE, 19);
          remsg2.setFont(font);
          remsg2.setBounds(80,230,250,30);
          f2.add(remsg2);
