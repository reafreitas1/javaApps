package p8.arrays_students_register;

import java.util.Arrays;
import java.util.Scanner;

public class Exercises {

	public static void main(String[] args) {

		// Exercise01();
		// Exercise02();
		// Exercise03();
		Exercise04();
	}

	public static void Exercise01() {
		int[] array = { 1, 2, 3, 4, 5 }; // var needs to know the type, we need to substitute the var keyword or change
											// the array initialization
		var array1 = new int[] { 1, 2, 3, 4, 5 };

		// public class Pessoa {} // class is a keyword begins with a small letter
	}

	public static void Exercise02() {
		Scanner scanner = new Scanner(System.in);

		char[] array = new char[5];

		System.out.print("Please enter a character: ");
		array[0] = scanner.nextLine().charAt(0);
		System.out.print("Please enter a character: ");
		array[1] = scanner.nextLine().charAt(0);
		System.out.print("Please enter a character: ");
		array[2] = scanner.nextLine().charAt(0);
		System.out.print("Please enter a character: ");
		array[3] = scanner.nextLine().charAt(0);
		System.out.print("Please enter a character: ");
		array[4] = scanner.nextLine().charAt(0);

		char[] copy = Arrays.copyOf(array, array.length);

		String ascending = "" + copy[0] + copy[1] + copy[2] + copy[3] + copy[4];
		String descending = "" + copy[4] + copy[3] + copy[2] + copy[1] + copy[0];
		System.out.println(ascending);
		System.out.println(descending);

		System.out.println(copy[0] + " " + copy[1] + " " + copy[2]);

		System.out.println(copy[0]);

		System.out.println(copy[4]);
		scanner.close();
	}

	public static void Exercise03() {
		Scanner scanner = new Scanner(System.in);

		Date birthdate = new Date();
		System.out.print("Please enter your birth day: ");
		birthdate.day = scanner.nextInt();
		System.out.print("Please enter your birth month: ");
		birthdate.month = scanner.nextInt();
		System.out.print("Please enter your birth year: ");
		birthdate.year = scanner.nextInt();

		birthdate.calculateAge();

		Hour work = new Hour();
		System.out.print("Please, enter the hour you finish work: ");
		work.hour = scanner.nextInt();
		System.out.print("Please, enter the minutes you finish work: ");
		work.minute = scanner.nextInt();
		System.out.print("Please, enter the seconds you finish work: ");
		work.second = scanner.nextInt();

		work.calculateTimeLeft();
		scanner.close();
	}

	public static void Exercise04() {
		Scanner scanner = new Scanner(System.in);

		Turma turmaA = new Turma();

		Estudante aluno1 = new Estudante();
		aluno1.nome = "Aluno 1";
		turmaA.estudantes[0] = aluno1;
		Estudante aluno2 = new Estudante();
		aluno2.nome = "Aluno 2";
		turmaA.estudantes[1] = aluno2;
		Estudante aluno3 = new Estudante();
		aluno3.nome = "Aluno 3";
		turmaA.estudantes[2] = aluno3;
		Estudante aluno4 = new Estudante();
		aluno4.nome = "Aluno 4";
		turmaA.estudantes[3] = aluno4;
		Estudante aluno5 = new Estudante();
		aluno5.nome = "Aluno 5";
		turmaA.estudantes[4] = aluno5;

		Exame exame = new Exame();
		exame.disciplina = "Matem�tica";
		exame.estudantes = turmaA.estudantes;

		System.out.print("Introduza a nota do aluno {0}: " + exame.estudantes[0].nome);
		exame.notas[0] = new Nota();
		exame.notas[0].nota = scanner.nextInt();

		System.out.print("Introduza a nota do aluno {0}: " + exame.estudantes[1].nome);
		exame.notas[1] = new Nota();
		exame.notas[1].nota = scanner.nextInt();

		System.out.print("Introduza a nota do aluno {0}: " + exame.estudantes[2].nome);
		exame.notas[2] = new Nota();
		exame.notas[2].nota = scanner.nextInt();

		System.out.print("Introduza a nota do aluno {0}: " + exame.estudantes[3].nome);
		exame.notas[3] = new Nota();
		exame.notas[3].nota = scanner.nextInt();

		System.out.print("Introduza a nota do aluno {0}: " + exame.estudantes[4].nome);
		exame.notas[4] = new Nota();
		exame.notas[4].nota = scanner.nextInt();
		
		double average = (exame.notas[0].nota + exame.notas[1].nota +exame.notas[2].nota +exame.notas[3].nota + exame.notas[4].nota) / exame.notas.length;
		System.out.println("Class average is: " + average);
		scanner.close();
	}
}

class Date {

	public int day;
	public int month;
	public int year;

	public void calculateAge() {
		Date now = new Date();
		now.day = 23;
		now.month = 3;
		now.year = 2020;

		double age = ((now.year - year) * 365.5 + ((now.month - month) * 30)) / 365.25;
		System.out.println(age);
	}
}

class Hour {
	public int hour;
	public int minute;
	public int second;

	public void calculateTimeLeft() {
		Hour now = new Hour();
		now.hour = 13;
		now.minute = 50;
		now.second = 0;

		int hoursLeft = hour - now.hour;
		int minutesLeft = 60 + (minute - now.minute);
		int secondsLeft = 60 + (second - now.second);

		System.out.println(hoursLeft + " : " + minutesLeft + " : " + secondsLeft);
	}
}

class Turma {
	public Estudante[] estudantes = new Estudante[5];
	public Exame exame;
}

class Estudante {
	public String nome;
}

class Exame {

	public String disciplina;
	public Estudante[] estudantes;
	public Nota[] notas = new Nota[5];
}

class Nota {
	public int nota;
}