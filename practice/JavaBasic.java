interface Runner
{
  int ID = 1;
  void run ();
}


interface Animal extends Runner
{
  void breather ();
}
interface Flyer 
{
	void fly();
}

class Fish implements Animal
{
	  public void run ()
	{
	   System.out.println("fish is swimming");
	}

	public void breather()
	{
	   System.out.println("fish is bubbing");   
	}
}


class Bird implements Runner , Flyer
{
  public void run ()
   {
       System.out.println("bird is running");
   }
  public void fly ()
   {
       System.out.println("bird is flying");
   }
}
abstract class LandAnimal implements Animal
{
 
	  public void breather ()
	{
	   System.out.println("LandAnimal is breathing");
	}
}
class Turtle extends LandAnimal{
 	public void breather ()
	{
	   System.out.println("Turtle is breathing");
	}
	public void run ()
	{
	   System.out.println("Turtle is running");
	}
}

class JavaBasic
{
  public static void main (String args[])
   {
      Fish f = new Fish();
      Bird b = new Bird();
      Turtle t = new Turtle();
      f.run();
      f.breather();
      b.run();
      b.fly();
      t.run();
      t.breather();
   }

}