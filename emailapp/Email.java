package emailapp;

import java.util.Scanner;

//syntax firstname.lastname@dept.company.com
//determine dept
// set & get methods: pwchange, mailboxcapacity, altemail


public class Email {

	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String alternateEmail;
	private String email;
	private String companySuffix = "somecompany.com";
	
	private int mailboxCapacity = 500;
	private int defaultPWLength = 10;
	
	//Constructors
	/**Constructor: no parameters */
	public Email() {}
	/** Constructor: first & last name**/
	public Email(String firstName, String lastName) 
	{
		this.firstName = firstName;
		this.lastName = lastName;
			//System.out.println("Email created " + getFullName());
		
		//Call asking for dept, return dept
		this.department = setDepartment();
			//System.out.println("Department: " + this.department);
		
		//returns random password
		this.password = randoPassword(defaultPWLength);
		System.out.println("Your password is: " + this.password);
		
		//Generate Email
		email = firstName.toLowerCase() +"." + lastName.toLowerCase() + 
				"@" + department + "." +  companySuffix;
			//System.out.println("Your email is: " + email);
	}
	
	/** gets full name with spacing*/
	public String getFullName()
	{
		return firstName + " " + lastName;
	}
	
	
	/**Get All Info **/
	public String showInfo()
	{
		return "Display Name: " + getFullName()+
				"\nCompany Email:" + email +
				"\nMailbox Capacity: " + mailboxCapacity + "mb";
		
	}
	
	
	/** Set Department**/
	private String setDepartment()
	{
		System.out.print("New worker: " + getFullName() 
				+ "\nDepartment Codes:\n"
				+ "1 for Sales\n"
				+ "2 for Developement\n"
				+ "3 for Accounting\n"
				+ "0 for other\n"
				+ "Enter Department Code: ");
		Scanner in = new Scanner(System.in);
		int deptChoice = in.nextInt();
		if(deptChoice == 1){return "sales";}
		else if(deptChoice == 2){return "dev";}
		else if(deptChoice == 3){return "acct";}
		else {return "";}
	}
	
	/**Generate random password**/
	private String randoPassword(int length)
	{
		String passwordSet = "QWERTYUIOPLKJHGFDSAZXCVBNM1234567890!@#$%&*";
		char[] password = new char[length];
		for (int i = 0; i < length; i ++)
		{
			int rand = (int) (Math.random()* passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	

	
	//Set mailbox capacity
	public void setMailboxCapacity(int capacity)
	{
		this.mailboxCapacity = capacity;
	}
	
	//Set alternate email
	public void setAltEmail(String altEmail)
	{
		this.alternateEmail = altEmail;
	}
	//Change password
	public void changePasswird(String password)
	{
		this.password = password;
	}
	
	//get mailbox capacity
	public int getMailboxCapacity() {return mailboxCapacity;}
	
	//get alternate email
	public String getAltEmail() {return alternateEmail;}
	
	//get password
	public String getPassword() {return password;}

	
	
	
	
}
