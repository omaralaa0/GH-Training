import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class streamandlambda {
	
	public static void main (String [] args) {
		
		System.out.println("STREAM AND OPTIONAL EXERCISES");

//		 1 - sum of even numbers
		System.out.println("1 - sum of even numbers");
		List<Integer> n = Arrays.asList(1,8,4,5,8,6);
		int sum = n
		.stream()
		.filter(x -> x%2 == 0)
		.mapToInt(Integer::intValue)
		.sum();
		
		System.out.println(sum);
		System.out.println("////////////");
		////////////
		
//		 2- optional for returning sring length or 0 if null
		System.out.println("2- optional for returning sring length or 0 if null");
		String s = null;
//		String s = "sayed";
		
		int length = Optional.ofNullable(s).map(String::length).orElse(0);
		System.out.println(length);
		System.out.println("////////////");
		////////////
		
//		3- group words by len
		System.out.println("3- group words by len");
		List<String> words = Arrays.asList("sayed", "atef", "abdullah");
		Map<Integer,List<String>> map = words.stream().collect(Collectors.groupingBy(String::length));
		map.forEach((l,w) -> System.out.println(l + " " + w));
		System.out.println("////////////");
		////////////
		
//		4- chain of methods
		System.out.println("4- chain of methods");
		Person omar = new Person(new Address("Nasr City"));
		Person mostafa = new Person(new Address(null));
	    System.out.println(getCityName(omar));
	    System.out.println(getCityName(mostafa));
	    System.out.println("////////////");
	    ////////////
	    
//	    5- find second largest number
	    System.out.println("5- find second largest number");
	    int second = n
	    .stream()
	    .distinct()
	    .sorted((a,b) -> b - a)
	    .skip(1)
	    .findFirst()
	    .orElse(-1);
	    System.out.println(second);
	    System.out.println("////////////");
	    ////////////
	    
//	    6- nested validation
	    System.out.println("6- nested validation");
	    User se7s = new User(new Profile("abcd@ay7aga.com"));
	    User aly = new User(new Profile("abcday7aga.com"));
	    System.out.println(getEmailAddress(se7s));
	    System.out.println(getEmailAddress(aly));
	    System.out.println("////////////");
	    ////////////
	    
//	    7- fibonacci sequence
	    System.out.println("7- fibonacci sequence");
	    // LESA
	    
	    

	    System.out.println("////////////");
	    ////////////
	    
//	    8- sum of 2 optionals
	    System.out.println("8- sum of 2 optionals");
	    Optional<Integer> a = Optional.of(5);
	    Optional<Integer> b = Optional.of(20);
	    Optional<Integer> c = Optional.empty();
	    System.out.println(getSumOfOptionals(a,b));
	    System.out.println(getSumOfOptionals(a,c));
	    System.out.println("////////////");
	    ////////////
	    
//	    9- nested data processing
	    System.out.println("9- nested data processing");
        List<Employee> employees = List.of(
                new Employee("Osos", "IT", Optional.empty(), 20000), new Employee("Hamdy", "HR", Optional.of(LocalDate.of(2023, 12, 31)), 15000));
        Map<String, Double> avgSalariesByDep = getSalaryByDep(employees);

        avgSalariesByDep.forEach((dep, avgSalary) -> System.out.println(dep +" " + avgSalary));
	    System.out.println("////////////");
	    ////////////

//	    10- custom collector for primes and non primes
	    System.out.println("10- custom collector for primes and non primes");
	    List<Integer> list = IntStream.range(2, 21).boxed().collect(Collectors.toList());
	    Map<Boolean, List<Integer>> part = list
	    		.stream()
	    		.collect(Collectors.partitioningBy(x -> isPrime(x)));

	    List<Integer> primes = part.get(true);
        List<Integer> nonPrimes = part.get(false);
        int primesSum = primes
        		.stream()
        		.mapToInt(Integer::intValue)
        		.sum();
        int nonPrimesProduct = nonPrimes.stream().reduce(1, (ss, kk) -> ss * kk);
        System.out.println("sum of primes: " + primesSum );
        System.out.println("produc of non primes: " + nonPrimesProduct);
        System.out.println("////////////");
	    ////////////
//        11- validate username
        System.out.println("11- validate username");
        Optional<String>username1 = Optional.of("NPCbot123");
        Optional<String>username2 = Optional.of("npcbot123@");
        Optional<String>username3 = Optional.empty();
        validateUsername(username1);
        validateUsername(username2);
        validateUsername(username3);
        System.out.println("////////////");
	    ////////////
        
//        12- moving average of window of size k
        System.out.println("12- moving average of window of size k");
        //LESAAAAA
        System.out.println("////////////");
	    ////////////
        
//        13- mapping usernames to uppercase
        System.out.println("13- mapping usernames to uppercase");
        List<String> names = Arrays.asList("alice", "bob", "charlie");
        List<String>outputNames = names.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(outputNames);
        System.out.println("////////////");
	    ////////////
        
//        14- flatmap sentences to words
        System.out.println("14- flatmap sentences to words");
        List<String> sentences = Arrays.asList("Hello world", "Java streams");
        List<String>outputSentences = sentences.stream().flatMap(sentence -> Arrays.stream(sentence.split(" "))).collect(Collectors.toList());
        System.out.println(outputSentences);
        System.out.println("////////////");
	    ////////////
        
//        15- get emails from list of users
        System.out.println("15- get emails from list of users");
        List<User2> users = Arrays.asList(
        	    new User2("ninja@gmail.com"),
        	    new User2("walt@hotmail.com"));
        List<String> emails = 
        		users
        		.stream()
        	    .map(User2::getEmail)
        	    .collect(Collectors.toList());
        	System.out.println(emails);
            System.out.println("////////////");
    	    ////////////
            
//      16- flatmap with nested collections
        System.out.println("16- flatmap with nested collections");
        List<Order> orders = Arrays.asList(new Order(List.of(new Item("Chips"), new Item("Honey"))), new Order(List.of(new Item("Water")))); 
        List<Item> allItems =
        		orders
        		.stream()
        	    .flatMap(order -> order.getItems().stream())
        	    .collect(Collectors.toList());

        System.out.println(allItems);
        System.out.println("////////////");
	    ////////////
        	

//        17- extract employee phone num
        System.out.println("17- combining map and flatmap");
        List<Department> departments = Arrays.asList(
        	    new Department(List.of(new Employee2("01011121314"))), new Department(List.of(new Employee2("911"))));

        List<String> phoneNumbers = departments.stream()
        	    .flatMap(dept -> dept.getEmployees().stream())
        	    .map(Employee2::getPhoneNumber)
        	    .collect(Collectors.toList());
        System.out.println(phoneNumbers);
        System.out.println("////////////");
	    ////////////
        
//        18- get address using optional
        System.out.println("18- get address using optional --- DONE in 4 & 6");
        System.out.println("////////////");
	    ////////////
        System.out.println("------------------------------------------------------------------------------");
        
//        REFRACTOR USING STREAM AND OPTIONAL
        System.out.println("REFRACTOR USING STREAM AND OPTIONAL");
        
//        Example 2: 
        System.out.println("Example 2: ");
        
        List<String> values = Arrays.asList(null, "hello", null, "world");

        String firstNonNull = values.stream()
            .filter(Objects::nonNull)
            .findFirst()
            .orElse("default");

        System.out.println(firstNonNull);
        System.out.println("////////////");
	    ////////////
        
//        Example 3: 
        System.out.println("Example 3: ");
        List<Order2> o = Arrays.asList(
                new Order2(List.of(new Item2(120), new Item2(80))),
                new Order2(List.of(new Item2(150)))
            );
        System.out.println("Before refractoring: ");
        double totalPrice = 0.0;
        for (Order2 os : o) {
         for (Item2 item : os.getItems2()) {
         if (item.getPrice() > 100) {
         totalPrice += item.getPrice();
         }
         }
        }
        System.out.println("total price is: " + totalPrice);


        System.out.println("after refractoring: ");
            double price =
            	o.stream()
                .flatMap(order -> order.getItems2().stream())
                .filter(item -> item.getPrice() > 100)
                .mapToDouble(Item2::getPrice)
                .sum();

            System.out.println("total price is: " + price);
            System.out.println("////////////");
    	    ////////////
            
            


           
            
            
       }

        
            




	
	
	
	public static boolean validateUsername(Optional<String> username) {
		if(username.isPresent()) {
			if(username.get().length() >= 5 && username.get().matches("[A-Za-z0-9]+")) {
				System.out.println("Valid username: " + username.get().toLowerCase());
				return true;
			}
			else {
				System.out.println("Invalid username (false characters): " + username);
				return false;
				
			}
		}
		else {

			System.out.println("Validation Exception - no username provided");
			return false;
			
		}

		
	}
	
	public static String getCityName(Person person) {
        return person.getAddress()
                     .flatMap(Address::getCity)
                     .orElse("Unknown");
    }
	
	public static String getEmailAddress(User user) {
        return user.getProfile()
                     .getEmail()
                     .filter(email -> email.contains("@"))
                     .orElse("InvalidEmailException");
    }
	
	public static Optional<Integer> getSumOfOptionals(Optional<Integer> s, Optional<Integer>r) {
        return s.flatMap(x -> r.map(y -> x + y));
    }
	public static Map<String, Double> getSalaryByDep(List<Employee> employees) {
        return employees.stream()
            .filter(e -> e.getEndDate().isEmpty())
            .collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.averagingInt(Employee::getSalary)
            ));
    }
	
	public static boolean isPrime(int num) {
	    if (num < 2) {
	        return false;
	    }
	    int sqrt = (int) Math.sqrt(num);
	    for (int i = 2; i <= sqrt; i++) {
	        if (num % i == 0) {
	            return false;
	        }
	    }
	    return true;
	}
}


class Order {
    List<Item> items;
    public Order(List<Item> items) {
    	this.items = items; 
    }
    public List<Item> getItems() {
    	
    	return items; 
    }
}

class Item {
    String name;

    public Item(String name) {
        this.name = name;
    }
    public String toString() {
        return "Item: " + name;
    }
}


class Person {
    Optional<Address> address;
    public Person(Address address) {
        this.address = Optional.ofNullable(address);
    }

    public Optional<Address> getAddress() {
        return address;
    }
}

class Address {
    Optional<String> city;
    public Address(String city) {
        this.city = Optional.ofNullable(city);
    }

    public Optional<String> getCity() {
        return city;
    }
}

class Profile {
	Optional<String> email;
	public Profile (String email) {
		this.email = Optional.ofNullable(email);
	}
    public Optional<String> getEmail() {
        return email;
    }
}

class User { 
	
	Profile profile;
	public User(Profile profile) {
		this.profile = profile;
	}
    public Profile getProfile() {
        return profile;
    }
	
}
class User2 {
	 private String email;
	 public User2(String email) {
		 this.email = email;

	}
	public String getEmail() { return email; }
	}

class Employee{
	String name;
	String department;
	Optional<LocalDate> endDate;
	int salary;
	public Employee(String name, String department, Optional<LocalDate> endDate, int salary) {
		this.name = name;
		this.department = department;
		this.endDate = endDate;
		this.salary = salary;
	}
	
    public Optional<LocalDate> getEndDate() {
        return endDate;
    }

    public String getDepartment() {
        return department;
    }

    public int getSalary() {
    	return salary;
    }
	
	
}

class Department {
    List<Employee2> employees;
    public Department(List<Employee2> employees) {
    	this.employees = employees;
    }
    public List<Employee2> getEmployees() {
    	return employees;
    }
}

class Employee2 {
    String phoneNumber;
    public Employee2(String phoneNumber) {
    	this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber() {
    	return phoneNumber;
    }
}

class Item2 {
    double price;
    public Item2(double price) {
    	this.price = price;
    }
    public double getPrice() {
    	return price;
    }
}

class Order2 {
    List<Item2> items;
    public Order2(List<Item2> items) {
    	this.items = items;
    }
    public List<Item2> getItems2() {
    	return items;
    }
}

