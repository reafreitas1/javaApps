package pa8.arrays_random;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Exercises {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {


	}

	private static void Exercise01() {
		boolean flag = true;
		do {
			System.out.print("Escreva um número (Sair para sair): ");
			String input = scanner.nextLine();

			if (input.equalsIgnoreCase("sair")) {
				flag = false;
				;
			} else {
				int num = Integer.parseInt(input);
				System.out.printf("Número introduzido é %s%n", ((num % 2 == 0) ? "Par" : "Impar"));
			}
		} while (flag);

	}

	private static void Exercise02() {
		boolean flag = true;
		do {
			int n1 = 0;
			int n2 = 0;
			String input;
			int count = 1;
			while (count <= 2) {
				System.out.print("Escreva um número: ");
				input = scanner.nextLine();
				if (input.equalsIgnoreCase("sair")) {
					flag = false;
					;
					break;
				}
				if (count == 1)
					n1 = Integer.parseInt(input);
				else
					n2 = Integer.parseInt(input);
				count++;
			}

			if (flag) {
				if (n1 > n2) {
					System.out.println("Primeiro número é maior");
				} else if (n1 < n2) {
					System.out.println("Segundo número é maior");
				} else {
					System.out.println("Números são iguais");
				}
			}
		} while (flag);
	}

	private static void Exercise03() {
		// Qualquer das formas está correcta, contudo fazer i+= 2 vai fazer com que não
		// hajam tantas iteracções, será mais rápido
		// Por vezes temos que ajudar o próprio algoritmo
		System.out.print("Gostaria de ver os números primos até quanto? ");
		int input = scanner.nextInt();

		for (int i = 1; i <= input; i += 2) {
			System.out.print(i + ", ");
		}
		System.out.println();
	}

	private static void Exercise04() {
		System.out.print("Qual a dimensão do quadrado? ");
		int input = scanner.nextInt();

		for (int i = 0; i < input; i++) {
			// desenhar a primeira e última linha
			if (i == 0 || i == input - 1) {
				for (int j = 0; j < input; j++) {
					System.out.print("* ");
				}
			}
			// desenhar as linhas do meio vazias
			else {
				for (int j = 0; j < input; j++) {
					if (j == 0 || j == input - 1)
						System.out.print("* "); // primeira e última coluna
					else
						System.out.print("  "); // colunas do meio
				}
			}
			System.out.println();
		}
	}

	private static void Exercise05() {
		int input = 0;
		while (true) {
			System.out.print("Qual a dimensão do diamante? ");
			input = scanner.nextInt();
			if (input % 2 != 0)
				break;
			else
				System.out.println("Para um diamante perfeito apenas poderá ser com números impares");
		}

		int half = input / 2;
		int count = 0;

		for (int i = 0; i < input; i++) {
			for (int j = 0; j < input; j++) {
				if (j == half + count)
					System.out.print(" * ");
				else if (j == half - count)
					System.out.print(" * ");
				else
					System.out.print("   ");
			}

			if (i < half)
				count++;
			if (i >= half)
				count--;
			System.out.println();
		}
	}

	private static void Exercise06() {
		System.out.print("Introduza um número: ");
		int input = scanner.nextInt();

		for (int i = 1; i <= 10; i++) {
			System.out.printf("%d x %2d = %2d%n", input, i, input * i);
		}
	}

	private static void Exercise07() {
		System.out.print("Introduza um número: ");
		int input = scanner.nextInt();

		if (input == 0) {
			System.out.println("O número introduzido tem 1 digito");
		} else {
			int count = 0;
			while (input != 0) {
				input /= 10;
				count++;
			}
			System.out.println("O número introduzido tem " + count + " digito" + (count > 1 ? "s" : ""));
		}
	}

	private static void Exercise08() {
		System.out.print("Introduza um número: ");
		int input = scanner.nextInt();
		int factorial = 1;

		while (input > 0) {
			if (input != 1)
				System.out.print(input + " * ");
			else
				System.out.print(input + " = ");
			factorial *= input--;
		}
		System.out.printf("%,d", factorial);
	}

	private static void Exercise09() {
		System.out.print("Quantas linhas: ");
		int input = scanner.nextInt();

		int count = 1;
		for (int i = 0; i < input; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(" " + count++);
			}
			System.out.println();
		}
	}

	private static void Exercise10() {
		// Número perfeito temos que decompor o número e se a sua soma da decomposição
		// for igual ao número é considerado um número perfeito
		int count = 0;
		for (long i = 1; i < Long.MAX_VALUE; i++) {

			long[] array = new long[200]; // não sabemos quanto coloco 200

			// Decompor o n�mero
			for (long j = 1, k = 0; j < i; j++) // começamos pelo um pois é um numero primo
			{
				if (i % j == 0) // se for divisivel incluimos na array
				{
					array[(int) k++] = j;
				}
			}

			// Fazer soma para ver se é um número perfeito
			long sum = 0;
			for (var item : array) {
				sum += item;
			}

			if (sum == i) {
				System.out.printf("Número perfeito: %d%n", i);
				count++;
			}

			if (count == 4) // Atenção colocar 4 caso contrário para além de demorar a processar, irá dar
							// excepção, pois a array de 200 não chega
				break;
		}
	}

	private static void Exercise11() {

		System.out.print("Introduza um número: ");
		int input = scanner.nextInt();

		int temp = input;
		int count = 0;
		while (true) {
			temp /= 10;
			count++;
			if (temp == 0)
				break;
		}

		for (int i = 0, j = 1; i < count; i++, j *= 10) {
			System.out.print(input / j % 10);
		}
		System.out.println();

	}

	private static void Exercise12() {
		int[] array = new int[10];
		Arrays.fill(array, Integer.MIN_VALUE); // Temos que preencher com um número que o utilizador provavelemente não
												// irá colocar

		for (int i = 0; i < array.length; i++) {
			boolean repeated;
			do {
				repeated = false;
				System.out.print("Introduza um número: ");
				int input = scanner.nextInt();

				for (var item : array) {
					if (item == input) {
						repeated = true;
						System.out.println("Número repetido. Introduza outro, por favor!");
					}
				}
				if (!repeated) {
					array[i] = input;
				}
			} while (repeated);
		}

		boolean sorted = false;
		int temp = 0;

		// Bubble sort (verificar cada elemento lado a lado até que a array esteja toda
		// ordenada)
		while (!sorted) {
			sorted = true; // dizer que está ordenada para sair do loop
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] > array[i + 1]) // se entrar aqui não está ordenada
				{
					temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					sorted = false; // alterar a condição de sorted pois se entrou aqui quer dizer que poderá ainda
									// não estar ordenada
				}
			}
		}
		for (var item : array) {
			System.out.print(item + " ");
		}

	}

	private static void Exercise13() {
		System.out.print("Introduza um texto: ");
		String input = scanner.nextLine();

		char[] small = { 'a', 'e', 'i', 'o', 'u' };
		char[] big = { 'A', 'E', 'I', 'O', 'U' };
		int[] quantidade = new int[5];

		for (var item : input.toCharArray()) {
			for (int i = 0; i < small.length; i++) {
				if (item == small[i] || item == big[i])
					quantidade[i]++;
			}
		}

		for (int i = 0; i < small.length; i++) {
			System.out.printf("Quantidade de {%s/%s} = %s%n", big[i], small[i], quantidade[i]);
		}

	}

	private static void Exercise14() {
		SecureRandom random = new SecureRandom();
		int number = random.nextInt(1000) + 1;
		System.out.println(number);
		boolean guessed = false;
		int tentativas = 0;
		while (!guessed) {
			System.out.print("Advinhe o n�mero: ");
			int input = scanner.nextInt();
			tentativas++;

			if (input == number) {
				guessed = true;
				System.out.printf("Parabéns conseguiu advinhar em %d tentativas", tentativas);
				if (tentativas <= 10)
					System.out.println("Ou tem sorte ou entendeu a lógica");
			} else if (input < number) {
				System.out.println("Mais Baixo");
			} else if (input > number) {
				System.out.println("Mais Alto");
			}
		}
	}

	private static void Exercise14a() {
		SecureRandom random = new SecureRandom();

		int flag = 0; // -1 low; 0 neutro; 1 high
		int tries = 1000;
		int maximum = 1000; // Magic Number

		int[] tentativas = new int[tries];

		for (int i = 0; i < tries; i++) {
			int number = random.nextInt(1000) + 1;
			System.out.println("Random: " + number);

			boolean guessed = false;
			int input = 0;

			int bottom = 1; 
			
			int top = maximum;
			System.out.print("Guess: ");

			while (!guessed) {
				
				if (flag == 1) {
					top = input;
				} else if (flag == -1) {
					bottom = input;
				}

				input = ((top - bottom) / 2) + bottom;
				System.out.print(input + ", ");

				tentativas[i]++;

				if (input == number) {
					flag = 0;
					guessed = true;
				} else if (input < number) {
					flag = -1;
					guessed = false;
				} else if (input > number) {
					flag = 1;
					guessed = false;
				}
			}

			if (tentativas[i] > 10) {

				System.out.println(" <- AQUI");

			}
			System.out.println("\n");
		}

		int sum = 0;

		for (int i = 0; i < tentativas.length; i++) {
			System.out.printf("%d tentativa: %d%n", i + 1, tentativas[i]);
			sum += tentativas[i];
		}

		System.out.println("Média de tentativas: " + sum / tentativas.length);
	}
}
