    import java.util.*;
	public class exam{
	Scanner scobj = new Scanner(System.in);
	HashMap<String,Integer> Details = new HashMap<String,Integer>();
	    public void User_Login() {
			Details.put("supraja",1754);
			System.out.println("\n------ WELCOME TO THE ONLINE EXAMINATION------");
			String Uname;
			System.out.println("Enter UserName : ");
			Uname = scobj.next();
			int PWD;
			System.out.println("Enter Password : ");
			PWD= scobj.nextInt();
			if(Details.containsKey(Uname)) {
				if(Details.get(Uname)==PWD){
					System.out.println("\nWelcome");
					Options_Menu();	}
				else {
					System.out.println("Enter Valid Password For: "+Uname);
					User_Login();    }
	        }
			else{
				System.out.println("Enter Valid User Name");
			}
	    
		}
		public void Options_Menu() {
			int Choice;
			System.out.println("MENU");
			System.out.println("1.Update profile \n2.Write Exam \n3.Quit ");
			System.out.println("Enter Choice: ");
			Choice = scobj.nextInt();
			switch(Choice) {
			case 1:
				Details=Update_Details();
				Options_Menu();
				break;
			case 2:
				Examination();
				Options_Menu();
				break;
			case 3:
	            System.out.println("Thank You");
				System.exit(0);
				break;
			default:
				System.out.println("Please Enter Number in User Menu Only");
			}
		}
		public HashMap<String,Integer> Update_Details(){
			String update_name;
			int update_pwd;
			System.out.println("updateDetails Profile");
			System.out.println("Enter Username: ");
			update_name = scobj.next();
			if(Details.containsKey(update_name)) {
			System.out.println("Enter New Password ");
			update_pwd = scobj.nextInt();
			Details.replace(update_name, update_pwd);
	        System.out.println("Details updated successfully");
			}
			else {
				System.out.println("Enter The Correct UserName");
			}
			return Details;
		}
	public void Examination() {
	    Calendar cr = Calendar.getInstance();
		long StartTime=System.currentTimeMillis();
		long EndTime=StartTime+30;
		int AnsweredQueries=0;
		int UserAnswer,MarksSecured;
		System.out.println("Start your exam");
		System.out.println("sInstructions: ");
		System.out.println("You Have To Answer 5 Questions in 30 Seconds");
		System.out.println("Each Question carries 10 marks and -5 for wrong answer");
		HashMap<String,ArrayList<String>> queries=new HashMap<String,ArrayList<String>>();
		ArrayList<String> Ques1=new ArrayList<String>();
	        Ques1.add("12");
		Ques1.add("4");
		Ques1.add("8");
		Ques1.add("5");
		Ques1.add("3");
		queries.put("Number of primitive data types in java",Ques1);
		ArrayList<String> Ques2=new ArrayList<String>();
		Ques2.add("java.lang.object");
		Ques2.add("java.lang.string");
		Ques2.add("java.lang.util");
		Ques2.add("none");
		Ques2.add("1");
		queries.put("In which of the following is toString() method defined",Ques2);
		ArrayList<String> Ques3=new ArrayList<String>();
		Ques3.add("int");
		Ques3.add("void");
		Ques3.add("double");
		Ques3.add("none");
		Ques3.add("2");
		queries.put("Identify the return type of a method that does not return any value",Ques3);
		ArrayList<String> Ques4=new ArrayList<String>();
		Ques4.add("Polymorphism");
		Ques4.add("Inheritance");
		Ques4.add("compilation");
		Ques4.add("Encapsulation");
		Ques4.add("3");
		queries.put("which of the following is not an OOPS concept in java?",Ques4);
	    ArrayList<String> Ques5=new ArrayList<String>();
		Ques5.add(".js");
		Ques5.add(".txt");
		Ques5.add(".class");
		Ques5.add(".java");
		Ques5.add("4");
		queries.put("what is the extension of java code files?",Ques5);
		int sno=0;
	    Set<String> set=queries.keySet(); 
	    ArrayList<String> al=new ArrayList<>(set);
	    int x=al.size();
		while(System.currentTimeMillis()<EndTime || sno<x) {
	        String i=al.get(sno);
			System.out.println("\n\nQ."+(sno+1)+") "+i);
			System.out.println("\n(1) "+queries.get(i).get(0)+"\t"+"(2) "+queries.get(i).get(1)+"\t"+"(3) "+queries.get(i).get(2)+"\t"+"(4) "+queries.get(i).get(3)+" ");
			System.out.println("Enter Option");
			UserAnswer=scobj.nextInt();
			System.out.println("Your Answer is submitted");
			if(UserAnswer==Integer.parseInt(queries.get(i).get(4))) {
				AnsweredQueries++;
			}
	        sno++;
		}
		System.out.println("You Have Completed the Exam");
		MarksSecured=AnsweredQueries*10-((5-AnsweredQueries)*5); 
		System.out.println("Your score is..."+" "+MarksSecured+"/50");	
	}

	public static void main(String[] args)
	{
		exam em =new exam();
			em.User_Login(); 
	}
	}