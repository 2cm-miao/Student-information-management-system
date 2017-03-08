package student;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Dictionary;
import java.util.Scanner;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

public class Student extends JFrame implements ActionListener{
	
	private static final String DRIVER="oracle.jdbc.driver.OracleDriver";
	private static final String URL="jdbc:oracle:thin:@localhost:1521/orcl";
	private static final String USERNAME="C##ZCM";
	private static final String PASSWORD="root";
	private static Connection conn=null;
	private static Statement sta=null;
	private static ResultSet res=null;
	
	final JTextField textp=new JTextField();
	final JPasswordField pass=new JPasswordField();
	final FlowLayout flow=new FlowLayout();
	final BorderLayout bor=new BorderLayout();
	final JButton button1=new JButton();
	final JButton button2=new JButton();
	final JButton button3=new JButton();
	final JButton button4=new JButton();
	final JButton button=new JButton();
	
	final JTextField tno=new JTextField();
	final JTextField tname=new JTextField();
	final JTextField tsex=new JTextField();
	final JTextField tscssj=new JTextField();
	final JTextField tsources=new JTextField();
	final JTextField tsour=new JTextField();
	final JTextField tscor=new JTextField();
	
	Li lis=new Li();
	Field[] fi=lis.getClass().getDeclaredFields();
	
	JTable tables;
	JScrollPane scro;
	
	String[][] lnames=new String[20][20];
	String[] cname={"Student ID","Name","Sex","Course Name","Birthday","Number of Course","Mark"};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student stu=new Student();
		stu.setVisible(true);
	}
	
	public Student()
	{
		super.setTitle("login");
		super.setBounds(400, 300, 400, 230);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setLayout(null);
		
		final JLabel label=new JLabel();
		final JLabel label1=new JLabel();
		label.setBounds(80, 40, 100, 20);
		label1.setBounds(80, 90, 100, 20);
		label1.setText("password  ");
		label.setText("User Name ");
		label.setHorizontalTextPosition(JLabel.CENTER);
		label1.setHorizontalTextPosition(JLabel.CENTER);
		super.add(label1);
		super.add(label);
		
		textp.setBounds(180, 40, 110, 20);
		textp.setEditable(true);
	
		pass.setEchoChar('*');
		pass.setBounds(180, 90, 110, 20);

		Scanner scan=new Scanner(System.in);

		super.add(textp);
		super.add(pass);
		
		button.setBounds(130, 140, 100, 30);
		button.setText("login");
		super.add(button);
		button.setActionCommand("login");
		button.addActionListener(this);
	}

	public void des(String str,int x,int y)
	{
		try {
			Class.forName(DRIVER);
			conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);
			sta=conn.createStatement();
			
			String sql="select "+str+" from student ,score where student.sno=score.num";
			res=sta.executeQuery(sql);
			
			while(res.next())
			{
				lnames[x][y]=res.getString(1);
				x++;
				//System.out.print(res.getString(1)+"  ");
			}
			//System.out.println();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				sta.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("lalalla");
		Student stu=new Student();
		String stru=textp.getText();          //get user name
		char strp[]=pass.getPassword();       
		String strpa=new String(strp);        //get password
		
		if("cm".equals(stru)&&"123".equals(strpa))  
		{
			stu.mainboard();
			this.dispose();
		}
		else
		{
			textp.setText(null);
			pass.setText(null);
			JOptionPane.showMessageDialog(null, "user name or password is wrong,please login again!");
		}
	}
	
	public void mainboard()
	{	
		final JFrame fra=new JFrame();
		fra.setTitle("student information management system");
		fra.setBounds(150, 150, 800, 500);
		fra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fra.setLayout(null);
		fra.setVisible(true);
		
		//add button
		button1.setText("ADD");
		button2.setText("DELETE");
		button3.setText("CHAGNE");
		button4.setText("QUERY");
		
		button1.setBounds(680, 200, 85, 20);
		button2.setBounds(680, 250, 85, 20);
		button3.setBounds(680, 300, 85, 20);
		button4.setBounds(680, 350, 85, 20);
		
		fra.add(button1);
		fra.add(button2);
		fra.add(button3);
		fra.add(button4);
		
		//deine and add label
		final JLabel lname=new JLabel();
		final JLabel lno=new JLabel();
		final JLabel lsex=new JLabel();
		final JLabel lscssj=new JLabel();
		final JLabel lsoures=new JLabel();
		final JLabel lsour=new JLabel();
		final JLabel lscor=new JLabel();
		
		lname.setBounds(50, 40, 100, 20);
		lno.setBounds(250, 40, 100, 20);
		lsex.setBounds(50, 80, 100, 20);
		lscssj.setBounds(250, 80, 100, 20);
		lsoures.setBounds(50, 120, 200, 20);
		lsour.setBounds(500, 40, 100, 20);
		lscor.setBounds(500, 80, 100, 20);
		
		lname.setText("Name ");
		lno.setText("Student ID");
		lsex.setText("Sex");
		lscssj.setText("Date of Birth");
		lsoures.setText("Number of Elective Courses");
		lsour.setText("Course Name");
		lscor.setText("Mark");
		
		fra.add(lname);
		fra.add(lno);
		fra.add(lsex);
		fra.add(lscssj);
		fra.add(lsoures);
		fra.add(lsour);
		fra.add(lscor);
		
		//define and add edit
		tname.setBounds(100, 40, 100, 20);
		tsex.setBounds(100, 80, 100, 20);
		tno.setBounds(350, 40, 100, 20);
		tscssj.setBounds(350, 80, 100, 20);
		tsour.setBounds(600, 40, 100, 20);
		tscor.setBounds(600, 80, 100, 20);
		tsources.setBounds(230, 120, 100, 20);
		
		fra.add(tname);
		fra.add(tsex);
		fra.add(tno);
		fra.add(tscssj);
		fra.add(tsour);
		fra.add(tscor);
		fra.add(tsources);
		
		Student stu=new Student();
		stu.clea(fra);
		
		button4.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				qur(fra);
			}
			
		});
		
		button1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				up(fra);
			}
			
		});
		
		button2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				del(fra);
			}
			
		});
		
		button3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				change(fra);
			}
			
		});
	}
	
	public void clea(JFrame fr)
	{
		try {
			Class.forName(DRIVER);
			conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);
			sta=conn.createStatement();
			
			int f=0;
			for(int i=0;i<fi.length;i++)
			{
				des(fi[i].getName(),0,f);
				f++;
			}
			
			tables=new JTable(lnames,cname);
			scro=new JScrollPane(tables);

			scro.setBounds(16, 160, 650, 250);
			fr.add(scro);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			try {
				sta.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void change(JFrame fr)
	{
		try {
			Class.forName(DRIVER);
			conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);
			sta=conn.createStatement();
			
			String stno=tno.getText();
			String stname=tname.getText();
			String stsex=tsex.getText();
			String stcssj=tscssj.getText();
			String stscor=tscor.getText();
			String stsources=tsources.getText();
			String stsour=tsour.getText();
			
			int f=0;
			if(!"".equals(stno))
			{
				String sql="";
				if(!"".equals(stname))
				{
					sql="update student set sname='"+stname+"' where sno='"+stno+"'";
					f=sta.executeUpdate(sql);
				}
				if(!"".equals(stsex))
				{
					sql="update student set sex='"+stsex+"' where sno='"+stno+"'";
					f=sta.executeUpdate(sql);
				}
				if(!"".equals(stcssj))
				{
					sql="update student set scssj='"+stcssj+"' where sno='"+stno+"'";
					f=sta.executeUpdate(sql);
				}
				if(!"".equals(stscor))
				{
					sql="update score set scor='"+stscor+"' where num='"+stno+"'";
					f=sta.executeUpdate(sql);
				}
				if(!"".equals(stsources))
				{
					sql="update student set sources='"+stsources+"' where sno='"+stno+"'";
					f=sta.executeUpdate(sql);
				}
				if(!"".equals(stsour))
				{
					sql="update score set sour='"+stsour+"' where num='"+stno+"'";
					f=sta.executeUpdate(sql);
				}
			}
			else  JOptionPane.showMessageDialog(null, "Failed,Please Input Student ID!");

			if(f!=0)  JOptionPane.showMessageDialog(null, "sucessful!");
			else  JOptionPane.showMessageDialog(null, "Failed,Please Input Student ID!");
			
			Student stu=new Student();
			stu.clea(fr);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			try {
				sta.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void del(JFrame fr)
	{
		try {
			Class.forName(DRIVER);
			conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);
			sta=conn.createStatement();
			
			String stno=tno.getText();
			
			String sql="";
			int f=0;
			int k=0;
			if(!"".equals(stno))
			{
				sql="delete from student where sno='"+stno+"'";
				f=sta.executeUpdate(sql);
				sql="delete from score where num='"+stno+"'";
				k=sta.executeUpdate(sql);
			}
			//System.out.println(f);
			if(f!=0&&k!=0)  JOptionPane.showMessageDialog(null, "Sucessful!");
			else  JOptionPane.showMessageDialog(null, "Failed,Please Input New Student ID!");
			
			Student stu=new Student();
			stu.clea(fr);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			try {
				sta.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void up(JFrame fras)
	{
		try {
			Class.forName(DRIVER);
			conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);
			sta=conn.createStatement();
			
			String stno=tno.getText();
			String stname=tname.getText();
			String stsex=tsex.getText();
			String stcssj=tscssj.getText();
			String stscor=tscor.getText();
			String stsources=tsources.getText();
			
			/*System.out.println(stscor);
			System.out.println("lalala");*/
			
			String sql="insert into student  values('"+stno+"','"+stname+"','"+stsex+"',to_date('"+stcssj+"','YYYY-MM-DD'),'"+stsources+"')";
			String sqs="insert into score values('"+stno+"','"+stname+"','"+stsources+"','"+stscor+"')";
			int f=sta.executeUpdate(sql);
			int k=sta.executeUpdate(sqs);
			if(f!=0&&k!=0)
			{
				JOptionPane.showMessageDialog(null, "Sucessful!");
				Student stu=new Student();
				stu.clea(fras);
			}
			else  JOptionPane.showMessageDialog(null, "Failed,Please Input Again!");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{		
			try {
				sta.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void qur(JFrame f)
	{	
		try {
			Class.forName(DRIVER);
			conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);
			sta=conn.createStatement();
			
			String stno=tno.getText();
			String stname=tname.getText();
			
			if(!"".equals(stno)||!"".equals(stname))
			{
				for(int i=0;i<20;i++)
				{
					for(int j=0;j<20;j++)  lnames[i][j]=null;
				}
				tables=new JTable(lnames,cname);
				scro=new JScrollPane(tables);
				
				scro.setBounds(16, 160, 650, 250);
				f.add(scro);
				
				//query
				String sql="";
				
				int x=0;
				int y=0;
				for(int i=0;i<fi.length;i++)
				{
					if(!"".equals(stno))
						sql="select "+fi[i].getName()+" from student ,score where student.sno='"+stno+"' and score.num="+stno;
					else
						sql="select "+fi[i].getName()+" from student ,score where student.sname='"+stname+"' and score.names='"+stname+"'";
					res=sta.executeQuery(sql);
					x=0;
					while(res.next())
					{
						lnames[x][y]=res.getString(1);
						x++;
					}
					y++;
				}
				
				tables=new JTable(lnames,cname);
				scro=new JScrollPane(tables);
				
				scro.setBounds(16, 160, 650, 250);
				f.add(scro);
			}
			else JOptionPane.showMessageDialog(null, "Please Input Name or ID!");
			
			Student stu=new Student();
			stu.clea(f);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}