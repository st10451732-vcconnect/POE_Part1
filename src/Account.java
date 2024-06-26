
public class Account {
	private String userName;
	private String passWord;
	private String firstName;
	private String lastName;
	
	
	//Constructor
	public Account(String userName, String passWord, String firstName, String lastName) {
		this.userName = userName;
		this.passWord = passWord;
		this.firstName = firstName;
		this.lastName = lastName;	
	}

	//Getters and setters
	//----Username
	public String getuserName() {
		return userName;
	}
	public void setuserName(String userName) {
		this.userName = userName;
	}
	
	//----Password
	public String getpassWord() {
		return passWord;
	}
	public void setpassWord(String passWord) {
		this.passWord = passWord;
	}
	
	//----Firstname
	public String getfirstName() {
		return firstName;
	}
	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}
	
	//----Lastname
	public String getlastName() {
		return lastName;
	}
	public void setlastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	//-----------Validations
	//username: 5 characters and has underscore
	public boolean checkUsername(String userName) {
		return userName.length() >= 1 && userName.length() <= 5 && userName.contains("_");
	}
	
	//password: 8 characters and has underscore
	public boolean checkPasswordComplexity(String passWord) {
		String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%?&])[A-Za-z\\d@$!%?&]{8,}$";
	    return passWord.matches(regex);
	}
	
	
	//================Registration
	public String registerUser(String userName, String passWord, String firstName, String lastName) {
		String regMessage= "";
		
		if (!checkUsername(userName)) {
			regMessage ="Username is not correctly formatted, please ensure you username contains an underscore and is not more than 5 characters long";
		} else if (!checkPasswordComplexity(passWord)) {
			regMessage ="Password is not correctly formatted, please ensure the password contains at least 8 characters, a capital letter a number and a special character";
			
		} else {
			this.userName = userName;
			this.passWord = passWord;
			this.firstName = firstName;
			this.lastName = lastName;
			
			regMessage = "User registration sucessful.";
		}
		
		return regMessage;
	}
	
	
	//================Login
	public boolean loginUser(String userName, String passWord) {
        return this.userName.equals(userName) && this.passWord.equals(passWord);
    }
}
