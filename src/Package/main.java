package Package;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int maxIntentos = 5;

        while (true){
            System.out.println("Ingrese su nombre:");
            String nombreJugador = teclado.nextLine();

            String palabraAdivinar = "hola";
            int intentosRestantes = maxIntentos;
            Set<Character> letrasAdivinadas = new HashSet<>();
            Set<Character> letrasErradas = new HashSet<>();

            while (intentosRestantes > 0){
                System.out.println("Ingrese una letra:");
                char letra = teclado.nextLine().toLowerCase().charAt(0);

                if (palabraAdivinar.indexOf(letra) >= 0){
                    System.out.println("Ingrese otra letra:");
                    letra = teclado.nextLine().toLowerCase().charAt(0);

                    if (palabraAdivinar.indexOf(letra) >= 0){
                        letrasAdivinadas.add(letra);
                    }

                    if (todasLetrasAdivinadas(palabraAdivinar, letrasAdivinadas)){
                        System.out.println("Ganaste" + palabraAdivinar);
                        int puntaje = maxIntentos - letrasErradas.size();
                        break;
                    }
                } else {
                    letrasErradas.add(letra);
                    intentosRestantes--;
                }

                if (intentosRestantes == 0){
                    System.out.println("Perdiste, la palabra era " + palabraAdivinar);
                    System.out.println("Intenta salvar el juego.");
                    System.out.println("Ingrese las coordenadas x, y");
                    int x = teclado.nextInt();
                    int y = teclado.nextInt();

                    if (salvarAhorcado(x, y)){
                        System.out.println("Lo has salvado, ganaste");
                    } else {
                        System.out.println("Perdiste");
                        break;
                    }
                }
            }
        }


    }

    public static boolean todasLetrasAdivinadas(String palabra, Set<Character> letrasAdivinadas){
        for (char c : palabra.toCharArray()){
            if (!letrasAdivinadas.contains(c)){
                return false;
            }
        }
        return true;
    }

    public static boolean salvarAhorcado(int x, int y){
        return x == 1 && y == 1;
    }
}
