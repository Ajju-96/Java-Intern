/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
/*Problem statement:
Create a Java program using inheritance with two classes: Animal and Dog.
Requirements:
1. Create a parent class Animal with:
- A variable String name.
- A method eat() that prints "Animal is eating".
2. Create a child class Dog that extends Animal with:
- A method bark() that prints "Dog is barking".
3. In the main() method:
- Create an object of Dog.
- Assign "Tommy" to its name.
- Print the dog's name.
- Call both eat() and bark().*/

class Animal{
    String name;
    
    void eat(){
        System.out.println("Animal is eating");
        
    }
}

//Child class
class dog extends Animal{
    void bark(){
        System.out.println("Dog is barking");
    }
}

public class Main
{
	public static void main(String[] args) {
		System.out.println("Hii Master");
		Dog d = new Dog();
		d.name = "Tommy";
		System.out.println("Dog name: "+ name);
		d.eat();
		d.bark();
	}
}
