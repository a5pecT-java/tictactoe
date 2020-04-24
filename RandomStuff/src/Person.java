public class Person
{

	private String name;

	private int feet;

	private int inches;

	public Person(String nm, int ft, int in)

	{

		name = nm;

		feet = ft;

		inches = in;

	}

	public int heightInInches()

	{

		return feet * 12 + inches;

	}

	public String getName()

	{

		return name;

	}

	public String compareHeights(person other)
	
	{
	
	if (this.heightInInches() < other.heightInInches())
	
	{
	
	return name;
	
	}
	
	else if (this.heightInInches() > other.heightInInches())
	
	{
	
	return other.getName();
	
	}
	
	else return "Same"
	
	}

}
